import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class amazonSearch {
		
		WebDriver driver;
		
		@BeforeClass
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver",
					"G:\\selenium\\Setup\\Chromedriver File\\chromedriver_win32\\chromedriver.exe");
			
			driver=new ChromeDriver();
	        driver.manage().window().maximize();
		}
		
		@Test
		public void serachProduct()
		{
			driver.get("https://www.amazon.in/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.xpath("(//a[contains(@class,'a-text-normal')])[1]")).click();
			
			WebElement price = driver.findElement(By.xpath("(//span[@class='a-price']/span[@class='a-offscreen'])[1]"));
			String prodPrice = price.getText();
			System.out.println("Product Price : " + prodPrice);
			
			driver.findElement(By.id("add-to-cart-button")).click();
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
		}
	

}
