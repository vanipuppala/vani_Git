package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import suite.SuiteManger;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManger {
    public static WebDriver driver;

    /*@BeforeTest
    public void getUsernamePassword()
    {

       // String username= config.getProperty("username");
        //String password=config.getProperty("password");
    }*/

    @Test(dataProvider = "loginCredentials",dataProviderClass = loginCredentials.class)
    public void login(String username,String password)
    {

        String logInlink="//a[text()='Login']";
        String emailinput="//input[@id='spree_user_email']";
        String passwordinput ="//input[@id='spree_user_password']";
        String login="//input[text()='Login']";

        DriverManager.driver.findElement(By.xpath(logInlink)).click();
        DriverManager.driver.findElement(By.xpath(emailinput)).sendKeys(username);
        DriverManager.driver.findElement(By.xpath(passwordinput)).sendKeys(password);
        DriverManager.driver.findElement(By.xpath(login)).click();

    }

    @Test()

    public void searchItem()
    {


        String searchbox="//input[@id='keywords']";
        String searchbutton="//input[@class='btn btn-success']";
        String searchItem=config.getProperty("searchitem");

        DriverManager.driver.findElement(By.xpath(searchbox)).sendKeys(searchItem);
        DriverManager.driver.findElement(By.xpath(searchbutton)).click();
    }

}