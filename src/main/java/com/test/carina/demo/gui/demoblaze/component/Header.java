package com.test.carina.demo.gui.demoblaze.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@id='nava']")
    private ExtendedWebElement storeBanner;

    @FindBy(xpath = "//a[text()='Contact']")
    private ExtendedWebElement contactLink;

    @FindBy(xpath = "//a[text()='Log in']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//*[@id='nameofuser']")
    private ExtendedWebElement userBanner;
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getStoreBanner() {
        return storeBanner;
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
}
