package com.OrangeHRM.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Utilities.DriverFactory;
import com.testBase.testBase_old;

public class AddProductpage extends testBase_old {
	
	By msg_productconfirm=By.xpath("//div[@class='modal-body']//p[text()='Your product has been added to cart.']");
	By btn_continueshop=By.xpath("//div[@class='modal-footer']//button[text()='Continue Shopping']");
	By lnk_viewcart=By.xpath("//div[@class='modal-body']//u[text()='View Cart']");
	By frm_Addcart=By.id("aswift_1:");
	
	public String getproductconfimation() {
		webdriverwait_visibility(DriverFactory.getinstance().getdriver().findElement(msg_productconfirm),60);
		return gettext(DriverFactory.getinstance().getdriver().findElement(msg_productconfirm),"AddProduct_Confirmation");
	}

	public void click_continueshop() {
		click(DriverFactory.getinstance().getdriver().findElement(btn_continueshop),"Continue Shopping");
	}
	
	public void click_viewcart() {
		click(DriverFactory.getinstance().getdriver().findElement(lnk_viewcart),"ViewCart");
	}
	
	public void switchframe(String id) {
		DriverFactory.getinstance().getdriver().switchTo().frame(id);
	}
}
