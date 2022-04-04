package com.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generics.TestBase;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;

public class HomePageTest extends TestBase {

	@Test
	public void testHomePage() {

		LoginPage lp = new LoginPage(driver);
		lp.login();

		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.addCustomer());
		Assert.assertTrue(hp.editCustomerTest());
		hp.deleteCustomerTest();
	}

	
	
}
