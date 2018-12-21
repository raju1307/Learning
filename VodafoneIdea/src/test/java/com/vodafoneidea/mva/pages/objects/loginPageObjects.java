package com.vodafoneidea.mva.pages.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class loginPageObjects {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='button-2']")
    public MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='loginMsisdn']")
    public MobileElement msisdnInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='mva_login_genrate_otp_button']")
    public MobileElement sendOtpViaSmsButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='otpBoxOne']")
    public MobileElement otpBoxOne;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='otpBoxTwo']")
    public MobileElement otpBoxTwo;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='otpBoxThree']")
    public MobileElement otpBoxThree;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='otpBoxFour']")
    public MobileElement otpBoxFour;



    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='mva_login_login_button']")
    public MobileElement otploginbutton;



    @AndroidFindBy(className ="android.widget.Button")
    public MobileElement ContinueToMyVodaphoneApp;

    @AndroidFindBy(className ="android.widget.Button")
    public MobileElement MenuOption;

    @AndroidFindBy(xpath ="//android.widget.Button")
    public MobileElement YourAccount;



}
