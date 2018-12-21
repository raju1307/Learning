package com.vodafoneidea.mva.test;

import com.relevantcodes.extentreports.ExtentTest;
import com.vodafoneidea.mva.config.TestRunnerInfo;
import com.vodafoneidea.mva.pages.actions.loginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class loginTest extends TestSetUp{
    AppiumDriver driver;
    @Test
    public void testAppLogin(String myDeviceContext) throws Exception {
        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);

        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"test1");
//        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);

    }

    public loginPage getLoginPage(WebDriver driver){

//        return new loginPage(new TestRunnerInfo().getDriverSession());
        return new loginPage(driver);
    }
}
