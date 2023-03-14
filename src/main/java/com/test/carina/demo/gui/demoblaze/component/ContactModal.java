package com.test.carina.demo.gui.demoblaze.component;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactModal extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='recipient-email']")
    private ExtendedWebElement contactEmail;

    @FindBy(xpath = "//*[@id='recipient-name']")
    private ExtendedWebElement contactName;

    @FindBy(xpath = "//*[@id='message-text']")
    private ExtendedWebElement contactMessage;

    @FindBy(xpath = "//button[text()='Send message']")
    private ExtendedWebElement sendMessageButton;

    public ContactModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeEmail(String email) {
        contactEmail.type(email);
    }

    public void typeName(String name) {
        contactName.type(name);
    }

    public void typeMessage(String message) {
        contactMessage.type(message);
    }

    public void clickSendMessage() {
        sendMessageButton.click();
    }
}
