package com.orghrm.testCases.Admin.Nationalities;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;
import com.orghrm.pages.Admin.Nationalities.NationalitiesPage;
import com.orghrm.testCases.BaseTest;

public class NationalitiesTest extends BaseTest {

	LoginPage lp;
	HomePage hp;
	NationalitiesPage nation;
	Actions act;
	
	public NationalitiesTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		nation=new NationalitiesPage(driver);
		act = new Actions(driver);
	}
	
	@Test(priority=21)
	public void verifyValidLogin() {
		String validUser=config.getLoginUserName(); //Data source -> config.properties
		String validPassword=config.getLoginPassword(); //Data source -> config.properties
		hp = lp.doLogin(validUser, validPassword);
	}
	
	@Test(priority=22)
	public void countOfNationalitiesListItem() {
		hp.getAdminMenu().click();
		act.moveToElement(nation.getNationalitiesMenu()).build().perform();
		int nationLstCount = nation.getNationalitiesListCount();
		System.out.println(" No of Nationalities list Items are : "+nationLstCount);
		Assert.assertEquals(nationLstCount, 0);
	}
}
