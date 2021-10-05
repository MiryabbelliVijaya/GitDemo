package com.orghrm.pages.Admin.Nationalities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orghrm.pages.BasePage;

public class NationalitiesPage extends BasePage{

	public NationalitiesPage(WebDriver driver) {
		            super(driver);
		}
	//Locators
		private By NationalitiesMenu = By.id("menu_admin_nationality");
		private By lstItemNationMenu = By.xpath("//a[@id='menu_admin_nationality']/following-sibling::ul/li");

		
		//Getters
		public WebElement getNationalitiesMenu() { return getElement(NationalitiesMenu); }
		public List<WebElement> getLstItemNationalitiesMenu() { return getElements(lstItemNationMenu); }

		
		//Get count of list items in Nationalities Menu
		public int getNationalitiesListCount() {
			return getLstItemNationalitiesMenu().size();
		}

}
