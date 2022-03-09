package com.adactin.utilities;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.adactin.constants.Constants;
import com.adactin.pageobjects.LoginPage;
import com.adactin.webdrivermanager.DriverManager;

public class Utilities {
	
	public void loadproperties() {
			
		Properties properties = new Properties();
		
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}
		catch (IOException e) { 
			e.printStackTrace();
		}
			
		
		
		Constants.BrowserName = properties.getProperty("BrowserName");
		Constants.AppUrl = properties.getProperty("Url");
		Constants.UserName = properties.getProperty("UserName");
		Constants.Password = properties.getProperty("Password");
		
		
	}
	
	public void initWebElemts() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
	}
	

}
