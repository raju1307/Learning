package com.vodafoneidea.mva.pages.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HamburgerObjects {

// Clicking Hamburger Menu
      @AndroidFindBy(xpath="//android.widget.Button[@resource-id='step1']")
      public MobileElement HamburgerButton;

//Hamburger MenuList

 /*   @AndroidFindBy(xpath="//android.widget.ListView[@resource-id='hamburger_menu_list'],@index='1'")
        public MobileElement HamburgerMenuList;
      @AndroidFindBy(xpath = "//android.widget.ListView[@index='1'][contains(@resource-id='hamburger_menu_list')]")
        public MobileElement hamburgerSection;
      @AndroidFindBy(xpath = "//android.widget.Button)")
        public MobileElement hamchild;
      @AndroidFindBy(className = "android.widget.Button")
        public MobileElement hamChildElements;*/
//Recharge for other
      @AndroidFindBy(xpath="//android.widget.ListView[@index='1']/android.widget.Button[@index='8']")
      public MobileElement Rechargeforother;
//Enter MSISDN for Recharge for other
      @AndroidFindBy(xpath="//android.view.View[@index='0']/android.widget.EditText[@index='0']")
      public MobileElement ManuallyEnterNumber;
//Enter Amount for Recharge
      @AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
      public MobileElement EnterAmountForRecharge;
// Click Recharge Now
      @AndroidFindBy(xpath="//android.view.View[@index='5']/android.widget.Button[@index='6']")
      public MobileElement RechargeNowCTA;
// Payment page -- Paytm
    @AndroidFindBy(xpath = "//android.view.View[@index='6']/android.widget.Button[@index='5']")
    public  MobileElement payTM;

  /*---------------------New Connection Objects----------*/

// New Connection
   //Parent and child class xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='1']")
     @AndroidFindBy(xpath="//android.widget.ListView[@index='1']/android.widget.Button[@index='17']")
      public MobileElement NewConnection;
//New Connection Sub Menu
     @AndroidFindBy(xpath="//android.widget.Button[@text='New Connection' and @index='0']")
     public MobileElement SubNewConnection;

     @AndroidFindBy(xpath ="//android.widget.Button[@text='Proceed ']")
     public MobileElement proceedNC;
//Help and Support
     @AndroidFindBy(xpath="//android.widget.ListView[@index='1']/android.widget.Button[@index='20']")
    // @AndroidFindBy(xpath="//android.widget.Button[@text='Help & Support'and @index='20']")
     public MobileElement helpandSupport;
//Get Support
     @AndroidFindBy(xpath="//android.widget.Button[@text='Get Support' and @index='0']")
     public MobileElement getSupport;
//Faq TabsSection
     @AndroidFindBy(xpath="//android.view.View[@index='0']/android.widget.EditText[@index='0']")
     public MobileElement faqKeyword;
     @AndroidFindBy(xpath="//android.view.View[@index='0']/android.view.View[@index='3']")
     public MobileElement chatTab;
     @AndroidFindBy(xpath="//android.view.View[@index='0']/android.view.View[@index='4']")
     public MobileElement calltab;
    @AndroidFindBy(xpath="//android.view.View[@index='0']/android.view.View[@index='5']")
    public MobileElement email;

// Search Button on FAQ
     @AndroidFindBy(xpath="//android.view.View[@index='1']/android.widget.Button[@text='\uF4A5 ']")
     public MobileElement searchButton;
//Back Button for FAQ..
      @AndroidFindBy(xpath="//android.view.View[@index='1']/android.widget.Button[@index='0']")
       public MobileElement backButtonFAQ;


/*Share app */
     @AndroidFindBy(xpath = "//android.widget.Button[@text='Share App ']")
     public MobileElement shareElement;

    /*---------------------Help and Support------------------------*/
 /*   @AndroidFindBy(className = "android.view.View")
    public MobileElement FaqTabsChildElements;*/

}
