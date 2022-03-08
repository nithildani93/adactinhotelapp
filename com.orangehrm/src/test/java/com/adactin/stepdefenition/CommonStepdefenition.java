package com.adactin.stepdefenition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.adactin.constants.Constants;
import com.adactin.utilities.Utilities;
import com.adactin.webdrivermanager.DriverManager;

import io.cucumber.java.Before;

public class CommonStepdefenition {


	private static final Logger LOGGER = LogManager.getLogger(CommonStepdefenition.class);

	@Before
	public void BeforeScenario() {	

		try {
			LOGGER.info("Loading properties");
			Utilities utilities = new Utilities();
			utilities.loadproperties();

			if(DriverManager.getDriver()==null) {

				LOGGER.info("opening "+Constants.BrowserName+" Browser");

				DriverManager.LaunchBrowser();
				utilities.initWebElemts();

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}




}
