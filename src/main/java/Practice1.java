import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		File file = new File("LoginPage.xlsx");

		FileInputStream xlreader = new FileInputStream(file);

		Workbook wb = new XSSFWorkbook(xlreader);

		Sheet sheet = wb.getSheet("Login");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int colcount= sheet.getRow(0).getLastCellNum();
						
		
			 Object obj [][] = new Object[rowCount][colcount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = sheet.getRow(i).getFirstCellNum(); j < sheet.getRow(i).getLastCellNum(); j++) {

				obj[i-1][j]=sheet.getRow(i).getCell(j);
				
					System.out.println(obj[i-1][j]);
					
				

			}
		}
		
		
 
		
		

	}

}
