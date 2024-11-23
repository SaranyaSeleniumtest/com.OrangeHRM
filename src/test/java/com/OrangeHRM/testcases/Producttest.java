package com.OrangeHRM.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Utilities.ExcelOperations;
import com.OrangeHRM.pageobjects.AllTabsPage;
import com.OrangeHRM.pageobjects.Loginpage;
import com.OrangeHRM.pageobjects.Productpage;
import com.testBase.testBase_old;

public class Producttest extends testBase_old {
	Loginpage lp= new Loginpage();
	AllTabsPage tabs= new AllTabsPage();
	Productpage pdt= new Productpage();
	
	ExcelOperations excelopt= new ExcelOperations("Login");
	
	@Test(dataProvider="pdtdata")
	public void TC02_ViewProduct(Object obj1) throws InterruptedException {
		HashMap<String,String> hm= (HashMap<String,String>)obj1;
		lp.loginapp(hm);
		tabs.Click_tabs("Products");
		
		Assert.assertTrue(pdt.verifytitle(),"Product title not displayed");
		
		pdt.Clickviewpdt();
		pdt.verifyAllpdtdetails();
		
	}
	
	
	
	@DataProvider(name="pdtdata",indices={0})
	public Object[][] productdata() {
		
		Object[][] obj= new Object[excelopt.getrow()][1];
		int rowcnt = excelopt.getrow();
		
		for(int j=1;j<=rowcnt;j++) {
			HashMap<String, String> testdata = ExcelOperations.gethashvalue(j);
			obj[j-1][0]=testdata;
		}
		
		return obj;
		
		
	}
}
