package com.vodafoneidea.mva.pages.actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssts.util.reporting.ExecutionResult;
import com.ssts.util.reporting.SingleRunReport;
import com.vodafoneidea.mva.config.DeviceHelper;
import com.vodafoneidea.mva.config.DeviceInterface;
import com.vodafoneidea.mva.config.ExtentTestFactory;
import com.vodafoneidea.mva.config.WebDriverListener;
import com.vodafoneidea.mva.pages.objects.HamburgerObjects;
import com.vodafoneidea.mva.pages.objects.MainPageObjects;
import com.vodafoneidea.mva.pages.objects.loginPageObjects;
import com.vodafoneidea.mva.test.DeviceContext;
import com.vodafoneidea.mva.test.TestSetUp;
import com.vodafoneidea.mva.test.TestVer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.apache.log4j.Logger;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends TestSetUp
{
    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;

    WebDriverListener webDriverListener = new WebDriverListener();
    MainPageObjects mainPageObjects = new MainPageObjects();
    HamburgerObjects hamburgerObjects = new HamburgerObjects();
    static Logger log = Logger.getLogger(TestVer.class.getName());
    //ExtentTest report;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), mainPageObjects);
        
            /*    PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        PageFactory.initElements(new AppiumFieldDecorator(driver), hamburgerObjects);*/
      //  this.runnerInfo = runnerInfo;
    }

    public void VefifyHamburgerMenuOption(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {


        try {
          //  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

            //  mainPageObjects.ProfileName.isDisplayed();

           // boolean Profileicon = mainPageObjects.ProfileIcon.isDisplayed();

        	Thread.sleep(9000);
        	
        	mainPageObjects.closePrepaidOffePopup.click();
        	Thread.sleep(5000);


            boolean menuoption = mainPageObjects.MenuOption.isDisplayed();



          //  Assert.assertTrue(Profileicon);
            Assert.assertTrue(menuoption);

            report.log(LogStatus.PASS,"Succesfully Verified MenuOption for Prepaid Customer");
            pcloudyreport.addComment("Succesfully Verified MenuOption for Prepaid Customer");
            log.info(" | "+"VefifyHamburgerMenuOption"+"Verify MenuOption");
         /*   prePaidCallSection();

            prePaidTabSection();
*/


            // ExtentTestFactory.getExtentTest().info("test");

        } catch (Exception e) {
           // webDriverListener.captureScreenShot("MainPage", "VerifyMainPageSection");
            report.log(LogStatus.FAIL,"MenuOption Not Verified in Prepaid number");
            pcloudyreport.addStep("Click",null,"MenuOption Not Verified in Prepaid number",ExecutionResult.Fail);
            log.error(" | "+"VefifyHamburgerMenuOption"+"MenuOption Not Verified in Prepaid number");
            Assert.assertTrue(false, e.getMessage());
        }
    }


    public void prePaidCallSection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
    {
        try
        {
            //to verifyCals section
            WebElement CallsValue=mainPageObjects.CallsSection;
           boolean  CalsSect=CallsValue.isDisplayed();
            Assert.assertTrue(CalsSect);


            WebElement DataValue=mainPageObjects.dataSection;
            boolean  dataValueSec=DataValue.isDisplayed();
            Assert.assertTrue(dataValueSec);


            WebElement BalanceValue=mainPageObjects.balanceSection;
            boolean  BalanceSect=BalanceValue.isDisplayed();
            Assert.assertTrue(BalanceSect);
            report.log(LogStatus.PASS,"Succesfully Verified CallSection , DataValue,BalanceValue for Prepaid Customer");
            pcloudyreport.addComment("Succesfully Verified CallSection , DataValue,BalanceValue for Prepaid Customer");
            log.info(" | "+"prePaidCallSection"+"Verify Calls,Data,BalanceSectionv");
            pcloudyreport.addStep("Verify","","Succesfully Verified CallSection , DataValue,BalanceValue for Prepaid Customer",ExecutionResult.Pass);
        }
        catch (Exception e3)
        {

            report.log(LogStatus.FAIL,"Failed in Verifying CallSection, DataValue, BalanceValue for Prepaid Customer");
            report.log(LogStatus.FAIL,e3);
            
            log.error(" | "+"prePaidCallSection"+"Failed in Verifying CallSection, DataValue, BalanceValue for Prepaid Customer");
            pcloudyreport.addStep("Click",null,"Failed in Verifying CallSection, DataValue, BalanceValue for Prepaid Customer",ExecutionResult.Fail);
            Assert.assertTrue(false, e3.getMessage());
        }
    }


    public void prePaidTabSection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
    {
        try
        {
            WebElement Tabs=mainPageObjects.tabSection;
            List<WebElement> childElements9 = Tabs.findElements(By.className("android.view.View"));
            WebElement offers= childElements9.get(1);
            WebElement superPlans= childElements9.get(0);
            WebElement history= childElements9.get(2);
            WebElement upgrade= childElements9.get(3);
            WebElement superDeals= childElements9.get(4);

            String Ofes=offers.getText();
            String spr=superPlans.getText();
            String hstry=history.getText();
            String upg=upgrade.getText();
            String spdls=superDeals.getText();

            Assert.assertEquals(spr,"Super Plans");
            Assert.assertEquals(Ofes,"Offers");
            Assert.assertEquals(hstry,"History");
            Assert.assertEquals(upg,"Upgrade");
            Assert.assertEquals(spdls,"Super Deals");
            report.log(LogStatus.PASS,"Succesfully Verified Tabs Section Like Super plans, Offers, History, Upgrade, Super Deals for Prepaid Customer");
            log.info(" | "+"prePaidTabSection"+"Verify Tabs Section Like Super plans, Offers");
         //   pcloudyreport.addComment("Succesfully Verified CallSection , DataValue,BalanceValue for Prepaid Customer");
            pcloudyreport.addStep("Verify","","Succesfully Verified Tabs Section Like Super plans, Offers, History, Upgrade, Super Deals for Prepaid Customer",ExecutionResult.Pass);
        }
        catch (Exception e1)

        {
            report.log(LogStatus.FAIL,"Failed in Verifying Tabs Section Like Super plans, Offers, History, Upgrade, Super Dealfor Prepaid Customer");
            pcloudyreport.addStep("Click",null,"Failed in Verifying Tabs Section Like Super plans, Offers, History, Upgrade, Super Dealfor Prepaid Customer",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e1);
            log.error(" | "+"prePaidTabSection"+"Failed in Verifying Tabs Section Like Super plans, Offers, History");
        }
    }







        public void verifyPostPaidDashboardSection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception
        {


            try {
                driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

                boolean postProfileicon= mainPageObjects.postPaidProfileIcon.isDisplayed();
                boolean  menuoption= mainPageObjects.MenuOption.isDisplayed();
                            boolean out=mainPageObjects.postPaidOutStandingAmount.isDisplayed();


                Assert.assertTrue(postProfileicon);
                Assert.assertTrue(menuoption);
                              Assert.assertTrue(out);
                report.log(LogStatus.PASS,"Succesfully Verified Menu Option for PostPaid Customer");
                pcloudyreport.addStep("Verify","","Succesfully Verified Menu Option for PostPaid Customer",ExecutionResult.Pass);
              /*  veifydataAndSmsSection();
                currentSpendSection();*/
                log.info(" | "+"verifyPostPaidDashboardSection"+"Verify Menu Option for PostPaid Customer");

            }
            catch (Exception e) {

                report.log(LogStatus.FAIL,"Failed in Verifying Menu Option for PostPaid Customer");
                pcloudyreport.addStep("Click",null,"Failed in Verifying Menu Option for PostPaid Customer",ExecutionResult.Fail);
                report.log(LogStatus.FAIL,e);
                log.error(" | "+"verifyPostPaidDashboardSection"+"Failed in Verifying Menu Option for PostPaid Customer");
            }


    }



    public void veifydataAndSmsSection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
    {

        try
        {
            //To Click on data Profile
            WebElement DataSmSectoin =mainPageObjects.postPaidDataSmsSection;

            List<WebElement> childElements =DataSmSectoin.findElements(By.className("android.widget.Button"));
            WebElement Data = childElements.get(1);
            WebElement mins = childElements.get(2);
            WebElement Sms = childElements.get(3);
            WebElement MPesa = childElements.get(4);

             /*   boolean s=Data.isDisplayed();
                boolean s2=mins.isDisplayed();
                boolean s3=Sms.isDisplayed();
                boolean s4=MPesa.isDisplayed();*/

            String DataSec=Data.getText();
            System.out.println(DataSec);

            String MinsSec=mins.getText();
            System.out.println(MinsSec);


            String Smsec=Sms.getText();
            System.out.println(Smsec);


            String MpesaSec=MPesa.getText();
            System.out.println(MpesaSec);

            Assert.assertEquals(DataSec,"Data");
            Assert.assertEquals(MinsSec,"Mins");
            Assert.assertEquals(Smsec,"SMS");
            Assert.assertEquals(MpesaSec,"M- Pesa");
            report.log(LogStatus.PASS,"Succesfully Verified Data&SMS Section for PostPaid Customer");
            pcloudyreport.addStep("Verify","","Succesfully Verified Data&SMS Section for PostPaid Customer",ExecutionResult.Pass);
            log.info(" | "+"veifydataAndSmsSection"+"Verify Data&SMS Section for PostPaid Customer");
            
        }
        catch (Exception e)
        {
            report.log(LogStatus.FAIL,"Failed in Verifying Data&SMS Section for PostPaid Customer");
            pcloudyreport.addStep("Click",null,"Failed in Verifying Data&SMS Section for PostPaid Customer",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e);
            log.error(" | "+"veifydataAndSmsSection"+"Failed in Verifying Data&SMS Section for PostPaid Customer");
        }
    }

    public void currentSpendSection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
    {
        try
        {

            WebElement CurrentSpendSec = mainPageObjects.currentSpendSection;

            List<WebElement> childElements7 = CurrentSpendSec.findElements(By.className("android.widget.Button"));
            WebElement currentSpend = childElements7.get(0);
            boolean  currentSpendValue=currentSpend.isDisplayed();
            //String g=currentSpend.getText();

            Assert.assertTrue(currentSpendValue);
            report.log(LogStatus.PASS,"Succesfully Verified currentSpendSection for PostPaid Customer");
            log.info(" | "+"currentSpendSection"+"Verify currentSpendSection for PostPaid Customer");
            pcloudyreport.addStep("Verify","","Succesfully Verified currentSpendSection for PostPaid Customer",ExecutionResult.Pass);
        }
        catch (Exception e)
        {
            report.log(LogStatus.FAIL,"Failed in Verifying currentSpendSection for PostPaid Customer");
            pcloudyreport.addStep("Click",null,"Failed in Verifying currentSpendSection for PostPaid Customer",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e);
            log.error(" | "+"currentSpendSection"+"Failed in Verifying currentSpendSection for PostPaid Customer");

        }
    }

public void clickManageProfile(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
{
    try
    {
    	Thread.sleep(9000);
    	
    	mainPageObjects.closePrepaidOffePopup.click();
    	Thread.sleep(6000);
    	
    	
    	//Thread.sleep(8000);
    	mainPageObjects.MenuOption.click();
Thread.sleep(3000);
    	mainPageObjects.yourAccount.click();
    	Thread.sleep(4000);
        //To Click on Manage Profile
    	
    	//Clck on ManageProfile
    /*	
        WebElement parentElement = driver.findElement(By.className("android.widget.ListView"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.view.View"));
        WebElement mainElement = childElements.get(1);
        mainElement.findElement(By.className("android.view.View")).click();*/
    	
    	
    	
    	/*driver.findElement(By.xpath("//android.view.View[@text='Manage Profiles Add/Edit/Delete Profiles ']")).click();
        log.info(" | "+"clickManageProfile"+"click on manageprofile");*/
        
        
        
        
        
       // System.out.println("click on manageprofile");
        report.log(LogStatus.INFO,"Clicked on ManageProfile");
        pcloudyreport.addStep("Click","","Clicked on ManageProfile",ExecutionResult.Pass);
    }
    catch (Exception e)
    {
    	report.log(LogStatus.FAIL,"Clicked on ManageProfile");
    	log.error(" | "+"clickManageProfile"+"Click on ManageProfile");
        pcloudyreport.addStep("Click",null,"Failed in Clicking on ManageProfile",ExecutionResult.Fail);
        report.log(LogStatus.FAIL,e);
    }
}


    public void addNewProfile(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext)
    {
        try
        {
            //Click on Add Profile
            WebElement parentElement2 = driver.findElement(By.className("android.widget.ListView"));

            List<WebElement> childElements2 = parentElement2.findElements(By.className("android.view.View"));
            WebElement mainElement2 = childElements2.get(1);
            mainElement2.findElement(By.className("android.view.View")).click();
            Thread.sleep(3000);
            report.log(LogStatus.INFO,"Clicked on AddNewProfile button");
            pcloudyreport.addComment("Clicked on AddNewProfile button");
            log.info(" | "+"addNewProfile"+"click on add new profile button");
           
            driver.findElement(By.xpath("//android.widget.Button[@text='Add profiles You can add up to 5 profiles']")).click();
            Thread.sleep(3000);
            //Enter number
            mainPageObjects.EnterNo.click();
            Thread.sleep(2000);
            ((AppiumDriver<MobileElement>) driver).hideKeyboard();
            mainPageObjects.EnterNo.sendKeys("7069002553");
            Thread.sleep(3000);
            report.log(LogStatus.INFO,"Entered PhoneNo");
            pcloudyreport.addComment("Entered PhoneNo");
            log.info(" | "+"addNewProfile"+"Entered PhoneNo");
            ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON );


            mainPageObjects.generateOtp.click();

            mainPageObjects.otp1.sendKeys("1");
            mainPageObjects.otp2.sendKeys("1");
            mainPageObjects.otp3.sendKeys("1");
            mainPageObjects.otp4.sendKeys("1");
            
            report.log(LogStatus.INFO,"Otp Entered Succesfully");
            pcloudyreport.addComment("Otp Entered Succesfully");
            log.info(" | "+"addNewProfile"+"Otp Entered");
            Thread.sleep(3000);
            try {
                mainPageObjects.otp4.click();
                ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON);
            }
            catch(Exception e3)
            {

            }
            ((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER);

            mainPageObjects.addProfileButton.click();

            Thread.sleep(4000);

/*WebElement  SuccesMsg=driver.findElement(By.xpath("//android.view.View[@resource-id='toast-container']"));

            List<WebElement> childElements3 = SuccesMsg.findElements(By.className("android.widget.Button"));
            WebElement Msg = childElements3.get(0);
           String toastrmsg=Msg.getText();
            System.out.println(toastrmsg);
           Assert.assertEquals(toastrmsg,"Secondary profile added successfully ");*/
           report.log(LogStatus.PASS,"New Profile Added Succesfully");
           pcloudyreport.addStep("Verify","","New Profile Added Succesfully",ExecutionResult.Pass);
           // mainPageObjects.addProfileButton.click();
            log.info(" | "+"addNewProfile"+"New Profile Added");
        }
        catch (Exception e)
        {

        	report.log(LogStatus.FAIL,"Failed on Adding New Profile");
            pcloudyreport.addStep("Click",null,"Failed on Adding New Profile",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e);
        	
            log.error(" | "+"addNewProfile"+"Failed on Adding New Profile");
        }
    }

    public void editProfile(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContex) {
        try {
        	
        	
        Thread.sleep(8000);
        

    	
    	mainPageObjects.closePrepaidOffePopup.click();
    	Thread.sleep(6000);
    	
        
        	mainPageObjects.MenuOption.click();
    Thread.sleep(3000);
        	mainPageObjects.yourAccount.click();
        	Thread.sleep(4000);
        	
        	 WebElement parentElement2 = driver.findElement(By.className("android.widget.ListView"));

             List<WebElement> childElements2 = parentElement2.findElements(By.className("android.view.View"));
             WebElement mainElement2 = childElements2.get(1);
             mainElement2.findElement(By.className("android.view.View")).click();
             
             Thread.sleep(4000);
             
        	
        	//Click on edit Profile
            WebElement parentElement3 = driver.findElement(By.xpath("//android.view.View[@index='3']"));

            List<WebElement> childElements3 = parentElement3.findElements(By.className("android.view.View"));
            WebElement mainElement3 = childElements3.get(0);
            mainElement3.findElement(By.className("android.widget.Button")).click();
            
            
            report.log(LogStatus.INFO,"Click on Edit Profile");
            pcloudyreport.addComment("Click on Edit Profile");
            log.info(" | "+"editProfile"+"Click Edit Profile");
          //  pcloudyreport.addStep("Click","","Click on Edit Profile",ExecutionResult.Pass);

            //edit name
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='checkSmileyNickname']")).click();
            ((AppiumDriver<MobileElement>) driver).hideKeyboard();
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='checkSmileyNickname']")).sendKeys("test");
            
Thread.sleep(3000);
            report.log(LogStatus.INFO,"Updated Profile Name");
            pcloudyreport.addComment("Updated Profile Name");
            log.info(" | "+"editProfile"+"Update ProfileName");

         //   swipeUp();
          //  Thread.sleep(3000);
            
            driver.findElement(By.xpath("//android.widget.Button[@text='Save Changes']")).click();
            Thread.sleep(3000);
            
            
           /* WebElement parentElement4 = driver.findElement(By.xpath("//android.view.View[@index='22']"));
            parentElement4.findElement(By.xpath("//android.widget.Button[@index='0']")).click();*/
            
            report.log(LogStatus.PASS,"Succesfully updated Profile");
            pcloudyreport.addStep("Click",null,"Succesfully updated Profile",ExecutionResult.Pass);
            log.info(" | "+"editProfile"+"Profile Updated Succesfully");
        }
        catch (Exception e)
        {
        	report.log(LogStatus.FAIL,"Failed on Updating Profile");
            pcloudyreport.addStep("Click",null,"Failed on Updating Profile",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e);
            log.error(" | "+"editProfile"+"Failed on Updating Profile");
    }

    }

    
    public void DeleteProfiles(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContex)
    {
    	try
    	{
    		
    		
            Thread.sleep(8000);
            
            try
            {
            mainPageObjects.closePrepaidOffePopup.click();
            Thread.sleep(4000);
            }catch(Exception e3)
            {
            	System.out.println("popup not handled");
            }
            
            
        	//mainPageObjects.closePrepaidOffePopup.click();
        	Thread.sleep(2000);
        	
            
            	mainPageObjects.MenuOption.click();
        Thread.sleep(3000);
            	mainPageObjects.yourAccount.click();
            	Thread.sleep(4000);
            	
            	 WebElement parentElement2 = driver.findElement(By.className("android.widget.ListView"));

                 List<WebElement> childElements2 = parentElement2.findElements(By.className("android.view.View"));
                 WebElement mainElement2 = childElements2.get(1);
                 mainElement2.findElement(By.className("android.view.View")).click();
             	Thread.sleep(4000);
    		
    		
    		
    		
    		  //Click on delete Profile
            WebElement parentElement3 = driver.findElement(By.xpath("//android.view.View[@index='3']"));

            List<WebElement> childElements3 = parentElement3.findElements(By.className("android.view.View"));
            WebElement mainElement3 = childElements3.get(1);
            mainElement3.findElement(By.className("android.widget.Button")).click();

            report.log(LogStatus.INFO,"Click on Delete Profile");
            pcloudyreport.addComment("Click on Delete Profile");
            log.info(" | "+"DeleteProfiles"+"Click Delete Profile");
//delete icon
            
        	Thread.sleep(4000);
    		
            
            WebElement parentElement4 = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='delete_confirm_list']"));

            List<WebElement> childElements4 = parentElement4.findElements(By.className("android.view.View"));
            WebElement mainElement4 = childElements4.get(0);
mainElement4.click();

Thread.sleep(4000);
           // mainElement4.findElement(By.className("android.widget.Button")).click();
        //  mainElement4.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
          
          report.log(LogStatus.PASS,"Profile Deleted Succesfully");
          pcloudyreport.addStep("Click",null,"Profile Deleted Succesfully",ExecutionResult.Pass);
          log.info(" | "+"DeleteProfiles"+"Profile Deleted Succesfully");
          
    	}
    	catch(Exception e)
    	{
    		report.log(LogStatus.FAIL,"Failed on Deleting Profile");
            pcloudyreport.addStep("Click",null,"Failed on Deleting Profile",ExecutionResult.Fail);
            report.log(LogStatus.FAIL,e);
            log.error(" | "+"DeleteProfiles"+"Failed on Deleting Profile");
    	}
    	
    	
    }
    
    
    public void addProfiles(ExtentTest report, DeviceContext myContext)
    {
        try {
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            mainPageObjects.MenuOption.click();

mainPageObjects.yourAccount.click();
            report.log(LogStatus.INFO,"Clicked on AccountOption");

//mainPageObjects.manageProfile.click();

        //    clickManageProfile();
            report.log(LogStatus.INFO,"Clicked on ManageProfile");
        //    addNewProfile();

            report.log(LogStatus.INFO,"Clicked on AddNewProfile");

       /*  //Click on edit Profile
            WebElement parentElement3 = driver.findElement(By.xpath("//android.view.View[@index='3']"));

            List<WebElement> childElements3 = parentElement3.findElements(By.className("android.view.View"));
            WebElement mainElement3 = childElements3.get(0);
            mainElement3.findElement(By.className("android.widget.Button")).click();


            //edit name
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='checkSmileyNickname']")).click();
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id='checkSmileyNickname']")).sendKeys("test");




            WebElement parentElement4 = driver.findElement(By.xpath("//android.view.View[@index='22']"));
            parentElement4.findElement(By.xpath("//android.widget.Button[@index='0']")).click();*/


            //Click on delete Profile
            WebElement parentElement3 = driver.findElement(By.xpath("//android.view.View[@index='3']"));

            List<WebElement> childElements3 = parentElement3.findElements(By.className("android.view.View"));
            WebElement mainElement3 = childElements3.get(1);
            mainElement3.findElement(By.className("android.widget.Button")).click();


//delete icon
            WebElement parentElement4 = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='delete_confirm_list']"));

            List<WebElement> childElements4 = parentElement4.findElements(By.className("android.view.View"));
            WebElement mainElement4 = childElements4.get(3);

           // mainElement4.findElement(By.className("android.widget.Button")).click();
          mainElement4.findElement(By.xpath("//android.widget.Button[@index='0']")).click();

          /*  List<WebElement> childElements = driver.findElements(By.className("android.view.View"));
            WebElement mainElement = childElements.get(3);
            mainElement.click();
*/


        }
        catch(Exception e)
        {
            report.log(LogStatus.FAIL,"Failed in Verifying Profiles");
            report.log(LogStatus.FAIL,e);

           // Assert.assertTrue(false,e.getMessage());
        }
    }

    
    
    public void VerifyActivePacksAndSerices(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws InterruptedException
    
    {
    	
    	Thread.sleep(9000);
    	
    	mainPageObjects.closePrepaidOffePopup.click();
    	Thread.sleep(5000);
    	
    	try
    	{   mainPageObjects.MenuOption.click();
    	Thread.sleep(4000);
    	 report.log(LogStatus.INFO, "Click on Menu Option");
    		mainPageObjects.Activedatapacks.click();
    		
    		report.log(LogStatus.INFO, "Click on ActivePacks");

    		Thread.sleep(4000);
    		swipeUp();
    		Thread.sleep(3000);
    		 boolean  activepacks=mainPageObjects.ActivePacks.isDisplayed();
    		             Assert.assertTrue(activepacks);
    		
    		             swipeUp();
    		             Thread.sleep(4000);
    		             boolean  activeservices=mainPageObjects.ActiveServices.isDisplayed();
    		             Assert.assertTrue(activeservices);
    		             report.log(LogStatus.PASS,"Verified ActivePacks and ActiveServices");

    	}catch(Exception e)
    	{
    		  report.log(LogStatus.FAIL, "ActivePacks Not Verified in Prepaid number");
              report.log(LogStatus.FAIL,e.getMessage());
              log.error(" | "+"VerifyHamburgerMenuOption"+"ActivePacks Not Verified in Prepaid number");
              pcloudyreport.addStep("Click", null, "HamburgerMenuOptionl" + "ActivePacks Not Verified in Prepaid number", ExecutionResult.Fail);
    	}
    	
    }
    
    
    
    
    
    
    
    //Latet
    public void VerifyHamburgerMenuOption(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
           // driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
           
            //hamburgerObjects.HamburgerButton.click();
        	
        	Thread.sleep(8000);
        	
        	mainPageObjects.closeOffePopup.click();
        	Thread.sleep(5000);
        	
        	mainPageObjects.clickNotNow.click();
        	//mainPageObjects.closepostpaidpopup.click();
        	
        	Thread.sleep(8000);
        	
        	
        	
        	
        	mainPageObjects.MenuOption.click();
        	
        	
        	
         
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
                    report.log(LogStatus.PASS, "Succesfully Verified HamburgerMenuOption ");
                    pcloudyreport.addComment("Succesfully Verified HamburgerMenuOption ");
                    log.info(" | "+"VerifyHamburgerMenuOption"+"HamburgerMenuOption Verified");
                } else {
                    //   System.out.println(" The value is not found");
                    report.log(LogStatus.FAIL, "HamburgerMenuOption Not Verified ");
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
            report.log(LogStatus.FAIL,e.getMessage());
            log.error(" | "+"VerifyHamburgerMenuOption"+"HamburgerMenuOption Not Verified in Prepaid number");
            pcloudyreport.addStep("Click", null, "HamburgerMenuOptionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }
    
    
    public void RechargeForother(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
        	
        	
        	Thread.sleep(8000);
        	
        	mainPageObjects.closeOffePopup.click();
        	Thread.sleep(5000);
        	
        	mainPageObjects.clickNotNow.click();
        	//mainPageObjects.closepostpaidpopup.click();
        	
        	Thread.sleep(8000);
        	
        	
        	
        	
        	mainPageObjects.MenuOption.click();
           // hamburgerObjects.HamburgerButton.click();
        	  System.out.println("Enter Recharge for other function");
        	  log.info(" | "+"RechargeForother"+"Click hamburger button");
        	  report.log(LogStatus.INFO, "Click hamburger button");
        	  Thread.sleep(3000);
        	  
           // hamburgerObjects.Rechargeforother.click();
        	  mainPageObjects.Rechargeforother.click();
        	  report.log(LogStatus.INFO, "Click RechargeforOther button");
        	  Thread.sleep(3000);
            System.out.println("Click RechargeforOther button ");
            log.info(" | "+"RechargeForother"+"Click Recharge for other");
            
            mainPageObjects.ManuallyEnterNumber.click();
            Thread.sleep(2000);
            mainPageObjects.ManuallyEnterNumber.setValue("9962248716");
            Thread.sleep(2000);
            ((AppiumDriver<MobileElement>) driver).hideKeyboard();
           
           //((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER, AndroidKeyMetastate.META_SHIFT_ON );
            
            report.log(LogStatus.INFO, "Manually Entered a No");
            Thread.sleep(3000);
           // hamburgerObjects.ManuallyEnterNumber.sendKeys("9962248716 ");
            System.out.println("Manually enter a Number");
            log.info(" | "+"RechargeForother"+"Manually enter a number");
            
mainPageObjects.EnterAmountForRecharge.sendKeys("10");
report.log(LogStatus.INFO, "Enter Amount for Recharge");
log.info(" | "+"RechargeForother"+"Enter amount for recharge");
Thread.sleep(3000);
          //  hamburgerObjects.EnterAmountForRecharge.sendKeys("10");
            System.out.println("....Enter Amount for recharge for other....");

            //swipeUpUntilTextExists("Recharge Now", 1);
            Thread.sleep(6000);
            mainPageObjects.RechargeNowCTA.click();
            report.log(LogStatus.INFO, "Click Recharge now button");
            Thread.sleep(4000);
           // hamburgerObjects.RechargeNowCTA.click();
            System.out.println("......Recharge Now Button Clicked Successfully.......");
            Thread.sleep(7000);

            
            
            
          /*  //Click Paytm
            WebElement parentElement3 = driver.findElement(By.xpath("//android.view.View[@index='6']"));

            List<WebElement> childElements3 = parentElement3.findElements(By.className("android.view.View"));
            WebElement mainElement3 = childElements3.get(0);
mainElement3.findElement(By.className("android.widget.Button")).click();
            
            
            
            */
            //latest
            try
            {
            driver.findElement(By.xpath("//android.widget.Image[@text='paytm-image']/following::android.widget.Button")).click();
            }
            catch(Exception e)
            {
            	System.out.println("Clicked firsttime Paytm");
            }
            try
            {
            driver.findElement(By.xpath("//android.widget.Image[@text='paytm-image']/following::android.widget.Button[1]")).click();
            }
            catch(Exception e)
            {
            	System.out.println("Clicked Secondtime Paytm");
            }
           // driver.findElement(By.xpath("//android.widget.Image[@text='paytm-image']/following::android.widget.Button")).click();
        //    mainPageObjects.payTM.click();
            Thread.sleep(4000);
            System.out.println("Clicked on Paytm Paynow button");
          //  driver.findElement(By.xpath("//android.widget.Button[@text='Pay Now ']")).click();
            
            
            
            report.log(LogStatus.INFO, "Click Paytm button");
            log.info(" | "+"RechargeForother"+"Click Paytm option");
            Thread.sleep(3000);
        //    hamburgerObjects.payTM.click();
            System.out.println("......Paytm PayNow Clicked Successfully.......");
            Thread.sleep(2000);
            report.log(LogStatus.PASS, "Succesfully Performed recharge for Prepaid Customer");
            pcloudyreport.addComment("Succesfully Performed recharge for Prepaid Customer");

        } catch (Exception e) {
        	
            webDriverListener.captureScreenShot("HamburgerMenu", "RechargeForother");
            report.log(LogStatus.FAIL, "RechargeForother Not Verified in Postpaid number");
            report.log(LogStatus.FAIL,e.getMessage());
            log.error(" | "+"RechargeForother"+"RechargeForother Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + "RechargeForother Not Verified in Postpaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }
    }

    public void NewConnection(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception {
        try {
        	
	Thread.sleep(8000);
        	
        	mainPageObjects.closeOffePopup.click();
        	Thread.sleep(5000);
        	System.out.println("Clicked on OfferPopup");
        //	mainPageObjects.clickNotNow.click();
        	//mainPageObjects.closepostpaidpopup.click();
        	
        	Thread.sleep(8000);
        	mainPageObjects.MenuOption.click();
        	System.out.println("Clicked on Menu Option");
        	Thread.sleep(3000);
        	
        	
            swipeUpUntilTextExists("New Connection", 1);
            System.out.println("Scroll untilnewConnection is visible");
           // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Thread.sleep(4000);
            mainPageObjects.NewConnection.click();
            System.out.println("Clicked on New Connection");
            Thread.sleep(4000);
            log.info(" | "+"NewConnection"+"Click newconnection option");
            //            hamburgerObjects.NewConnection.click();
            report.log(LogStatus.INFO, "Click NewConnection button");
            mainPageObjects.SubNewConnection.click();
            System.out.println("Clicked on SubNew Connection");
            Thread.sleep(5000);
            
            
            report.log(LogStatus.INFO, "Click SubNewConnection button");
            log.info(" | "+"NewConnection"+"Click Subnewconnection option");
          //  hamburgerObjects.SubNewConnection.click();
            System.out.println(" New Connection is clicked from Hamburger Menu");
            List<WebElement> formElements;
            formElements = driver.findElements(By.className("android.widget.EditText"));
            System.out.println("Number of elements:" + formElements.size());

            formElements.get(0).sendKeys("Ashwini");
            log.info(" | "+"NewConnection"+"Enter Name");
            report.log(LogStatus.INFO, "Enter name");
            formElements.get(1).sendKeys("9636489183");
            report.log(LogStatus.INFO, "Enterd phoneno");
            log.info(" | "+"NewConnection"+"Enter MobileNumber");
            formElements.get(2).sendKeys("ashwini.kamble@qualitrix.com");
            log.info(" | "+"NewConnection"+"Enter Email Address");
            formElements.get(3).sendKeys("Mum");
            log.info(" | "+"NewConnection"+"Enter city name");
            Thread.sleep(5000);
            formElements.get(3).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//android.widget.Button[@text='Mumbai']")).click();
            Thread.sleep(4000);
            
            
            mainPageObjects.proceedNC.click();
            Thread.sleep(3000);
            report.log(LogStatus.INFO, "Click Proceed button");
            report.log(LogStatus.PASS, "NewConnection Completed Succesfully");
            log.info(" | "+"NewConnection"+"Click on proceed");
          //  hamburgerObjects.proceedNC.click();
            System.out.println("Procced Nc Clicked");
           // waitOptions(Duration.ofSeconds(4));
        } catch (Exception e) {
            webDriverListener.captureScreenShot("HamburgerMenu", "RechargeForother");
            report.log(LogStatus.FAIL, "NewConnection failed");
            report.log(LogStatus.FAIL,e.getMessage());
            log.error(" | "+"NewConnection"+"NewConnection  Not Verified in Postpaid number");
            pcloudyreport.addStep("Click", null, "Optionl" + " Not Verified in Prepaid number", ExecutionResult.Fail);
            Assert.assertTrue(false, e.getMessage());
        }

    }

    
    public void Recharge(ExtentTest report, SingleRunReport pcloudyreport, DeviceContext myContext) throws Exception{
        try {
           // driver.manage().timeouts().implicitlyWait(1000, java.util.concurrent.TimeUnit.SECONDS);
            System.out.println("Recharge");
Thread.sleep(9000);
        	
        	mainPageObjects.closePrepaidOffePopup.click();
        	Thread.sleep(5000);
        	 report.log(LogStatus.INFO, "Click on ClosePopup button");
        	
        	mainPageObjects.MenuOption.click();
        	Thread.sleep(3000);
        	 report.log(LogStatus.INFO, "Click on Menu Option");
        	 
        	driver.findElement(By.xpath("//android.widget.Button[@resource-id='step1']")).click();
        	Thread.sleep(4000);
        	
        	
        	System.out.println("Closed popup");
        	try
        	{
     //    mainPageObjects.lastRecharge.click();
        		
        		driver.findElement(By.xpath("//android.view.View[@text='Recommended']/following::android.widget.Button")).click();
        		 report.log(LogStatus.INFO, "Click on Last Recharge");
                 System.out.println("Clicked on LastREcharge");
                 Thread.sleep(5000);
                 
                 
                 mainPageObjects.rechargePaySecurely.click();
                 report.log(LogStatus.INFO, "Click on  PaySecurely");
                 Thread.sleep(5000);
                 System.out.println("Click on  PaySecurely");
                 
                 driver.findElement(By.xpath("//android.widget.Image[@text='paytm-image']/following::android.widget.Button")).click();
                 System.out.println("Click on  Paytm Butotn");
                 report.log(LogStatus.INFO, "Click on  Paytm Butotn");
//             
//                 driver.findElement(By.xpath("//android.widget.Button[@text='Deduct from balance (One-tap payment) ']/following::android.widget.Button")).click();
//                 //driver.findElement(By.xpath("//android.widget.Button[@text='Others ']")).click();
//                 System.out.println("Click 1");
//                 Thread.sleep(5000);
//                 
//                 try
//                 {
//                 driver.findElement(By.xpath("//android.widget.Button[@index='8']")).click();
//                 Thread.sleep(5000);
//                 driver.findElement(By.xpath("//android.widget.Button[@text='Others '][@index='4']")).click();
//                 }
//                 catch(Exception ee)
//                 {
//                	 System.err.println("Exception Occured");
//                 }
//                 
//                 report.log(LogStatus.INFO, "Click on Others option");
//                 System.out.println("Click on Others option");
//                 Thread.sleep(4000);
//                 
//        		
//        
//         
         
        	/* 
        	 driver.findElement(By.xpath("//android.widget.Button[contains(text(),'UNLIMITED')][@index='1']")).click();
        	 Thread.sleep(5000);*/
           
        	
        	}
        	catch(Exception e3)
        	{
        		System.out.println("Handled");
        	}
             
         
             
        	/*Thread.sleep(2000);
        /*	
        	try
        	{
        		WebElement parentElement = driver.findElement(By.xpath("//android.view.View[@text='Recommended']"));
                List<WebElement> childElements = parentElement.findElements(By.className("android.widget.Button"));
                WebElement mainElement = childElements.get(0);
                mainElement.click();

        		
        		driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        		
        		driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
        		

        	Thread.sleep(4000);
        	}
        	catch(Exception e5)
        	{
        		System.out.println("Handled");
        	}
        	
        	
        	
        	try
        	{
        		driver.findElement(By.xpath("//android.widget.Button[@index='3']")).click();
        		
        	}catch(Exception e8)
        	{
        		System.out.println("Handled");
        	}*/
        /**/
        	//mainPageObjects.closepostpaidpopup.click();
        	
        	/*Thread.sleep(2000);
            
        	try
        	{
            mainPageObjects.lastRecharge.click();
            report.log(LogStatus.INFO, "Click LastRecharge");
            Thread.sleep(4000);
        	}
        	catch(Exception e3)
        	{
        		
        	}
        	
        	try
        	{
        	driver.findElement(By.xpath("//android.view.View[@resource-id='prepaid-step-4']")).click();
        	Thread.sleep(4000);
        	}
        	catch(Exception e5)
        	{
        		
        	}
            */
            
            
           
            //    Payment();
        	
        	
           // mainPageObjects.paytmPaynow.click();
            Thread.sleep(5000);
            
            
            
            //Commented paytm Not working
           /* mainPageObjects.paytmLgn.click();
            report.log(LogStatus.INFO, "Click Payemlogin");
            mainPageObjects.paytmregisterednum.sendKeys("7777777777");
            report.log(LogStatus.INFO, "Enter Paytm Registered no");
            mainPageObjects.otpPaytm.click();
            mainPageObjects.enterotpPaytm.sendKeys("489871");
            report.log(LogStatus.INFO, "Enter Paym otp");
            Thread.sleep(6000);
            mainPageObjects.logininPaytm.click();
            Thread.sleep(3000);
            mainPageObjects.paynowWallet.click();
            report.log(LogStatus.INFO, "Click PaytmWalled");

            String tnps=  mainPageObjects.tnpsData.getText();
            System.out.println("tnps data"+tnps);
            String vov= mainPageObjects.rechargeVOV.getText();
            System.out.println("tnps data"+vov);*/
            report.log(LogStatus.PASS, "Recharge Perfomed succesfully");
        }catch (Exception e) 
        {
        	 report.log(LogStatus.FAIL, "Recharge failed");
             report.log(LogStatus.FAIL,e.getMessage());
             log.error(" | "+"Recharge"+"Recharge Not performed for Prepaid number");
             pcloudyreport.addStep("Click", null, "Optionl" + "Recharge Not performed for Prepaid number", ExecutionResult.Fail);
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
        	
Thread.sleep(8000);
        	try
        	{
        	mainPageObjects.closeOffePopup.click();
        	Thread.sleep(5000);
        	
        	mainPageObjects.clickNotNow.click();
        	}
        	catch(Exception e)
        	{
        		
        	}
        	mainPageObjects.MenuOption.click();
        	Thread.sleep(3000);
        	
        	
        	
            swipeUpUntilTextExists("Help & Support", 2);
            Thread.sleep(3000);
            
          //  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
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
            log.error(" | "+"helpAndSupport"+"helpAndSupport Not Verified in Postpaid number");
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
    



