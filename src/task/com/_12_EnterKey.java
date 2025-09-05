package task.com;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _12_EnterKey 
{
	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/key_presses";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException
	{
		WebElement page = driver.findElement(By.xpath("//html"));
		//searchBox.click();
	    page.sendKeys(Keys.ENTER);
	    //Thread.sleep(3000);
	    //searchBox.sendKeys(Keys.ENTER);
	    
	   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	   // searchBox.sendKeys(Keys.ENTER);
	    
	    String afterEnter = driver.findElement(By.xpath("//p[@id='result']")).getText();
	    
	    if(afterEnter.equals("You entered: ENTER"))
			System.out.println("Key Pressed");
		else
			System.out.println("Key Not Pressed");
	}
	
	@After
	public void after()
	{
	driver.quit();
	}
}