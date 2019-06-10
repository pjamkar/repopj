package com.forescout.challenge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.forescout.challenge.BaseSetup;

/* This class is for Index page object to get webelements to login*/
public class WelcomePage extends BaseSetup {

	By customers = By.xpath("//a[contains(text(),'Customers')]");

	public WebElement getCustomers() {
		BaseSetup.waitForElement(driver, customers, 10);
		return driver.findElement(customers);
	}

	public void navigateToCustomerView() throws InterruptedException {
		getCustomers().click();
		//Thread.sleep(500);
	}
}