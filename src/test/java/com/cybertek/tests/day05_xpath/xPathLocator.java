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
                            //search p tag that contain 'Here'

        WebElement startswithElement=driver.findElement(By.xpath("//button[starts-with(@id,'button')]"));
        startswithElement.click();
                            //search button and this tag has a dynamic id that id value start with this text

        WebElement containsElement=driver.findElement(By.xpath("//button[contains(@id,'_button')][1]"));
        startswithElement.click();
                         //search button and this tag has a dynamic id that id value contains this text


        WebElement childELementP=driver.findElement(By.xpath("//div[@id='content']/div[1]/p"));

        //search div tag and this tag has id attribute value content child div of first one, child p

        //Choosing between cousins(different parent, same name)
        //  (your xpath formula)[index number]

        //  **Locating with multiple attributes
        // tagName[@attributeName1='value1'][@attributeName2='value2']
        //tagName[@attributeName1='value1' and @attributeName2='value2']
        //tagName[@attributeName1='value1' or @attributeName2='value2']

        // **Locating parent from child:
        //knownXpath/parent::parentName
        //knownXpath/parent::*
        //knownXpath/.. <-- Easiest way

        //**Locating sibling:
        //knownXpath/following-sibling::tagName
        //knownXpath/preceding-sibling::tagName
         //knownXpath/../tagName <-- Easiest way(child>parent>other child)

    }

}
