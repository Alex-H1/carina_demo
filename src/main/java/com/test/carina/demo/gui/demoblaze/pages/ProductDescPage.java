package com.test.carina.demo.gui.demoblaze.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.test.carina.demo.gui.demoblaze.component.Header;
import com.test.carina.demo.gui.demoblaze.component.ProductCard;
import com.test.carina.demo.gui.demoblaze.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDescPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//*[@class='price-container']")
    private ExtendedWebElement price;

    @FindBy(xpath = "//*[@class='row']//a[text()='Add to cart']")
    private ExtendedWebElement addToCart;

    @FindBy(xpath = "//*[@class='card-block']//h4")
    private ProductCard productCard;

    @FindBy(xpath = "//nav")
    private Header header;

    public ProductDescPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
    }

    public Header getHeader() {
        return header;
    }

    public CartPage clickAddToCart(){
        addToCart.click();
        return new CartPage(getDriver());
    }

    public ProductCard getProductCard() {
        return productCard;
    }

    public boolean isProductPresent(){
        return productName.isElementPresent();
    }
}
