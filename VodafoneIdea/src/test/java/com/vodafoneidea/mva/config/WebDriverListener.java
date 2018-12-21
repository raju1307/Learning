package com.vodafoneidea.mva.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vodafoneidea.mva.utils.GenericFunctions;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.xml.XmlClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	    Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	    Test Utilities and Listeners
 */

public class WebDriverListener implements ITestListener,IInvokedMethodListener{

    ExtentReports report;
    ExtentTest logger;
    ExtentTestFactory extentTestFactory;
    private static AtomicInteger atomicIndex = new AtomicInteger(0);
    private int count = 0;
    private int maxCount = Integer.parseInt("1");
    static HashMap<String,ExtentTest> extentMap = new HashMap();
    PropertyReader propertyReader;
    public static String filePath = System.getProperty("user.dir") + "/target/AutomationReport.html";


    public WebDriverListener() {
        extentTestFactory = new ExtentTestFactory();
    }

    @Override public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            String browserName = iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            AppiumDriver driver = null;//DriverFactory.createInstance(browserName);
            DriverManager.setDriver(driver);
        }
        Thread.currentThread().setName(String.valueOf(atomicIndex.getAndIncrement()));
    }

    @Override public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTest child = extentMap.get(iInvokedMethod.getTestMethod().getRealClass().getSimpleName())
                    .createNode(result.getMethod().getMethodName())
                    .assignCategory(iInvokedMethod.getTestMethod().getRealClass().getSimpleName());
            extentTestFactory.setExtentTest(child);
            extentTestFactory.getExtentTest().pass("Test passed");
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotNameWithTimeStamp = currentDateAndTime();
            String failedScreen =
                    System.getProperty("user.dir") + "/target/screenshot/" + iInvokedMethod.getTestMethod().getRealClass().getSimpleName() + "/" + result.getMethod().getMethodName() + "/"
                            + screenShotNameWithTimeStamp + "_" + result.getMethod().getMethodName() + "_failed" + ".png";

            try {
                String screenPath = GenericFunctions.readFromNotepad();

                captureScreenShot(iInvokedMethod.getTestMethod().getRealClass().getSimpleName(),result.getMethod().getMethodName());
                extentTestFactory.getExtentTest().addScreenCaptureFromPath(failedScreen);
                extentTestFactory.getExtentTest().fail("Te" +
                        "st failed");
                logger.log(Status.FAIL, (Markup) logger.addScreenCaptureFromPath(screenPath));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @Override public void onStart(ITestContext iTestContext) {
        report = new ExtentReports();
        report.attachReporter(getHtmlReporter());
        report.setSystemInfo("Selenium Java Version", "3.0");
        String environment = System.getenv("EnvironmentName");

        report.setSystemInfo("Environment", environment);
        List<XmlClass> classnames = iTestContext.getCurrentXmlTest().getClasses();
        for(XmlClass classname:classnames) {
            String name = classname.getName().toString();
            String[] names = name.split("\\.");
            extentMap.put(names[names.length - 1],report.createTest(names[names.length - 1]));
        }
    }

    @Override public void onFinish(ITestContext iTestContext) {
        report.flush();
    }

    public void captureScreenShot(String className, String methodName) throws IOException, InterruptedException {
        try{

//            File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//
//            String screenShotNameWithTimeStamp = currentDateAndTime();
//            String failedScreen =
//                    System.getProperty("user.dir") + "/target/screenshot/" + className + "/" + methodName + "/"
//                            + screenShotNameWithTimeStamp + "_" + methodName + "_failed" + ".png";
//            String fileName = screenShotNameWithTimeStamp + "_" + methodName + "_failed" + ".png";
//            FileUtils.copyFile(scrFile, new File(failedScreen));
//            String filePath = failedScreen.toString();
//            GenericFunctions.writeToNotepad(filePath);
//
//            /*String path2 = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
//             Reporter.log(path2);*/
//            String path = "<center><a href=\"file://" + filePath + "\" alt=\"\" target=\"_blank\" >Screenshot Image:</a>"+fileName+"</center>";
//            Reporter.log(path);
//            ExtentTest logger=null;
//            logger.log(Status.FAIL, (Markup) logger.addScreenCaptureFromPath(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String currentDateAndTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        return now.format(dtf);
    }

    private static ExtentHtmlReporter getHtmlReporter() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setDocumentTitle("VodafoneIDEA - Automation");
        htmlReporter.config().setReportName("MyVodafoneApp Automation");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        return htmlReporter;
    }


    public boolean retry(ITestResult result) {
        if(count < maxCount && !result.isSuccess()) {
            System.out.println("Retrying test case: " + result.getMethod() + " [" + result.getParameters()[0] + "]" + ", " + count + " out of " + maxCount);
            count++;
            return true;
        }
        Object[] obj = result.getParameters();
        if (result.getStatus() == ITestResult.FAILURE && count == maxCount){
            ExtentTest child = extentMap.get(result.getMethod().getRealClass().getSimpleName())
                    .createNode(result.getMethod().getMethodName() + " [" + obj[0] + "]")
                    .assignCategory(result.getMethod().getRealClass().getSimpleName());
            ExtentTestFactory.setExtentTest(child);
            ExtentTestFactory.getExtentTest().log(Status.FAIL, "<pre>" + result.getThrowable() + "</pre>");
            try {
                captureScreenShot(result.getMethod().getRealClass().getSimpleName(),result.getMethod().getMethodName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                WebDriver driver = DriverManager.getDriver();
                if (driver != null) {
                    driver.quit();
                }
            }
        }
        return false;
    }

    @Override public void onTestStart(ITestResult iTestResult) {

    }

    @Override public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
}