package com.test.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.test.carina.demo.gui.demoblaze.CartPage;
import com.test.carina.demo.gui.demoblaze.HomePage;
import com.test.carina.demo.gui.demoblaze.ProductDescPage;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
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
        productDescPage.clickCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page is not opened");
        Assert.assertTrue(cartPage.isProductInCart(testProduct), "Product is not in the cart");

    }
    @Test
    public void testLogin(){
        HomePage homePage = new HomePage(getDriver());
        String username = "username";
        String password = "password";
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        homePage.getHeaderComponent().clickLogin();
        homePage.getLoginModal().typeLogin(username);
        homePage.getLoginModal().typePassword(password);
        homePage.getLoginModal().clickSubmitLogin();
        Assert.assertTrue(homePage.isPageOpened(), "Login Unsuccessful ");

    }

    @Test
    public void testContactUs(){
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
        Assert.assertTrue(homePage.isPageOpened(), "About Us successfully sent");


    }
}
