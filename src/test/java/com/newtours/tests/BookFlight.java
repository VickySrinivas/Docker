package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

import tests.BaseTest;

public class BookFlight extends BaseTest{
	
	
	private String noOfPassengers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers", "expectedPrice"})
	public void setParameters(String noOfPassengers, String expectedPrice) {
		
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;
		
	}
	
	@Test
	public void registrationPage() {
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goToUserInfoPage();
		registrationPage.enterContactInformation("Selenium", "Docker");
		registrationPage.enterUserDetails("Selenium", "Docker", "Docker");
		registrationPage.clickSubmitBtn();
	}
	
	@Test(dependsOnMethods="registrationPage")
	public void registrationConfirmationPage() {
		
		RegistrationConfirmationPage registrationPage = new RegistrationConfirmationPage(driver);
		registrationPage.goToFlightDetailsPage();
	}
	
	@Test(dependsOnMethods="registrationConfirmationPage")
	public void flightDetailsPage() {
		
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengersCount(noOfPassengers);
		flightDetailsPage.goToFindFlightsPage();
	}
	
	@Test(dependsOnMethods="flightDetailsPage")
	public void findFlightsPage() {
		
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.submitFlightDetais();
		findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods="findFlightsPage")
	public void flightConfirmationPage() {
		
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		String actualPrice = flightConfirmationPage.flightPrice();
		AssertJUnit.assertEquals(actualPrice, expectedPrice);
	}
	
	
	
	
}
