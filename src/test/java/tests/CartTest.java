package tests;

import base.Hooks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.StorePage;

public class CartTest extends Hooks {

    HomePage homePage;
    StorePage storePage;
    ProductPage productPage;
    CartPage cartPage;


    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
        storePage = new StorePage(getDriver());
        productPage = new ProductPage(getDriver());
        cartPage = new CartPage(getDriver());
    }

//    @Test
//    public void titleTest2() {
//        homePage.click(homePage.storeLinkBtn);
//        storePage.click(storePage.tshirtItem);
//        productPage.selectSize("M");
//        productPage.click(productPage.addToCartBtn);
//        productPage.click(productPage.proceedToCheckoutBtn);
//        cartPage.click(cartPage.cartVoucherBtn);
//        cartPage.sendKeys(cartPage.promoCodeField, cartPage.PROMO_CODE);
//        cartPage.click(cartPage.addPromoCodeBtn);
//        cartPage.click(cartPage.proceedToCheckoutWithShippingBtn);
//    }

    @Test
    public void test() {
        homePage.click(homePage.storeLinkXpath);
        Assert.assertEquals(getDriver().getTitle(), "teststore");
    }
}
