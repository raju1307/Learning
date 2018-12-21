package com.vodafoneidea.mva.pages.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPageObjects {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue to MyVodafone app']")
    public MobileElement ContinueToMyVodaphoneApp;

   /* @AndroidFindBy(xpath = "//android.widget.Button[@text='Vimlesh_Kushwah']")
    public MobileElement ContinueToMyVodaphoneApp;
*/


    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='step1']")
    public MobileElement MenuOption;

   // @AndroidFindBy(xpath = "//android.widget.Button[@text='Your account']")
    
  // @AndroidFindBy(xpath = "//android.widget.Button[@index='10']")
    @AndroidFindBy(xpath ="//android.widget.Button[@index='10']")
    public MobileElement yourAccount;


    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='secMsisdn_text_box']")
    public MobileElement EnterNo;



    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='mva_login_genrate_otp_button']")
    public MobileElement generateOtp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='addSecotpBoxOne']")
    public MobileElement otp1;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='addSecotpBoxTwo']")
    public MobileElement otp2;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='addSecotpBoxThree']")
    public MobileElement otp3;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='addSecotpBoxFour']")
    public MobileElement otp4;


    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='mva_login_login_button']")
    public MobileElement addProfileButton;


    // @AndroidFindBy(xpath = "//android.view.View[@index='0']")
   @AndroidFindBy(xpath = "//android.view.View[@index='2']/following-sibling::android.view.View")
    public MobileElement manageProfile;



    @AndroidFindBy(className = "android.widget.Image")
    public MobileElement ProfileIcon;




    @AndroidFindBy(xpath = "//android.widget.Button[@text='Vimlesh_Kushwah']")
    public MobileElement ProfileName;



    //Prepaid Calls Section
       @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    public MobileElement CallsSection;

    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    public MobileElement dataSection;

    @AndroidFindBy(xpath = "//android.view.View[@index='5']")
    public MobileElement balanceSection;



//Prepaid TabsSection
@AndroidFindBy(xpath = "//android.view.View[@resource-id='prepaid-step-5']")
public MobileElement tabSection;

    @AndroidFindBy(className = "android.view.View")
    public MobileElement tabsChildElements;






    //postPaidDataSmsSec
       @AndroidFindBy(xpath = "//android.view.View[@resource-id='postpaid-step-2']")
    public MobileElement postPaidDataSmsSection;

    //current spend section
    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    public MobileElement currentSpendSection;




    //Postpaid
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='dashboard-profile-pic-div']")
    public MobileElement postPaidProfileIcon;



    @AndroidFindBy(xpath = "//android.view.View[@resource-id='dashboard-outstanding']")
    public MobileElement postPaidOutStandingAmount;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='Data'][@index='0']")
    public MobileElement data;
    
    
    //Active Service Packs
    @AndroidFindBy(xpath = "//android.widget.Button[@index='11']")
    public MobileElement Activedatapacks;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Data'][@index='0']")
    public MobileElement Activedata;
    
    
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    public MobileElement ActivePacks;
    

    @AndroidFindBy(xpath = "//android.view.View[@index='10']")
    public MobileElement ActiveServices;
    
    
    
    @AndroidFindBy(xpath="//android.view.View[@index='0']/android.widget.Button[@index='1']")
    public MobileElement closepostpaidpopup;
    
    
    
    
    
    
    
    
    
    
    //Latest 
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
    
    //Modified by raju
   /* @AndroidFindBy(xpath="//android.view.View[@index='0']/android.widget.EditText[@index='0']")
    public MobileElement ManuallyEnterNumber;
    */
    
    @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
    public MobileElement ManuallyEnterNumber;
    
//Enter Amount for Recharge
    @AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
    public MobileElement EnterAmountForRecharge;

    
 /* //Click Recharge Now
    @AndroidFindBy(xpath="//android.view.View[@index='5']/android.widget.Button[@index='6']")
    public MobileElement RechargeNowCTA;
    
    */
    
    //Modified by Raju S
    //Click Recharge Now
    @AndroidFindBy(xpath="//android.widget.Button[@resource-id='mva_bill_mode_button']")
    public MobileElement RechargeNowCTA;
    
    
