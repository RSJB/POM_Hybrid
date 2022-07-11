package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	//1. String Locators - OR
	private String emailId = "#input-email";
	private String pwdField="#input-password";
	private String loginBtn="//input[@class='btn btn-primary']";
	private String forgotPwtLink="//div[@class='form-group']//a[1]";
	private String logoutLink="(//a[contains(text(),'Logout')])[2]";
	

	
	// 2. page constructor:
		public LoginPage(Page page) 
		{
			this.page = page;
		}
		
		// 3. page actions/methods:
		public String getLoginPageTitle() 
		{
		String title = page.title();
		System.out.println("page title is:"+title);
		return title;
		}	
		
		public boolean isForgotPwtLinlkIsExist() {
			return page.isVisible(forgotPwtLink);
		}
		
		public boolean doLogin(String useranme, String password ) //Declare value was not pass its show "'Null Point Execption'"
		{
			System.out.println("App cred :"+useranme + ":" +password);
			
			page.fill(emailId, useranme);
			page.fill(pwdField, password);
			page.click(loginBtn);
			page.waitForLoadState();//without wait command the dom was not fully load so theplaywirgt  can't read so the test was failed in the "TestLoginPage"
			if (page.isVisible(logoutLink)) 
			{
				System.out.println("user is logged in Successfully....");
				return true;
			}
			System.out.println("user is not Login");
			return false;
		
		}
		
}
























