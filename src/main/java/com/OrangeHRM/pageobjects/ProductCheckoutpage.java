package com.OrangeHRM.pageobjects;

import org.openqa.selenium.By;

import com.OrangeHRM.Utilities.DriverFactory;
import com.testBase.testBase;

public class ProductCheckoutpage extends testBase {
	
	public String getproductdetails(String description,String tblcompare) {
		//String xpath="//table[@id='cart_info_table']//td//a[text()='Blue Top']//ancestor::td/following-sibling::td[@class='cart_price'"
		
		String custom_xpath="//table[@id='cart_info_table']//td//a[text()='"+description+"']//ancestor::td/following-sibling::td[@class='"+tblcompare+"']/p";
		
		return DriverFactory.getinstance().getdriver().findElement(By.xpath(custom_xpath)).getText();
	}
	

}
