package com.orghrm.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orghrm.pages.HomePage;
import com.orghrm.pages.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage lp;
	HomePage hp;
	
	public LoginTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		lp=new LoginPage(driver);
	}
	
	@Test(priority=0)
	public void verifyLoginPageTitle() {
		String expectedPageTitle="OrangeHRM"; 
		String actualPageTitle =  lp.getLoginPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
	
	@Test(priority=1)
	public void verifyLoginPageHeader() {
		String expectedLoginPageHeader="LOGIN Panel";
		String actualPageHeader=  lp.getLoginPageHeader();
		Assert.assertEquals(actualPageHeader, expectedLoginPageHeader);
	}
	
	@Test(priority=2)
	public void verifyLoginPageFooter() {
		String expectedLoginPageFooter="OrangeHRM, Inc";
		String actualPageFooter =  lp.getLoginPageFooter();
		Assert.assertEquals(actualPageFooter, expectedLoginPageFooter);
	}
	
	@Test(priority=3)
	public void verifyInvalidLogin() {
//		String invalidUser=excellib.getCellData(dataFile, "UserCred", 2, 0);
//		String invalidPassword=excellib.getCellData(dataFile, "UserCred", 2, 1);
		String invalidUser="admin123";
		String invalidPassword="test123";
		
		lp.doLogin(invalidUser, invalidPassword);
		boolean result = driver.getPageSource().contains("Invalid credentials");
		Assert.assertEquals(result, true, "Invalid credentials error message is not displayed");
	}
	
	@Test(priority=4)
	public void verifyValidLogin() {
		hp = lp.doLogin("Admin", "admin123");
		boolean logoPresence= hp.getCompanyLogo();
		Assert.assertEquals(logoPresence, true, "Failed redirecting to HomePage");
		
	}
	
}