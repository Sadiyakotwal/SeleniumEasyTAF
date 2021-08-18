package com.Day21.SoftAssertAndHardAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OnlyTestingPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	public String ActualText;
	SoftAssert soft_assert = new SoftAssert();
	public OnlyTestingPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	//To wait
	public void implicitlyWait() 
	{
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;

	}
	
	//Example 
	//Hard Assert
	public String getDateOfHomePage() 
	{
		return ActualText = objBaseTest.getDriver().findElement(By.xpath("//h2/span")).getText();
	}
	//Verify home page date
	public void verifyDateOfHomePage() 
	{
		 Assert.assertEquals(getDateOfHomePage(), "Tuesday, 28 January 2014", "1st assert Passed.");
		 System.out.println("Home Page Date");
	}
	
	//Verify home page date
	public void verifyDateOfHomePageWithIncorrectAssertCondotion() 
	{
		Assert.assertEquals(getDateOfHomePage(), "Tuesday, 28 Feb 2014", "1st assert failed.");
	}
	//get alert text
	public String getAlertMessage() 
	{
		this.implicitlyWait();
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		//Switches to alert box
		this.implicitlyWait();
		String Alert_text = objBaseTest.getDriver().switchTo().alert().getText();
		objBaseTest.getDriver().switchTo().alert().accept();
		return Alert_text;
	}
	//Verify alert
	public void verifyAlertMessage() 
	{
		 Assert.assertEquals(getAlertMessage(), "Hi.. This is alert message!", "Alert Is Correct");
	}
	//Verify alert with incorect data
	public void verifyAlertMessageWithIncorrectCondition() 
	{
		Assert.assertEquals(getAlertMessage(), "Hi..  is alert message!", "Alert Is Correct");
	}
	
	//Example
	//Soft Assert
	//Verify home page date
	public void verifyDateOfHomePageWithSoftAssert() 
	{
		soft_assert.assertEquals(getDateOfHomePage(), "Tuesday, 28 January 2014", "1st assert failed.");
		//soft_assert.assertAll();

	}
	
	//Verify alert
	public void verifyAlertMessageWithSoftAssert() 
	{
		soft_assert.assertEquals(getAlertMessage(), "Hi..  is alert message!", "Alert Is Correct");
		//soft_assert.assertAll();
	}
}
