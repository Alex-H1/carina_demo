package com.test.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.test.carina.demo.gui.demoblaze.pages.CartPage;
import com.test.carina.demo.gui.demoblaze.pages.HomePage;
import com.test.carina.demo.gui.demoblaze.pages.ProductDescPage;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeTest implements IAbstractTest {

    @Test
    @TestPriority(Priority.P0)
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        String testProduct = "Samsung galaxy s6";
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        Assert.assertTrue(homePage.getProductCard().isProductTitlePresent(testProduct), "Product is not present");
        ProductDescPage productDescPage = homePage.getProductCard().clickProductTitle(testProduct);
        Assert.assertTrue(productDescPage.isPageOpened(), "Product Page is not open");
        CartPage cartPage = productDescPage.clickAddToCart();
        productDescPage.getHeader().clickCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page is not opened");
        Assert.assertTrue(cartPage.isProductInCart(testProduct), "product is not in the cart");

    }

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        homePage.getHeaderComponent().clickLogin();
        homePage.getLoginModal().typeLogin(R.TESTDATA.get("username"));
        homePage.getLoginModal().typePassword(R.TESTDATA.get("password"));
        homePage.getLoginModal().clickSubmitLogin();
        Assert.assertTrue(homePage.getHeaderComponent().isUserBannerPresent(), "Welcome, username banner is not present");

    }

    @Test
    public void testContactUs() {
        HomePage homePage = new HomePage(getDriver());
        String email = "email";
        String name = "name";
        String message = "message";
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        homePage.getHeaderComponent().clickContact();
        homePage.getContactModal().typeEmail(email);
        homePage.getContactModal().typeName(name);
        homePage.getContactModal().typeMessage(message);
        homePage.getContactModal().clickSendMessage();
        Assert.assertTrue(homePage.isPageOpened(), "Contact Us message unsuccessfully sent");

    }

    @Test
    void testGoHome() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        String testProduct = "Samsung galaxy s6";
        ProductDescPage productDescPage = homePage.getProductCard().clickProductTitle(testProduct);
        Assert.assertTrue(productDescPage.isPageOpened(), "Product Page is not open");
        productDescPage.getHeader().clickHome();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }
}
