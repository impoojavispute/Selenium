package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_Todo_List 
{
	
	WebDriver driver;
	String url = "https://lambdatest.github.io/sample-todo-app/";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		//add 3 task 
		driver.findElement(By.xpath("//input[@id='sampletodotext']")).sendKeys("Buy Milk");
		driver.findElement(By.xpath("//input[@id='addbutton']")).click();
		driver.findElement(By.xpath("//input[@id='sampletodotext']")).sendKeys("Learn Java");
		driver.findElement(By.xpath("//input[@id='addbutton']")).click();
		driver.findElement(By.xpath("//input[@id='sampletodotext']")).sendKeys("Practise Selenium");
		driver.findElement(By.xpath("//input[@id='addbutton']")).click();
		
		//learn java completed 
		driver.findElement(By.xpath("//input[@name='li7']")).click();
		
		//delete first task 
		driver.findElement(By.xpath("//input[@id='sampletodotext']")).click();
		
		
	}
	
	
	@After
	public void after()
	{
		driver.close();
		
	}
	
	
	
	
	
	

}
