package com.cybertek.tests.day08_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    WebDriver driver=WebDriverFactory.getDriver("Chrome");

    @BeforeMethod
    public void setUp(){
       driver=WebDriverFactory.getDriver("Chrome");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement= driver.findElement(By.id("dropdownMenuLink"));
        Select stateDropdown=new Select(dropdownElement);
       //click dropdown to see available options
        dropdownElement.click();

        driver.findElements(By.className("dropdown-item"));

    }



}
