package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameinput=driver.findElement(By.id("username"));

        System.out.println("usernameinput.isDisplayed() = " + usernameinput.isDisplayed());


        //verify username inputbox is not displayed on the screen
        Assert.assertFalse(usernameinput.isDisplayed(),"verify is NOT displayed on the screen");
        //click start button
        driver.findElement(By.cssSelector("#start>button")).click();
        //verify username displayed on the screen
        Thread.sleep(10000);
        Assert.assertTrue(usernameinput.isDisplayed(),"verify username inputbox is displayed");

    }

}
