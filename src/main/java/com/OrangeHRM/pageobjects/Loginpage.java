package com.OrangeHRM.pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;

import com.OrangeHRM.Utilities.DriverFactory;
import com.testBase.testBase_old;

public class Loginpage extends testBase_old {

	By txtpassword=By.name("password");
	
	By txtemail=By.name("email");
	
	By btnLogin=By.xpath("//button[@type='submit' and text()='Login']");
	
	By lnkLogin= By.xpath("//a[contains(text(),'Login')]");
	
	
	
	
	public void loginapp(HashMap<String,String>hm) throws InterruptedException {
		try {
		click(DriverFactory.getinstance().getdriver().findElement(lnkLogin),"Login_lnk");
		sendKeys(DriverFactory.getinstance().getdriver().findElement(txtemail),hm.get("Email"),"EmailAddress");
		Thread.sleep(3000);
		System.out.println(hm.get("Email"));
		System.out.println(hm.get("Password"));
		sendKeys(DriverFactory.getinstance().getdriver().findElement(txtpassword),hm.get("Password"),"Password");
		click(DriverFactory.getinstance().getdriver().findElement(btnLogin),"Login_btn");
		}catch(Exception e)	{
			System.out.println("The exception is " +e.getMessage());
		}
	}
}
