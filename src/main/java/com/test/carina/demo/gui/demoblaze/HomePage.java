package com.test.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='nava']")
    private ExtendedWebElement storeBanner;
//    @FindBy(xpath = "//a[text()='Home ']")
//    private ExtendedWebElement homeLink;
    @FindBy(xpath = "//a[text()='Contact']")
    private ExtendedWebElement contactLink;
    @FindBy(xpath = "//a[text()='Log in']")
    private ExtendedWebElement loginLink;
    @FindBy(xpath = "//*[@id='loginusername']")
    private ExtendedWebElement loginUsernameField;
    @FindBy(xpath = "//*[@id='loginpassword']")
    private ExtendedWebElement loginPasswordField;
    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Log in']")
    private ExtendedWebElement loginButton;
    @FindBy(xpath = "//*[@class='card-title']//a[text()='%s']")
    private ExtendedWebElement productTitle;
    @FindBy(xpath = "//*[@id='recipient-email']")
    private ExtendedWebElement contactEmail;
    @FindBy(xpath = "//*[@id='recipient-name']")
    private ExtendedWebElement contactName;
    @FindBy(xpath = "//*[@id='message-text']")
    private ExtendedWebElement contactMessage;
    @FindBy(xpath = "//button[text()='Send message']")
    private ExtendedWebElement sendMessageButton;



//    @FindBy(xpath = "//*[@class='carousel-inner']")
//    private ExtendedWebElement productCarosel;
//    @FindBy(xpath = "//*[@class='list-group-item']")
//    private ExtendedWebElement categoriesList;

//    @FindBy(xpath = "//*[@id='next2']")
//    private ExtendedWebElement nextPageButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(storeBanner);
    }

    public boolean isProductInPresent(String name){
        return productTitle.format(name).isElementPresent();
    }

    public ProductDescPage clickProduct(String name){
        if(productTitle.format(name) != null){
            productTitle.format(name).click();
            return new ProductDescPage(driver);
        }
        return null;
    }

    public void clickLogin(){
        loginLink.click();
    }

    public void typeLogin(String username){
        loginUsernameField.type(username);
    }

    public void typePassword(String password){
        loginPasswordField.type(password);
    }

    public void submitLogin(){
        loginButton.click();
    }

    public void clickContact(){
        contactLink.click();
    }

    public void typeEmail(String email){
        contactEmail.type(email);
    }

    public void typeName(String name){
        contactName.type(name);
    }

    public void typeMessage(String message){
        contactMessage.type(message);
    }

    public void clickSendMessage(){
        sendMessageButton.click();
    }


}
