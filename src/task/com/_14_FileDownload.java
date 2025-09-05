 package task.com;



 import java.io.File;
 import java.util.HashMap;
 import java.util.Map;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.chrome.ChromeOptions;

 public class _14_FileDownload 
 {
     public static void main(String[] args) throws InterruptedException 
     {
         // Set download directory
         String downloadPath = "C:\\Users\\Pooja\\Downloads\\selenium";

         Map<String, Object> prefs = new HashMap<>();
         prefs.put("download.default_directory", downloadPath); // custom folder
         prefs.put("download.prompt_for_download", false);
         prefs.put("download.directory_upgrade", true);

         ChromeOptions options = new ChromeOptions();
         options.setExperimentalOption("prefs", prefs);

         WebDriver driver = new ChromeDriver(options);
         driver.get("https://the-internet.herokuapp.com/download");

         // Click on file link to download
         driver.findElement(By.linkText("some-file.txt")).click();

         // Wait for file to download
         Thread.sleep(5000);

         // Verify file exists
         File f = new File(downloadPath + "\\some-file.txt");
         if (f.exists()) {
             System.out.println("File Downloaded Successfully!");
         } else {
             System.out.println("File Not Found!");
         }

         driver.quit();
     }
 }
