package com.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generics.TestBase;
import com.pageObjects.LoginPage;

public class LoginPageTest extends TestBase{

	@Test
	public void loginTest() {
		LoginPage lp=new LoginPage(driver);		
		Assert.assertTrue(lp.login());
	
	}
	
	
}
