package com.test.carina.demo.gui.demoblaze.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.test.carina.demo.gui.demoblaze.ProductDescPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//*[@class='card-title']//a[text()='%s']")
    private ExtendedWebElement productTitle;

    public ProductDescPage clickProduct(String name) {
        productTitle.format(name).click();
        return new ProductDescPage(driver);

    }
    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductInPresent(String name) {
        return productTitle.format(name).isElementPresent();
    }
}
