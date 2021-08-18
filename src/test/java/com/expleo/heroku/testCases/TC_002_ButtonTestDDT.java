package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.expleo.heroku.Utils.XLUtils;
import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_002_ButtonTestDDT extends BaseClass {

	@Test(dataProvider="Buttondata")
	public void buttonDDT(String buttonNum) throws IOException, InterruptedException {
		ChallengingDomPage cdp = new ChallengingDomPage(driver);

		String beforeBtnID = cdp.getButtonId(buttonNum);
		logger.info("Button Click Step Done");

		cdp.clickButton(buttonNum);
		Thread.sleep(3000);
		
		String afterBtnId = cdp.getButtonId(buttonNum);
		System.out.println(beforeBtnID+"   "+afterBtnId);
		if(!beforeBtnID.equals(afterBtnId)) {
			assertTrue(true);
			logger.info("Button Click Test Passed");

		}else {
			captureScreen(driver,"TC_002_ButtonTestDDT");
			assertTrue(false);
			logger.info("Button Click Test Failed");

		}


	}
	
	@DataProvider(name="Buttondata")
	String[][] getData() throws IOException{
	String path = System.getProperty("user.dir")+"/src/test/java/com/expleo/heroku/testData/TestData.xlsx";
	
	int rowNum = XLUtils.getRowCount(path, "Button");
	int colCount = XLUtils.getCellCount(path, "Button", 1);
	
	String[][] buttonData = new String[rowNum][colCount];
	
	for(int i=1;i<=rowNum;i++) {
		for(int j=0;j<colCount;j++) {
			buttonData[i-1][j] = XLUtils.getCellData(path, "Button", i, j);
		}
	}
	return buttonData;
	}
	

}
