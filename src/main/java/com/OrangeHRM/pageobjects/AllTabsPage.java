package com.OrangeHRM.pageobjects;

import org.openqa.selenium.By;

import com.OrangeHRM.Utilities.DriverFactory;
import com.OrangeHRM.Utilities.ExtentFactory;
import com.aventstack.extentreports.Status;
import com.testBase.testBase_old;

public class AllTabsPage extends testBase_old {

	//By locators

	By tab_Home=By.linkText(" Home");

	By tab_Products=By.xpath("//a[text()=' Products']");

	By tab_cart=By.linkText(" Cart");

	By tab_contact= By.linkText(" Contact us");


	//Methods

	public void Click_Pdt() {
		click(DriverFactory.getinstance().getdriver().findElement(tab_Products),"ProductLnk");
	}


	public void Click_tabs(String tabname) {
		try {
			String xpath= "//a[text()=' "+tabname+"']";

			DriverFactory.getinstance().getdriver().findElement(By.xpath(xpath)).click();
			ExtentFactory.getinstance().getextent().log(Status.PASS, "Tabname "+tabname+"is selected");
		}catch(Exception e){
			ExtentFactory.getinstance().getextent().log(Status.FAIL, "Tabname "+tabname+"is not selected due to exception"+ e);
		}
	}


}
