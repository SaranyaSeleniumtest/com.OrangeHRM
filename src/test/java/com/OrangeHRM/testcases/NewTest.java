package com.OrangeHRM.testcases;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Utilities.ExcelOperations;
import com.OrangeHRM.pageobjects.Loginpage;
import com.testBase.testBase_old;

public class NewTest extends testBase_old {
	
	Loginpage lp= new Loginpage();
	ExcelOperations excelopt= new ExcelOperations("new");
	
	@Test(dataProvider="newdata")
	public void TC002_newtest(Object obj1) throws InterruptedException {
		HashMap<String,String> hm= (HashMap<String,String>)obj1;
		lp.loginapp(hm);
		}
	
	@DataProvider(name="newdata",indices= {0})
	public Object[][] newdata() {
		
		Object[][] obj= new Object[excelopt.getrow()][1];
		int rowcnt = excelopt.getrow();
		for(int j=1;j<=rowcnt;j++) {
			HashMap<String, String> testdata = ExcelOperations.gethashvalue(j);
			obj[j-1][0]=testdata;
		}
		
		return obj;
		
		
		
	}

}
