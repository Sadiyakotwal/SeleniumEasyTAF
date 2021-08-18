package com.Day20.CheckBoxDemo;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest 
{
	    //Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		
		//Initialize Web Enviroment
		public void initializeWebEnvironment() 
		{
			this.loadConfigProperties();
			//Set system property
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(objConfigFile.getProperty("AUT_URL"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL"));
			driver.manage().window().maximize();		
		}
		//Load properties
		public void loadConfigProperties() 
		{
			try 
			{
				objConfigFile = new Properties();
				objConfigFile.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configurationCheckBox/configFile.properties"));
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());	
			}
		}
		//To take webdriver element
		public WebDriver getDriver() 
		{
			return driver;	
		}
		//To close the window
		public void tearDown() 
		{
			//driver.close();
		}


}
