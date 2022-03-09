package com.adactin.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.adactin.constants.Constants;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.webdrivermanager.DriverManager;

public class Utilities {
	
	private static Utilities getInstance;
	
	private Utilities() {
		
	}
	
	public static Utilities getInstance() {
		
		if(getInstance==null) {
			getInstance = new Utilities();
		}
		
		return getInstance;
	}
	

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
		PageFactory.initElements(DriverManager.getDriver(), SearchHotelPage.getInstance());
	}


	public void takeScreenshot() {
		try {
			File Screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot, new File("Screenshot.png"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 2px solid red');", element);
	}


}
