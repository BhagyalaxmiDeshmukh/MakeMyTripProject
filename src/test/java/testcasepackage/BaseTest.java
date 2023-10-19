package testcasepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pagepackage.SelectData;

public class BaseTest 
{
	
	public static WebDriver driver;
	
	SelectData sd;
	@BeforeSuite
	public static  void initBrowser()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
	}
	
	@BeforeClass
	public void createObject()
	{
		sd=new SelectData(driver);
	}

}
