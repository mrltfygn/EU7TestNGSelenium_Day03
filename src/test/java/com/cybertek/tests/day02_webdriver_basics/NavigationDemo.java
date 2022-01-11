package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://www.google.com");

    // navigate to another website with different selenium method
        driver.navigate().to("http://www.facebook.com");

    //wait three seconds here than move on
        Thread.sleep(3000);

    //goes back yo previous page
        driver.navigate().back();

        Thread.sleep(2000);

    //goes back to back
        driver.navigate().forward();

    //refresh webpage
    driver.navigate().refresh();

    }
}
