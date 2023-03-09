package com.test.carina.demo.gui.demoblaze;

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
    @FindBy(xpath = "//*[@id='narvbarx']")
    private Header headerComponent;
    @FindBy(xpath = "//*[@id='logInModal']")
    private LoginModal loginModal;
    @FindBy(xpath = "//*[@id='exampleModal']")
    private ContactModal contactModal;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(headerComponent.getStoreBanner());
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
