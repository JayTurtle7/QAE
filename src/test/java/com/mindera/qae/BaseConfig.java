package com.mindera.qae;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseConfig {

    private WebDriver driver;
    private DesiredCapabilities desiredCapabilities;

    @BeforeMethod(groups = {"smoke", "regression"})
    @Parameters({"browserName"})
    public void setUp(
            @Optional("firefox") String browserName
    ) throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", browserName);
        desiredCapabilities.setCapability("acceptInsecureCerts", true);
      //  driver = new FirefoxDriver();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        setWebDriver(driver);
    }

    @AfterMethod(groups = {"smoke", "regression"})
    public void closeBrowser() {
        driver.quit();
    }

}