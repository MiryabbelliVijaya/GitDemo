package com.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}
	
	@Override
	public String getPageFooter(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
	 	waitForElementPresent(locator);
		WebElement element=null;
		try {
			element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Some Error occured while finding an element: "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	
	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> element=null;
		try {
			waitForElementPresent(locator);
			element = driver.findElements(locator);
		}catch(Exception e) {
			System.out.println("Some Error occured while finding an element: "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	
	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Some Exception/Error occured while waiting for an element: "+locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			System.out.println("Some Exception/Error occured while waiting for an element: "+title);
			e.printStackTrace();
		}
	}

	@Override
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

}