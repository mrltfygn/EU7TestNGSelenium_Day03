package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver d=new ChromeDriver();
        d.get("http://practice.cybertekschool.com");

        Thread.sleep(15000);

        //close current tab
        d.close();

        //giving new browser  tab
        Thread.sleep(15000);

        //close current tab
        d.quit();
    }
}
