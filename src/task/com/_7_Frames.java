package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_Frames
{
	WebDriver driver;
	String url = "https://practice.expandtesting.com/iframe?utm_source=chatgpt.com";
	
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
		driver.switchTo().frame("mce_0_ifr");
		WebElement editor = driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']"));
		editor.clear();
		editor.sendKeys("Hello Automation");
	}
	
	
	@Test
	public void test1()
	{
		driver.switchTo().frame("email-subscribe");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("abc@gmail.com");
		
		
	}
	
	@After
	public void after()
	{
		driver.close();
	}
}