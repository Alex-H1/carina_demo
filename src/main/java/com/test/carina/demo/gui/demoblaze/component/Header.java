package com.test.carina.demo.gui.demoblaze.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.test.carina.demo.gui.demoblaze.pages.CartPage;
import com.test.carina.demo.gui.demoblaze.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='nava']")
    private ExtendedWebElement storeBanner;

    @FindBy(xpath = "//a[text()='Contact']")
    private ExtendedWebElement contactLink;

    @FindBy(xpath = "//a[text()='Cart']")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = "//a[text()='Home ']")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[text()='Log in']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//*[@id='nameofuser']")
    private ExtendedWebElement userBanner;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isBannerPresent(){
        return storeBanner.isElementPresent();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickContact() {
        contactLink.click();
    }

    public boolean isUserBannerPresent(){
        return userBanner.isElementPresent();
    }

    public CartPage clickCart(){
        cartLink.click();
        return new CartPage(driver);
    }

    public HomePage clickHome(){
        homeLink.click();
        return new HomePage(driver);
    }
}
