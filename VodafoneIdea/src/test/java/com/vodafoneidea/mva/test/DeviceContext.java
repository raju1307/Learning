package com.vodafoneidea.mva.test;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.util.reporting.SingleRunReport;

import io.appium.java_client.android.AndroidDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DeviceContext {

    //By Shibu
    /*private String uniqueName;

    public DeviceContext(String uniqueName)
    {
        this.uniqueName = uniqueName;
    }

    public String getUniqueName() {
        return this.uniqueName;
    }

    public URL endpoint;
    public BookingDtoDevice device;
    public PCloudyAppiumSession pCloudySession;
    public SingleRunReport report;
    public DesiredCapabilities capabilities;
    public AndroidDriver<WebElement> driver;


    public File snapshotsFolder;
    public File deviceFolder;
*/



private String uniqueName;

    public DeviceContext(String uniqueName)
    {
        this.uniqueName = uniqueName;
    }

    public String getUniqueName() {
        return this.uniqueName;
    }

    public URL endpoint;
    public BookingDtoDevice device;
    public PCloudyAppiumSession pCloudySession;
    public SingleRunReport report;
    public DesiredCapabilities capabilities;
    public AndroidDriver<WebElement> driver;
    //Added fr new phone number mapping implementation
    public String phoneNoMap;



   // public ExtentReports extentReport;

    public File snapshotsFolder;
    public File deviceFolder;



}
