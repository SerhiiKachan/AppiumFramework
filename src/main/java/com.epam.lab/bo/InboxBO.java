package com.epam.lab.bo;

import com.epam.lab.po.Inbox;
import org.openqa.selenium.WebDriver;

public class InboxBO {

    private Inbox inbox;

    public InboxBO(WebDriver driver) {
        inbox = new Inbox(driver);
    }

    public boolean isUserAuthorized(){
        return inbox.isUserLoggedIn();
    }
}
