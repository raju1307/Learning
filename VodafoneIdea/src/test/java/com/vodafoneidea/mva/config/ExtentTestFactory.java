package com.vodafoneidea.mva.config;

import com.aventstack.extentreports.ExtentTest;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:     Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:     To implement the test driven through the extent test
 */

public class ExtentTestFactory {
    private static ThreadLocal<ExtentTest> extentPool = new ThreadLocal<ExtentTest>();

    public static void setExtentTest(ExtentTest extentTest) {
        extentPool.set(extentTest);
    }

    public static ExtentTest getExtentTest() {
        return extentPool.get();
    }
}










