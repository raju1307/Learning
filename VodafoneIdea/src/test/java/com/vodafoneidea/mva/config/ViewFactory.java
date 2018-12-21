package com.vodafoneidea.mva.config;

import com.vodafoneidea.mva.flows.AndroidFlow;
import com.vodafoneidea.mva.flows.iOSFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	    Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	    To serve the test flow based on the platform
 */

public class ViewFactory extends DeviceHelper {

    private AndroidFlow androidFlow;
    private iOSFlow iosFlow;

    public ViewFactory(WebDriver driver) {
        super(driver);
    }

    public DeviceInterface getMobilePlatform(String platform, AppiumDriver<MobileElement> driver) {
        if (platform == null) {
            System.out.println("---Couldn't return a Mobile platform---");
            return null;
        }
        if (platform.equalsIgnoreCase("Android") || platform.equalsIgnoreCase("LINUX")) {
            if (platform.equalsIgnoreCase("Android")) {
                return androidFlow = new AndroidFlow(driver);
            }
        } else if (platform.equalsIgnoreCase("iOS")) {
            if (driver.getCapabilities().getCapability("browserName").toString().length() > 0) {
                // return webFlow = new WebFlow(driver);
            } else if (iosFlow == null) {
                return iosFlow = new iOSFlow(driver);
            }
            return iosFlow;

        }
        System.out.println("Couldn't return a Mobile platform");
        return null;

    }

}
