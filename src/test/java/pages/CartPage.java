package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManger;
import util.DriverManager;

public class CartPage extends SuiteManger {

    public CartPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(xpath = "//a[text()='Ruby on Rails Bag']")
    public WebElement ProductNameTitle;

    @FindBy(xpath = "//button[@id='checkout-link']")
   private WebElement checkout;


    public String getProductnameTitle()
    {
        ProductNameTitle.getText();
        return new String();
    }
    public CheckOutPage checkOut()
    {
        checkout.click();
        return new CheckOutPage();
    }


}
