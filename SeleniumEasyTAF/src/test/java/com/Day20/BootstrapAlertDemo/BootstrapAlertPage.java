package com.Day20.BootstrapAlertDemo;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class BootstrapAlertPage 
{
	public BaseTest objBaseTest;
	public boolean blnFlag = false;

	public BootstrapAlertPage(BaseTest BaseTest) 
	{
		this.objBaseTest = BaseTest;
	}
	
	//Close popup
	public void closePopup() throws InterruptedException 
	{
			Thread.sleep(2000);
	        objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	  }
	
	//Select menubar option
	public void selectMenuBarElement(String strMenuBar) 
	{
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
		System.out.println("Menu Bar Selected : "+strMenuBar);
		objBaseTest.getDriver().findElement(MenuList).click();	
		
	}
	
	//Select drop down option
	public void selectParticularDropDown(String strDropDownValue)
	{
		//Dynamic xpath
		By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
		System.out.println("Drop Down Selected : "+strDropDownValue);
		objBaseTest.getDriver().findElement(Drop_Down_Option).click();	
	}
	
	//Select menubar and drop down option
	public void selectMenuBarOptionAndDropDown(String strMenu,String strDropDownValue) 
	{
		this.selectMenuBarElement(strMenu);
		this.selectParticularDropDown(strDropDownValue);
		
	}
	
	//Verify the home page of bootstrap Alert message
	public void verifyBootStrapAlertMessagesPageIsDisplayedOrNot(String strHeaderExpected) 
	{
		By bootStrapAlertPageHeader = By.xpath("//h2[text()='Bootstrap Alert messages']");
		String strActualHeader = objBaseTest.getDriver().findElement(bootStrapAlertPageHeader).getText();
		Assert.assertTrue(strActualHeader.equals(strHeaderExpected));
		System.out.println("This is BootStrap Alert page....\n");
	}
	
	//Get information of button selected
	public void checkWhichButtonIsSelected(String strButtonsOption) 
	{
		//Dynamic xpath for All Buttons of bootstrap alert message
		By BootstrapAlertButtonOptions = By.xpath("//button[@id='"+strButtonsOption+"']");
		String strButtonName = objBaseTest.getDriver().findElement(BootstrapAlertButtonOptions).getText();
		System.out.println("Bootstrap Button Selected is :"+strButtonName);
		System.out.println("------------------------------------------------------");
	}
	
	//Click on button
	public void clickBootstrapAlertButtonsOption(String strButtonsOption) 
	{
		//Dynamic xpath for All Buttons of bootstrap alert message
		objBaseTest.getDriver().findElement(By.xpath("//button[@id='"+strButtonsOption+"']")).click();
	}
	
	//Get the text message of autocloseable success messsage button
	//Button 1
	public String getAutocloseableMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-success alert-autocloseable-success']")).getText();
				
	}
			
	//verify the autocloseable message
	public void verifyAutocloseableSuccessMsgIsDisplayedOrNot(String strExpAutocloseableSuccessMsg) 
	{
		String strActualMessage = this.getAutocloseableMsg();
		Assert.assertTrue(strExpAutocloseableSuccessMsg.equals(strActualMessage));
	}
	
	//Check  normal success button present or not
	//Button 2-changed
	public boolean verifyNormalSuccessMessageButtonIsPresentOrNot(String strButtonsOption) 
	{
		boolean blnFlagElement = false;
		blnFlagElement = objBaseTest.getDriver().findElement(By.xpath("//button[@id='"+strButtonsOption+"']")).isDisplayed();
		return blnFlagElement;
	}
	
	//If button present then click on button
	public void clickNormalSuccessButton(String strButtonsOption) 
	{
		Assert.assertTrue(verifyNormalSuccessMessageButtonIsPresentOrNot(strButtonsOption));
		this.clickBootstrapAlertButtonsOption(strButtonsOption);	
	}
	
	//Verify message is displayed or not
	public boolean verifyNormalSuccessMsgIsDisplayedOrNot() 
	{
		boolean blnFlag = false;
      blnFlag = objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-success alert-normal-success']")).isDisplayed();
      return blnFlag;
	}
	
	//Check if message displayed and then verify msg
	public void verifyNormalSuccessMessage() 
	{
		Assert.assertTrue(verifyNormalSuccessMsgIsDisplayedOrNot());
		boolean verifyText = objBaseTest.getDriver().getPageSource().contains("I'm a normal success message. To close use  the appropriate button.");
		Assert.assertTrue(verifyText);
		//System.out.println(verifyText);
	}		
	
	
	//Get autocloseable warning message
	//Button 3
	public String getAutocloseableWarningMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-warning alert-autocloseable-warning']")).getText();
	}
			
	//Verify autocloseable warning  message
	public void verifyAutocloseableWarningMessageIsDisplayedOrNot(String strExpAutocloseableWarningMsg) 
	{
			String strActualMessage = this.getAutocloseableWarningMsg();
			Assert.assertEquals(strActualMessage, strExpAutocloseableWarningMsg);
	}
		
	//Check button displayed or not
	//Button 4 -changed
	public void verifyNormalWarningMsgbuttonIsDisplayedOrNot(String strButtonsOption) 
	{
		//verify the button present or not
		List<WebElement> listNormalWarningButton  = objBaseTest.getDriver().findElements(By.id("autoclosable-btn-warning"));
		Assert.assertEquals(listNormalWarningButton.size()!=0, true);	
		this.clickBootstrapAlertButtonsOption(strButtonsOption);
	}
	
	//Verify text of normal warning msg
	public void verifyNormalWarningMsg() 
	{
	    List<WebElement> listMsg= objBaseTest.getDriver().findElements(By.xpath("//div[@class='alert alert-warning alert-normal-warning']"));
	    Assert.assertTrue(listMsg.size()>0);
	}

}


