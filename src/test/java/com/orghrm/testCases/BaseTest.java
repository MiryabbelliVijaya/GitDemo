package com.orghrm.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import com.orghrm.pages.LoginPage;
import com.orghrm.pages.Page;
import com.orghrm.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static ReadConfig config;
	public static Page page;
	public LoginPage lp;
	
	final String dataFile=System.getProperty("user.dir")+"\\src\\test\\java\\com\\orghrm\\testData\\TestData.xlsx";
	
	public BaseTest() {
		config = new ReadConfig();
	}
	

	public static void initialize() 
	{	
		if (config.getBrowser().equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (config.getBrowser().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (config.getBrowser().equalsIgnoreCase("ie")) 
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} 
		else 
		{
			System.out.println("Browser name is not defined in 'config.properties' File....");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(config.getBaseURL());  //BaseURL is defined is config.properties file
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}