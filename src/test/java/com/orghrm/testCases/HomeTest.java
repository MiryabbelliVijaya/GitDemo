package com.orghrm.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;

public class HomeTest extends BaseTest {	
	LoginPage lp;
	HomePage hp;
	
	public HomeTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
		
	}
	
	@Test(priority=6)
	public void verifyValidLogin() {
		String validUser=config.getLoginUserName(); //Data source -> config.properties
		String validPassword=config.getLoginPassword(); //Data source -> config.properties
		String expectedWelcomeText="Welcome Admin";
	
		hp = lp.doLogin(validUser, validPassword);
		String actualWelcomeText = hp.getHomePageHeader();
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
	
	@Test(priority=7)
	public void verifyHomePageTitle() {
		String expectedHomepageTitle="OrangeHRM";
		String actualPageTitle = hp.getHomePageTitle();
		Assert.assertEquals(actualPageTitle, expectedHomepageTitle);
	}

	@Test(priority=8)
	public void verifyHomePageHeader() {
		String expectedWelcomeText="Welcome Admin";
		String actualPageHeader = hp.getHomePageHeader();
		Assert.assertEquals(actualPageHeader, expectedWelcomeText);
	}

	@Test(priority=9)
	public void verifyLogout() {
		String expectedLoginPageHeader="LOGIN Panel";
		lp = hp.doLogOut();
		String actualPageHeader=  lp.getLoginPageHeader();
		Assert.assertEquals(actualPageHeader, expectedLoginPageHeader);
	}
}