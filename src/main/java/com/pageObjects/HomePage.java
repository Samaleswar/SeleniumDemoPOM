package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generics.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	private WebElement newCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement name;
	
	@FindBy(xpath="(//input[@name='rad1'])[1]")
	private WebElement male;
	
	@FindBy(xpath="(//input[@name='rad1'])[2]")
	private WebElement female;
	
	@FindBy(xpath="//input[@id='dob']")
	private WebElement dobCalender;
	
	@FindBy(xpath="//textarea[@name='addr']")
	private WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	private WebElement pincode;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@name='emailid']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//p[contains(text(),'Customer Registered Successfully!!!')]")
	private WebElement successMsg;
	
	@FindBy(xpath="//td[contains(text(),'Customer ID')]/following::td")
	private WebElement customerId;
	
	
	@FindBy(xpath="//input[@name=\"cusid\"]")
	private WebElement editCustomerId;
	
	@FindBy(xpath="//input[@name=\"AccSubmit\"]")
	private WebElement submitBtnEditCusPage;
	
	@FindBy(xpath="//a[@href=\"EditCustomer.php\"]")
	private WebElement editCustomerBtn;
	
	
	@FindBy(xpath="//p[contains(text(),'Edit Customer')]")
	private WebElement editCustomerTxt;
	
	
	@FindBy(xpath="//a[@href=\"DeleteCustomerInput.php\"]")
	private WebElement deleteCustomer;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean addCustomer() {
		
		newCustomer.click();
		name.sendKeys("Samaleswar Mishra");
		female.click();
		male.click();
		dobCalender.sendKeys("09191998");
		address.sendKeys("Nandapara");
		city.sendKeys("sambalpur");
		state.sendKeys("odisha");
		pincode.sendKeys("768001");
		phone.sendKeys("768984125");
		email.sendKeys(System.getProperty("EMAIL"));
		password.sendKeys("pritam");
		submitBtn.click();
		
		boolean addcm=successMsg.isDisplayed();
		String cid=customerId.getText();
		System.setProperty("customerId", cid);
		return addcm;
	}
	
	public boolean editCustomerTest() {
		editCustomerBtn.click();
		editCustomerId.sendKeys(System.getProperty("customerId"));
		submitBtnEditCusPage.click();
		boolean editCusTxt=editCustomerTxt.isDisplayed();
		return editCusTxt;
	}
	
	public boolean deleteCustomerTest() {
		deleteCustomer.click();
		editCustomerId.sendKeys(System.getProperty("customerId"));
		submitBtnEditCusPage.click();
		driver.switchTo().alert().accept();
		boolean editCusTxt;
		String txt=	driver.switchTo().alert().getText();
		editCusTxt=txt.equalsIgnoreCase("Customer does not Exist!!!");
		
		driver.switchTo().alert().accept();
		return editCusTxt;
	}
	
	
	
}
