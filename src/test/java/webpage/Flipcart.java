package webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipcart {
 
  	WebDriver driver;
  @Test
	public void xyz() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Calculator\\driver\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");//use for open website
		//String expectedurl = "https://www.flipkart.com/";//use for expected url
		//String ActualUrl = driver.getCurrentUrl();
		String expectedtitle ="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String Actualtitle = driver.getTitle();
		//System.out.println(Actualtitle);
		if(expectedtitle.contains(Actualtitle))	
		{
			driver.manage().window().maximize();
			System.out.println("Correct Url is launched ");
			driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8459877542");
			driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("66337020");
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();		
			}
		else
		{
			System.out.println("Url is incorrect");
			driver.close();
		}
		Thread.sleep(3000);
		mouseover();
	}
	public void mouseover()
	{
		Actions action= new Actions(driver);
		WebElement elecxpath = driver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));
		action.moveToElement(elecxpath).perform();
		/*driver.switchTo().frame("asift_2");
		driver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));
		driver.switchTo().defaultContent();*/

		
	}
		
}
