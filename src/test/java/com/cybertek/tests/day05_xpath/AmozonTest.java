package com.cybertek.tests.day05_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmozonTest {
    public static void main(String[] args) {
        //go to amozon.com
        //search for selenium
        //click search button
        //verify 1-48 of 304 results for "selenium"

        String expectedResult="1-48 of 304 results for";

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement searchbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbox.sendKeys("Selenium");

        WebElement searchButton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        WebElement result=driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("result.getText() = " + result.getText());

        if(expectedResult.equals(result.getText())){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
            System.out.println(expectedResult);
            System.out.println("result = " +result.getText());
        }


    }
}
