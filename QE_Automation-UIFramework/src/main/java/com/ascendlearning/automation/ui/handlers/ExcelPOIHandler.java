package com.ascendlearning.automation.ui.handlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelPOIHandler extends BaseHandler {

	private static HSSFWorkbook wb;
	private static Hashtable<String, Integer> excelrRowColumnCount;

	public ExcelPOIHandler(WebDriver webDriver) {
		super(webDriver);
	}

	public static HashMap<String, String> getTestDataFromExcel(String filePath, String sheetName, String testCaseId)throws IOException {
		HSSFRow row = null;
		HSSFCell cell = null;
		InputStream XlsxFileToRead = null;
		XlsxFileToRead = new FileInputStream(filePath);
		wb = new HSSFWorkbook(XlsxFileToRead);
		HSSFSheet sheet = wb.getSheet(sheetName);
		excelrRowColumnCount = new Hashtable<String, Integer>();
		excelrRowColumnCount = findRowColumnCount(sheet, excelrRowColumnCount);
		Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
		readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);
		HashMap<String, String> data = null;
		ArrayList<String> header = new ArrayList<String>();
		ArrayList<String> matcher = null;
		HashMap<String, String> matcherList = new HashMap<String, String>();
		row = sheet.getRow(0);
		int r;
		if (row != null) {
			for (r = 0; r < ((Integer) excelrRowColumnCount.get("ColumnCount")).intValue(); ++r) {
				cell = sheet.getRow(0).getCell(r);
				if (cell != null) {
					String tempCell = convertHSSFCellToString(row.getCell(r));
					header.add(tempCell);
				}
			}
		}

		for (r = 1; r < ((Integer) excelrRowColumnCount.get("RowCount")).intValue(); ++r) {
			row = sheet.getRow(r);
			if (row != null) {
				HSSFCell arg19 = sheet.getRow(r).getCell(0);
				if (arg19 != null) {
					String tcID = convertHSSFCellToString(row.getCell(0));
					if (tcID.equalsIgnoreCase(testCaseId)) {
						data = new HashMap<String, String>();
						matcher = new ArrayList<String>();
						matcher.add(tcID);

						int i;
						for (i = 1; i < ((Integer) excelrRowColumnCount
								.get("ColumnCount")).intValue(); ++i) {
							cell = sheet.getRow(r).getCell(i);
							String temp = convertHSSFCellToString(row.getCell(i));
							matcher.add(temp);
						}

						for (i = 0; i < matcher.size(); ++i) {
							data.put(header.get(i), matcher.get(i));
						}

						matcherList.putAll(data);
					}
				}
			}
		}

		return matcherList;
	}
	
	public static Hashtable<String, Integer> findRowColumnCount(HSSFSheet sheet, Hashtable<String, Integer> rowColumnCount) {
		HSSFRow row = null;
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = 0;
		int counter = 0;
		String temp = null;

		for (int i = 0; i < 10 || i < rows; ++i) {
			row = sheet.getRow(i);
			if (row != null) {
				temp = convertHSSFCellToString(row.getCell(0));
				if (!temp.isEmpty()) {
					++counter;
				}

				int arg8 = sheet.getRow(i).getPhysicalNumberOfCells();
				if (arg8 > cols) {
					cols = arg8;
				}
			}
			
		}
		rowColumnCount.put("RowCount", Integer.valueOf(counter));
		rowColumnCount.put("ColumnCount", Integer.valueOf(cols));
		return rowColumnCount;
	}
	
		public static Hashtable<String, Integer> readExcelHeaders(HSSFSheet sheet,Hashtable<String, Integer> excelHeaders,Hashtable<String, Integer> rowColumnCount) {
			HSSFRow row = null;
			HSSFCell cell = null;

			for (int r = 0; r < ((Integer) rowColumnCount.get("RowCount")).intValue(); ++r) {
				row = sheet.getRow(r);
				if (row != null) {
					for (int c = 0; c < ((Integer) rowColumnCount.get("ColumnCount")).intValue(); ++c) {
						cell = row.getCell(c);
						if (cell != null) {
							excelHeaders.put(cell.toString(), Integer.valueOf(c));
						}
					}
					return excelHeaders;
				}
			}
			return excelHeaders;
		}

		public static String convertHSSFCellToString(HSSFCell hssfCell) {
			String cellValue = null;
			if (hssfCell != null) {
				cellValue = hssfCell.toString();
				cellValue = cellValue.trim();
			} else {
				cellValue = "";
			}
			return cellValue;
		}
		
		
		public static void putDataOnExcel(String filePath, String sheetName, String testCaseId,int rowindex,int columnindex,String cellvalue)throws IOException {
			
			InputStream excelFileToRead= new FileInputStream(filePath);  
			HSSFWorkbook wb = new HSSFWorkbook(excelFileToRead);
			HSSFSheet sheet = wb.getSheet(sheetName);
			sheet.getRow(rowindex).getCell(columnindex).setCellValue(cellvalue);
			excelFileToRead.close();
			
			FileOutputStream outputFile =new FileOutputStream(filePath);  
			wb.write(outputFile);
			outputFile.close();
		}
}
