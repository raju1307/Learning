package com.vodafoneidea.mva.pages.actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssts.util.reporting.ExecutionResult;
import com.ssts.util.reporting.SingleRunReport;
import com.vodafoneidea.mva.config.DeviceHelper;
import com.vodafoneidea.mva.config.DeviceInterface;
import com.vodafoneidea.mva.config.WebDriverListener;
import com.vodafoneidea.mva.pages.objects.loginPageObjects;
import com.vodafoneidea.mva.test.DeviceContext;
import com.vodafoneidea.mva.test.TestSetUp;
import com.vodafoneidea.mva.test.TestVer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class loginPage extends TestSetUp{
    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;

    WebDriverListener webDriverListener = new WebDriverListener();
    static Logger log = Logger.getLogger(TestVer.class.getName());
    loginPageObjects loginPageObjects = new loginPageObjects();

    public loginPage(WebDriver driver) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
        //this.runnerInfo = runnerInfo;
    }

    public void loginPage(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {

        try {
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            loginPageObjects.loginButton.click();
            log.info(" | "+"loginPage"+"Click login button");
            report.log(LogStatus.INFO, "User is in login page");
            pcloudyreport.addComment("User is in LoginPage");
            
            loginPageObjects.msisdnInput.click();
            report.log(LogStatus.INFO, "Enter Phone Number");
            Thread.sleep(2000);
           // loginPageObjects.msisdnInput.sendKeys("9962248716");   9619218231
            System.out.println("Phone number using " +myContext.phoneNoMap +"on"+ myContext.getUniqueName());
            loginPageObjects.msisdnInput.sendKeys(myContext.phoneNoMap);
            log.info(" | "+"loginPage"+"Enter PhoneNo");

            ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON );
            loginPageObjects.sendOtpViaSmsButton.click();
            log.info(" | "+"loginPage"+"Click SMS button");
            Thread.sleep(2000);

            loginPageObjects.otpBoxOne.setValue("1");
            loginPageObjects.otpBoxTwo.setValue("1");
            loginPageObjects.otpBoxThree.setValue("1");
            loginPageObjects.otpBoxFour.setValue("1");
            log.info(" | "+"loginPage"+"Enter OTP");
            report.log(LogStatus.INFO, "Otp Entered Succesfully");
            pcloudyreport.addComment("Otp Entered Succesfully");
            
           /* loginPageObjects.otpBoxOne.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxTwo.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxThree.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxFour.sendKeys("1");
            Thread.sleep(2000);*/


            try {
                //loginPageObjects.otpBoxFour.click();
               // loginPageObjects.otpBoxFour.setValue("1");
               // loginPageObjects.otpBoxFour.sendKeys("1");
                Thread.sleep(2000);


               // ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON);
                loginPageObjects.otploginbutton.click();
                log.info(" | "+"loginPage"+"Click login button");
                report.log(LogStatus.PASS,"Logged in Succesfully");
                pcloudyreport.addComment("User Logged in Succesfully");
                pcloudyreport.addStep("Click",null,"Home Screen",takeScreenShot(myContext), ExecutionResult.Pass);
                
                
                Thread.sleep(5000);
loginPageObjects.ContinueToMyVodaphoneApp.click();
log.info(" | "+"loginPage"+"Click continuewToMyVodaphoneApp button");
report.log(LogStatus.PASS,"HomePage Displayed Succesfully");
pcloudyreport.addComment("HomePage Displayed Succesfully");

            }
            catch(Exception e3)
            {

            }

        }
        catch (Exception e) {
            webDriverListener.captureScreenShot("loginPage","loginPage");
            report.log(LogStatus.FAIL,"Login Script has Failed");
            
pcloudyreport.addStep("Click",null,"",ExecutionResult.Fail);
log.error(" | "+"loginPage"+"Login Script has Failed");
Assert.assertFalse(false,e.getMessage());


        }
    }


    
    
    
    
    
    //Latest
    public void PostPaidLogin(ExtentTest report, SingleRunReport pcloudyreport,String PhoneNo) throws Exception {

        try {
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            loginPageObjects.loginButton.click();
            report.log(LogStatus.INFO, "User is in login page");
            pcloudyreport.addComment("User is in LoginPage");
            
            loginPageObjects.msisdnInput.click();
            report.log(LogStatus.INFO, "Enter Phone Number");
            Thread.sleep(2000);
           // loginPageObjects.msisdnInput.sendKeys("9962248716");   9619218231
            //System.out.println("Phone number using " +myContext.phoneNoMap +"on"+ myContext.getUniqueName());
            loginPageObjects.msisdnInput.sendKeys(PhoneNo);

            ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON );
            loginPageObjects.sendOtpViaSmsButton.click();
            Thread.sleep(2000);

            loginPageObjects.otpBoxOne.setValue("1");
            loginPageObjects.otpBoxTwo.setValue("1");
            loginPageObjects.otpBoxThree.setValue("1");
            loginPageObjects.otpBoxFour.setValue("1");
            report.log(LogStatus.INFO, "Otp Entered Succesfully");
            pcloudyreport.addComment("Otp Entered Succesfully");
            
           /* loginPageObjects.otpBoxOne.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxTwo.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxThree.sendKeys("1");
            Thread.sleep(2000);
            loginPageObjects.otpBoxFour.sendKeys("1");
            Thread.sleep(2000);*/


            try {
                //loginPageObjects.otpBoxFour.click();
               // loginPageObjects.otpBoxFour.setValue("1");
               // loginPageObjects.otpBoxFour.sendKeys("1");
                Thread.sleep(2000);


               // ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON);
                loginPageObjects.otploginbutton.click();

                report.log(LogStatus.PASS,"Logged in Succesfully");
                pcloudyreport.addComment("User Logged in Succesfully");
               // pcloudyreport.addStep("Click",null,"Home Screen",takeScreenShot(myContext), ExecutionResult.Pass);
                
                
                Thread.sleep(5000);
loginPageObjects.ContinueToMyVodaphoneApp.click();

report.log(LogStatus.PASS,"HomePage Displayed Succesfully");
pcloudyreport.addComment("HomePage Displayed Succesfully");

            }
            catch(Exception e3)
            {

            }

        }
        catch (Exception e) {
            webDriverListener.captureScreenShot("loginPage","loginPage");
            report.log(LogStatus.FAIL,"Login Script has Failed");
            
pcloudyreport.addStep("Click",null,"",ExecutionResult.Fail);

Assert.assertFalse(false,e.getMessage());


        }
    }
//    public loginPage(WebDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }
}

