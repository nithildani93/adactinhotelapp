package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id="username")
	public static WebElement userName;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="login")
	public static WebElement LoginButton;
	
}
