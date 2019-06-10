package com.forescout.challenge;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.forescout.challenge.pageobjects.CustomerView;
import com.forescout.challenge.pageobjects.SignInPage;
import com.forescout.challenge.pageobjects.WelcomePage;

public class PageJump extends BaseSetup {

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
	public void jumpToPage() throws InterruptedException{
		signInPageObj.accountSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
		welcomePageObj.navigateToCustomerView();
		/*int numberOfItems = customerViewObj.getTableRowCount();
		System.out.println(numberOfItems);
		
		while (numberOfItems <= 11) {
			customerViewObj.addItem();
			numberOfItems++;
		}*/
		if (customerViewObj.checkTableHeader()) {
			customerViewObj.selectPageNumber();
			Thread.sleep(200);
		}
		while (!(customerViewObj.checkTableHeader())){
			customerViewObj.addItem();
			customerViewObj.selectPageNumber();
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}