package webpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;



public class LaunchWebpage  
{	 	 WebDriver driver;
		//String userId="Admin";
		//String pwd="admin123";
		String value = null;

	 	@BeforeMethod
	public void launchbrowser() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Calculator\\driver\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//use for open website
		//String expectedurl = "https://opensource-demo.orangehrmlive.com/";//use for expected url
		//String ActualUrl = driver.getCurrentUrl();//to get actual url
		String expectedtitle ="OrangeHRM";
		String Actualtitle = driver.getTitle();
		//System.out.println(Actualtitle); 
	
		if(expectedtitle.contains(Actualtitle))	
		{
			System.out.println("Correct Url is launched ");
			driver.manage().window().maximize();
		}
		else
		{
				System.out.println("Url is incorrect");
				driver.close();//use to close window
				//drive.quit();//use to quit from browser
		}
				
	}
	public void loginCredential() throws InterruptedException, IOException
	{
		String userid=ExcelReadMethod("Login",2,1);
		String pwd=ExcelReadMethod("Login",2,2);
		/*String UserId = null;
		String pwd=null;
		for(int k=0;k<2;k++)
		{
			UserId=value;
			pwd=value+1;
		}*/

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pwd);
		Thread.sleep(2000);
		ScreenShots();
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		ScreenShots();
	}
	String fileWithPath="C:\\Users\\Administrator\\eclipse-workspace\\Orangehrm\\ScreenShots\\";
	//Simple Method
	/*public void ScreenShot() throws IOException 
	{
		TakesScreenshot scrShot	=((TakesScreenshot)driver);
		File scrfile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile =new File(fileWithPath);
		FileHandler.copy(scrfile, DestFile);
		
	}*/
	public void ScreenShots() throws IOException
	{
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(fileWithPath + FileName));
		
	}
	public String ExcelReadMethod(String sheetname, int l,int m) throws IOException 
	{
		//String value= null;
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Orangehrm\\Excel\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		//int rowcount = sheet.getLastRowNum();
		
		for(int i=0;i<l;i++)
		{
			//int colcount = sheet.getRow(i).getLastCellNum();
			XSSFRow currentrow = sheet.getRow(i);
			for(int j=0;j<m;j++)
			{
				value=currentrow.getCell(j).toString();
				System.out.print(" "+value);
			}
			System.out.println();		
		}
		return value;
	}
	
	
	/*public static void main(String args[]) throws Throwable {
		
		LaunchWebpage obj = new LaunchWebpage();
		obj.launchbrowser();
		//obj.enterpersonaldetails();
	}*/
}
