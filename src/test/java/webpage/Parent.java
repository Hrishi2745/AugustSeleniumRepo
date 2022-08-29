package webpage;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Parent extends LaunchWebpage 
{
	
 		//String username="Hrushikesh";
		@Test(enabled=true, priority=2)
		public void clickonQuickLaunchRun() throws InterruptedException, IOException
		{
			clickonQuickLaunch("Leave List");
		}
		
		public void clickonQuickLaunch( String var) throws InterruptedException, IOException
		{	
			loginCredential();
			//driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'"+ var +"')]")).click();
		}  
		@Test(enabled=true, priority=1)
		public void enterpersonaldetails() throws InterruptedException, IOException  
		{
			loginCredential();
			String username=ExcelReadMethod("Info",2,1);
			String middlename=ExcelReadMethod("Info",2,2);
			String lastname=ExcelReadMethod("Info",2,3);
			String empid=ExcelReadMethod("Info",2,4);
			String otherid=ExcelReadMethod("Info",2,5);
			String licenno=ExcelReadMethod("Info",2,6);
			String ssnno=ExcelReadMethod("Info",2,7);
			String sinno=ExcelReadMethod("Info",2,8);
			String nickname=ExcelReadMethod("Info",2,9);





			driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
			driver.findElement(By.xpath("//input[@id='btnSave']")).click();
			Thread.sleep(2000);
			ScreenShots();
			driver.findElement(By.xpath("//input[@name='personal[txtEmpFirstName]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtEmpFirstName]']")).sendKeys(username);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='personal[txtEmpMiddleName]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtEmpMiddleName]']")).sendKeys(middlename);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='personal[txtEmpLastName]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtEmpLastName]']")).sendKeys(lastname);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='personal[txtEmployeeId]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtEmployeeId]']")).sendKeys(empid);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='personal[txtOtherID]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtOtherID]']")).sendKeys(otherid);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='personal[txtLicenNo]']")).clear();
			driver.findElement(By.xpath("//input[@name='personal[txtLicenNo]']")).sendKeys(licenno);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'SSN Number')]/..//input[@name='personal[txtNICNo]']")).clear();
			driver.findElement(By.xpath("//label[contains(text(),'SSN Number')]/..//input[@name='personal[txtNICNo]']")).sendKeys(ssnno);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'SIN Number')]//following-sibling::input[@name='personal[txtSINNo]']")).clear();
			driver.findElement(By.xpath("//label[contains(text(),'SIN Number')]//following-sibling::input[@name='personal[txtSINNo]']")).sendKeys(sinno);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'Male')]/..//input[@name='personal[optGender]']")).click();
			
			Select drp = new Select(driver.findElement(By.xpath("//label[contains(text(),'Marital Status')]/..//select[@name='personal[cmbMarital]']")));
			//drp.deselectByIndex(1);
			//drp.deselectByValue("Single");
			drp.selectByVisibleText("Single");
			Select drp1 = new Select(driver.findElement(By.xpath("//select[@name='personal[cmbNation]']")));
			drp1.selectByVisibleText("Indian");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[contains(text(),'Nick Name')]/..//input[@id='personal_txtEmpNickName']")).clear();
			driver.findElement(By.xpath("//label[contains(text(),'Nick Name')]/..//input[@id='personal_txtEmpNickName']")).sendKeys(nickname);
			Thread.sleep(2000);
			boolean Checkbox = driver.findElement(By.xpath("//label[contains(text(),'Smoker')]//following-sibling::input[@name='personal[chkSmokeFlag]']")).isSelected();
			//driver.findElement(By.xpath("//label[contains(text(),'Smoker')]//following-sibling::input[@name='personal[chkSmokeFlag]']")).click();
			if (Checkbox==true)
			{
			
				System.out.println("Checked");
			}
			else
			{
				driver.findElement(By.xpath("//label[contains(text(),'Smoker')]//following-sibling::input[@name='personal[chkSmokeFlag]']")).click();
			}
			ScreenShots();
			
			
		}
		public void clearCache() throws InterruptedException
		{
			driver.get("chrome://settings/clearBrowserData");
			Thread.sleep(3000);
			JavascriptExecutor js =(JavascriptExecutor)driver;
			String script ="return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')";
			WebElement cleardata= (WebElement)js.executeScript(script);
			cleardata.click();	
			Thread.sleep(4000);
		}
		
		
		@AfterMethod
		public void driverClose() throws InterruptedException 
		{
			clearCache();
			driver.close();	
		}
		
  		
}
