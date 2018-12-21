package com.vodafoneidea.mva.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.exception.ConnectError;
import com.ssts.util.reporting.ExecutionResult;
import com.ssts.util.reporting.printers.HtmlFilePrinter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestSetUp {

    public static ExtentReports report;

    @BeforeSuite
    public void beforeSuite() {
        report = new ExtentReports(System.getProperty("user.dir") + "/Reports/ExtentReport_pCloudy.html");
     // report.loadConfig(new File("Q:\\PCloudyExtentReportDec03\\VodafoneIdea\\extent-config.xml"));
        
        report.loadConfig(new File("caps\\extent-config.xml"));
        System.out.println("Extent report config file loaded successfully");
        //report.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
        System.out.println("Before Suite Execution Started");
    }


    @Parameters({"myDeviceContext"})
    @BeforeMethod
    public void beforeClass(String myDeviceContext) throws ConnectError, IOException, InterruptedException {
        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        try {

        	myContext.report.beginTestcase("@Before Class");
        	myContext.report.addComment("@Before Class : " + getClass().getName());
            myContext.driver = new AndroidDriver<WebElement>(myContext.endpoint, myContext.capabilities);
            myContext.report.addStep("Launch App", myContext.capabilities.toString(), myContext.endpoint.toString(), ExecutionResult.Pass);
            System.out.println("Phone number using " +myContext.phoneNoMap +" on "+ myContext.getUniqueName());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Parameters({"myDeviceContext"})
    @AfterMethod
    public void afterClass(String myDeviceContext) throws ConnectError, IOException {
    	try{
        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);

        
        //Latest
        myContext.report.beginTestcase("@AfterClass");
        myContext.report.addStep("@AfterClass : " + getClass().getName(), null, null, ExecutionResult.Pass);
        myContext.driver.quit();
        myContext.report.addStep("Quit Driver Object", null, null, ExecutionResult.Pass);
        
        
        myContext.driver.quit();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	
  
    }

    
    
    //Latest
    @Parameters({ "myDeviceContext" })
    @BeforeTest
    public void beforeTest(String myDeviceContext) {
        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        myContext.report.beginTestcase("@Before Test: " + this.getClass().getName());
        myContext.report.addStep("@BeforeTest", null, null, ExecutionResult.Pass);

        BookingDtoDevice aDevice = myContext.device;
        myContext.deviceFolder = new File(Controller.ReportsFolder, aDevice.manufacturer + " " + aDevice.model + " " + aDevice.version);
        myContext.snapshotsFolder = new File(myContext.deviceFolder, "Snapshots");
        myContext.snapshotsFolder.mkdirs();
        myContext.report.addStep("Create Report Folders", null, null, ExecutionResult.Pass);
    }

    
    
    
    
    
    @Parameters({"myDeviceContext"})
    @AfterTest(alwaysRun = true)
    public void afterTest(String myDeviceContext) throws Exception {
        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        try {
            myContext.pCloudySession.releaseSessionNow();
            
            
            
            //Latest
            try {
                myContext.report.beginTestcase("@After Test: " + this.getClass().getName());
                myContext.pCloudySession.releaseSessionNow();
                myContext.report.addStep("Release Appium Session", null, null, ExecutionResult.Pass);

            } catch (ConnectError | IOException e) {
                myContext.report.addStep("Error Running TestCase", null, e.getMessage(), ExecutionResult.Fail);
                e.printStackTrace();

            } finally {
                HtmlFilePrinter printer = new HtmlFilePrinter(new File(myContext.deviceFolder, myContext.deviceFolder.getName() + ".html"));
                printer.printSingleRunReport(myContext.report);
            }
            
            

        } catch (ConnectError | IOException e) {
            e.printStackTrace();

        }
    }

    @AfterSuite
    public void afterSuite() throws InterruptedException {
    	
    	
    	Thread.sleep(2000);
    	
    	
        report.flush();
        System.out.println("Reports--> " + System.getProperty("user.dir") + "/Reports/ExtentReport_pCloudy.html");
        System.out.println("After Suite Executed");

        
        
        
        
    }

    public static String takeScreenShot(DeviceContext deviceContext) {
        try {
            File snapshotTmpFile = deviceContext.pCloudySession.takeScreenshot();



//			File snapshotFile = new File(deviceContext.snapshotsFolder, snapshotTmpFile.getName());
//			FileUtils.moveFile(snapshotTmpFile, snapshotFile);
            //return snapshotFile.getAbsolutePath();
            return snapshotTmpFile.getAbsolutePath();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    
    

    protected String takeScreenShot2(DeviceContext deviceContext) {
        try {
            File snapshotTmpFile = deviceContext.pCloudySession.takeScreenshot();
            File snapshotFile = new File(deviceContext.snapshotsFolder, snapshotTmpFile.getName());
            FileUtils.moveFile(snapshotTmpFile, snapshotFile);
            return snapshotFile.getAbsolutePath();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return null;
    }
}