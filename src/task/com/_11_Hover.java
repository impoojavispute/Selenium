package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _11_Hover 
{
	WebDriver driver;
	String url = "https://demoqa.com/menu";
	
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
		WebElement mainItem2 = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
		
		WebElement subSubList = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
		
		WebElement subSUbListItem2 = driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(mainItem2).perform();
		
		action.moveToElement(subSubList).perform();
		
		action.moveToElement(subSUbListItem2).build().perform();
		
		
		
	}
	
	@After
	public void after()
	{
		driver.quit();
	}
}
