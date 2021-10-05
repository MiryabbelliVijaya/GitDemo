package com.orghrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public int rowCount(String filePath, String sheetName) {
		int rowCount=0;
		try
		{
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis); 
			sheet = wb.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	
	public int cellCount(String filePath, String sheetName, int rowNum) {
		
		int cellCount=0;
		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cellCount = row.getLastCellNum();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cellCount;
	}
	
	
	public String getCellData(String filePath, String sheetName, int rowNum, int cellNum) 
	{
		String cellData=null;
		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis); 
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(cellNum);
			DataFormatter formatter = new DataFormatter();
	        cellData = formatter.formatCellValue(cell);
	        wb.close();
	        fis.close();
	        
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellData;
	}

	
	public void setCellData(String filePath, String sheetName, int rowNum, int colNum, String data) 
	{
		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis); 
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.createCell(colNum);
			cell.setCellValue(data);
	        fos = new FileOutputStream(filePath);
	        wb.write(fos);
	        wb.close();
	        fis.close();
	        
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
