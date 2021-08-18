package com.Day20.CheckBoxDemo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
public class CheckBoxDemoPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlagElement = false;
	public CheckBoxDemoPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	
	public void managePopUP() 
	{
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	}
	//To scroll page
	public void toScrollDownPage(String strYAxisValue) 
	{
		 
		 JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
		 js.executeScript("window.scrollBy(0,"+strYAxisValue+")", "");
		
	}
	//To select Menu bar element
	public void selectMenuBarElement(String strMenuBar) 
	{
		//Dynamic locator
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
		System.out.println("Menu Bar Selected : "+strMenuBar);
		objBaseTest.getDriver().findElement(MenuList).click();		
	}
	//To select particular drop down from menu bar list
	public void selectParticularDropDownFromMenuBar(String strDropDownValue)
	{
		//Dynamic xpath
		By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
		System.out.println("Drop Down Selected : "+strDropDownValue);
		objBaseTest.getDriver().findElement(Drop_Down_Option).click();	
	}
	//Directed to the page of drop down selected
	public void getPageOfParticularDropDown(String strMenu,String strDropDownValue) 
	{
		this.selectMenuBarElement(strMenu);
		this.selectParticularDropDownFromMenuBar(strDropDownValue);
	}
	//Verify home page of checkbox demo page
	public void verifyCheckBoxDemoPageIsDisplayedOrNot(String strHeaderExpected) 
	{
		By CheckBoxHeader = By.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']");
		String strActualHeader = objBaseTest.getDriver().findElement(CheckBoxHeader).getText();
		Assert.assertEquals(strActualHeader, strHeaderExpected);
		System.out.println("This is CheckBox Demo  Home page....");
	}
	//verify single checkBox demo section 
	public boolean verifySingleCheckBoxDemoSection() 
	{
		blnFlagElement = objBaseTest.getDriver().findElement(By.xpath("//div[text()='Single Checkbox Demo']")).isDisplayed();
		return blnFlagElement;
	}
	//Verify Single demo Section is displayed or not
	public void verifySingleCheckBoxDemoSectionIsDisplayedOrNot() 
	{
		Assert.assertEquals(verifySingleCheckBoxDemoSection(), true);	
	}       			
	//Verfiy if single check box is selected or not
	public boolean verifySingleCheckBoxIsSectedOrNot() 
	{
        blnFlagElement = objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
        return blnFlagElement;
    }
	//Select single check box
	public void selectSingleCheckBox() 
	{
		Assert.assertFalse(verifySingleCheckBoxIsSectedOrNot());
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).click();
	}
	//Get the text message of header section of Multiple checkbox demo section 
	public String getMultipleCheckBoxDemoSectionHeader() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[text()='Multiple Checkbox Demo']")).getText();
				
	}
	//Verify the multiple checkbox demo section displayed or not
	public void verifyMultipleCheckBoxDemoSectionIsDisplayedOrNot(String strExpectedHeader) 
	{
		this.toScrollDownPage("250");
		Assert.assertEquals(getMultipleCheckBoxDemoSectionHeader(), strExpectedHeader);
	}
	//verify whether the multiple checkbox is selected or not
	public boolean verifyMultipleCheckbox(String strCheckBoxOption) 
	{
	     blnFlagElement = objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+strCheckBoxOption+"']")).isSelected();
	     return blnFlagElement;		
	}
	//to select multiple checkbox
	public void selectMultipleCheckBox(String strCheckBoxOption) 
	{
		Assert.assertFalse(verifyMultipleCheckbox(strCheckBoxOption), "Check box is selected by user..");
		objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+strCheckBoxOption+"']")).click();
	}
}
