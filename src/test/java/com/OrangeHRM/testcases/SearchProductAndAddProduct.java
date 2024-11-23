package com.OrangeHRM.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Utilities.ExcelOperations;
import com.OrangeHRM.Utilities.ExtentFactory;
import com.OrangeHRM.pageobjects.AddProductpage;
import com.OrangeHRM.pageobjects.AllTabsPage;
import com.OrangeHRM.pageobjects.Loginpage;
import com.OrangeHRM.pageobjects.ProductCheckoutpage;
import com.OrangeHRM.pageobjects.Productpage;
import com.OrangeHRM.pageobjects.Shoppingcartpage;
import com.aventstack.extentreports.Status;
import com.testBase.testBase_old;

public class SearchProductAndAddProduct extends testBase_old {

	//	1. Launch browser
	//	2. Navigate to url 'http://automationexercise.com'
	//	3. Verify that home page is visible successfully
	//	4. Click on 'Products' button
	//	5. Verify user is navigated to ALL PRODUCTS page successfully
	//	6. Enter product name in search input and click search button
	//	7. Verify 'SEARCHED PRODUCTS' is visible
	//	8. Verify all the products related to search are visible

	Loginpage lp= new Loginpage();
	AllTabsPage tabs= new AllTabsPage();
	Productpage pdt= new Productpage();
	AddProductpage addpdt= new AddProductpage();
	Shoppingcartpage shopcart= new Shoppingcartpage();
	ProductCheckoutpage pdtcheckout= new ProductCheckoutpage();
	
	ExcelOperations excelopt = new ExcelOperations("AddProduct");

	@Test(dataProvider="AddProduct")
	public void TC05_SearchandAddpdt(Object obj) throws IOException, InterruptedException {
		HashMap<String,String> datatable= (HashMap<String, String>) obj;
		try {
			//login
			lp.loginapp(datatable);
			Assert.assertEquals(gettitle("Homepage"),datatable.get("Hometitle"),"Title mismatched");
			
			//pdt search
			tabs.Click_Pdt();
			Assert.assertTrue(pdt.verifytitle(),"Product Title mismatched");
			pdt.searchpdt(datatable);
			Assert.assertEquals(pdt.validatepdt(),datatable.get("Productname1"),"Product mismatched");
			
			//search and add 2 pdts
			pdt.comparepdt_addtocart(datatable.get("Productname1"));
			
			Assert.assertEquals(addpdt.getproductconfimation(),datatable.get("Productconfirmmsg"));
			
			addpdt.click_continueshop();
			assertEqualsString_custom(gettitle("AllProducts"),datatable.get("ProductTitle"),"ProductTitle");
			pdt.searchSecondpdt(datatable);
			assertEqualsString_custom(pdt.validatepdt(),datatable.get("Productname2"),"Product name");
			pdt.comparepdt_addtocart(datatable.get("Productname2"));
			Assert.assertEquals(addpdt.getproductconfimation(),datatable.get("Productconfirmmsg"));
			addpdt.click_viewcart();
			Assert.assertEquals(shopcart.shopping_gettitle(),datatable.get("Shoppingtitle"));
			
			//Verify shopping cart
			assertEqualsString_custom(pdtcheckout.getproductdetails(datatable.get("Productname1"),datatable.get("Pricelabel")),datatable.get("Price"),"Price");
			assertEqualsString_custom(pdtcheckout.getproductdetails(datatable.get("Productname2"),datatable.get("Pricelabel")),datatable.get("Product2price"),"Product2_Price");

			ExtentFactory.getinstance().getextent().log(Status.PASS, "Addproduct is successful");
		}catch(Exception e) {
			ExtentFactory.getinstance().getextent().log(Status.FAIL, "Addproduct is NOT successful due to following error"+ e.getMessage());	
		}
	}

	@DataProvider(name="AddProduct")
	public Object[][] searchdata() {
		Object[][] obj= new Object[excelopt.getrow()][1];
		int rowcnt = excelopt.getrow();

		for(int j=1;j<=rowcnt;j++) {
			HashMap<String, String> testdata = ExcelOperations.gethashvalue(j);
			obj[j-1][0]=testdata;
		}

		return obj;


	}
}
