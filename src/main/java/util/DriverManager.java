package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
   public static WebDriver driver;

    public DriverManager()
    {
        String chromeDriverPath = System.getProperty("user.dir")+"/src/resources/drivers/chromedriver-2";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
    }


}
