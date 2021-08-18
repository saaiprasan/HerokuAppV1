package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_008_DeleteClickTest extends BaseClass {

	/*
	 * Requirement: Verify the static Delete Link
	 * 
	 * Test Conditions: Get the URL value to verify Delete link
	 *
	 * Author: Saai Kuppannagari
	 */
	
	@Test
	public void deleteTest() throws IOException {
		String deleteUrl = "https://the-internet.herokuapp.com/challenging_dom#delete";
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		for(int i=1;i<=10;i++) {
				cdp.getEditVal(i, 2);
				if(deleteUrl.equals(driver.getCurrentUrl())) {
					assertTrue(true);
					logger.info("TC_007_EditClickTest - Delete Click Test - Passed");

				}else {
					captureScreen(driver,"TC_008_DeleteClickTest");

					assertTrue(false);
					logger.info("TC_007_EditClickTest - Delete Click Test - Failed");

				}
			}
		}
	}
	
