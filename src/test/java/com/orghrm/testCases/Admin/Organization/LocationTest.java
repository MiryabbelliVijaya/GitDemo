package com.orghrm.testCases.Admin.Organization;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;
import com.orghrm.pages.Admin.Organization.LocationPage;
import com.orghrm.pages.Admin.Organization.OrganizationPage;
import com.orghrm.testCases.BaseTest;

public class LocationTest extends BaseTest {

	LoginPage lp;
	HomePage hp;
	OrganizationPage org;
	LocationPage locPage;
	Actions act;
	SoftAssert softAssertion;
	
	public LocationTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		org=new OrganizationPage(driver);
		locPage=new LocationPage(driver);
		act=new Actions(driver);
		softAssertion= new SoftAssert();
	}
	
	@Test(priority=21)
	public void verifyValidLogin() {
		String validUser=config.getLoginUserName(); //Data source -> config.properties
		String validPassword=config.getLoginPassword(); //Data source -> config.properties
		hp = lp.doLogin(validUser, validPassword);
	}
	
	@Test(priority=22)
	public void verifyLocationPageFields() {
		hp.getAdminMenu().click();
		act.moveToElement(org.getOrgMenu()).build().perform();
		org.getLocationSubMenu().click();
		String pageHeader = locPage.getTxtLocationHeading().getText();
		Assert.assertEquals(pageHeader, "Locations");
		
		softAssertion.assertEquals(locPage.getTxtLocationName().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getTxtLocationName().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getTxtCityName().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getDrpCountry().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getBtnSearch().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getBtnReset().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getBtnAdd().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getBtnDelete().isDisplayed(), true);
		softAssertion.assertEquals(locPage.getResultTable().isDisplayed(), true);
		softAssertion.assertAll();
	}
	
	@Test(priority=23)
	public void addNewLocation() {
		locPage.getBtnAdd().click();
		
	}
}
