package com.Day21.SoftAssertAndHardAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlyTestingTest extends BaseTest
{
	public OnlyTestingPage objOnlyTestingPage;
	public void initializePageObjectModel() 
	{
		objOnlyTestingPage =new OnlyTestingPage(this);
	}

	@BeforeMethod
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();	
	}
	
	@Test(priority=1)
	public void TC_ID_01_verifyHardAssert() 
	{
		objOnlyTestingPage.verifyDateOfHomePage();
		objOnlyTestingPage.verifyAlertMessage();
	}
	@Test(priority=2)
	public void TC_ID_02_verifyHardAssertWithIncorectData() 
	{
		objOnlyTestingPage.verifyDateOfHomePageWithIncorrectAssertCondotion();
		objOnlyTestingPage.verifyAlertMessageWithIncorrectCondition();

	}
	@Test(priority=3)
	public void TC_ID_03_verifySoftAssert() 
	{
		objOnlyTestingPage.verifyDateOfHomePageWithSoftAssert();
		objOnlyTestingPage.verifyAlertMessageWithSoftAssert();
	}
	@AfterMethod
	public void tearDownWebEnvironment()
	{
		tearDown();
	}

}
