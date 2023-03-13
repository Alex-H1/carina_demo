package com.test.carina.demo.gui.demoblaze.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.test.carina.demo.gui.demoblaze.component.ContactModal;
import com.test.carina.demo.gui.demoblaze.component.Header;
import com.test.carina.demo.gui.demoblaze.component.LoginModal;
import com.test.carina.demo.gui.demoblaze.component.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='card-block']//h4")
    private ProductCard productCard;

    @FindBy(xpath = "//nav")
    private Header headerComponent;

    @FindBy(xpath = "//*[@id='logInModal']")
    private LoginModal loginModal;

    @FindBy(xpath = "//*[@id='exampleModal']")
    private ContactModal contactModal;

    @FindBy(xpath = "//*[@class='carousel-inner']")
    private ExtendedWebElement jumboTron;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(jumboTron);
    }

    public ProductCard getProductCard(){
        return this.productCard;
    }

    public Header getHeaderComponent() {
        return headerComponent;
    }

    public LoginModal getLoginModal() {
        return loginModal;
    }

    public ContactModal getContactModal() {
        return contactModal;
    }
}
