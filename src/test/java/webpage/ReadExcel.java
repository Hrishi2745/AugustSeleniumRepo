package webpage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel 
{
	//static
	/*public void ExcelRead() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Orangehrm\\Excel\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Login");
		System.out.print(sheet.getRow(0).getCell(0));
		System.out.print("	");
		System.out.print(sheet.getRow(0).getCell(1));
		System.out.println();
		System.out.print(sheet.getRow(1).getCell(0));
		System.out.print("	");
		System.out.print(sheet.getRow(1).getCell(1));

	}*/
	//Dynamic
	
	
	public void ExcelReadMethod(String sheetname) throws IOException 
	{
		String res= null;
	
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Orangehrm\\Excel\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		
		for(int i=rowcount;i<=rowcount;i++)
		{
			int colcount = sheet.getRow(i).getLastCellNum();
			XSSFRow currentrow = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				//value=currentrow.getCell(j).toString();
				XSSFCell cell = currentrow.getCell(j);
				switch(cell.getCellType())
				{
				case STRING:
					res =cell.getStringCellValue();
					
				}
			}
					
		}
		for(int i=0;i<=rowcount;i++)
		{
			int colcount = sheet.getRow(i).getLastCellNum();
			XSSFRow currentrow = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				System.out.println(res);
			}
			System.out.println();		
		}
		
		
	}
	
	
	public static void main(String[] args) throws Throwable 
	{
		ReadExcel read = new ReadExcel();
		read.ExcelReadMethod("Login");
		
	}	
}
