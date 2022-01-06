package com.cybertek.tests.day09_popup_tabs_frame.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ImplicitWaitExample {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        Thread.sleep(20000);

        WebElement element = driver.findElement(By.cssSelector("#finish"));




    }
}
