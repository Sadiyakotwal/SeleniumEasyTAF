package com.Day22.ParellelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	//Global variable
	public WebDriver driver;
	public WebDriver getDriver(String strBrowser) 
	{
		if (strBrowser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(strBrowser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(strBrowser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}
		return driver;
	}

}
