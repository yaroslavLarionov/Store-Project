package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "group_1")
    public WebElement sizeSelector;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='cart-content-btn']//a")
    public WebElement proceedToCheckoutBtn;

    public void selectSize(String size) {
        Select select = new Select(sizeSelector);
        select.selectByVisibleText(size);
    }

}
