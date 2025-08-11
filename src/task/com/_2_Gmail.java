package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_Gmail 
{
		WebDriver driver;
		String url = "https://www.google.com/";
		@Before
		public void before()
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			
			
		}
		
		
		@Test
		public void test() throws InterruptedException
		{
			driver.findElement(By.xpath("//a[@aria-label='Sign in']")).click();
			driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("impoojavispute@gmail.com");
			driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
			driver.wait(10);
			
			driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		}
		
		
		@After
		public void after()
		{
			
		}
}
