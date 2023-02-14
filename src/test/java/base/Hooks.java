package base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class Hooks extends BasePage {

    @BeforeMethod
    public void setUp() {
        getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            WebDriverInstance.cleanupDriver();
        }
    }

}
