package com.forescout.challenge;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.forescout.challenge.pageobjects.CustomerView;
import com.forescout.challenge.pageobjects.SignInPage;
import com.forescout.challenge.pageobjects.WelcomePage;

public class AddItemInTable extends BaseSetup {

	WelcomePage welcomePageObj = new WelcomePage();
	SignInPage signInPageObj = new SignInPage();
	CustomerView customerViewObj = new CustomerView();

	
	@BeforeMethod
	public void setUp() {
		ConfigProperties.loadProperties();
		System.out.println("property file is loaded successfully");
		driver = Browser.setBrowser(ConfigProperties.getProperty("browser"));
		driver.get(ConfigProperties.getProperty("testurl"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void addNewItem() throws InterruptedException{
		signInPageObj.accountSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
		welcomePageObj.navigateToCustomerView();
		customerViewObj.addItem();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}