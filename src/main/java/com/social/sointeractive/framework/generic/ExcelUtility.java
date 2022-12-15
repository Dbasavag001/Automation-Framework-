package com.social.sointeractive.framework.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is the generic utility for Excel File
 * @author D Basava
 *
 */
public class ExcelUtility
{

	private FileInputStream fis = null;
	Workbook wb;
	private FileOutputStream fos = null;

	/**
	 * This method is for opening the Excel file 
	 * @param excelPath
	 */
	public void openExcel(String excelPath) {
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is for Closing the excel file
	 */
	public void closeExcel() {
	
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
  
	/**
	 * This method is for getting the data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String sheetName, int rowNum,int cellNum){
		
		
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	/**
	 * This method is for setting and saving the data to the excel file
	 * @param excePath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 */
	public void setAndSaveDataToExcel(String excePath, String sheetName, int rowNum, int cellNum , String data) {
		
		try {
			fos= new FileOutputStream(excePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(data);
	}
	
	public void getDataFromExcel(String sheetName) {
		
	}
	

}
