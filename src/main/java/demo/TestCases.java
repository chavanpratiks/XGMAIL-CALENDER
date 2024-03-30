package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

import javax.swing.plaf.TableHeaderUI;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");

        String actualUrl =driver.getCurrentUrl();
        String expectedUrl ="calendar";
        if(actualUrl.contains(expectedUrl)){
            System.out.println("TestCase01 Url contains:: Passed!");
        }else{
            System.out.println("TestCase01 Url contains:: Failed!");
        }
        System.out.println("end Test case: testCase01");
    }


    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        //select month selecter
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/button[@aria-haspopup='menu']")).click();
        Thread.sleep(3000);

        List<WebElement> dropDown = driver.findElements(
                By.xpath("//li[@data-viewkey='month']"));
        for(WebElement element: dropDown){
            String elementText = element.getText();
            if(elementText.contains("Month")){
                element.click();
                break;
            }
        }

        //select Today Date of add noties :- Crio INTV Task Automation
        Thread.sleep(5000);
         driver.findElement(By.xpath("//div[5]//div[3]//div[1]//div[7]")).click();

        Thread.sleep(2000);
         driver.findElement(By.xpath("//button[@id='tabTask']")).click();
        Thread.sleep(3000);
         driver.findElement(By.xpath("//input[@aria-label='Add title and time']")).sendKeys("Crio INTV Task Automation");
        Thread.sleep(3000);
        //send key "Description"
         driver.findElement(By.xpath("//textarea[@placeholder='Add description']")).sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(3000);
        // Click the Save button
         driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();


        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {

        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");

//  //select month selecter
//  Thread.sleep(3000);
//  driver.findElement(By.xpath("//div/button[@aria-haspopup='menu']")).click();
//  Thread.sleep(3000);

//  List<WebElement> dropDown = driver.findElements(
//          By.xpath("//li[@data-viewkey='month']"));
//  for(WebElement element: dropDown){
//      String elementText = element.getText();
//      if(elementText.contains("Month")){
//          element.click();
//          break;
//      }
//  }

        Thread.sleep(8000);
        driver.findElement(By.xpath("//h2[@data-datekey='27774']")).click();
        //click existing task
         Thread.sleep(6000);
         driver.findElement(By.xpath("(//div[@role='presentation']/div/div/span)[1]")).click();
        //click on the edit button
        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@aria-label='Edit task']")).click();

        //Replace text
         driver.findElement(By.xpath("//textarea[@placeholder='Add description']")).clear();
         driver.findElement(By.xpath("//textarea[@placeholder='Add description']")).sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        //click on the Save Button
         driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();

        //verify text
         driver.findElement(By.xpath("//div[@jslog='185338; track:impression,click,dblclick']")).click();
         Thread.sleep(3000);

         WebElement verification = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
         String verificationText = verification.getText();
         if(verificationText.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")){
             System.out.println("TestCase 03: Passed");
         }
         else {
             System.out.println("TestCase 03: Failed");
         }
 System.out.println("end Test case: testCase03");

     }

    public void testCase004() throws InterruptedException {
        System.out.println("end Test case: testCase04");
        driver.get("https://calendar.google.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/button[@aria-haspopup='menu']")).click();
        Thread.sleep(3000);

        List<WebElement> dropDown = driver.findElements(
                By.xpath("//li[@data-viewkey='month']"));
        for(WebElement element: dropDown){
            String elementText = element.getText();
            if(elementText.contains("Month")){
                element.click();
                break;
            }
        }

    


        Thread.sleep(5000);
        driver.findElement(By.xpath("//h2[@data-datekey='27774']")).click();
        //click existing task
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@jscontroller=\"YVjRCf\"]")).click();

        

        //Check title is correct
         WebElement tastLitle =driver.findElement(By.xpath("//span[@id='rAECCd']"));
        String tastLitleVerify =tastLitle.getText();
         if(tastLitleVerify.contains("Crio INTV Task Automation")){
            System.out.println("TestCase04 Task Title verify:: Passed!");
         }else{
             System.out.println("TestCase04 Task Title verify:: Failed!");
         }
        Thread.sleep(3000);

        //delete the task
        driver.findElement(By.xpath("//button[@aria-label='Delete task']")).click();

        //verify task is deleted
        WebElement deleteTask =driver.findElement(By.xpath("//div[@class = 'VYTiVb']"));
        String deleteTaskVerify =deleteTask.getText();

        if(deleteTaskVerify.contains("Task deleted")){
            System.out.println("TestCase04 Task Deleted:: Passed!");
        }
        else{
            System.out.println("TestCase04 Task Deleted:: Failed!");
        }

        System.out.println("end Test case: testCase04");
    }

    }