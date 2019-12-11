package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class HomePage {

    public HomePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(xpath="//div[contains(@id,'product_')]")
    private WebElement products;


}
