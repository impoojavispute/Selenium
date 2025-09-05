package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _10_Drag_Drop 
{
	WebDriver driver;
	String url = "https://demoqa.com/droppable";
	
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
		WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement toElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
		
		
		Actions actions  = new Actions(driver);
		
		actions.dragAndDrop(fromElement, toElement).perform();
		
		String afterDragging = driver.findElement(By.xpath("//p[normalize-space()='Dropped!']")).getText();
		
		if(afterDragging.equals("Dropped!"))
			System.out.println("Drag successful.");
		else
			System.out.println("Drag Unsuccessful.");
	}
	
	@After
	public void after()
	{
		driver.quit();
	}
}
