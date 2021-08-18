package com.expleo.heroku.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChallengingDomPage {
	
	WebDriver driver;
	public String buttonText;
	public ChallengingDomPage(WebDriver driver_ref) {
		driver = driver_ref;
		PageFactory.initElements(driver_ref, this);	
	}
	
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/h3")
	WebElement heading;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/p")
	WebElement para;
	
	@FindBy(xpath="//*[@id=\"page-footer\"]/div/div/a[@href='http://elementalselenium.com/']")
	WebElement link;

	
	/*
	 * 
	 * Different Generic Action Methods Used in the project
	 * 
	 * Author: Saai Kuppannagari
	 * 
	 * 
	 * Get Button ID = Used to check before ID vs After ID when the button is clicked
	 * Click Button = Used to click Relevant Button Blue, Red or Green
	 * Click Link = Used to click the Footer link which opens a new Window/Tab
	 * Get Button Text = Used to get the button Text
	 * Get edit = Link to Edit based on Row and Column Count in the static table
	 * Get delete = Link to delete based on Row and Column Count in the static table
	 * Get Heading = Header Text 
	 * Get Para = Paragraph under the Header
	 * Get Canvas Text = The Canvas near the footer is utilizing a Script which generates a random number for every refresh or click of a button
	 * Get Table Text = Will retrieve cell value based on row and column values passed
	 */
	
	public String getButtonId(String buttonNum) {
		String id = new String();
		if(buttonNum.equals("buttonblue")) {
			List<WebElement> button1 = driver.findElements(By.xpath("//a[@class='button']"));
			id = button1.get(0).getAttribute("id");
		}else if(buttonNum.equals("buttonred")) { 
			List<WebElement> button2 = driver.findElements(By.xpath("//a[@class='button alert']"));
			id = button2.get(0).getAttribute("id");
		} else if(buttonNum.equals("buttongreen")) {
			List<WebElement> button3 = driver.findElements(By.xpath("//a[@class='button success']"));
			id = button3.get(0).getAttribute("id");
		}
		return id;
	}
	
	public void clickButton(String buttonNum) {
		if(buttonNum.equals("buttonblue")) {
			List<WebElement> button1 = driver.findElements(By.xpath("//a[@class='button']"));
			button1.get(0).click();
		}else if(buttonNum.equals("buttonred")) { 
			List<WebElement> button2 = driver.findElements(By.xpath("//a[@class='button alert']"));
			button2.get(0).click();
		} else if(buttonNum.equals("buttongreen")) {
			List<WebElement> button3 = driver.findElements(By.xpath("//a[@class='button success']"));
			button3.get(0).click();
		}
	}
	
	public String clickLink() throws InterruptedException {
		
		link.click();
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
				
		Set<String> allWindows = driver.getWindowHandles();

	
		for(String childWindow:allWindows) {
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		return driver.getCurrentUrl();

	}

	public String getButtonText(String buttonNum) {
		String buttonText = new String();
		if(buttonNum.equals("buttonblue")) {
			List<WebElement> button1 = driver.findElements(By.xpath("//a[@class='button alert']"));
			buttonText = button1.get(0).getText();
		}else if(buttonNum.equals("buttonred")) { 
			List<WebElement> button2 = driver.findElements(By.xpath("//a[@class='button alert']"));
			buttonText = button2.get(0).getText();
		} else if(buttonNum.equals("buttongreen")) {
			List<WebElement> button3 = driver.findElements(By.xpath("//a[@class='button success']"));
			buttonText = button3.get(0).getText();
		}

		return buttonText;
	}
	
	public void getEditVal(int i,int j) {
		WebElement we = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[7]/a["+j+"]"));
		we.click();
	}
	
	public void getDeleteVal(int i,int j) {
		WebElement we = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[7]/a["+j+"]"));
		we.click();
	}
	
	public String getHeading() {
		String headerText = heading.getText();
		return headerText;
	}
	
	public String getPara() {
		String paraText = para.getText();
		return paraText;
	}
	
	public String getCanvasText() {
		
	    ArrayList<WebElement>scripts = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));
	    String canvasText = new String();

	    for(int i = 0; i < scripts.size(); i++) {
	        
	        String numVal = scripts.get(i).getAttribute("innerHTML");
	        
	        if(numVal.contains("canvas.strokeText")) {

	        	canvasText = numVal.substring(numVal.indexOf("Answer"), numVal.indexOf("',"));
	                
	                break;
	                
	        }
	    }
		return canvasText;
		
	}
	
	public String getTableText(String row, int j) {
		WebElement col = null;
		
		if(row=="0"){
			col = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/thead/tr/th["+j+"]"));
		}else {
			col = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr["+row+"]/td["+j+"]"));
		}
		String tableVal = col.getText();
		return tableVal;
		
	}
	
}
