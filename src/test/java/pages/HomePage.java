package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import suite.SuiteManger;
import util.DriverManager;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class HomePage  extends SuiteManger {

    public HomePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(xpath="//div[contains(@id,'product_')]")
    private WebElement products;

    @FindBy(xpath = "//input[@id='keywords']")
    private WebElement search;

    @FindBy(xpath=("//div[text()='Logged in successfully']"))
    private WebElement successmessage;


    @FindBy(xpath = ("//input[@class='btn btn-success']"))
    private WebElement searchbtn;


    @FindAll(@FindBy(xpath = ("//span[@class='info mt-3 d-block']")))
    private List<WebElement> productList;

    private int noofproducts;


    public String getsuccessmsg()
    {

        return successmessage.getText();
       /* String actual_successMessage=DriverManager.driver.findElement(successmessage).getText();
        System.out.println("actual_successMessage");
        String expected_successMessage="login successful";
        if((actual_successMessage).equals(expected_successMessage))
        {
            System.out.println("successful");
        }
        else
        {
            System.out.println("login fails");
        }*/

    }

    public String searchItem=config.getProperty("searchitem");

    public void searchItem()
    {
        search.click();
        search.clear();
        search.sendKeys(searchItem);
        searchbtn.click();
        //return searchItem;

        /*String searchbox="//input[@id='keywords']";

        String searchItem=config.getProperty("searchitem");
        String searchbutton="//input[@class='btn btn-success']";

        DriverManager.driver.findElement(By.xpath(searchbox)).sendKeys(searchItem);
        DriverManager.driver.findElement(By.xpath(searchbutton)).click();

        /*List<WebElement>products= driver.findElements(By.xpath("//a[@class='d-block text-center']"));

        int noofproducts= products.size();
        System.out.println(noofproducts);*/
    }


    public List getnoofproducts() {

        List<WebElement> allProducts = productList;
        //List<WebElement> Products =DriverManager.driver.findElements(By.tagName("a"));
        // List<WebElement> noOfProducts1 =DriverManager.driver.findElements(By.xpath("//a[@class='d-block text-center']"));
        int noofproducts = allProducts.size();
        System.out.println("Total no of products" + noofproducts);
        return allProducts;

    }
        public List getproductnames()
        {
            List<String >productNames = new ArrayList<String>();

            for(int i=1;i<=noofproducts;i++)
            {
                productList.get(i).getText();
                //productNames.add(productList.get(i).getText());
                System.out.println(productNames);
            }
            return productNames;



    }

    public void checkformatchproducts()
    {



    }



    public void addtocart()
    {
        DriverManager.driver.findElement(By.xpath("//span[text()='Ruby on Rails Tote']")).click();
    }






}
