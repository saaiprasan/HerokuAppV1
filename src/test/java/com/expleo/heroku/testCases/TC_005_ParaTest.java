package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_005_ParaTest extends BaseClass{

	/*
	 * Requirement: Verify the static Paragraph Value
	 * 
	 * Test Conditions: Get the value from paragraph and validate from test data
	 *
	 * Author: Saai Kuppannagari
	 */
	
	@Test
	public void paraCheck() throws IOException {
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		String paraText = "The hardest part in automated web testing is finding the best locators (e.g.,"
				+ " ones that well named, unique, and unlikely to change). It's more often than not that the application "
				+ "you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, "
				+ "a table with no helpful locators, and a canvas element.";
	
		if(cdp.getPara().equals(paraText)) {
			assertTrue(true);
			logger.info("TC_005_ParaTest - Paragraph Check Test - Passed");
		}else {
			captureScreen(driver,"TC_005_ParaTest");
			assertTrue(false);
			logger.info("TC_005_ParaTest - Paragraph Check Test - Failed");
		}
	}
}
