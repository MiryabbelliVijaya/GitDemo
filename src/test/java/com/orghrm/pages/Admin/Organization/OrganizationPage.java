package com.orghrm.pages.Admin.Organization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orghrm.pages.BasePage;

public class OrganizationPage extends BasePage {

	public OrganizationPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	private By orgMenu = By.id("menu_admin_Organization");
	private By lstItemOrgMenu = By.xpath("//a[@id='menu_admin_Organization']/following-sibling::ul/li");
	private By generalInfoSubMenu = By.id("menu_admin_viewOrganizationGeneralInformation");
	private By locationSubMenu = By.id("menu_admin_viewLocations");
	private By structureSubMenu = By.id("menu_admin_viewCompanyStructure");
	
	//Getters
	public WebElement getOrgMenu() { return getElement(orgMenu); }
	public List<WebElement> getLstItemOrgMenu() { return getElements(lstItemOrgMenu); }
	public WebElement getGeneralInfoSubMenu() { return getElement(generalInfoSubMenu); }
	public WebElement getLocationSubMenu() { return getElement(locationSubMenu); }
	public WebElement getStructureSubMenu() { return getElement(structureSubMenu); }
	
	//Get count of list items in Organization Menu
	public int getOrgListCount() {
		return getLstItemOrgMenu().size();
	}

}
