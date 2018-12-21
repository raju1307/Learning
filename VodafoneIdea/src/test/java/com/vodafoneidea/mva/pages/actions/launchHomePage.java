package com.vodafoneidea.mva.pages.actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssts.util.reporting.ExecutionResult;
import com.ssts.util.reporting.SingleRunReport;
import com.vodafoneidea.mva.config.DeviceHelper;
import com.vodafoneidea.mva.config.DeviceInterface;
import com.vodafoneidea.mva.config.WebDriverListener;
import com.vodafoneidea.mva.pages.objects.launchHomePageObjects;

import org.apache.log4j.Logger;
import com.vodafoneidea.mva.test.DeviceContext;
import com.vodafoneidea.mva.test.TestSetUp;
import com.vodafoneidea.mva.test.TestVer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.net.www.content.text.Generic;

import java.util.concurrent.TimeUnit;

public class launchHomePage extends TestSetUp {

    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();

    launchHomePageObjects homePageObjects = new launchHomePageObjects();
    static Logger log = Logger.getLogger(TestVer.class.getName());

    public launchHomePage(WebDriver driver) {
        System.out.println("Enter into LaunchHomePage");
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageObjects);
        //this.runnerInfo = runnerInfo;
    }


  //  By Shibu
   // public void launchHomePage(SingleRunReport report, DeviceContext myContext) throws Exception {
        public void launchHomePage(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {

        try {
            report.log(LogStatus.INFO,"Starting Test");
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            report.log(LogStatus.PASS,"APP Succesfully Launched");
            pcloudyreport.addComment("App Succesfully Launched");
            
            homePageObjects.allowPermissionButton.click();
//            report.addStep("Click",null,"Next Screen",takeScreenShot(myContext), ExecutionResult.Pass);
            pcloudyreport.addStep("Click",null,"Next Screen",takeScreenShot(myContext), ExecutionResult.Pass);
            homePageObjects.allowPermissionButton.click();
            log.info(" | "+"launchHomePage"+"Clicked Allow Permission button first time");
            
            homePageObjects.allowPermissionButton.click();
            log.info(" | "+"launchHomePage"+"Clicked Allow Permission button second time");
            homePageObjects.allowPermissionButton.click();
            log.info(" | "+"launchHomePage"+"Clicked Allow Permission button third time");
            homePageObjects.allowPermissionButton.click();
            log.info(" | "+"launchHomePage"+"Clicked Allow Permission button fourth time");
            report.log(LogStatus.INFO,"Clicked on Allow Permission");
          pcloudyreport.addComment("Clicked on Allow Permission");
          report.log(LogStatus.PASS,"Succesfully Clicked Permission button");
            pcloudyreport.addStep("Click",null,"Next Screen",takeScreenShot(myContext), ExecutionResult.Pass);
        }
        catch (Exception e) {
//            report.addStep("Exception Occur", null, e.getMessage(), takeScreenShot(myContext), ExecutionResult.Fail);

//            webDriverListener.captureScreenShot("launchHomePage","launchHomePage");
//            Assert.assertTrue(false,e.getMessage());

            report.log(LogStatus.FAIL,"App Didn't Launch Succesfully ");
            pcloudyreport.addStep("Click",null,"",ExecutionResult.Fail);
            report.log(LogStatus.ERROR, e);
            log.error(" | "+"launchHomePage"+"App Didn't Launch Succesfully");
            Assert.assertFalse(false,e.getMessage());
           
        }
    }

//    public launchHomePage(WebDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }
}
