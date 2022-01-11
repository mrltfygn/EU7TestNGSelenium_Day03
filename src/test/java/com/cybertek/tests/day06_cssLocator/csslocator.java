package com.cybertek.tests.day06_cssLocator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class csslocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
         driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClick=driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println("dontClick.getText() = " + dontClick.getText());

    }
}
