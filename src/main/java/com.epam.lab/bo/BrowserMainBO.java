package com.epam.lab.bo;

import com.epam.lab.po.BrowserMain;
import org.openqa.selenium.WebDriver;

public class BrowserMainBO {

    private BrowserMain browserMain;

    public BrowserMainBO(WebDriver driver) {
        browserMain = new BrowserMain(driver);
    }

    public void goToGmail(){
        browserMain.search();
    }
}
