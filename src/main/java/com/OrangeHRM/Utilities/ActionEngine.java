package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;




public class ActionEngine {
	public WebDriverWait Wait;

	public void scrolldown(WebElement ele,String fieldname) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getinstance().getdriver();
			//executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			executor.executeScript("javascript:window.scrollBy(250,700)");
			ExtentFactory.getinstance().getextent().log(Status.PASS, fieldname + " scrolled successfully");
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname+ " not scrolled due to exception " +e);
		}
	}

	public void sendKeys(WebElement element,String value, String fieldname) {
		try {
			element.clear();
			element.sendKeys(value);
			//add extent report for success
			ExtentFactory.getinstance().getextent().log(Status.PASS,"The value: "+"<b>"+value+ "</b>"+ " is entered in the field "+ fieldname);
		}catch(Exception e) {
			//add extent report for failure
			ExtentFactory.getinstance().getextent().log(Status.FAIL,"The value: "+value+" is not entered in to field: "+fieldname+ "due to exception "+e.getMessage());
		}
	}


	public void click(WebElement element, String fieldname) {
		try {
			element.click();
			//add extent report for success
			ExtentFactory.getinstance().getextent().log(Status.PASS, "<b>"+fieldname+"</b>"+ " is clicked successfully");
		}catch(Exception e) {
			//add extent report for failure
			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname+ " not clicked due to exception: "+e.getMessage());
		}
	}


	public void selectByvisibletext(WebElement element, String visibletxt, String fieldname) {
		try {
			Select sel= new Select(element);

			sel.selectByVisibleText(visibletxt);
			//add extent report for success
			ExtentFactory.getinstance().getextent().log(Status.PASS, fieldname + " is selected with value: "+visibletxt);
		}catch(Exception e) {
			//add extent report for failure
			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname + " is NOT selected with value: "+visibletxt +" due to exception: "+e.getMessage());
		}
	}


	public void selectByvalue(WebElement element, String value, String fieldname) {
		try {
			Select sel= new Select(element);

			sel.selectByValue(value);
			//add extent report for success
			ExtentFactory.getinstance().getextent().log(Status.PASS, fieldname + " is selected with value: "+value);
		}catch(Exception e) {
			//add extent report for failure
			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname + " is NOT selected with value: "+value +" due to exception: "+e.getMessage());
		}
	}


	public void selectByIndex(WebElement element, int index, String fieldname) {
		try {
			Select sel= new Select(element);

			sel.selectByIndex(index);
			//add extent report for success
			ExtentFactory.getinstance().getextent().log(Status.PASS, fieldname + " is selected with index: "+index);
		}catch(Exception e) {
			//add extent report for failure
			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname + " is NOT selected with index: "+index +" due to exception: "+e.getMessage());
		}
	}


	public void mousehover(WebElement element) {
		try {
			Actions act= new Actions(DriverFactory.getinstance().getdriver());
			act.moveToElement(element).build().perform();
			//add extent report for success
		}catch(Exception e) {
			//add extent report for failure
		}
	}


	public boolean isdisplayed(WebElement ele,String Fieldname) {
		boolean flag= false;
		try {
			if(ele.isDisplayed()) {
				flag=true;
				ExtentFactory.getinstance().getextent().log(Status.PASS,Fieldname +" is displayed");
				return flag;
			}
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL,Fieldname +" is not displayed due to exception: "+ e.getMessage());
					}
		return flag;

	}
	
	public void webdriverwait_visibility(WebElement ele,int duration) {
		try {
			Wait= new WebDriverWait(DriverFactory.getinstance().getdriver(),Duration.ofSeconds(duration));
			Wait.until(ExpectedConditions.visibilityOf(ele));
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL,"Webdriver wait for visibility of element failed due to error: "+e.getMessage());

		}
	}

	
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName){
		try {
			if(actualValue.equals(expvalue)) {
				ExtentFactory.getinstance().getextent().log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
			}else {
				ExtentFactory.getinstance().getextent().log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}



	public String gettext(WebElement ele,String fieldname) {
		String value=null;
		try {
			value=ele.getText();
			ExtentFactory.getinstance().getextent().log(Status.PASS,"The text available for field "+fieldname+ " is "+value);
			return value;
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL,"The text not available for field " +fieldname+ "due to exception "+e.getMessage());
		}
		return value;
	}
	
	public String gettitle(String Fieldname) {
		String title=null;
		try {
			title=DriverFactory.getinstance().getdriver().getTitle();
			ExtentFactory.getinstance().getextent().log(Status.PASS,Fieldname+ "page title: "+ title);
			return title;
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL,"Unable to fetch: " +Fieldname+ "page title: due to exception "+e.getMessage());
		}
		return null;
	}
	public void capturescreen() {
		TakesScreenshot screen= (TakesScreenshot)DriverFactory.getinstance().getdriver();
		File source = screen.getScreenshotAs(OutputType.FILE);
		String path_screen="//Screenshots//Automation123.png";
		try {
			File Destination= new File(path_screen);
			source.renameTo(Destination);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
