package com.vodafoneidea.mva.pages.actions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssts.util.reporting.ExecutionResult;
import com.ssts.util.reporting.SingleRunReport;
import com.vodafoneidea.mva.config.DeviceHelper;
import com.vodafoneidea.mva.config.DeviceInterface;
import com.vodafoneidea.mva.config.WebDriverListener;
import com.vodafoneidea.mva.pages.objects.HamburgerObjects;
import com.vodafoneidea.mva.test.DeviceContext;
import io.appium.java_client.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

//import static com.sun.jmx.snmp.ThreadContext.contains;
import static io.appium.java_client.android.AndroidKeyCode.KEYCODE_PAGE_UP;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class HamburgerMenu {
    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    HamburgerObjects hamburgerObjects = new HamburgerObjects();
    AppiumDriver appiumDriver;
    AndroidDriver<MobileElement> driverandroid;

    public HamburgerMenu(WebDriver driver) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), hamburgerObjects);
        //   this.runnerInfo = runnerInfo;
    }

    public void VerifyHamburgerMenuOption(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            hamburgerObjects.HamburgerButton.click();
            int count = 0;
            String[] Expected = {"Home ", "Bills and Payments ", "Shop & Extras ", "Super Deals ",
                    "Change Date ", "Pay Bill for others ", "Roaming ",
                    "Recharge for Others ", "Your account ", "Active Packs & Plans ",
                    "Device Health ", "Network & Usage ", "RED Together ", "M-Pesa ",
                    "New Connection ", "Share App ", "Home & SME Broadband ",
                    "Help & Support ", "Legal ", "Recharge and more ", "Super Plans ",
                    "Offers and extras ", "Pay Bill for others ", "Active Packs & Services", "Upgrade plan "};

            List<WebElement> allElements;
            allElements = driver.findElements(By.className("android.widget.Button"));
            System.out.println("Number of elements:" + allElements.size());
            for (WebElement element : allElements) {
                System.out.println("Element are getting Displayed------>" + element.getText() + element);
                String Actual = element.getText();
                //   boolean contains = Stream.of(Actual).anyMatch(x -> x.equals(Expected));
                boolean found = Arrays.asList(Expected).contains(Actual);

                if (found) {
                    //  System.out.println("The Value is found");
                    report.log(LogStatus.PASS, "Succesfully Verified HamburgerMenuOption for Prepaid Customer");
                    pcloudyreport.addComment("Succesfully Verified HamburgerMenuOption for Prepaid Customer");
                } else {
                    //   System.out.println(" The value is not found");
                    report.log(LogStatus.FAIL, "HamburgerMenuOption Not Verified in Prepaid number");
                    pcloudyreport.addStep("Click", null, "HamburgerMenuOptionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
                }
            }
            //  Assert.assertTrue(found);
            //   mainPageObjects.ProfileName.isDisplayed();
            //   boolean Profileicon = mainPageObjects.ProfileIcon.isDisplayed();
            //   boolean menuoption = mainPageObjects.MenuOption.isDisplayed();
            //   Assert.assertTrue(Profileicon);
            //   Assert.assertTrue(menuoption);
            report.log(LogStatus.PASS, "Succesfully Verified HamburgerMenuOption for Prepaid Customer");
            pcloudyreport.addComment("Succesfully Verified HamburgerMenuOption for Prepaid Customer");
         /*  prePaidCallSection();
             prePaidTabSection();
*/        // ExtentTestFactory.getExtentTest().info("test");

        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "VerifyHamburgerMenuOption");
            report.log(LogStatus.FAIL, "HamburgerMenuOption Not Verified in Prepaid number");
            pcloudyreport.addStep("Click", null, "HamburgerMenuOptionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }

    public void RechargeForother(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
            hamburgerObjects.HamburgerButton.click();
            System.out.println("Enter Recharge for other function");

            hamburgerObjects.Rechargeforother.click();
            System.out.println(".From Hamburger recharge for other is clicked ");

            hamburgerObjects.ManuallyEnterNumber.sendKeys("9962248716 ");
            System.out.println("Manually enter a Number");

            hamburgerObjects.EnterAmountForRecharge.sendKeys("10");
            System.out.println("....Enter Amount for recharge for other....");

            swipeUpUntilTextExists("Recharge Now", 1);

            hamburgerObjects.RechargeNowCTA.click();
            System.out.println("......Recharge Now Button Clicked Successfully.......");
            Thread.sleep(2000);

            hamburgerObjects.payTM.click();
            System.out.println("......Paytm PayNow Clicked Successfully.......");
            Thread.sleep(2000);

        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "RechargeForother");
            report.log(LogStatus.FAIL, "RechargeForother Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }

    public void NewConnection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
            swipeUpUntilTextExists("New Connection", 1);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            hamburgerObjects.NewConnection.click();
            hamburgerObjects.SubNewConnection.click();
            System.out.println(" New Connection is clicked from Hamburger Menu");
            List<WebElement> formElements;
            formElements = driver.findElements(By.className("android.widget.EditText"));
            System.out.println("Number of elements:" + formElements.size());

            formElements.get(0).sendKeys("Ashwini");
            formElements.get(1).sendKeys("9636489183");
            formElements.get(2).sendKeys("ashwini.kamble@qualitrix.com");
            formElements.get(3).sendKeys("Mum");
            Thread.sleep(5000);
            formElements.get(3).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//android.widget.Button[@text='Mumbai']")).click();
            hamburgerObjects.proceedNC.click();
            System.out.println("Procced Nc Clicked");
            waitOptions(Duration.ofSeconds(4));
        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "RechargeForother");
            report.log(LogStatus.FAIL, "RechargeForother Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }

    }

    public void swipeUpUntilTextExists(String expected, int times) {
        int i = 0;
        do {
            swipeUp();
            i++;
            System.out.println(i);
            if (i == times)
                break;
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = (int) (size.width / 2.2);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction((PerformsTouchActions) driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(3)))
                    .moveTo(point(startx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete succesfully.");
        }
    }

    public void helpAndSupport(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
            swipeUpUntilTextExists("Help & Support", 2);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            hamburgerObjects.helpandSupport.click();
            Thread.sleep(2000);
            hamburgerObjects.getSupport.click();
            System.out.println("Get Support Clicked");
            hamburgerObjects.faqKeyword.sendKeys("Prepaid");
            Thread.sleep(4000);
            hamburgerObjects.searchButton.click();
            System.out.println("Help and Support done");
            hamburgerObjects.chatTab.click();
            System.out.println("Chat is done");
            hamburgerObjects.calltab.click();
            System.out.println("Call is done");
            hamburgerObjects.email.click();
            System.out.println("Email");
            hamburgerObjects.backButtonFAQ.click();
            System.out.println("Back Button Click");
            driver.wait(15);
        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "helpAndSupport");
            report.log(LogStatus.FAIL, "helpAndSupport Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }

    public void shareApp(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
            hamburgerObjects.shareElement.click();
        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "shareApp");
            report.log(LogStatus.FAIL, "shareApp Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }
}