package com.Day21.Groups;

import org.testng.annotations.Test;

public class FlipcartPageTest 
{
	@Test(groups= {"SmokeTest"})  
	 public void TCID_01_WebLogin()  
	 {  
	     System.out.println("Web Login for flipcart page...");  
	 }  
	 @Test  
	 public void TCID_02_MobileLogin()  
	 {  
	     System.out.println("Mobile Login for flipcart page...");  
	 }  
	 
	 @Test(groups= {"RegressionTest"})
	 public void TCID_03_WebAddCartItem()  
	 {  
		 System.out.println("Added item to cart through web login for flipcart page....");  
	 }
		
	 @Test
	 public void TCID_04_MobileAddCartItem()  
	 {  
		 System.out.println("Added item to cart through mobile login for flipcart page....");  
	 }
}
