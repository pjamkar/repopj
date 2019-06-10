package com.forescout.challenge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.forescout.challenge.BaseSetup;

/* This class is for Index page object to get webelements to login*/
public class SignInPage extends BaseSetup {

	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By signin = By.xpath("//input[@name='submit']");

	public WebElement getUsername() {
		BaseSetup.waitForElement(driver, username, 10);
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		BaseSetup.waitForElement(driver, password, 10);
		return driver.findElement(password);
	}

	public WebElement getSignIn() {
		BaseSetup.waitForElement(driver, signin, 10);
		return driver.findElement(signin);
	}
	
	public void accountSignIn(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSignIn().click();
	}
}