package com.expleo.heroku.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.expleo.heroku.Utils.ReadConfig;


public class BaseClass {
	
	/*
	 * BaseClass will be extended by all the Test cases in the Framework
	 * Init and Teardown will be run as part of every Test using beforeclass and after class
	 * CaptureScreenshot = Will be used to capture screenshots for any failed Test cases and display in the reports
	 */
	
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getAppUrl();	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void init(String browser)
	{
		logger = Logger.getLogger("HerokuApp");
		PropertyConfigurator.configure("log4j.properties");

		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
			logger.info("Loaded Chrome Broswer Driver");
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("Loaded Firefox Broswer Driver");
		} else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
			logger.info("Loaded Edge Broswer Driver");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String test) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + test + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot Captured");
	}

	
}
