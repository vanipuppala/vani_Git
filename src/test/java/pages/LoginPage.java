package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManger;
import util.DriverManager;

public class LoginPage extends SuiteManger {

    public LoginPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(xpath = "//input[@id='spree_user_email']")
            private WebElement email;

    @FindBy(xpath = "//input[@id='spree_user_password']")

    private WebElement pword;

    @FindBy(xpath = "//input[@name='commit']")

    private WebElement submit;



    public void enterValue(WebElement field,String value)
    {
        field.click();
        field.clear();
        field.sendKeys(value);
    }
   public HomePage login(String username,String password)
   {
       enterValue(email,username);
       enterValue(pword,password);
       submit.click();
       return new HomePage();


   }

   public String loginMessage()
   {
        return null;
   }

}
