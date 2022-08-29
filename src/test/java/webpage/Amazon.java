package webpage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon 
{
	
  @Test
  public void searchItem() throws InterruptedException
  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Calculator\\driver\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 13 (256 GB) - Green')][1]")).click();
		Thread.sleep(3000);
		String parentWin =driver.getWindowHandle();
		System.out.println(parentWin);
		Set<String> childwin=driver.getWindowHandles();
		System.out.println(childwin);
		Iterator<String> itr = childwin.iterator();
		while (itr.hasNext())
		{
			String childwindow = itr.next();
			if (!parentWin.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			}
		}
		//driver.switchTo().window(parentWin);
		driver.switchTo().defaultContent();
  }
}
