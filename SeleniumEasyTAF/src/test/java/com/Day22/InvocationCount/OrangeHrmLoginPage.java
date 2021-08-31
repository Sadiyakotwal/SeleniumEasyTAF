package com.Day22.InvocationCount;

import org.openqa.selenium.By;

public class OrangeHrmLoginPage 
{
	private BaseTest objBaseTest;
	public OrangeHrmLoginPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	//do login 
	public void doLogin(String strUsername,String strPassword) 
	{
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(strUsername);
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(strPassword);
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
}

/*//Click on Admin module
public void clickOnAdmin() 
{
	objBaseTest.getDriver().findElement(By.xpath("//a/b[text()='Admin']")).click();
	
}*/