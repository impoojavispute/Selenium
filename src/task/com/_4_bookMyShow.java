package task.com;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_bookMyShow 
{

	WebDriver driver;
	String Url = "https://in.bookmyshow.com/";
	@Before
	public void before()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(Url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test() throws InterruptedException
	{
		
	    //Select Pune Location 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Pune']"))).click();
	    
	    //Select Plays option
	    driver.findElement(By.xpath("//a[normalize-space()='Plays']")).click();
	    
		//wait until play screen load 
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='sc-b1h692-8 kgjaGy']")));
	    
	    //list of plays 
	    List<WebElement> plays = driver.findElements(By.xpath("//div[@class='sc-b1h692-8 kgjaGy']"));
	    
	    //print titles 
	    System.out.println("List Plays in Pune:");
	    for (WebElement play : plays) 
	    {
	        String title = play.getText();
	        System.out.print("- " + title);
	        System.out.println("   ");
	        
	    }
		
	}
	
	
	@After
	public void after()
	{
		driver.close();
	}
	
	
	
	
	
	
}
