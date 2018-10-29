package com.epam.lab.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inbox {

    private final Logger LOG = Logger.getLogger(Inbox.class);


    @FindBy(xpath = "//*[@content-desc='Меню']")
    private WebElement menu;

    @FindBy(xpath = "//*[@content-desc='serkach.test@gmail.com']")
    private WebElement expectedEmail;

    public Inbox(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isUserLoggedIn(){
        LOG.info("Go to menu");
        menu.click();
        LOG.info("Verify whether user is logged in");
        return expectedEmail.isDisplayed();
    }
}
