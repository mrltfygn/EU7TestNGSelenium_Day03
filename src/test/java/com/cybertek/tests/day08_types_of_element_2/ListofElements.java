package com.cybertek.tests.day08_types_of_element_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListofElements {
    WebDriver driver= WebDriverFactory.getDriver("Chrome");
    @BeforeMethod
    public void setUp(){
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());
        Assert.assertEquals(buttons.size(),6,"Verify buttons size");

        //iter+enter to get for each loopwith shortcut
        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify bottons are displayed");
        }
        //click second button
        buttons.get(1).click();
    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //regular findElement method will throw NoSuchElement if locator does not exist
        //driver.findElements(By.tagName("buttonasfdag"));

        //passing locator which does not exist it will not throw NoSuchElement
        //ALT+Enter or OPTION+ENTER then one more enter for the shortcut
        List<WebElement> buttons = driver.findElements(By.tagName("buttonasfsaf"));

    }

}
