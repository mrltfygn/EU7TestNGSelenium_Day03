package com.cybertek.tests.day09_popup_tabs_frame.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    @Test
    public void test1() throws InterruptedException {

        //Waits
        //Thread.sleep()
        //This method is from java not selenium/It pauses  the programs based on given miliseconds
        // it waits for the duration given be careful not to long or to short.
        //its recommended to minimize the use of thread using to much slows th executions of test.


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        Thread.sleep(6000);

        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");


    }
}
