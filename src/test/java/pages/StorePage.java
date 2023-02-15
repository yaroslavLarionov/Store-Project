package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage extends BasePage {

    protected WebDriver driver;

    public StorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Hummingbird printed t-shirt']")
    public WebElement tshirtItem;

    public final String pageTitle = "teststore";

}
