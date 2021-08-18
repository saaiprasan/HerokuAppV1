package com.expleo.heroku.testCases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;


public class TC_001_TitleTest extends BaseClass{

	/*
	 * Requirement: The title of the Web page must be The Internet 
	 * 
	 * 
	 * Test: Get the value from the web page and assert True 
	 * 
	 */
	
	@Test
	public void titleTest() throws IOException {			

		logger.info("URL Opened: "+baseURL);

		if(	driver.getTitle().equals("The Internet")) {
			assertTrue(true);
			logger.info("Title Check Test Passed");

		}else {
			captureScreen(driver,"Title Test");
			assertTrue(false);
			logger.info("Title Test Failed");

		}
		
		
	}
}
