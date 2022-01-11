package com.cybertek.tests.day05_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        driver.navigate().refresh();

        // if line starts with // and looks element anywere on the page
        WebElement button2=driver.findElement(By.xpath("//button[@onclick='button2()']"));
                            //search button and this button have onclick attribute thats attribute value is 'button()2'
        button2.click();

        WebElement button3=driver.findElement(By.xpath("//button[text()='Button 3']"));
                            //search button and this button has this text "Button 3"
        button3.click();

        WebElement button1=driver.findElement(By.xpath("//*[text()='Button 1']"));
                            //search anything that has text 'Button 1' also you can use like this
        button1.click();

        WebElement paragraphContains=driver.findElement(By.xpath("//p[contains(text(),'Here')]"));
                            //






    }

}
