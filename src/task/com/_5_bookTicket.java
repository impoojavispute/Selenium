package task.com;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _5_bookTicket    // code is incomplete. ip address blocked. task - book random seat for a play .
{

	WebDriver driver;
	String Url = "https://in.bookmyshow.com/";
	@Before
	public void before()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		//open in incognito mode
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
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
	    
	    //select play 
	    driver.findElement(By.xpath("//div[contains(text(),'Sangeet Devbabhali')]")).click();
	    driver.findElement(By.xpath("//div[@class='sc-pxa29k-0 KSTIO']")).click();
	    
	    
	    
	}

}
