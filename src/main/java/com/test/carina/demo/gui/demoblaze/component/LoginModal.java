package com.test.carina.demo.gui.demoblaze.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='loginusername']")
    private ExtendedWebElement loginUsernameField;
    @FindBy(xpath = "//*[@id='loginpassword']")
    private ExtendedWebElement loginPasswordField;
    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Log in']")
    private ExtendedWebElement loginButton;

    public LoginModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeLogin(String username) {
        loginUsernameField.type(username);
    }

    public void typePassword(String password) {
        loginPasswordField.type(password);
    }

    public void submitLogin() {
        loginButton.click();
    }
}
