package com.vodafoneidea.mva.test;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;
import com.ssts.util.reporting.MultipleRunReport;
import com.ssts.util.reporting.SingleRunReport;
import com.ssts.util.reporting.printers.HtmlFilePrinter;

public class Controller {

    public static File ReportsFolder = new File("Reports");

    public static Map<String, DeviceContext> allDeviceContexts = new HashMap<String, DeviceContext>();

    public static void main(String args[]) throws Exception {
        JenkinsEnvironmentVariables.printEnvironmentVariables();
        Controller runExecutionOnPCloudy = new Controller();
        runExecutionOnPCloudy.runTestNGTest();

        System.exit(0);
    }

    public void runTestNGTest() throws Exception {

        int deviceBookDurationTime = JenkinsEnvironmentVariables.getDuration();

        // Create an instance on TestNG
        TestNG myTestNG = new TestNG();

        // Create an instance of XML Suite and assign a name for it.
        XmlSuite mySuite = new XmlSuite();
        mySuite.setName("pCloudy Suite");
        mySuite.setParallel("tests");

        // Create a list which can contain the classes that you want to run.
        List<XmlClass> myClasses = new ArrayList<XmlClass>();
        myClasses.add(new XmlClass("com.vodafoneidea.mva.test.launchAppTest"));
        
        // Create a list of XmlTests and add the Xmltest you created earlier to it.
        List<XmlTest> allDevicesTests = new ArrayList<XmlTest>();

        Connector con = new Connector(JenkinsEnvironmentVariables.getApiEndpoint());
        // User Authentication over pCloudy
        String authToken = con.authenticateUser(JenkinsEnvironmentVariables.get_pCloudy_UserName(), JenkinsEnvironmentVariables.get_pCloudy_ApiKey());
        ArrayList<MobileDevice> selectedDevices = new ArrayList<>();

        selectedDevices.addAll(con.chooseDevicesFromArrayOfFullNames(authToken, "android", JenkinsEnvironmentVariables.getDevicesFullNames()));

        String sessionName = selectedDevices.get(0).display_name + " Appium Session";
        // Select apk in pCloudy Cloud Drive
        File fileToBeUploaded = new File(JenkinsEnvironmentVariables.getApplication());
        PDriveFileDTO alreadyUploadedApp = con.getAvailableAppIfUploaded(authToken, fileToBeUploaded.getName());
        if (alreadyUploadedApp == null) {
            System.out.println("Uploading App: " + fileToBeUploaded.getAbsolutePath());
            PDriveFileDTO uploadedApp = con.uploadApp(authToken, fileToBeUploaded, false);
            System.out.println("App uploaded");
            alreadyUploadedApp = new PDriveFileDTO();
            alreadyUploadedApp.file = uploadedApp.file;
        } else {
            System.out.println("App already present. Not uploading... ");
        }

        // Book the selected devices in pCloudy
        BookingDtoDevice[] bookedDevices = con.AppiumApis().bookDevicesForAppium(authToken, selectedDevices, deviceBookDurationTime, sessionName);
        System.out.println("Devices booked successfully");

        con.AppiumApis().initAppiumHubForApp(authToken, alreadyUploadedApp);
        URL endpoint = con.AppiumApis().getAppiumEndpoint(authToken);

        System.out.println("Appium Endpoint: " + endpoint);
        URL reportFolderOnPCloudy = con.AppiumApis().getAppiumReportFolder(authToken);
        System.out.println("Report Folder: " + reportFolderOnPCloudy);

        for (int i = 0; i < bookedDevices.length; i++) {
            BookingDtoDevice aDevice = bookedDevices[i];
            SingleRunReport report = new SingleRunReport();
            PCloudyAppiumSession pCloudySession = new PCloudyAppiumSession(con, authToken, aDevice);
            String uniqueName = aDevice.manufacturer + " " + aDevice.model + " " + aDevice.version;
            report.Header = uniqueName;
            report.Enviroment.addDetail("NetworkType", aDevice.networkType);
            report.Enviroment.addDetail("Phone Number", aDevice.phoneNumber);
            report.HyperLinks.addLink("Appium Endpoint", endpoint);
            report.HyperLinks.addLink("pCloudy Result Folder", reportFolderOnPCloudy);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("newCommandTimeout", 600);
            capabilities.setCapability("launchTimeout", 90000);
            capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
            capabilities.setCapability("browserName", aDevice.capabilities.deviceName);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.mventus.selfcare.activity");
            capabilities.setCapability("appActivity", "com.mventus.selfcare.activity.MainActivity");
            capabilities.setCapability("rotatable", true);
            capabilities.setCapability("automationName", "uiautomator2");
            capabilities.setCapability("systemPort", new Random().nextInt(2000) + 1024);
            capabilities.setCapability("forceReset", true);
            
            //Added for new phone number mapping implementation
            //Prepaid Numbers8879009022  9727123952   9595700553
   //  String[] str = new String[]{"8879009022","7021780248","9727123952","9595700553","9176217051","8375911224","9654936684","8939238054","7069006154"};
            
            //Postpaid Numbers
          String[] str = new String[]{"9619218213","9176558313","9884541507","9176500206","7069002553","9582940953","9643316907","9884516031","9176635080","7069002192"};
            
            HashMap<String, String> numberMapping = new HashMap<>();
            numberMapping.put(uniqueName,str[i]);

            DeviceContext aDeviceContext = new DeviceContext(uniqueName);
            //Added fr new phone number mapping implementation
            aDeviceContext.phoneNoMap = numberMapping.get(uniqueName);

            aDeviceContext.endpoint = endpoint;
            aDeviceContext.device = aDevice;
            aDeviceContext.pCloudySession = pCloudySession;
            aDeviceContext.report = report;
            aDeviceContext.capabilities = capabilities;

            allDeviceContexts.put(uniqueName, aDeviceContext);

            XmlTest aTestNgDeviceTest = new XmlTest(mySuite);
            aTestNgDeviceTest.setName("test_" + uniqueName);
            aTestNgDeviceTest.addParameter("myDeviceContext", uniqueName);

            aTestNgDeviceTest.setXmlClasses(myClasses);
            allDevicesTests.add(aTestNgDeviceTest);
        }
        mySuite.setThreadCount(bookedDevices.length);
        // add the list of tests to your Suite.
        mySuite.setTests(allDevicesTests);

        // Add the suite to the list of suites.
        List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
        mySuites.add(mySuite);

        // Set the list of Suites to the testNG object you created earlier.
        myTestNG.setXmlSuites(mySuites);

        // Create TestNG.xml
        File file = new File("./TestNG" + System.currentTimeMillis() + ".xml");
        FileWriter writer = new FileWriter(file);
        writer.write(mySuite.toXml());
        writer.close();
        // invoke run() - this will run your class.
        myTestNG.run();

        con.revokeTokenPrivileges(authToken);

       // System.out.println("Execution Completed...");
        
        
        
        
        
        
        
        
        
        //Latest
        File consolidatedReport = new File(ReportsFolder, "Consolidated Reports.html");
		HtmlFilePrinter printer = new HtmlFilePrinter(consolidatedReport);
		MultipleRunReport multipleReports = new MultipleRunReport();
		for (DeviceContext ctx : Controller.allDeviceContexts.values()) {
			multipleReports.add(ctx.report);
		}
		printer.printConsolidatedSingleRunReport(multipleReports);
		System.out.println("Check the reports at : " + consolidatedReport.getAbsolutePath());
		System.out.println("Execution Completed...");


    }
}

