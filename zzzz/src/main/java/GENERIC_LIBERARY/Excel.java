package GENERIC_LIBERARY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements Paths{
	Logger log =LogManager.getLogger();
	public File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\excel.properties");
	public Workbook workbook = null;
	
	//TO GET NUMBERS FROM EXCEL
	public double readNumberDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{
		log.info("readNumberDataFromExcel  METHOD IS CALLED TO RETRIEVE NUMBER DATA FROM EXCEL");
		FileInputStream fis=null; 
		try {
			 fis = new FileInputStream(file );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
	}
	
	// TO GETSTRING DATA FROM EXCEL
	public String readStringDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{
		log.info("readStringDataFromExcel  METHOD IS CALLED TO RETRIEVE STRING DATA FROM EXCEL");
		FileInputStream fis=null;
		try {
			 fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	} 
	
	//READ BOOLEAN VALUES FROM EXCEL
	public boolean readBooleanDataFromExcel(String sheetName, int rowNumber, int cellNumber)
	{

		log.info("readBooleanDataFromExcel  METHOD IS CALLED TO RETRIEVE BOOLEAN DATA FROM EXCEL");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getBooleanCellValue();
	}
	
		
// TO GET MULTIPLE VALUES
	public String[][] readMultipleDataFromExcel(String sheetName) {
		log.info("readBooleanDataFromExcel  METHOD IS CALLED TO RETRIEVE MULTIPLE  DATA FROM EXCEL");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		int rowNumber = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		int cellNumber = workbook.getSheet(sheetName).getRow(rowNumber).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowNumber][cellNumber];
		for(int i=0; i<rowNumber; i++) {
			for(int j=0; j<cellNumber; j++) {
				data[i][j]= workbook.getSheet(sheetName).getRow(i).getCell(j).toString();
			}
		}
		return  data;
		
	}	
}



