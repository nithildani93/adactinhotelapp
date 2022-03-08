package com.adactin.stepdefenition;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.adactin.constants.Constants;
import com.adactin.pageobjects.LoginPage;
import com.adactin.webdrivermanager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyUserLogin_StepDef {
	
	WebDriver driver = DriverManager.getDriver();
	public static final Logger LOGGER = LogManager.getLogger(VerifyUserLogin_StepDef.class);
	
	
	@Given("the user opens the adactin site")
	public void the_user_opens_the_adactin_site() {
		driver.get(Constants.AppUrl);
	}

	@When("the user enters the username as {string}")
	public void the_user_enters_the_username_as(String string) {
		LoginPage.userName.sendKeys(Constants.UserName);
		LOGGER.info("the_user_enters_the_username");
	}

	@When("the user enters the password as {string}")
	public void the_user_enters_the_password_as(String string) {
		LoginPage.password.sendKeys(Constants.Password);
		LOGGER.info("the_user_enters_the_password");
	}

	@When("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		LoginPage.LoginButton.click();
		LOGGER.info("the_user_clicks_the_submit_button");
		
	}

	@Then("the user should be logged in and will able to see his username")
	public void the_user_should_be_logged_in_and_will_able_to_see_his_username() {
		LOGGER.info("the_user_should_be_logged_in");
	}


}
