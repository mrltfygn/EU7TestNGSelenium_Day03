package com.cybertek.tests.day08_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropdown_Webelement {
    WebDriver driver= WebDriverFactory.getDriver("Chrome");
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");

    }

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
       //1.Locate your dropdownElement just like the other web element with unique locator

        WebElement dropdownElement=driver.findElement(By.id("state"));
      //2.Create select objec by passing element that element as a constructor

        Select stateDropdown=new Select(dropdownElement);
      //3.getOption -->return all available option from dropdown

        List<WebElement> options = stateDropdown.getOptions();
      //4.print size of option

        System.out.println("options.size() = " + options.size());
      //5.print option one by one

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
    }

        @Test
        public void test2() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/dropdown");

            //1.Locate your dropdownElement just like the other web element with unique locator
            WebElement dropdownElement2= driver.findElement(By.id("state"));

            //2.Create select object by passing element that element as a constructor
            Select stateDropdown2=new Select(dropdownElement2);

            //verify that fist selection is Select a stage
            String expected="Select a Stage";
            String actualOption=stateDropdown2.getFirstSelectedOption().getText();

            Assert.assertEquals(actualOption,expected,"verify your fist selection");
            Thread.sleep(5000);

            //1) HOW WE SELECT FROM DROPDOWN?
            stateDropdown2.selectByVisibleText("Virginia");//select using visible text
            String expected2="Virginia";
            String actualOption2=stateDropdown2.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expected,"verify your fist selection");

            // 2) SELECT USING INDEX
            stateDropdown2.selectByIndex(51); // we have this dropdown list 52 element that index number start '0' for this reason we write 51 for the last element
            String expected3="Wyoming";
            String actualOption3=stateDropdown2.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expected,"verify your fist selection");

            //3) SELECT USING VALUE
            stateDropdown2.selectByValue("TX");
            String expected4="Texas";
            String actualOption4=stateDropdown2.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption4,expected4,"verify your fist selection");

        }



    }

