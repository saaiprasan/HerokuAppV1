package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.expleo.heroku.Utils.XLUtils;
import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_006_CanvasTest extends BaseClass{

	@Test(dataProvider="Buttondata")
	public void canvaTest(String buttonNum) {
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		String beforeCanText = cdp.getCanvasText();

		cdp.clickButton(buttonNum);
		logger.info("Button Click Step Done");
		String afterCanText = cdp.getCanvasText();
		
		logger.info("Before Text: "+beforeCanText+" After Text:   "+afterCanText);
				
		if(!beforeCanText.equals(afterCanText)) {
			logger.info("Canvas Text Verification Passed: "+cdp.getCanvasText());
			assertTrue(true);
			
		}else {
			assertTrue(false);
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
