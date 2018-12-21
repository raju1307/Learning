package com.vodafoneidea.mva.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	    Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	    Generic Methods
 */

public class GenericFunctions {

    public void captureScreeshot(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destFile = ".//Screenshot";
        FileUtils.copyFile(srcFile, new File(destFile));
    }

        public static void writeToNotepad(String Path){
            try {
                String notpadPath=".\\Path.txt";
                BufferedWriter bWriter=new BufferedWriter(new FileWriter(notpadPath));
                bWriter.write(Path);
                bWriter.newLine();
                bWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        public static String readFromNotepad() {
            String path = "";
            String notpadPath = ".\\Path.txt";
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(notpadPath));
                while ((path = bReader.readLine()) != null) {
                    System.out.println("Path:  " + path);
                    String str = bReader.readLine();
                    System.out.println(str);
                    return path;
                }
            } catch (Exception e) {

            }
            return path;

        }
}
