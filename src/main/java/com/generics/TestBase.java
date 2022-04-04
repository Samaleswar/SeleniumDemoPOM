package com.generics;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	
	
	@BeforeClass
	public void setUp() {
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	
	public String generateRandomEmail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000000);
		String s = "Demotest" + randomInt + "@yopmail.com";
		return s;
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
