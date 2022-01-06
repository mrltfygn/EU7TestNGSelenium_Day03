package com.cybertek.tests.day09_popup_tabs_frame.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    @Test
    public void test1(){
        WebDriver driver=WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("mrltfygn");

        WebDriverWait wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(username));
        

    }
}
