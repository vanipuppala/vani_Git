package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManger;
import util.DriverManager;

public class CheckOutPage extends SuiteManger {
    public CheckOutPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(xpath = "//h1[text()='Checkout']")

    private WebElement titleofcheckoutpage;

    @FindBy(xpath = "//input[@class='btn btn-lg btn-success']")
    private WebElement saveandContinue;

    public String getTitleofCheckOutPage()
    {
        titleofcheckoutpage.getText();
        return new String();
    }
    public void clickonSaveandContinue()
    {
        saveandContinue.click();
    }
}
