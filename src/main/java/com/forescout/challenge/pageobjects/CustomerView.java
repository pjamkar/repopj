package com.forescout.challenge.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.forescout.challenge.BaseSetup;
import com.forescout.challenge.ConfigProperties;

public class CustomerView extends BaseSetup{
	
	By table = By.xpath("//table");
	By tableRows = By.xpath("//table[@id='id1b']/tbody/tr");
	By addItemLink = By.xpath("//a[contains(text(),'Add item')]");
	By nameField = By.xpath("//form[@class='form-horizontal']//fieldset//input[@name='fieldsPanel:name']");
	By addressField = By.xpath("//input[@class='form-control'][@name='fieldsPanel:addressline1']");
	By cityField  = By.xpath("//input[@class='form-control'][@name='fieldsPanel:city']");
	By stateField = By.xpath("//input[@class='form-control'][@name='fieldsPanel:state']");
	By phoneField = By.xpath("//input[@class='form-control'][@name='fieldsPanel:phone']");
	By emailField = By.xpath("//input[@class='form-control'][@name='fieldsPanel:email']");
	By creditLimitField = By.xpath("//input[@class='form-control'][@name='fieldsPanel:creditLimit']");
	By zip = By.xpath("//select[@class='form-control'][@name='fieldsPanel:zip']");
	By discountCode = By.xpath("//select[@class='form-control'][@name='fieldsPanel:discountCode']");
	By submitButton = By.xpath("//div[@class='modal-dialog']//button[contains(text(),'Submit')]");
	By tableHeaderPagination = By.xpath("//table//thead/tr[1]/td/div"); 
	By secondPageNumber = By.xpath("//table//thead/tr[1]/td//span[contains(text(),'2')]");
	
	//form[@class='form-horizontal']//fieldset/div[@class='form-group']//input
	public int getTableRowCount(){
		BaseSetup.waitForElement(driver, tableRows, 10);
		WebElement tbody = driver.findElement(table);
		List<WebElement> row = tbody.findElements(By.xpath("//tbody/tr"));
		int numberOfRecords = row.size();
		System.out.println(numberOfRecords);
		return numberOfRecords;
	}
	
	public void addItem() throws InterruptedException {
		System.out.println("Add an item in the table");
		//BaseSetup.waitForElement(driver,addItemLink, 20);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(driver.findElement(addItemLink)).click().perform();
		driver.findElement(addItemLink).click();
		Thread.sleep(200);
		BaseSetup.waitForElement(driver, nameField, 10);
		driver.findElement(nameField).sendKeys(ConfigProperties.getProperty("name"));
		driver.findElement(addressField).sendKeys(ConfigProperties.getProperty("address"));
		driver.findElement(cityField).sendKeys(ConfigProperties.getProperty("city"));
		driver.findElement(stateField).sendKeys(ConfigProperties.getProperty("state"));
		driver.findElement(phoneField).sendKeys(ConfigProperties.getProperty("phone"));
		driver.findElement(emailField).sendKeys(ConfigProperties.getProperty("email"));
		driver.findElement(creditLimitField).sendKeys(ConfigProperties.getProperty("creditLimit"));
		
		Select selectZipCode = new Select(driver.findElement(zip));
		selectZipCode.selectByIndex(2);
		
		Select selectDiscountCode = new Select(driver.findElement(discountCode));
		selectDiscountCode.selectByVisibleText("H");
		driver.findElement(submitButton).click();
		Thread.sleep(200);
	}
	
	public boolean checkTableHeader(){
		boolean tableHeader = BaseSetup.waitForElement(driver,tableHeaderPagination, 20);
		System.out.println(tableHeader);
		return tableHeader;
	}
	
	public void selectPageNumber(){
		driver.findElement(secondPageNumber).click();
	}
}
