package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public FindFlightPage(WebDriver driver) {
	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="reserveFlights")
	private WebElement firstSubmitBtn;
	
	@FindBy(name="buyFlights")
	private WebElement secondSubmitBtn;
	
	public void submitFlightDetais() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
		this.firstSubmitBtn.click();
	}
	
	public void goToFlightConfirmationPage() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
		this.secondSubmitBtn.click();
	}
}
