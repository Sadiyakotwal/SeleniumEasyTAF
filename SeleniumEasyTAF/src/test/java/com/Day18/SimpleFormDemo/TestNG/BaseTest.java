package com.Day18.SimpleFormDemo.TestNG;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
			objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/repository.properties"));
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured: "+exception.getMessage());	
		}
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
