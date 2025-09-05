package task.com;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_Windows 
{
	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/windows";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
		Set <String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles)
		{
			driver.switchTo().window(handle);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			//driver.wait(20);
			if(url.equals("https://the-internet.herokuapp.com/windows/new"));
			{
				System.out.println("New WIndow Lounched");
				break;
			}
			
		}
	}
	
	@After
	public void after()
	{
		//driver.quit();
	}
}
