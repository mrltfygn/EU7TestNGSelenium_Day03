package com.cybertek.tests.day09_popup_tabs_frame;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {




    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
       driver.get("http://practice.cybertekschool.com/windows");
        //get Title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        //this page always see same window for this reason we must switch to window for new tabs
        System.out.println("After click window driver.getTitle() = " + driver.getTitle());

        // it gives us unique identifier new tabs
        // first window handle
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentwindowhandle = driver.getWindowHandle();

        //this method will get all the window open and add something to  set
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currentwindowhandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after switch to new window = " + driver.getTitle());


    }

    @Test
    public void moreThanOneWindow(){
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        //get Title


        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before switch driver.getTitle() = " + driver.getTitle());


        Set<String> windowHandles = driver.getWindowHandles();

        //Loop through each window
        for (String handle : windowHandles) {
            //one by one changed
            driver.switchTo().window(handle);

            //whenver your title equals to your expected window title
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("After switch driver.getTitle() = " + driver.getTitle());

    }
}
