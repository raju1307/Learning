package com.vodafoneidea.mva.test;

import com.ssts.util.reporting.SingleRunReport;
import com.vodafoneidea.mva.config.TestRunnerInfo;
import com.vodafoneidea.mva.pages.actions.HamburgerMenu;
import com.vodafoneidea.mva.pages.actions.MainPage;
import com.vodafoneidea.mva.pages.actions.launchHomePage;
import com.vodafoneidea.mva.pages.actions.loginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class launchAppTest extends TestSetUp{
    AppiumDriver driver;
    static Logger log = Logger.getLogger(TestVer.class.getName());



    
  
    


 


    
   //Postpaid
    @Parameters({"myDeviceContext"})
    @Test(priority = 1)
    public void NewConnection(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"NewConnection");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        
        //postpaid
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
        getMainPage(driver).NewConnection(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e){
    		
    	}

    }
    
@Parameters({"myDeviceContext"})
  @Test(priority = 2)
  public void RechargeForother(String myDeviceContext) throws Exception {


  	try{

      DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
      //  SingleRunReport report = myContext.report;
      SingleRunReport pcloudyreport = myContext.report;

      // ExtentReports reports = myContext.extentReport;
      AndroidDriver<WebElement> driver = myContext.driver;
      ExtentTest logger = report.startTest(myDeviceContext + " | "+"RechargeForother");

      getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
      
      //Postpaid
      getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
      
      getMainPage(driver).RechargeForother(logger,pcloudyreport,myContext);
  	}
  	catch(Exception e){
  		
  	}

  }
    

 @Parameters({"myDeviceContext"})
 @Test(priority = 3)
 public void VerifyDashboardForPostPaidCustomer(String myDeviceContext) throws Exception {



	   try{
     DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
     

     SingleRunReport pcloudyreport = myContext.report;
   
     AndroidDriver<WebElement> driver = myContext.driver;
     ExtentTest logger = report.startTest(myDeviceContext + " | "+"VerifyDashboardForPostPaidCustomer");


     
     
     getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
     

    getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);

     
 
     
     getMainPage(driver).verifyPostPaidDashboardSection(logger,pcloudyreport,myContext);
     getMainPage(driver).veifydataAndSmsSection(logger,pcloudyreport,myContext);
   getMainPage(driver).currentSpendSection(logger,pcloudyreport,myContext);
	   }catch(Exception e){
		   
	   }
 }



  
    
    
    
    //PrePaid Customer
    @Parameters({"myDeviceContext"})
    @Test(priority = 1)
    public void RechargeForPrepaidNo(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"RechargeForPrepaidNo");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        
        //Postpaid
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
        getMainPage(driver).Recharge(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e){
    		
    	}

    } 
    
    @Parameters({"myDeviceContext"})
    @Test(priority =2)
    public void ProfileFuncationlity(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"VerifyProfileFunctionality");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
        
       getMainPage(driver).clickManageProfile(logger,pcloudyreport,myContext);
      
      getMainPage(driver).addNewProfile(logger,pcloudyreport,myContext);
    //  getMainPage(driver).editProfile(logger,pcloudyreport,myContext);
        getMainPage(driver).DeleteProfiles(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    @Parameters({"myDeviceContext"})
    @Test(priority = 4)
    public void VerifyDashboardForPrepaidCustomer(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"VerifyDashboardForPrepaidCustomer");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        
        //PrePaid
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
 getMainPage(driver).VefifyHamburgerMenuOption(logger,pcloudyreport,myContext);
        
        
        getMainPage(driver).prePaidCallSection(logger,pcloudyreport,myContext);
        getMainPage(driver).prePaidTabSection(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e){
    		
    	}

    }
    
    @Parameters({"myDeviceContext"})
    @Test(priority = 3)
    public void VeriyActivePacksAndService(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"VeriyActivePacksAndService");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        
        //PostPaid
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
        getMainPage(driver).VerifyActivePacksAndSerices(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e){
    		
    	}

    }
  

    
    @Parameters({"myDeviceContext"})
    @Test(priority = 9)
    public void helpAndSupport(String myDeviceContext) throws Exception {


    	try{

        DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
        //  SingleRunReport report = myContext.report;
        SingleRunReport pcloudyreport = myContext.report;

        // ExtentReports reports = myContext.extentReport;
        AndroidDriver<WebElement> driver = myContext.driver;
        ExtentTest logger = report.startTest(myDeviceContext + " | "+"helpAndSupport");

        getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
        getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
        
        getMainPage(driver).helpAndSupport(logger,pcloudyreport,myContext);
    	}
    	catch(Exception e){
    		
    	}

    }
    
   
    
  //Latest
      
      @Parameters({"myDeviceContext"})
      @Test(priority = 10)
      public void VerifyHamburgerMenuOption(String myDeviceContext) throws Exception {


      	try{

          DeviceContext myContext = Controller.allDeviceContexts.get(myDeviceContext);
          //  SingleRunReport report = myContext.report;
          SingleRunReport pcloudyreport = myContext.report;

          // ExtentReports reports = myContext.extentReport;
          AndroidDriver<WebElement> driver = myContext.driver;
          ExtentTest logger = report.startTest(myDeviceContext + " | "+"VerifyHamburgerMenuOption");

          getHomePage(driver).launchHomePage(logger,pcloudyreport,myContext);
          
          //PostPaid
          getLoginPage(driver).loginPage(logger,pcloudyreport,myContext);
          
          getMainPage(driver).VerifyHamburgerMenuOption(logger,pcloudyreport,myContext);
      	}
      	catch(Exception e){
      		
      	}

      }
    
    launchHomePage getHomePage(WebDriver driver){

       // return new launchHomePage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
        return new launchHomePage(driver);

    }

    public loginPage getLoginPage(WebDriver driver){

        //return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
        return new loginPage(driver);
    }


    public MainPage getMainPage(WebDriver driver){

        //return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
        return new MainPage(driver);
    }
    
    public HamburgerMenu getHamburgerMenu(WebDriver driver) {
        // return new HamburgerMenu(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
         return new HamburgerMenu(driver);
     }
}
