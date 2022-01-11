package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

@Test
        public void test1() {

    WebDriver driver = WebDriverFactory.getDriver("Chrome");
    driver.manage().window().maximize();
    driver.get("http://practice.cybertekschool.com/radio_buttons");

    WebElement blueRadioBtn=driver.findElement(By.cssSelector("#blue"));
    WebElement redRadioBtn=driver.findElement(By.id("red"));

    //how to check radio button is selected
    System.out.println(blueRadioBtn.isSelected());
    System.out.println(redRadioBtn.isSelected());
    // if you wanna any button to click you can use this line
    //redRadioBtn.click();


    //verify blue is selected red is not selected
    // blue
    Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue is selected ");
    // red
    Assert.assertFalse(redRadioBtn.isSelected(),"verify that  red is not selected");
}
}
