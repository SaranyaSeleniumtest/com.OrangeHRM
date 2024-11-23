package com.OrangeHRM.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverWait wait;
		driver= new ChromeDriver();
		driver.get("https://automationexercise.com/products");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@class='productinfo text-center']//a[text()='Add to cart'  and  @data-product-id=1]")).click();
		
		  wait= new WebDriverWait(driver, Duration.ofSeconds(30)); //
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By. xpath("//div[@class='modal-body']//p[text()='Your product has been added to cart.']" ))));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']//p[text()='Your product has been added to cart.']")).getText());
		driver.findElement(By.xpath("//div[@class='modal-footer']//button[text()='Continue Shopping']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("View Product")).click();
		
		
		
	}

}
