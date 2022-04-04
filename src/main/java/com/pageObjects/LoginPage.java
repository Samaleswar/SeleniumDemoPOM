package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.ReadConfig;
import com.generics.TestBase;

public class LoginPage extends TestBase{

	
	
	@FindBy(xpath="//input[@name=\"uid\"]")
	private WebElement id;
	
	
	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement password;
	
	
	@FindBy(xpath="//input[@name=\"btnLogin\"]")
	private WebElement loginBtn;
	
	

	@FindBy(xpath="//h2[contains(text(),'Guru99 Bank')]")
	private WebElement headline;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public boolean login() {
		SignUpPage sp=new SignUpPage(driver);
		sp.signup();
		
		ReadConfig rc=new ReadConfig();
		driver.get(rc.getLoginUrl());
		id.sendKeys(System.getProperty("userId"));
		password.sendKeys(System.getProperty("password"));
		loginBtn.click();
		boolean loginverify=headline.isDisplayed();
		
		return loginverify;
	}
	
	
}
