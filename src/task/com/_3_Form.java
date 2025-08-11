package task.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _3_Form 
{
	WebDriver driver;
	String Url = "https://www.techlistic.com/p/selenium-practice-form.html";
	
	@Before
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(Url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pooja");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Vispute");
		driver.findElement(By.xpath("//input[@id='sex-1']")).click();
		driver.findElement(By.xpath("//input[@id='exp-3']")).click();
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("14 / 06 / 1996");
		driver.findElement(By.xpath("//input[@id='profession-1']")).click();
		driver.findElement(By.xpath("//input[@id='tool-2']")).click();
		
		Select dropdown = new Select (driver.findElement(By.xpath("//select[@id='continents']")));
		dropdown.selectByIndex(3);
		
		Select dropdown2 = new Select (driver.findElement(By.xpath("//select[@id='selenium_commands']")));
		dropdown2.selectByVisibleText("Wait Commands");
		
		
		driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\Users\\User\\Downloads\\test.jpg");
		
		System.out.println("First Name: " + driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value"));
		System.out.println("Last Name: " + driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value"));
		System.out.println("Gender: " + driver.findElement(By.xpath("//input[@id='sex-1']")).getAttribute("value"));
		System.out.println("Exprience: " + driver.findElement(By.xpath("//input[@id='exp-3']")).getAttribute("value"));
		System.out.println("Date: " + driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value"));
		System.out.println("Profession: " + driver.findElement(By.xpath("//input[@id='profession-1']")).getAttribute("value") );
		System.out.println("Automation Tool: " + driver.findElement(By.xpath("//input[@id='tool-2']")).getAttribute("value"));
		System.out.println("Continents: " + dropdown.getFirstSelectedOption().getText());
		System.out.println("Selenium Commands:" + dropdown2.getFirstSelectedOption().getText());
		
		
	}
	
	@After
	public void after()
	{
		driver.close();
	}

}
