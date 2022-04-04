package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ReadConfig;
import com.generics.TestBase;

public class SignUpPage extends TestBase {

	String emailaddress=generateRandomEmail();
	
	
	@FindBy(xpath = "//input[@name=\"emailid\"]")
	private WebElement email;

	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "//td[contains(text(),'User ID :')]/following::td")
	private WebElement username;

	@FindBy(xpath = "//td[contains(text(),'Password :')]/following::td")
	private WebElement pass;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signup() {
		ReadConfig rc=new ReadConfig();
		System.setProperty("EMAIL", emailaddress);
		driver.get(rc.getSignUpUrl());
		
	
		
		
		email.sendKeys(emailaddress);
		submitBtn.click();
		String usernameTxt = username.getText();
		String passTxt = pass.getText();
		System.setProperty("userId", usernameTxt);
		System.setProperty("password", passTxt);
		
		
		
		
		
	}
}
