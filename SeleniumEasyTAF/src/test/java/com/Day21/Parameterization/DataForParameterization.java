package com.Day21.Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataForParameterization 
{
	@DataProvider
	public Object[][]  gettestData() 
	{
		Object[][] UserData = new Object[2][2];
		//For 1st user
		UserData[0][0] = "sadiyakotwal10@gmail.com";
		UserData[0][1] = "sadiya@123";
		
		//For 2nd user
		UserData[1][0] = "documentssadiya0201@gmail.com";
		UserData[1][1] = "sadiya@123";
	
		
		return UserData;
	}
	
	@Test(dataProvider = "gettestData")
	public void doLogin(String strUsername,String strPassword) 
	{
		System.out.println("Username--->"+strUsername+"Password-->"+strPassword);
	}
	
	public void doLoginWithParameter(String strUsername,String strPassword) 
	{
		System.out.println("Username--->"+strUsername+"Password-->"+strPassword);
	}

}
