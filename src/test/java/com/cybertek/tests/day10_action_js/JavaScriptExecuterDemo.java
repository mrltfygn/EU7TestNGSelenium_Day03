package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink=driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //stackoverflow how to use click in selenium using javascript
        jse.executeScript("arguments[0].click();",dropdownLink);

    }

    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox=driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        String text="OmerYegen";

        //stackoverflow how to use sendkeys in selenium using javascript
        //jse.executeScript("arguments[0].setAttribute('value', 'OmerYegen')", inputBox);
        //This line means send OmerYegen to inputbox just different way
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);
    }

    @Test
    public void ScrollDownAndUp(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //scroll down --> scroll the document by 250px vertically
        //=> 0 is used horizontally movement 250 is used verticaly movement
        jse.executeScript("window.scrollBy(0,250)");
        //scroll up -->--> scroll the document by 250px vertically
        jse.executeScript("window.scrollBy(0,-250)");
    }
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement eng=driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //this line tell us scroll directly go where we want to go that web element
        jse.executeScript("arguments[0].scrollIntoView(true);",eng);




    }

}
