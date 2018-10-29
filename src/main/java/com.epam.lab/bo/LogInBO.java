package com.epam.lab.bo;

import com.epam.lab.po.LogIn;
import org.openqa.selenium.WebDriver;

public class LogInBO {

    private LogIn logIn;

    public LogInBO(WebDriver driver) {
        logIn = new LogIn(driver);
    }

    public void authorize(){
        logIn.enterCredentials();
    }
}