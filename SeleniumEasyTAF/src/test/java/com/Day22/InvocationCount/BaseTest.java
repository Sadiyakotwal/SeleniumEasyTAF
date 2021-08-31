package com.Day22.InvocationCount;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class BaseTest 
{
	    //Global variable
		public WebDriver driver = null;
		public Properties objConfigProperties;

		public void initializeWebEnvironment() 
		{
			this.loadConfigProperties();
			//Set system property
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(objConfigProperties.getProperty("AUT_URL"));
			System.out.println("URL to be Tested: "+objConfigProperties.getProperty("AUT_URL"));
			driver.manage().window().maximize();	
			
		}
		public void loadConfigProperties() 
		{
			try 
			{
				objConfigProperties = new Properties();
				objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/configFileInvocation.properties"));
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());	
			}
		}
		
		@DataProvider
		public  Object[][]  getTestData() 
		{
			Object[][] UserData = new Object[1][2];
			//For 1st user
			UserData[0][0] = "Admin";
			UserData[0][1] = "admin123";
			return UserData;
			
		}
		
		public WebDriver getDriver() 
		{
			return driver;	
		}
		public void tearDown() 
		{
			//driver.close();
		}


}
