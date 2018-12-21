package com.vodafoneidea.mva.config;


import com.appium.manager.AppiumDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	    Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	    Test Runner
 */

public class TestRunnerInfo {

    public DeviceInterface runnerInfo;
    PropertyReader propertyReader;
    ViewFactory viewFactory;

    public TestRunnerInfo() {
        runnerInfo = runnerInfoStatus();
    }

    public DeviceInterface getRunnerInfo() {
        return runnerInfo;
    }

    public DeviceInterface runnerInfoStatus() {
            viewFactory = new ViewFactory(AppiumDriverManager.getDriver());
            runnerInfo = viewFactory.getMobilePlatform(AppiumDriverManager.getDriver().
                            getPlatformName().toString(),
                    AppiumDriverManager.getDriver());
            DriverManager.setDriver(AppiumDriverManager.getDriver());
            return runnerInfo;
    }

    public WebDriver         getDriverSession() {
        return DriverManager.getDriver();
    }
}
