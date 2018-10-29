package com.epam.lab.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserMain {

    private final Logger LOG = Logger.getLogger(BrowserMain.class);

    @FindBy(id = "url_field")
    private WebElement url;

    @FindBy(xpath = "//*[@content-desc='Load URL']")
    private WebElement searchButton;

    public BrowserMain(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void search(){
        LOG.info("Typing into searchbox");
        url.sendKeys("www.gmail.com");
        LOG.info("Tap 'Search'");
        searchButton.click();
    }
}
