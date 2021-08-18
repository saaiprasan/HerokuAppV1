package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_008_DeleteClickTest extends BaseClass {

	@Test
	public void deleteTest() {
		String deleteUrl = "https://the-internet.herokuapp.com/challenging_dom#delete";
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		for(int i=1;i<=10;i++) {
				cdp.getEditVal(i, 2);
				if(deleteUrl.equals(driver.getCurrentUrl())) {
					assertTrue(true);
				}else {
					assertTrue(false);
				}
			}
		}
	}
	
