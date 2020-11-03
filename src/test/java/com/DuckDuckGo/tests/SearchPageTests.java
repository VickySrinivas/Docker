package com.DuckDuckGo.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DuckDuckGo.pages.SearchPage;

import tests.BaseTest;

public class SearchPageTests extends BaseTest{
	
	
	@Test
	@Parameters({"searchValue"})
	public void searchPage(String searchValue) {
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goToSearchPage(searchValue);
		searchPage.clickVideosLink();
		int videoCount = searchPage.getVideoCount();
		Assert.assertTrue(videoCount > 0);
		
	}
	
}
