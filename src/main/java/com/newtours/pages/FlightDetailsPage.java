package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FlightDetailsPage(WebDriver driver) {
	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="passCount")
	private WebElement passengersCount;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	public void selectPassengersCount(String noOfPassengers) {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(passengersCount));
		new Select(passengersCount).selectByValue(noOfPassengers);
	}
	
	public void goToFindFlightsPage() {
		
		this.continueBtn.click();
	}
	
	
	
}
