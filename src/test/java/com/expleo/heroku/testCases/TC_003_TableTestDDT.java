package com.expleo.heroku.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.expleo.heroku.Utils.XLUtils;
import com.expleo.heroku.pageObjects.ChallengingDomPage;

public class TC_003_TableTestDDT extends BaseClass{

	@Test(dataProvider="TableData")
	public void TableDDT(String lorem, String ipsum, String dolor, String sit, String amet, String dic,String row,String column) {
		
		String[] tableVal = {lorem,ipsum,dolor,sit,amet,dic};
		
		ChallengingDomPage cdp = new ChallengingDomPage(driver);
		
		
		for(int i=1;i<=6;i++) {
			
			System.out.println(cdp.getTableText(row,i));
			System.out.println(tableVal[i-1]);

			if( cdp.getTableText(row,i).equals(tableVal[i-1])) {
				assertTrue(true);
				
				logger.info("Test Passed validated: "+tableVal[i-1]);
			}else {
				assertTrue(false);
				logger.info("Failed");
			}
			
		}
	}
	
	
	@DataProvider(name="TableData")
	String[][] getData() throws IOException{
	String path = System.getProperty("user.dir")+"/src/test/java/com/expleo/heroku/testData/TestData.xlsx";
	
	int rowNum = XLUtils.getRowCount(path, "StaticTable");
	int colCount = XLUtils.getCellCount(path, "StaticTable", 1);
	
	String[][] tableData = new String[rowNum][colCount];
	
	for(int i=1;i<=rowNum;i++) {
		for(int j=0;j<colCount;j++) {
			tableData[i-1][j] = XLUtils.getCellData(path, "StaticTable", i, j);
		}
	}
	return tableData;
	}

	
}
