package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility (String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi=new FileInputStream(path);
		workBook = new XSSFWorkbook(fi);
		sheet=workBook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		workBook.close();
		fi.close();
		return rowCount;
		
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException 
	{
		fi=new FileInputStream(path);
		workBook= new XSSFWorkbook(fi);
		sheet=workBook.getSheet(sheetName);
		row= sheet.getRow(rownum);
		int cellCount= row.getLastCellNum();
		workBook.close();
		fi.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rowNum, int colNum) throws IOException
	{
		fi= new FileInputStream(path);
		workBook = new XSSFWorkbook(fi);
		sheet= workBook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell= row.getCell(colNum);
		
		DataFormatter  formatter = new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		
		catch(Exception e){
			data="";
		}
		workBook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int Colnum, String data) throws IOException
	{
		File X1file= new File(path);
		if(!X1file.exists()) //if file not exist then create new file
		{
			workBook = new XSSFWorkbook(); // Create a new workbook
			fo=new FileOutputStream(path); // Create a new file output stream
			workBook.write(fo); // Write the empty workbook to file

		}
		
		fi=new FileInputStream(path);
		workBook = new XSSFWorkbook(fi);
		if(workBook.getSheetIndex(sheetName)==-1) //if sheet not exist then create new sheet
			workBook.createSheet(sheetName);
		sheet=workBook.getSheet(sheetName);
		
		if (sheet.getRow(rowNum)==null) //if row not exist the create new row
			sheet.createRow(rowNum);
		row= sheet.getRow(rowNum);
		
		cell= row.createCell(Colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workBook.write(fo);
		workBook.close();
		fi.close();
		fo.close();
	}
}

