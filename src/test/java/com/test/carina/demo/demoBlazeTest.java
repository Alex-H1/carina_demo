package com.test.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.test.carina.demo.gui.demoblaze.CartPage;
import com.test.carina.demo.gui.demoblaze.HomePage;
import com.test.carina.demo.gui.demoblaze.ProductDescPage;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class demoBlazeTest implements IAbstractTest {

    @Test
    @TestPriority(Priority.P0)
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        String testProduct = "Samsung galaxy s6";
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        Assert.assertTrue(homePage.isProductInPresent(testProduct), "Product is not present");
        ProductDescPage productDescPage = homePage.clickProduct(testProduct);
        Assert.assertTrue(productDescPage.isPageOpened(), "Product Page is not open");
        CartPage cartPage = productDescPage.clickAddToCart();
        productDescPage.clickCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page is not opened");
        Assert.assertTrue(cartPage.isProductInCart(testProduct), "product is not in the cart");

    }
    @Test
    public void testLogin(){
        HomePage homePage = new HomePage(getDriver());
        String username = "username";
        String password = "password";
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        homePage.clickLogin();
        homePage.typeLogin(username);
        homePage.typePassword(password);
        homePage.submitLogin();
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
        homePage.clickContact();
        homePage.typeEmail(email);
        homePage.typeName(name);
        homePage.typeMessage(message);
        homePage.clickSendMessage();
        Assert.assertTrue(homePage.isPageOpened(), "About Us successfully sent");


    }
}
