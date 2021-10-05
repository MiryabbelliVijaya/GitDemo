package com.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	//HomePage Locators
	private By homePageHeader = By.cssSelector("#welcome");
	private By companyLogo = By.cssSelector("#branding>a>img");
	private By welcomeLink = By.xpath("//a[contains(text(),'Welcome')]");
	private By logOutLink = By.partialLinkText("Logout");
	private By adminMenu = By.id("menu_admin_viewAdminModule");
//	private By pimMenu = By.id("menu_pim_viewPimModule");
//	private By leaveMenu = By.id("menu_leave_viewLeaveModule");
//	private By timeMenu = By.id("menu_time_viewTimeModule");
//	private By recruitmentMenu = By.id("menu_recruitment_viewRecruitmentModule");
//	private By performanceMunu = By.id("menu__Performance");
//	private By dashboardMenu = By.id("menu_dashboard_index");
//	private By directoryMenu = By.id("menu_directory_viewDirectory");
//	private By maintenanceMenu = By.id("menu_maintenance_purgeEmployee");
//	private By buzzMenu = By.id("menu_buzz_viewBuzz");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	public WebElement getWelcomeLink() {
		return getElement(welcomeLink);
	}

	public WebElement getLogOutLink() {
		return getElement(logOutLink);
	}
	
	// page Title
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	//page Header
	public String getHomePageHeader() {
		return getPageHeader(homePageHeader);
	}

	//Logout Functionality
	public LoginPage doLogOut() {
		getWelcomeLink().click();
		getLogOutLink().click();
		return new LoginPage(driver);
	}
	
	//logout page URL
	public String getLogoutPageURL() {
		return getPageURL();
	}
	
	//GetAdmin Menu
	public WebElement getAdminMenu() {
		return getElement(adminMenu);
	}
	
	//Company Logo presence
	public boolean getCompanyLogo() {
		return getElement(companyLogo).isDisplayed();
}

}