package com.Day20.BootstrapAlertDemo;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/configFile.properties"));
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
	public boolean checkIfElementIsPresentOrNot(By locator) 
	{
		boolean blnFlag = false;
		try 
		{
	         WebDriverWait wait = new WebDriverWait(this.getDriver(), 5);
	         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	         WebElement WebElement =this.getDriver().findElement(locator);
	         blnFlag = WebElement.isSelected();
	         return blnFlag;
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured:");
		}
		return blnFlag;
		
	}
	public void tearDown() 
	{
		//driver.close();
	}



			
}
