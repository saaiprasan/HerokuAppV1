package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_004_HeaderTest extends BaseClass {
	
	@Test
	public void headTest() throws IOException {
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		if(cdp.getHeading().equals("Challenging DOM")) {
			logger.info("Header Test Passed with Text Value: Challenging DOM");
			assertTrue(true);
		}else {
			captureScreen(driver,"Header Test");
			assertTrue(false);
		}
	}

}
