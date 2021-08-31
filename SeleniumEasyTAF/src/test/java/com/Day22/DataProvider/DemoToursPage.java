package com.Day22.DataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoToursPage 
{
	private  BaseTest objBaseTest;
	public DemoToursPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	
	public  void doLogin(String strUsername,String strPassword) 
	{
		objBaseTest.getDriver().findElement(By.xpath("//input[@name='userName']")).sendKeys(strUsername);
		objBaseTest.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
		System.out.println("Username--->"+strUsername+"Password-->"+strPassword);
	}
	
	

}
