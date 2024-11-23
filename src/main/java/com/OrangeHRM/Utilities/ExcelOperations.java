package com.OrangeHRM.Utilities;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public ExcelOperations(String sheetname) {
		try {
		String file=System.getProperty("user.dir")+Propertiesfile.getpropval("testdataloc");
		FileInputStream fis= new FileInputStream(file);
		wb= new XSSFWorkbook(fis);
		sh=wb.getSheet(sheetname);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getrow() {
		return sh.getLastRowNum();
	
	}
	
	public static  int getcolumn() {
		return sh.getRow(0).getLastCellNum();
	}
	
	
	public static HashMap<String,String>  gethashvalue(int row) {
		HashMap<String,String> hash= new HashMap<String,String>();
		int colcnt = getcolumn();
		String colval,colname=null;
		for(int i=0;i<colcnt;i++) {
		//hash.put(colname, colval)
			
			
			if(sh.getRow(row).getCell(i) != null) {
			sh.getRow(row).getCell(i).setCellType(CellType.STRING);
			 colval=sh.getRow(row).getCell(i).toString();
			  colname = sh.getRow(0).getCell(i).toString();
			}
			else {
				colval="";
				System.out.println(colval+" value is empty");
			}
			hash.put(colname, colval);
			
		}
		return hash;
		
	}
	
}
