package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import suite.SuiteManger;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManger {
    public static WebDriver driver;

    @Test
    public void login()
    {
        //Chromedriver setup

        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver-2");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}