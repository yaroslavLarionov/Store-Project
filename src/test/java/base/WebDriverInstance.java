package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import utils.ConfigReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverInstance {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void createDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.merge(capabilities);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(options));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;
            default:
                throw new RuntimeException("Please provide correct browser value");
        }
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public static void cleanupDriver() {
        driver.get().quit();
        driver.remove();
    }
}
