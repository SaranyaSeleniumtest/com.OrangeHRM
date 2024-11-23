package com.OrangeHRM.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

	// Make extent test as threadsafe
	
	
	//privateconstructor
	private ExtentFactory() {
		
	}
	
	//singleton pattern . provider global access with getinstance method
	private static ExtentFactory instance= new ExtentFactory();
	public static ExtentFactory getinstance() {
		return instance;
	}
	
	//objects will be stored in internal thread local in hashmap
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	
	public ExtentTest getextent() {
		return extenttest.get();
	}
	public void setextent(ExtentTest extenttestobj) {
		extenttest.set(extenttestobj);
	}
	
	public void removeExtentobj() {
		extenttest.remove();
	}
}
