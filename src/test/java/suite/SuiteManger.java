package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManger {

    DriverManager driverManager;
    private static ConfigFileReader config =new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)

    public void startDriver()
    {
        driverManager=new DriverManager();
    }


    @AfterSuite(alwaysRun = true)
    public void quitDriver()
    {
        DriverManager.driver.quit();
    }

    public void launchuUrl()
    {
        DriverManager.driver.manage().window().maximize();
        String baseUrl=config.getProperty("base_url");
        DriverManager.driver.get(baseUrl);

    }
}
