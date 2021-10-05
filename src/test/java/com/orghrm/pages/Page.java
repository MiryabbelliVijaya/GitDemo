package com.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public static WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		Page.driver=driver;
		this.wait=new WebDriverWait(Page.driver, 15);
	}
	
	//Abstract methods
	abstract public String getPageTitle();
	abstract public String getPageURL(); 
	abstract public String getPageHeader(By locator);
	abstract public String getPageFooter(By locator);
	abstract public WebElement getElement(By locator);
	abstract public List<WebElement> getElements(By locator);
	abstract public void waitForElementPresent(By locator);
	abstract public void waitForPageTitle(String title);
	
	//Create generic
//	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) 
//	{
//		try 
//		{
//			//newInstance is used to create an object of that class
//			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(Page.driver);
//		}catch(Exception e) 
//		{
//			e.printStackTrace();
//			return null;
//		}
//	}
	
}
