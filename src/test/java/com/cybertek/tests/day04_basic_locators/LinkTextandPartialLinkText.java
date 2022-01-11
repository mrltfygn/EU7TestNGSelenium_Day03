package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.DocFlavor;

public class LinkTextandPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //linkText--> using full text of link to locate link webelement on the webpage
        WebElement link1=   driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();

        //partialLinkText-->using par of the linktext to locate link webelement
        WebElement link2=driver.findElement(By.partialLinkText("Example 2:"));
        link2.click();
    }
}
