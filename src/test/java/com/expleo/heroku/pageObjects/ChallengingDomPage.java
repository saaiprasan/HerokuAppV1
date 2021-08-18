package com.expleo.heroku.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	 * Setting Action Methods
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
