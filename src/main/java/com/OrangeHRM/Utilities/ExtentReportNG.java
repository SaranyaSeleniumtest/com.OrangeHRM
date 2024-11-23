package com.OrangeHRM.Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	//1setsysteminfor using extent report object
	//2format 
	//3 create extent spark report object and attach to extent report
	//4 Attach spark to extent report
	
	static ExtentReports extent;
	static ExtentSparkReporter extentspark;
	

	public static ExtentReports setupExtent() throws IOException {
		extent= new ExtentReports();
		//1setsysteminfor using extent report object
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Browser", Propertiesfile.getpropval("browser"));
		extent.setSystemInfo("OSname", "os.name");
		extent.setSystemInfo("ApplicationUrl", Propertiesfile.getpropval("url"));
		extent.setSystemInfo("ExecutedBy","user.name");
		extent.setSystemInfo("DateExecuted", "29-10");
		
		//2format 
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd-mm-ss-hh");
		String format = sdf.format(new Date());
		
		//3 create extent spark report object and attach to extent report
		extentspark = new ExtentSparkReporter(".//Reports//AutomationExecution"+format+"html");
		extentspark.config().setDocumentTitle("Firtframework");
		extentspark.config().setReportName("OrangeHRM_Report");
		extentspark.config().setTheme(Theme.DARK);
		
		//4 Attach spark to extent report
		extent.attachReporter(extentspark);
		
		return extent;
	}
	
	}

