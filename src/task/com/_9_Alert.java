package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _9_Alert 
{
	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/javascript_alerts";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void test1()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().dismiss();
		
	}
	
	@Test
	public void test2()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().sendKeys("Selenium");
		driver.switchTo().alert().accept();
	}
	
	@After
	public void after()
	{
		driver.quit();
	}
	
}
