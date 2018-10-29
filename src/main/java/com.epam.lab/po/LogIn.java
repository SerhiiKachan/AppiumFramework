package com.epam.lab.po;

import com.epam.lab.model.User;
import com.epam.lab.util.Parser;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    private User user;
    private final Logger LOG = Logger.getLogger(LogIn.class);

    @FindBy(id = "identifierId")
    private WebElement email;

    @FindBy(id = "identifierNext")
    private WebElement emailNextButton;

    @FindBy(xpath = "//android.widget.EditText[@password='true']")
    private WebElement password;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    @FindBy(xpath = "//*[@content-desc='Не интересно']")
    private WebElement decline;

    public LogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        user = Parser.parse("./src/test/resources/user.xml");
    }

    public void enterCredentials(){
        LOG.info("Entering email");
        email.sendKeys(user.getEmail());
        LOG.info("Tap 'Next'");
        emailNextButton.click();
        LOG.info("Entering password");
        password.sendKeys(user.getPassword());
        LOG.info("Tap 'Next'");
        passwordNextButton.click();
        if (decline.isDisplayed()){
            decline.click();
        }
    }
}