package task.com;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class _13_FileUpload {
    WebDriver driver;
    String downloadPath = "C:\\Users\\User\\eclipse-workspace\\SeleniumAutomation\\DownloadSamples";

    @Before
    public void before() 
    {
        // Chrome preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");
    }

    @Test
    public void testFileDownload() throws InterruptedException 
    {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("some-file.txt")).click();

        Thread.sleep(5000); // wait for download

        File f = new File(downloadPath + "\\some-file.txt");
        if (f.exists()) 
        {
            System.out.println("File Downloaded Successfully!");
        } 
        else 
        {
            System.out.println("File Not Found!");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
