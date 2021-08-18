package com.Day21.Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametersFromXmlFile 
{
	
	DataForParameterization objDataForParameterization = new DataForParameterization();

	@Parameters({"browser","environment"})
	@Test(dataProvider ="gettestData",dataProviderClass = DataForParameterization.class)
	public void getloginCredentials(String strBrowser,String strEnvironment) 
	{
		System.out.println(strBrowser+"---->"+strEnvironment);
		objDataForParameterization.doLoginWithParameter(strBrowser, strEnvironment);	
	}
	
	@Parameters({"browser","environment"})
	@Test
	public void getBrowser(String strBrowser,String strEnvironment) 
	{
		System.out.println(strBrowser+"---->"+strEnvironment);
		objDataForParameterization.doLoginWithParameter(strBrowser, strEnvironment);	
	}
	

}
