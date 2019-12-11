package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManger;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManger {
    public static WebDriver driver;
    public BasePage basePage;
    public LoginPage loginPage;


    /*@BeforeTest
    public void getUsernamePassword()
    {

       // String username= config.getProperty("username");
        //String password=config.getProperty("password");
    }*/

    @Test(dataProvider = "loginCredentials",dataProviderClass = loginCredentials.class)
    public void login(String username,String password)
    {
        basePage=new BasePage();
        loginPage=basePage.clickLoginButton();
        loginPage.login(username,password);

        String logInlink="//a[text()='Login']";
        String emailinput="//input[@id='spree_user_email']";
        String passwordinput ="//input[@id='spree_user_password']";
        String login="//input[@class='btn btn-lg btn-success btn-block']";

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

        /*List<WebElement>products= driver.findElements(By.xpath("//a[@class='d-block text-center']"));

        int noofproducts= products.size();
        System.out.println(noofproducts);*/



    }

}