package com.vodafoneidea.mva.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
public class WrapReport
{

	@Test

	public static void testURL() {

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		System.out.println("set property is completed ");
		// TODO Auto-generated method stub
		try{
			System.out.println();
			WebDriver driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://device.pcloudy.com/login");
			driver.findElement(By.id("userId")).click();
			driver.findElement(By.id("userId")).sendKeys("automation@qualitrix.com");
			driver.findElement(By.id("password")).click();
			driver.findElement(By.id("password")).sendKeys("QAutomation@2018");
			driver.findElement(By.id("loginSubmitBtn")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[@class='reports']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("allReports")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@id='allReportsDatatable']/tbody/tr[1]//td[5]//button[@title='View Report']")).click();
			Thread.sleep(3000);
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
			System.out.println(tabs.size());
			driver.switchTo().window((String) tabs.get(1)); 
			Thread.sleep(2000);
			String pCloudyReportURL = driver.getCurrentUrl();
			System.out.println(pCloudyReportURL);
			String fileName = System.getProperty("user.dir") + "/Session/caps/pCloudyReportURL.txt";
			try 
			{
				BufferedWriter bWriter=new BufferedWriter(new FileWriter(fileName));
				bWriter.write(pCloudyReportURL);
				System.out.println("Overwrite in "+fileName+" with "+pCloudyReportURL);
				bWriter.newLine();
				bWriter.close();
				
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}			
		}
		catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
		}

	}

}