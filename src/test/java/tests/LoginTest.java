package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    public HomePage homePage;


    /*@BeforeTest
    public void getUsernamePassword()
    {

       // String username= config.getProperty("username");
        //String password=config.getProperty("password");
    }*/

    @Test(dataProvider = "loginCredentials",dataProviderClass = loginCredentials.class)
    public void login(String username,String password) throws InterruptedException {
        basePage=new BasePage();
        loginPage=basePage.clickLoginButton();
        homePage = loginPage.login(username,password);

        Assert.assertEquals(homePage.getsuccessmsg(),"Logged in successfully");

        homePage.searchItem();

        homePage.getnoofproducts();
        homePage.getproductnames();

       /* String logInlink="//a[text()='Login']";
        String emailinput="//input[@id='spree_user_email']";
        String passwordinput ="//input[@id='spree_user_password']";
        String login="//input[@class='btn btn-lg btn-success btn-block']";

        DriverManager.driver.findElement(By.xpath(logInlink)).click();
        DriverManager.driver.findElement(By.xpath(emailinput)).sendKeys(username);
        DriverManager.driver.findElement(By.xpath(passwordinput)).sendKeys(password);
        DriverManager.driver.findElement(By.xpath(login)).click();*/

    }




}