//Payment page -- Paytm
  /*@AndroidFindBy(xpath = "//android.view.View[@index='6']/android.widget.Button[@index='5']")
  public  MobileElement payTM;*/
  
    //modified by raju
//@AndroidFindBy(xpath="//android.widget.Button[@text='Pay Now'][@index='0']")
    
 // @AndroidFindBy(xpath="//android.widget.Button[@text='Help & Support'and @index='20']")
   // @AndroidFindBy(xpath="//android.widget.Image[@text='paytm-image']/android.widget.Button[@index='0']")
    
   
  
/*---------------------New Connection Objects----------*/

//New Connection
 //Parent and child class xpath("//android.widget.LinearLayout[@index='1']/android.widget.Button[@index='1']")
   @AndroidFindBy(xpath="//android.widget.ListView[@index='1']/android.widget.Button[@index='17']")
    public MobileElement NewConnection;
   
//New Connection Sub Menu
   @AndroidFindBy(xpath="//android.widget.Button[@text='New Connection' and @index='0']")
   public MobileElement SubNewConnection;

  /* @AndroidFindBy(xpath ="//android.widget.Button[@text='Proceed']")
   public MobileElement proceedNC;
   */
   //modified by raju
   @AndroidFindBy(xpath ="//android.widget.Button[@index='3']")
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

//Search Button on FAQ
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

   
   

 //----------Recharge for self----------
     @AndroidFindBy(xpath="//android.widget.ListView[@index='1']/android.widget.Button[@index='0']")
   //@AndroidFindBy(xpath="//android.widget.Button[@index='1']")
      public MobileElement lastRecharge;

      
      
      @AndroidFindBy(xpath="//android.widget.Button[@index='8']")
      public MobileElement rechargePaySecurely ;

     @AndroidFindBy(xpath="//android.view.View[@index='6']/android.widget.Button[@index='0']")
     public MobileElement paytmPay;

     @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
     public MobileElement paytmLogin;
   

  // Payment page -- Paytm PayNow
      //@AndroidFindBy(xpath = "//android.view.View[@index='1']/android.widget.Button[@text='Pay Now ']")
      //@AndroidFindBy(xpath="//android.widget.Button[@text='Pay Now ']")
    @AndroidFindBy(xpath="//android.widget.Button[@text='Pay Now ' and @index='0']")
      public  MobileElement paytmPaynow;
      
      
      
  // Paytm login page.
      @AndroidFindBy(xpath = "//android.view.View[@index='1']/android.widget.Button[@text='Login']")
      public  MobileElement paytmLgn;
  //Pay tm enter registered number
      @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
      public MobileElement paytmregisterednum;
  //request otp for paytm
      @AndroidFindBy(xpath = "//android.widget.Button[@index='2']")
      public MobileElement otpPaytm;
  //enter otp for paytm
      @AndroidFindBy(xpath = "//android.view.View[@index='2']/android.widget.EditText[@index='0']")
      public MobileElement enterotpPaytm;

  //Click login in paytm walllet
      @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
      public MobileElement logininPaytm;

  //paytm paynowon paytm wallet
      @AndroidFindBy(xpath = "//android.widget.Button[@text='Pay Now']")
       public MobileElement paynowWallet;

  //Dashboard vov details
      @AndroidFindBy(xpath = "//android.widget.ListView[@index='1']/android.view.View[@index='0']")
      public MobileElement rechargeVOV;
  //Recharge TNPS
      @AndroidFindBy(xpath = "//android.view.View[@index='0']/android.view.View[@index='3']")
      public MobileElement tnpsData;

 
    //Closepopup
      @AndroidFindBy(xpath="//android.widget.Button[@index='0']")
      public MobileElement closeOffePopup;
      
      //Closepopup
      @AndroidFindBy(xpath="//android.widget.Button[@resource-id='step1']")
      public MobileElement closePrepaidOffePopup;
      
      
    //Closepopup
      @AndroidFindBy(xpath="//android.widget.Button[@index='4']")
      public MobileElement clickNotNow;
      
      
     // @AndroidFindBy(xpath="//android.widget.Button[@text='Pay Now ' and @index='0']")
      @AndroidFindBy(xpath="//android.widget.Button[@text='Pay Now ']")
      public  MobileElement payTM;
}

