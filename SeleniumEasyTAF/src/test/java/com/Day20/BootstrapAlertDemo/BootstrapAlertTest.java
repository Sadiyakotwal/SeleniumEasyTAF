package com.Day20.BootstrapAlertDemo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class BootstrapAlertTest extends BaseTest
{
	public BootstrapAlertPage objBootstrapAlertPage;
	
	public void initializePageObjectModel() 
	{
		objBootstrapAlertPage = new BootstrapAlertPage(this);
		
	}

	@BeforeClass
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
		
	}
	@Test(priority=1)
	public void TC_ID_01_verifyBootstrapAlertHomePage() throws InterruptedException 
	{
		objBootstrapAlertPage.closePopup();
		objBootstrapAlertPage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValue"));
		objBootstrapAlertPage.verifyBootStrapAlertMessagesPageIsDisplayedOrNot(objConfigProperties.getProperty("strHeaderExpected"));
	}
	
	@Test(priority=2)
	public void TC_ID_02_verifyAutocloseableableSuccessMessage() 
	{
		objBootstrapAlertPage.checkWhichButtonIsSelected(objConfigProperties.getProperty("strAutocloseableButton"));
		objBootstrapAlertPage.clickBootstrapAlertButtonsOption(objConfigProperties.getProperty("strAutocloseableButton"));
		objBootstrapAlertPage.verifyAutocloseableSuccessMsgIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableSuccessMsg"));
	}
	
	
	@Test(priority=3)
	public void TC_ID_03_verifyNormalSuccessMessage() 
	{
		objBootstrapAlertPage.checkWhichButtonIsSelected(objConfigProperties.getProperty("strNormalSuccessButton"));
		objBootstrapAlertPage.clickNormalSuccessButton(objConfigProperties.getProperty("strNormalSuccessButton"));
		objBootstrapAlertPage.verifyNormalSuccessMessage();
	}
	
	@Test(priority=4)
	public void TC_ID_04_verifyAutocloseableWarningMessage()
	{
		objBootstrapAlertPage.checkWhichButtonIsSelected(objConfigProperties.getProperty("strAutocloseableWarningButton"));
		objBootstrapAlertPage.clickBootstrapAlertButtonsOption(objConfigProperties.getProperty("strAutocloseableWarningButton"));
		objBootstrapAlertPage.verifyAutocloseableWarningMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableWarningMsg"));
	}
	

	@Test(priority=5)
	public void TC_ID_05_verifyNormalWarningMessage()
	{
		objBootstrapAlertPage.checkWhichButtonIsSelected(objConfigProperties.getProperty("strNormalWarningButton"));
		objBootstrapAlertPage.verifyNormalWarningMsgbuttonIsDisplayedOrNot(objConfigProperties.getProperty("strNormalWarningButton"));
		objBootstrapAlertPage.verifyNormalWarningMsg();
	}
	

}
