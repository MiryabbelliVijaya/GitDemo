package com.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
	//Page Locators
	private By username = By.id("txtUsername");
	private By loginPassword = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By loginPageHeader = By.id("logInPanelHeading");
	private By loginPageFooter =  By.linkText("OrangeHRM, Inc");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	//Getters
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		return getPageHeader(loginPageHeader);
	}
	
	public WebElement getUsername() {
		return getElement(username);
	}

	public WebElement getPassword() {
		return getElement(loginPassword);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	
	public String getLoginPageFooter() {
		return getPageFooter(loginPageFooter);
	}

	//Login Method
	public HomePage doLogin(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		return new HomePage(driver);
	}
}