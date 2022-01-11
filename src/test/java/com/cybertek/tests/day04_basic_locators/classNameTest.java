package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class classNameTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();

        driver.findElement(By.className("nav-link")).click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //print multiple buttons header

        //When we shoudnt use for classname locator?
        //if there is a space in the classname attribute value, we connot use it.
        System.out.println(driver.findElement(By.className("h3")).getText());

    }
}
