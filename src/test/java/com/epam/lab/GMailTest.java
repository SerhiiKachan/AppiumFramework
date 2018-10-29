package com.epam.lab;

import com.epam.lab.bo.BrowserMainBO;
import com.epam.lab.bo.InboxBO;
import com.epam.lab.bo.LogInBO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GMailTest {

    private AppiumDriver driver;
    private BrowserMainBO browserMainBO;
    private LogInBO logInBO;
    private InboxBO inboxBO;

    @BeforeTest
    public void initialize() throws MalformedURLException {
        PropertyConfigurator.configure("./src/main/properties/log4j.properties");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability("appPackage", "org.chromium.webview_shell");
        capabilities.setCapability("appActivity", ".WebViewBrowserActivity");
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browserMainBO = new BrowserMainBO(driver);
        logInBO = new LogInBO(driver);
        inboxBO = new InboxBO(driver);
    }

    @Test
    public void loggingTest() {
        browserMainBO.goToGmail();
        logInBO.authorize();
        Assert.assertTrue(inboxBO.isUserAuthorized(), "User hasn't been authorized");
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
