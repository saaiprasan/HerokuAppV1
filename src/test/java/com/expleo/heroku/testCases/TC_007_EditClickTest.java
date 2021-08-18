package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_007_EditClickTest extends BaseClass {

	/*
	 * Requirement: Verify the static Edit Link
	 * 
	 * Test Conditions: Get the URL value to verify edit link
	 *
	 * Author: Saai Kuppannagari
	 */
	
	@Test
	public void editTest() throws IOException {
		String editUrl = "https://the-internet.herokuapp.com/challenging_dom#edit";
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		for(int i=1;i<=10;i++) {
				cdp.getEditVal(i, 1);
				if(editUrl.equals(driver.getCurrentUrl())) {
					assertTrue(true);
					logger.info("TC_007_EditClickTest - Edit Click Test - Passed");

				}else {
					captureScreen(driver,"TC_007_EditClickTest");

					assertTrue(false);
					logger.info("TC_007_EditClickTest - Edit Click Test - Failed");

				}
			}
		}
	}
	
