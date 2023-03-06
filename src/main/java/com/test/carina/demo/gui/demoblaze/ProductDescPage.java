package com.test.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.mail.Header;

public class ProductDescPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='name']")
    private ExtendedWebElement productName;
    @FindBy(xpath = "//*[@class='price-container']")
    private ExtendedWebElement price;
    @FindBy(xpath = "//*[@class='row']//a[text()='Add to cart']")
    private ExtendedWebElement addToCart;

    @FindBy(xpath = "//a[text()='Cart']")
    private ExtendedWebElement cartLink;

    public ProductDescPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
    }

    public CartPage clickAddToCart(){
        addToCart.click();
        return new CartPage(getDriver());
    }

    public CartPage clickCart(){
        cartLink.click();
        return new CartPage(driver);
    }
}
