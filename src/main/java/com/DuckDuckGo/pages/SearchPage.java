package com.DuckDuckGo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SearchPage(WebDriver driver) {
	
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_form_input_homepage")
	private WebElement searchElement;
	
	@FindBy(id="search_button_homepage")
	private WebElement clickSearch;
	
	@FindBy(linkText="Videos")
	private WebElement clickVideos;
	
	@FindBy(className="tile--c--w")
	private List<WebElement> getVideosSize;
	
	
	public void goToSearchPage(String keyword) {
		
		this.driver.get("https://duckduckgo.com/");
		this.wait.until(ExpectedConditions.visibilityOf(searchElement));
		this.searchElement.sendKeys(keyword);
		this.clickSearch.click();
	}
	
	public void clickVideosLink() {
		
		this.wait.until(ExpectedConditions.visibilityOf(clickVideos));
		this.clickVideos.click();
	}
	
	public int getVideoCount() {
		
		By by = By.className("tile--c--w");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		int size = this.getVideosSize.size();
		return size;
	}
	
	
	
	
}
