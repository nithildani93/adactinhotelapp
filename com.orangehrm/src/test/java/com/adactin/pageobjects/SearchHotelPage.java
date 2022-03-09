package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactin.utilities.Utilities;

public class SearchHotelPage {

	private static SearchHotelPage SearchHotelPageInstance;

	private SearchHotelPage() {}

	public static SearchHotelPage getInstance() {

		if(SearchHotelPageInstance == null) {
			SearchHotelPageInstance = new SearchHotelPage();
		}

		return SearchHotelPageInstance;

	}

	@FindBy(name="username_show")
	private WebElement userNameShow;

	public String getUserName() {
		try {
			Utilities.getInstance().highlightElement(userNameShow);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userNameShow.getAttribute("value");
	}




}
