package com.OrangeHRM.Utilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;

public class BrowserFactory {
// browser detail is passed from config file
	WebDriver driver=null;
	public WebDriver setbrowser(String browser) throws IOException {
		String env=Propertiesfile.getpropval("environment");
		try {
			System.out.println(env);
		if(env.equalsIgnoreCase("remote")){
			DesiredCapabilities dc= new DesiredCapabilities();
			if(browser.equalsIgnoreCase("chrome")) {
				dc.setBrowserName("chrome");
			//	ExtentFactory.getinstance().getextent().log(Status.PASS,"Driver: "+ browser+ " is set successfully");
			}
			else if(browser.equalsIgnoreCase("edge")){
				dc.setBrowserName("MicrosoftEdge");
			//	ExtentFactory.getinstance().getextent().log(Status.PASS,"Driver: "+ browser+ " is set successfully");
			}
			driver= new RemoteWebDriver(new URL("http://localhost:4444"), dc); 
			return driver;
		}
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		//ExtentFactory.getinstance().getextent().log(Status.FAIL,"Driver: "+ browser+ " is NOT set successfully");
		}
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			
			ChromeOptions opt=new ChromeOptions();
			
			opt.addArguments("--incognito");
	//		ExtentFactory.getinstance().getextent().log(Status.PASS,"Driver: "+ browser+ " is set successfully");
			driver.manage().window().maximize();
			
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
		}
		
		return driver;
	}

}
