package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        // go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //we must save the current url because we compare with actual URL
        String expectedUrl=driver.getCurrentUrl();

        // click in retieve password
        WebElement retrievePasswordButton= driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualURL= driver.getCurrentUrl();

        //verify that url did not change
        if(expectedUrl.equals(actualURL)){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
        //close your  browser
        driver.quit();
    }
}
