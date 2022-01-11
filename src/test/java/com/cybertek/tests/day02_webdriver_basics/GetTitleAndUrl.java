package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver drv=new ChromeDriver();

        drv.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //shortcut for creating variable
        //Option or ALT +enter enter
        //getTitle()--> get you the title of the page
        String title = drv.getTitle();
        System.out.println("title = " + title);

        //getCurrentUrl--> get the  url from browser
        String currentUrl = drv.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource()-->gets source of the page
        String pageSource = drv.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
