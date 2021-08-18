package com.expleo.heroku.testCases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;



public class TC_001_TitleTest extends BaseClass{

	/*
	 * 
	 * Requirement: The title of the Web page must be "The Internet" 
	 * 
	 * Test Conditions: Get the value from the web page and assert if the value Equals 
	 *
	 * Author: Saai Kuppannagari
	 */
	
	@Test
	public void titleTest() throws IOException {			

		logger.info("URL Opened: "+baseURL);

		if(	driver.getTitle().equals("The Internet")) {
			assertTrue(true);
			logger.info("TC_001_TitleTest - Title Check Test - Passed");

		}else {
			captureScreen(driver,"TC_001_TitleTest");
			assertTrue(false);
			logger.info("TC_001_TitleTest - Title Check Test - Failed");

		}
		
		
	}
}
