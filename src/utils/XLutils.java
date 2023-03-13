package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils 
{
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static CellStyle style;
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		 fi = new FileInputStream(xlfile);
		 wb = new XSSFWorkbook(fi);
		 ws = wb.getSheet(xlsheet);
		 int rowcoutn = ws.getLastRowNum();
         wb.close();
         fi.close();
         return rowcoutn;
	 
	}
    public static int getCoumCount(String xlfile, String xlsheet, int rownum) throws IOException
    {
    	fi = new FileInputStream(xlfile);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlsheet);
    	row = ws.getRow(rownum);
    	int Colcount = row.getLastCellNum();
    	wb.close();
    	fi.close();
    	return Colcount;
    	
    	
    }
    public static String getCellStringData(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
    {
    	fi = new FileInputStream(xlfile);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlsheet);
    	row = ws.getRow(rownum);
    	String data;
    	try 
    	{
			cell = row.getCell(colnum);
			data = cell.getStringCellValue();
    		
		} catch (Exception e)
    	{
			data = "";
			System.out.println("No Data Found!");
		}
    	wb.close();
    	fi.close();
    	return data;
    	
    	
    	
    	
    }
    public static boolean getCellBooleanData(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
    {
    	fi = new FileInputStream(xlfile);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlsheet);
    	row = ws.getRow(rownum);
    	boolean data;
    	try 
    	{
			cell = row.getCell(colnum);
			data = cell.getBooleanCellValue();
    		
		} catch (Exception e)
    	{
			data = false;
			
		}
    	wb.close();
    	fi.close();
    	return data;
    
    
}
    public static void setCellData(String xlfile, String xlsheet, int rownum,int colnum, String data) throws IOException
    {
    	fi = new FileInputStream(xlfile);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlsheet);
    	row = ws.getRow(rownum);
    	cell = row.createCell(colnum);
    	cell.setCellValue(data);
    	fo = new FileOutputStream(xlfile) ;
    	wb.write(fo);
    	wb.close();
    	fi.close();
    	fo.close();
		
    	
    	
    }
    public static void setGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
    {
         fi= new FileInputStream(xlfile);
         wb = new XSSFWorkbook(fi);
         ws = wb.getSheet(xlsheet);
         row = ws.getRow(rownum);
         cell = row.getCell(colnum);         
         style = wb.createCellStyle();
         style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
         style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
         cell.setCellStyle(style);         
         fo = new FileOutputStream(xlfile);
         wb.write(fo);         
         wb.close();
         fo.close();
         fi.close();	
    }
    public static void setRedColor (String xlfile, String xlsheet, int rownum, int colnum) throws IOException
    {
    	fi= new FileInputStream(xlfile);
    	wb = new XSSFWorkbook(fi);
    	ws = wb.getSheet(xlsheet);
    	row = ws.getRow(rownum);
    	cell = row.getCell(colnum);
    	
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        
        fo= new FileOutputStream(xlfile);
        wb.write(fo);
         
       fo.close();
       wb.close();
       fi.close();
        
    	
    	
    }


}
        
    	
   
    