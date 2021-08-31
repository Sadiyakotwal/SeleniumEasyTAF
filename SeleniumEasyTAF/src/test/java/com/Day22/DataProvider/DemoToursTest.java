package com.Day22.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoToursTest extends BaseTest
{
	public  DemoToursPage objDemoToursPage;
	
	public void initializePageObjectModel() 
	{
		objDemoToursPage =new DemoToursPage(this);
		
	}
	@BeforeMethod
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
		
	}
	@Test(dataProvider="gettestData",dataProviderClass = BaseTest.class)
	public void doLogin(String strUsername,String strPassword) 
	{
		objDemoToursPage.doLogin(strUsername, strPassword);
		
	}
	
	@AfterMethod
	public void tearDownWebEnvironment()
	{
		tearDown();
	}

}
