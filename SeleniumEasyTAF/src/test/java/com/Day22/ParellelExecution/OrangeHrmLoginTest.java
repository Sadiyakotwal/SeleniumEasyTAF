package com.Day22.ParellelExecution;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHrmLoginTest extends BaseTest
{
	@Parameters({"browsername"})
	@Test
	public void doLogin(String strBrowser) 
	{
		System.out.println("Browser name: "+strBrowser);
		driver= getDriver(strBrowser);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}

}
