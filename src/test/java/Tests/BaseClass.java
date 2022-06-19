package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class BaseClass {
   public static WebDriver driver;
   public static  WebDriverWait wait;
    @BeforeMethod
    public WebDriver SetUp() throws InterruptedException {

        By LoginButton = By.xpath("//button[@type='button']");
        By DeloitteIdButton = By.xpath("(//input[@type='button'])[2]");
        By MailIdField = By.xpath("//input[@type='email']");
        By SubmitButton = By.xpath("//input[@type='submit']");


        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers//driver//Chromedriver//chromedriver.exe");
        File file = new File("C://Users//bochandana//IdeaProjects//AE//src//test//Config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("Url"));
        driver.findElement(LoginButton).click();
        driver.findElement(DeloitteIdButton).click();
        driver.findElement(MailIdField).sendKeys(prop.getProperty("Email"));
        driver.findElement(SubmitButton).click();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        return driver;






    }
    @AfterMethod
    public void tearDown() {
        // System.out.println("driver="+driver);
      //  driver.quit();
    }



}


