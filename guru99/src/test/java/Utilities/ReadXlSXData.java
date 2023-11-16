package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXlSXData {

	@DataProvider(name="Guru_Customer_Details")
	public Object[][] data() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\guru99.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowcnt = sheet.getPhysicalNumberOfRows();
		int cellcnt = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowcnt-1][cellcnt];
		for (int i = 0; i <rowcnt-1 ; i++) {
			for (int j = 0; j <cellcnt; j++) {
		XSSFCell cell =	sheet.getRow(i+1).getCell(j);
		DataFormatter df = new  DataFormatter();
		data[i][j]  = df.formatCellValue(cell);			
			}
		}
		wb.close();
		fis.close();
		return data;
	}


}
