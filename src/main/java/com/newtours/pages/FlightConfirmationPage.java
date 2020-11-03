package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public FlightConfirmationPage(WebDriver driver) {
	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//font[contains(text(),'Flight Confirmation')]")
	private WebElement flightConfirmationText;
	
	@FindBy(xpath="//table[@id='confirm-table']//tr[3]//font")
	private WebElement flightPrice;
	
	@FindBy(linkText="SIGN-OFF")
	private WebElement signoff;
	
	public String flightPrice() {
		
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationText));
		System.out.println(this.flightConfirmationText.getText());
		System.out.println(this.flightPrice.getText());
		String actualPrice = this.flightPrice.getText();
		this.signoff.click();
		return actualPrice;
		
	}
	
	
	
	
	
}
