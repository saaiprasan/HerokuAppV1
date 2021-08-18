package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_009_ElementalLinkTest extends BaseClass{

	/*
	 * Requirement: Verify the Footer Link and new Tab URL opened
	 * 
	 * Test Conditions: Clicking the footer link will open a new tab
	 * check the URL on new tab and if the link is clickable
	 *
	 * Author: Saai Kuppannagari
	 */
	
	@Test
	public void elementLinkTest() throws InterruptedException, IOException {
		
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		String newURL = "http://elementalselenium.com/";
		
		if(cdp.clickLink().equals(newURL)) {
			assertTrue(true);
			logger.info("TC_009_ElementalLinkTest - Element Link Click Test - Passed");
		}else {
			captureScreen(driver,"TC_008_DeleteClickTest");

			assertTrue(false);
			logger.info("TC_009_ElementalLinkTest - Element Link Click Test - Failed");
		}
		
	}
}
