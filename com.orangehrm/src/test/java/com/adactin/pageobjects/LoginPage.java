package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	private static LoginPage LoginPageInstance;
	
	private LoginPage() {
		
	}
	
	public static LoginPage getInstance() {
		
		if(LoginPageInstance == null) {
			LoginPageInstance = new LoginPage();
		}
		
		return LoginPageInstance;
		
	}
	
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement LoginButton;
	
	
	public void userName(String Username) {
		userName.sendKeys(Username);
	}
	
	public void password(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLogin() {
		LoginButton.click();
	}
	
	
	
	
	
}
