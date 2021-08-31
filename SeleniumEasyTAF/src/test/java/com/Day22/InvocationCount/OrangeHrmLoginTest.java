package com.Day22.InvocationCount;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OrangeHrmLoginTest extends BaseTest
{
    public OrangeHrmLoginPage objOrangeHrmLoginPage;
	
	public void initializePageObjectModel() 
	{
		objOrangeHrmLoginPage =new OrangeHrmLoginPage(this);
		
	}

	@BeforeMethod
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
	}
	
	@Test(priority=1,dataProvider = "getTestData",dataProviderClass = BaseTest.class,invocationCount = 3)
	public void TCID_01_doLogin(String strUsername,String strPassword) 
	{
		objOrangeHrmLoginPage.doLogin(strUsername, strPassword);
	}
	
	@AfterMethod
	public void tearDownWebEnvironment()
	{
		tearDown();
	}
}


/*@Test(dependsOnMethods = {"TCID_01_doLogin" })
public void TCID_01_ClickOnAdminModule() 
{
	objOrangeHrmLoginPage.clickOnAdmin();
}*/