package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws IOException{
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/MakeMyTripData.xlsx");
		Workbook workBook=WorkbookFactory.create(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;
	}
	
	
	public String getIntegerValueFromColumn(String sheetName,int rowNum,int cellNum) throws IOException {
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/MakeMyTripData.xlsx");
		Workbook workBook=WorkbookFactory.create(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format=new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}

}
