package com.Day20.CheckBoxDemo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxDemoPageTest extends BaseTest
{
	public CheckBoxDemoPage objCheckBoxDemoPage;
	//create reference of checkbox demo page class
	public void initializePageObjectModel() 
	{
		objCheckBoxDemoPage =new CheckBoxDemoPage(this);
	}
	@BeforeClass
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();	
	}
	@Test(priority=1)
	public void TC_ID_01_verifyCheckBoxDemoHomePage() 
	{
		objCheckBoxDemoPage.managePopUP();
		objCheckBoxDemoPage.getPageOfParticularDropDown(objConfigFile.getProperty("strMenuBar"), objConfigFile.getProperty("strDropDownValue"));
		objCheckBoxDemoPage.verifyCheckBoxDemoPageIsDisplayedOrNot(objConfigFile.getProperty("strHeaderExpected"));
	}
	@Test(priority=2)
	public void TC_ID_02_verifySingleCheckBoxDemoSection() 
	{
		objCheckBoxDemoPage.verifySingleCheckBoxDemoSectionIsDisplayedOrNot();
		objCheckBoxDemoPage.selectSingleCheckBox();
	}
	@Test(priority=3)
	public void TC_ID_03_verifymultipleCheckBoxDemoSection() 
	{
		objCheckBoxDemoPage.verifyMultipleCheckBoxDemoSectionIsDisplayedOrNot(objConfigFile.getProperty("strExpectedHeader"));
		objCheckBoxDemoPage.selectMultipleCheckBox(objConfigFile.getProperty("strCheckBoxOption1"));
		objCheckBoxDemoPage.selectMultipleCheckBox(objConfigFile.getProperty("strCheckBoxOption2"));
	}
	


}
