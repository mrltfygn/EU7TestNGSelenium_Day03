package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMassege {
    public static void main(String[] args) {
        //open browser
        WebDriver driver=WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));
        String expectedEmail="omer@yegen.com";
        emailInputBox.sendKeys(expectedEmail);
        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        //click on Retrieve password
        WebElement retrieveButton=driver.findElement(By.id("form_submit"));
        retrieveButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!
        WebElement massageBox= driver.findElement(By.name("confirmation_massage"));
        String text = massageBox.getText();
        if(text.equals("Your e-mail's been sent!")){
            System.out.println("Perfect Match");
        }
        else{
            System.out.println("not equal");
        }

        driver.quit();

    }
}
