package com.naukri.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_utiliy {
	public  String excel_email(int i) throws IOException {
		  

		  FileInputStream fil = new FileInputStream(new File("E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\testdata\\naukri.xlsx"));

		  

		  XSSFWorkbook workbook = new XSSFWorkbook(fil);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		    
			  XSSFRow row =sheet.getRow(i);
			  XSSFCell cell=row.getCell(0);
			  String em=cell.getStringCellValue();
			        
		return em;
}
	public  String excel_password(int i) throws IOException {
		  

		  FileInputStream fil = new FileInputStream(new File("E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\test\\resources\\testdata\\naukri.xlsx"));

	
		  XSSFWorkbook workbook = new XSSFWorkbook(fil);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		  
			  XSSFRow row =sheet.getRow(i);
			  XSSFCell cell1=row.getCell(1);
			  String pwd=cell1.getStringCellValue();
  
		return pwd;
}

}
