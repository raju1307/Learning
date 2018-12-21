package com.vodafoneidea.mva.config;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	To set the configuration for type of drivers
 */

public class DriverManager {

    private static ThreadLocal<AppiumDriver> webDriver = new ThreadLocal<>();

    public static void setDriver(AppiumDriver driver) {
        webDriver.set(driver);
    }

    public static AppiumDriver getDriver() {
        return webDriver.get();
    }
}
