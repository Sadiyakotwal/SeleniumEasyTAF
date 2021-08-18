package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider 
{
	//Global variable
	public WebDriver driver = null;
	@BeforeMethod
	public void initializeWebEnvironment() 
	{
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();		
	}

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
	
	@Test(dataProvider="gettestData")
	public void doLogin(String strUsername,String strPassword) 
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(strUsername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
		System.out.println("Username--->"+strUsername+"Password-->"+strPassword);
	}
	
	@AfterMethod
	public void tearDownEnvironment() 
	{
		driver.close();
	}
	

}
