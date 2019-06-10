package com.forescout.challenge;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.forescout.challenge.pageobjects.SignInPage;

// This class is to test creating a custom session
public class Login extends BaseSetup {
	
	//Declaring objectes for page object classes to access methods for actions performed on these pages
	SignInPage signInPageObj = new SignInPage();
	
	/*Invoking browser and opening the test url by taking the values from properties file
	Browser and environment can also be passed as parameters in mvn command and handle here*/
	
	@BeforeMethod
	public void setUp() {
		ConfigProperties.loadProperties();
		System.out.println("property file is loaded successfully");
		driver = Browser.setBrowser(ConfigProperties.getProperty("browser"));
		driver.get(ConfigProperties.getProperty("testurl"));
		driver.manage().window().maximize();
	}

	@Test
	public void accountSignIn() {
		signInPageObj.accountSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}