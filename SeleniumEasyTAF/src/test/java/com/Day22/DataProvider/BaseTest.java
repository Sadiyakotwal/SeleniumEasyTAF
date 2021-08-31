package com.Day22.DataProvider;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
			driver.get(objConfigProperties.getProperty("AUT_URL1"));
			System.out.println("URL to be Tested: "+objConfigProperties.getProperty("AUT_URL1"));
			driver.manage().window().maximize();	
			
		}
		public void loadConfigProperties() 
		{
			try 
			{
				objConfigProperties = new Properties();
				objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/repository.properties"));
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());	
			}
		}
		
		@DataProvider
		public  Object[][]  gettestData() 
		{
			Object[][] UserData = new Object[2][2];
			//For 1st user
			UserData[0][0] = "sadiyakotwal10@gmail.com";
			UserData[0][1] = "sadiya@123";
			
			//For 2nd user
			UserData[1][0] = "documentssadiya0201@gmail.com";
			UserData[1][1] = "sadiya@123";
			return UserData;
		}
		
		public WebDriver getDriver() 
		{
			return driver;	
		}
	
		public void tearDown() 
		{
			driver.close();
		}


}
