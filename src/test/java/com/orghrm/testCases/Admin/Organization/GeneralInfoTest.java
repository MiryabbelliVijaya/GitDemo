package com.orghrm.testCases.Admin.Organization;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;
import com.orghrm.pages.Admin.Organization.GeneralInfoPage;
import com.orghrm.pages.Admin.Organization.OrganizationPage;
import com.orghrm.testCases.BaseTest;

public class GeneralInfoTest extends BaseTest {

	LoginPage lp;
	HomePage hp;
	OrganizationPage org;
	GeneralInfoPage genInfo;
	Actions act;
	
	public GeneralInfoTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		org=new OrganizationPage(driver);
		genInfo=new GeneralInfoPage(driver);
		act=new Actions(driver);
	}
	
	@Test(priority=16)
	public void verifyValidLogin() {
		String validUser=config.getLoginUserName(); //Data source -> config.properties
		String validPassword=config.getLoginPassword(); //Data source -> config.properties
		hp = lp.doLogin(validUser, validPassword);
	}
	
	@Test(priority=17)
	public void verifyGeneralInfo() {
		hp.getAdminMenu().click();
		act.moveToElement(org.getOrgMenu()).build().perform();
		org.getGeneralInfoSubMenu().click();
		String GeneralInfoHeading= genInfo.getGenInfoHeading().getText();
		Assert.assertEquals(GeneralInfoHeading, "General Information");
		genInfo.verifyReadOnlyFields();
		genInfo.modifyGeneraInfoFields();
		driver.getPageSource().contains("Successfully Saved");
	}
}
