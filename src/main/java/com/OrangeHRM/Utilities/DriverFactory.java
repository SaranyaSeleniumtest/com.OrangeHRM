package com.OrangeHRM.Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//private constructor , object should not be created outside this class
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance= new DriverFactory();

	//global access is given to driver instance
	public static DriverFactory getinstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public void setdriver(WebDriver driverparam) {
		driver.set(driverparam);
	}
	
	public WebDriver getdriver() {
		return driver.get();
	}
	
	
	
}
