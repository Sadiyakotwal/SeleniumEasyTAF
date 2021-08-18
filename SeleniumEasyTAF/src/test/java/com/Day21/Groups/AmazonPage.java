package com.Day21.Groups;

import org.testng.annotations.Test;

public class AmazonPage 
{
	@Test
	public void WebLogin()  
	{  
	  System.out.println("Web Login for amazon page...");  
	}  
	@Test(groups= {"SmokeTest"})  
	public void MobileLogin()  
	{  
	  System.out.println("Mobile Login for amazon page...");  
	}  
	
	@Test  
	public void WebAddCartItem()  
	{  
	  System.out.println("Added item to cart through web login for amazon page....");  
	}
	
	@Test(groups= {"RegressionTest"})
	public void MobileAddCartItem()  
	{  
	  System.out.println("Added item to cart through mobile login for amazon page....");  
	}
}
