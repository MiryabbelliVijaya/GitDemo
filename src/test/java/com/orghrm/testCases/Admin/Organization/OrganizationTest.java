package com.orghrm.testCases.Admin.Organization;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;
import com.orghrm.pages.Admin.Organization.OrganizationPage;
import com.orghrm.testCases.BaseTest;

public class OrganizationTest extends BaseTest {
	
	LoginPage lp;
	HomePage hp;
	OrganizationPage org;
	Actions act;
	
	public OrganizationTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		org=new OrganizationPage(driver);
		act = new Actions(driver);
	}
	
	@Test(priority=11)
	public void verifyValidLogin() {
		String validUser=config.getLoginUserName(); //Data source -> config.properties
		String validPassword=config.getLoginPassword(); //Data source -> config.properties
		hp = lp.doLogin(validUser, validPassword);
	}
	
	@Test(priority=12)
	public void countOfOrganizationListItem() {
		hp.getAdminMenu().click();
		act.moveToElement(org.getOrgMenu()).build().perform();
		int orgLstCount = org.getOrgListCount();
		Assert.assertEquals(orgLstCount, 3);
	}
	
	

}
