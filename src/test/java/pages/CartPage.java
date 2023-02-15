package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    protected  WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public final String PROMO_CODE = "20OFF";

    @FindBy(xpath = "//div[@class='cart-voucher']//a")
    public WebElement cartVoucherBtn;

    @FindBy(name = "discount_name")
    public WebElement promoCodeField;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary']")
    public WebElement addPromoCodeBtn;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    public WebElement proceedToCheckoutWithShippingBtn;




}
