package excelInputAndOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInteraction {
	
	Workbook workbook;
	Sheet sheet;
	FileInputStream inputstream;
	
	public String getCellData(String filePath,String fileName,String sheetName,int rowno,int colno) throws IOException{
		File file = new File(filePath+"\\"+fileName);
		inputstream = new FileInputStream(file);
		
		String fileExtension = fileName.substring(fileName.indexOf("."));
		
		if(fileExtension.equals(".xls")){
			workbook = new HSSFWorkbook(inputstream);
		}else if(fileExtension.equals(".xlsx")){
			workbook = new XSSFWorkbook(inputstream);
		}
		
		sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowno);
		
		return row.getCell(colno).getStringCellValue().trim();
		
	}

}
