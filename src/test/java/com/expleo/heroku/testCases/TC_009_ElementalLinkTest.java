package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_009_ElementalLinkTest extends BaseClass{

	@Test
	public void elementLinkTest() throws InterruptedException {
		
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		String newURL = "http://elementalselenium.com/";
		
		if(cdp.clickLink().equals(newURL)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		
	}
}
