package excelOperations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public boolean readExcelFile(String ExcelFilePath, String Name) throws EncryptedDocumentException,
			InvalidFormatException, IOException, URISyntaxException {

		Workbook wb;
		Sheet sh;
		FileInputStream fis;
		FileOutputStream fos;
		Row row;
		Cell cell;
		int xx = 0;

		// (FileOutputStream fos = new
		// FileOutputStream("res\\input\\testReadExcel.xlsx");
		// FileInputStream fis = new
		// FileInputStream("res\\input\\testReadExcel.xlsx");)
		try {

			fis = new FileInputStream("C:\\Users\\rpa19\\workspace\\ExcelProject\\res\\input\\testReadExcel.xlsx");
			wb = WorkbookFactory.create(fis);
			sh = wb.getSheet("Department");
			int records = sh.getLastRowNum();
			System.out.println("Number Of Members : " + records);
			fis.close();

			row = sh.createRow(records + 1);
			row.createCell(0).setCellValue(Name);

			fos = new FileOutputStream("C:\\Users\\rpa19\\workspace\\ExcelProject\\res\\input\\testReadExcel.xlsx");
			wb.write(fos);
			fos.flush();

			fos.close();
			System.out.println("New Member Registered...");
			//
			System.out.println("Number Of Registered Members : " + sh.getLastRowNum());
			System.out.println("*****");

			return true;

		} catch (Exception exp) {
			exp.printStackTrace();
			return false;
		}
	}
}
