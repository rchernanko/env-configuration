package com.richard.test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RichardTest {

    private WebDriver driver;

    @Test
    public void openPageTest() {
        driver = getWebDriver();
        driver.navigate().to("http://www.bbc.co.uk/football");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private WebDriver getWebDriver() {
        return new FirefoxDriver();

        //need some way of linking the what's in the environment.yml file with which WebDriver to pass back.
        //Am not far away, but i need to go to the gym ha!
        //ifHasProperty() method. Need to work out how to inject Environment into here. I think I will have to create
        //an abstraction layer and inject the Environment file into there. So that webdriver navigate to - put it in a
        //new class and then have the Environment shizzle there. Try it out
    }

}
