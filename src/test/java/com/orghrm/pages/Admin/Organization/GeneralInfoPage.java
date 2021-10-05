package com.orghrm.pages.Admin.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.orghrm.pages.BasePage;

public class GeneralInfoPage extends BasePage {

	public GeneralInfoPage(WebDriver driver) {
		super(driver);
	}
	
	//Element Locators
	private By genInfoHeading = By.cssSelector("#genInfoHeading");
	private By street1 = By.cssSelector("#organization_street1");
	private By street2 = By.cssSelector("#organization_street2");
	private By city = By.cssSelector("#organization_city");
	private By country = By.cssSelector("#organization_country");
	private By note = By.cssSelector("#organization_note");
	private By btnEdit = By.xpath("//*[@id='btnSaveGenInfo' and @value='Edit']");
	private By btnSave = By.xpath("//*[@id='btnSaveGenInfo' and @value='Save']");
	
	//Getters
	public WebElement getGenInfoHeading() { return getElement(genInfoHeading); }
	public WebElement getStreet1() { return getElement(street1); }
	public WebElement getStreet2() { return getElement(street2); }
	public WebElement getCity() { return getElement(city); }
	public WebElement getCountry() { return getElement(country); }
	public WebElement getNotes() { return getElement(note); }
	public WebElement getEditBtn() { return getElement(btnEdit); }
	public WebElement getSaveBtn() { return getElement(btnSave); }
	
	//Action Methods
	public void verifyReadOnlyFields() {
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(getStreet1().getAttribute("disabled"), true);
		softAssertion.assertEquals(getStreet2().getAttribute("disabled"), true);
		softAssertion.assertEquals(getCity().getAttribute("disabled"), true);
		softAssertion.assertEquals(getCountry().getAttribute("disabled"), true);
		softAssertion.assertEquals(getNotes().getAttribute("disabled"), true);
//		softAssertion.assertAll();
	}
	
	public void modifyGeneraInfoFields() {
		getEditBtn().click();
		getStreet1().sendKeys("Test");
		getStreet2().sendKeys("Test");
		getCity().sendKeys("Bengalore");
		
		Select dd = new Select(getCountry());
		dd.selectByVisibleText("India");
		getNotes().sendKeys("Testing");
		getSaveBtn().click();
	}
	
	
}
