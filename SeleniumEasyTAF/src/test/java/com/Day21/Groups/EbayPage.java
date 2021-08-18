package com.Day21.Groups;

import org.testng.annotations.Test;

public class EbayPage 
{
	@Test(groups= {"SmokeTest"})  
	 public void WebLogin()  
	 {  
	     System.out.println("Web Login for ebay  page...");  
	 }  
	 @Test  
	 public void MobileLogin()  
	 {  
	     System.out.println("Mobile Login for ebay page...");  
	 }  
	 
	 @Test(groups= {"RegressionTest"})
	 public void WebAddCartItem()  
	 {  
		 System.out.println("Added item to cart through web login for ebay page....");  
	 }
		
	 @Test
	 public void MobileAddCartItem()  
	 {  
		 System.out.println("Added item to cart through mobile login for ebayt page....");  
	 }

}
