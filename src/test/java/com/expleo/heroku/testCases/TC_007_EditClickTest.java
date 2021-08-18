package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_007_EditClickTest extends BaseClass {

	@Test
	public void editTest() {
		String editUrl = "https://the-internet.herokuapp.com/challenging_dom#edit";
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		for(int i=1;i<=10;i++) {
				cdp.getEditVal(i, 1);
				if(editUrl.equals(driver.getCurrentUrl())) {
					assertTrue(true);
				}else {
					assertTrue(false);
				}
			}
		}
	}
	
