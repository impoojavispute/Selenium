package task.com;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _15_ShadowDom 
{
	WebDriver driver;
	String url = "https://shop.polymer-project.org/";
	
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
		
		WebElement shopApp = driver.findElement(By.cssSelector("shop-app[page='home']")); // top shadow dom 
		SearchContext shopAppShadow =  shopApp.getShadowRoot(); // enter in shopApp 
		
		WebElement shopHome = shopAppShadow.findElement(By.cssSelector(".iron-selected")); //  sjophome - second dom
		SearchContext shopHomeShadow = shopHome.getShadowRoot(); // enter in Shop Home 
		
		WebElement shopNowBtn = shopHomeShadow.findElement(By.cssSelector("a[aria-label=\"Men's Outerwear Shop Now\"]"));
		shopNowBtn.click();
		
		 // If clicked successfully, you should be on the product list page
        System.out.println("Current URL: " + driver.getCurrentUrl());
	}

}
