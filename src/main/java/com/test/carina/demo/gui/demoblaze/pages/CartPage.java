package com.test.carina.demo.gui.demoblaze.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='col-lg-8']//h2")
    private ExtendedWebElement productsHeader;

    @FindBy(xpath = "//*[@class='col-lg-1']//h2")
    private ExtendedWebElement totalHeader;

    @FindBy(xpath = "//*[@class='success']//td[text()='%s']")
    private ExtendedWebElement productName;


    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsHeader);
    }

    public boolean isProductInCart(String name) {
        return productName.format(name).isElementPresent();
    }

}
