package com.richard.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Map;

public class RichardTest {

    private Map<String, String> profiles;
    private EnvConfig envConfig = new EnvConfig();

    @Before
    public void setUp() {
        profiles = envConfig.getProfiles();
    }

    @Test
    public void openPageTest() {
        getWebDriver().navigate().to("http://www.bbc.co.uk/football");
    }

    private WebDriver getWebDriver() {

        switch (profiles.get("browser-name")) {

        case "chrome":
            return new ChromeDriver();
        case "firefox":
            return new FirefoxDriver();
        case "ie11":
            return new InternetExplorerDriver();
        default:
            return new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
    }
}
