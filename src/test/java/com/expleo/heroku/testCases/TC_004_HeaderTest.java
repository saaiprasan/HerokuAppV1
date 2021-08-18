package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

/*
 * Requirement: Verify the static Header Value
 * 
 * Test Conditions: Get the value from header and validate from test data
 *
 *
 * Author: Saai Kuppannagari
 */

public class TC_004_HeaderTest extends BaseClass {
	
	@Test
	public void headTest() throws IOException {
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		if(cdp.getHeading().equals("Challenging DOM")) {
			logger.info("TC_004_HeaderTest - Header text Test - Passed");
			assertTrue(true);
		}else {
			captureScreen(driver,"TC_004_HeaderTest");
			assertTrue(false);
			logger.info("TC_004_HeaderTest - Header text Test - Failed");
		}
	}

}
