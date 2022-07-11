package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstants;

public class LoginPageTest extends BaseTest {

	
	@Test(priority=1)
	public void LoginPageNavigtionTest() {
		loginPage = homePage.navigateToLogInPage();//page Chaining model archived
		
		String ActalLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Page Actual title:"+ActalLoginPageTitle);
		Assert.assertEquals(ActalLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);	
	}
	@Test(priority=2)
	public void ForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwtLinlkIsExist());
	}
	@Test(priority=3)
	public void appLoginTest()//without wait contion the page was not fully load so the contion can't find by playwright so its fail the Assert.
	{
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("useranme").trim(),
											prop.getProperty("password").trim()));
	
	}	
}
