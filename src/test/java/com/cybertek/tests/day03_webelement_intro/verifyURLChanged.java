package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox=driver.findElement(By.name("email"));

        // sendKeys()-->     send keyboard action to web element
         emailInputBox.sendKeys("omer@cydeo.com");


         WebElement retrieveButton=driver.findElement(By.id("form_submit"));
         retrieveButton.click();

         String expectedURL= driver.getCurrentUrl();
         if(expectedURL.equals("http://practice.cybertekschool.com/email_sent")){
             System.out.println("PASS");
         }
         else{
             System.out.println("FAIL");
         }


    }

}
