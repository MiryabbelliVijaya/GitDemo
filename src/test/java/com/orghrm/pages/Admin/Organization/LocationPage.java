package com.orghrm.pages.Admin.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orghrm.pages.BasePage;

public class LocationPage extends BasePage {

	public LocationPage(WebDriver driver) {
		super(driver);
	}
	
	//Element Locators
	private By txtLocationHeading = By.id("searchLocationHeading");
	private By txtLocationName = By.id("searchLocation_name");
	private By txtCityName = By.id("searchLocation_city");
	private By drpCountry = By.id("searchLocation_country");
	private By btnSearch  = By.id("btnSearch");
	private By btnReset = By.id("btnReset");
	private By btnAdd = By.id("btnAdd");
	private By btnDelete = By.id("btnDelete");
	private By resultTable = By.id("resultTable");
	
	
	//Getters
	public WebElement getTxtLocationHeading() { return getElement(txtLocationHeading); }
	public WebElement getTxtLocationName() { return getElement(txtLocationName); }
	public WebElement getTxtCityName() { return getElement(txtCityName); }
	public WebElement getDrpCountry() { return getElement(drpCountry); }
	public WebElement getBtnSearch() { return getElement(btnSearch); }
	public WebElement getBtnReset() { return getElement(btnReset); }
	public WebElement getBtnAdd() { return getElement(btnAdd); }
	public WebElement getBtnDelete() { return getElement(btnDelete); }
	public WebElement getResultTable() { return getElement(resultTable); }
	
	
}
