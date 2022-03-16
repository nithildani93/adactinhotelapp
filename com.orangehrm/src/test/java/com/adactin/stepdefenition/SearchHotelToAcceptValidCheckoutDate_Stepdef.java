package com.adactin.stepdefenition;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;
import com.adactin.webdrivermanager.DriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelToAcceptValidCheckoutDate_Stepdef {

	
	private static final Logger LOGGER = LogManager.getLogger(SearchHotelToAcceptValidCheckoutDate_Stepdef.class);

//	@Given("the user login to the adactin application")
//	public void the_user_login_to_the_adactin_application() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
	@When("the user selects the location as {string} by {string}")
	public void the_user_selects_the_location_as_by(String value, String method) {
		SearchHotelPage.getInstance().LocationDropdown(value, method);
		LOGGER.info("User Selects the location");

	}

	@When("the user selects the hotels as {string} by {string}")
	public void the_user_selects_the_hotels_as_by(String value, String method) {
		SearchHotelPage.getInstance().HotelsDropdown(value, method);
		LOGGER.info("User Selects the hotel");
	}

	@When("the user selects the {string} option in Room Type by {string}")
	public void the_user_selects_the_option_in_room_type_by(String value, String method) {
		SearchHotelPage.getInstance().roomtypeDropdown(value, method);
		LOGGER.info("User Selects the room type");
	}

	@When("the user selects option {string} as Rooms by {string}")
	public void the_user_selects_option_as_rooms_by(String value, String method) {
		SearchHotelPage.getInstance().room_nosDropdown(value, method);
		LOGGER.info("User Selects the no of rooms");
	}


	@When("the user enters the checkin date as\"{int}\\/{int}\\/{int}\"")
	public void the_user_enters_the_checkin_date_as(Integer int1, Integer int2, Integer int3) {
		String givendate = Integer.toString(int1) +"/"+ Integer.toString(int2) +"/"+ Integer.toString(int3);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  LocalDate checkindate = LocalDate.parse(givendate, format);
		  System.out.println("entered date is: "+checkindate);
		  
		  SearchHotelPage.getInstance().datepickin(givendate);
		  LOGGER.info("User enters checkin date as "+ givendate);
	}
	
	@When("the user enters the checkout date as\"{int}\\/{int}\\/{int}\"")
	public void the_user_enters_the_checkout_date_as(Integer int1, Integer int2, Integer int3) {
		String givendate = Integer.toString(int1) +"/"+ Integer.toString(int2) +"/"+ Integer.toString(int3);
	    SearchHotelPage.getInstance().datepickout(givendate);
	    LOGGER.info("User enters checkout date as "+ givendate);
	}

	@When("the user enters the search button")
	public void the_user_enters_the_search_button() {
		SearchHotelPage.getInstance().clickSearchButton();
		LOGGER.info("User clicks on search button");
	}

	@Then("the user should able to see the list of hotels")
	public void the_user_should_able_to_see_the_list_of_hotels() {
		System.out.println(DriverManager.getDriver().getCurrentUrl());
		if(DriverManager.getDriver().getCurrentUrl().contains("SelectHotel")) {
			LOGGER.info("User is able to see the search hotel page which should not be possible");
			Assert.assertFalse("User is able to see the search hotel page which should not be possible", true);
		}
	}
	
	
	
}
