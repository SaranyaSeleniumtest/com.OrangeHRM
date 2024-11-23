package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class ListnersManager implements ITestListener {

	//create extent report object
	//create extent spark reporter object
	//code--format of report 
	//code-- theme and document title
	//code-- dashboard details--Set system info
	//	###########################################################
	//0.Create extent report object(onetime)
	//1.start testcase(@Test)
	//2.create extent test(per test)
	//3. log messages,errors, screenshots in report(logged in actual testcases)
	//4.check if pass, fail , skip--log in report
	//5.close extent report(one time)
	//	###########################################################
	static ExtentReports report;
	static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		//2.create extent test(per test)
		//to log different test nodes into the report 
		test= report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getinstance().setextent(test);
		ExtentFactory.getinstance().getextent().log(Status.PASS, "Testcase " +result.getMethod().getMethodName()+ " is started.");
	
	}
	@Override
	public void onStart(ITestContext context) {
		//0.Create extent report object(onetime)
		try {
			report = ExtentReportNG.setupExtent();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getinstance().getextent().log(Status.PASS, "Testcase"+result.getMethod().getMethodName()+ " is passed.");
		ExtentFactory.getinstance().removeExtentobj();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getinstance().getextent().log(Status.FAIL, "Testcase " +result.getMethod().getMethodName()+ " is failed.");
		ExtentFactory.getinstance().getextent().log(Status.FAIL, result.getThrowable());
		//add screenshot code
		TakesScreenshot screen= (TakesScreenshot)DriverFactory.getinstance().getdriver();
		File source = screen.getScreenshotAs(OutputType.FILE);
		String path_screen="//Screenshots//Automation123.png";
		try {
			File Destination= new File(path_screen);
			source.renameTo(Destination);
			ExtentFactory.getinstance().getextent().addScreenCaptureFromPath(path_screen);
			ExtentFactory.getinstance().removeExtentobj();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getinstance().getextent().log(Status.SKIP, "Testcase " +result.getMethod().getMethodName()+ " is skipped.");
		ExtentFactory.getinstance().removeExtentobj();
	}



	@Override
	public void onFinish(ITestContext context) {
		//close extent
		report.flush();
	}

}
