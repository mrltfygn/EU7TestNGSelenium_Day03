package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Omer Yegen with tagname");

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("omer@yegen.com");

        driver.findElement(By.tagName("button")).click();



        driver.quit();
    }
}
