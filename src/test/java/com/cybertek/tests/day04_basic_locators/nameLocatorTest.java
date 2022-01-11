package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");

        //make browser fullscreen
        driver.manage().window().maximize();  //also we can use fullscreen on windows
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Omer Yegen");

        //put some email and click sign up button
       //proper way
        WebElement emailForUser=driver.findElement(By.name("email"));
        emailForUser.sendKeys("omer@yegen.com");

        //lazy way
     //   driver.findElement(By.name("email")).sendKeys("omer@yegen.com");
        // same jop but easy way.you can use the other line


        WebElement signupButton=driver.findElement(By.name("wooden_spoon"));
        signupButton.click();
}}
