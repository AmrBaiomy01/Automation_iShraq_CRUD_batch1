package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis= null;
	
	public FileInputStream getFileInputStream()
	{
		String filePath= System.getProperty("user.dir"+	"\\src\\test\\java\\Properties\\RepaymentPlanName.xlsx");
		String filePath2 = "C:\\Users\\Ahmed.Mounir\\AppiumSelenium\\I50QCFramework\\src\\test\\java\\Properties\\RepaymentPlanName.xlsx";
		File srcFile = new File(filePath2);
		
		try {
			fis=new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
		
			System.err.println("Error "+ e.getMessage());
		}
		
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int InTotalNumberOfRows = (sheet.getLastRowNum()+1);
		int InTotalNumberOfCols= 1;
		
		String [][] arrayExcelData= new String [InTotalNumberOfRows][InTotalNumberOfCols];
		for (int i = 0; i < InTotalNumberOfRows; i++)
		{
			for (int j = 0; j < InTotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData [i][j]= row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
				
	}
	
	
	
}
