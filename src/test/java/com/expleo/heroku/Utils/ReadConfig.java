package com.expleo.heroku.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	/*
	 * Utility File which will read the Config Properties file to read different
	 * constants
	 * 
	 * Author: Saai Kuppannagari
	 */
	
	Properties prop;
	public ReadConfig() {
		File file = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAppUrl() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;		
	}
	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;		
	}
	public String getEdgePath() {
		String edgepath = prop.getProperty("edgepath");
		return edgepath;		
	}
	
}
