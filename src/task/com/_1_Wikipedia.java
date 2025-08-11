package task.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1_Wikipedia 
{
	
	public static void main(String[] args) 
    {
		
		
	
       
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

       
        WebDriver driver = new ChromeDriver();

     
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium (software)");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Selenium (software)"));
        
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        
        if (actualTitle.contains("Selenium (software)"))
        {
            System.out.println("Page title contains 'Selenium (software)'.");
        } 
        else 
        {
            System.out.println("Page title validation failed. Actual: " + actualTitle);
        }
        
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headingElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")) );

        String actualHeadingText = headingElement.getText();
        String expectedHeadingText = "Selenium (software)";

        if (actualHeadingText.equals(expectedHeadingText))
        {
            System.out.println(" Page Heading matched: " + actualHeadingText);
        } 
        else
        {
            System.out.println(" Page heading mismatch. Expected: " + expectedHeadingText + ", Actual: " + actualHeadingText);
        }
        
        
        WebElement licenseHeader = driver.findElement(By.xpath("//td[@class='infobox-data']//a[@title='Apache License 2.0'][normalize-space()='Apache License 2.0']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", licenseHeader);
        
        WebElement licenseContent = licenseHeader.findElement(By.xpath("//td[@class='infobox-data']//a[@title='Apache License 2.0'][normalize-space()='Apache License 2.0']"));
        String licenseText = licenseContent.getText();

        System.out.println("License Text: " + licenseText);

       
        if (licenseText.contains("Apache")) 
        {
            System.out.println(" License contains 'Apache'.");
        } 
        else 
        {
            System.out.println(" License does not mention 'Apache'.");
        }
        
        driver.close();
        
    }
         


}

