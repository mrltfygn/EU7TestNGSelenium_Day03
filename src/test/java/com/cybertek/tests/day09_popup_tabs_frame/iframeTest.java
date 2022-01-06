package com.cybertek.tests.day09_popup_tabs_frame;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver= WebDriverFactory.getDriver("Chrome");

    //NoSuchElement Excception
    //1)Locator might be wrong(dynamic or not correct)
    //2)Not enough wait time
    //3)frame or iframe

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1.Switch using by name or ID attribute of Iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
       driver.findElement(By.cssSelector("#tinymce")).sendKeys("Omer");

       //goes back to first frame(main html)
        //goes back to first frame,useful when we have  switched multiple frames
        driver.switchTo().defaultContent();

        //2.Switching with index number
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Omer send second time --- ");

        //Second way to parent frame
        driver.switchTo().parentFrame();

        //3.Using webelement
        WebElement ifaramewebelement=driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(ifaramewebelement);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Omer send third time with webelement");


    }

    @Test
    public void test2(){
        //  HTML(Default frame)
        //      frame-Top(Parent frame)
        //                  left(0)
        //                  middle(1)
        //                  right(2)
        //      frame-Bottom

        //we only switch one at the time -not directly grandchild frame
        //connot switch to sibling , only parent to child

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //firstly we must switc first frame frame-top
        driver.switchTo().frame("frame-top");

        //top frame has 3 frame     left-middle-right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to top frame
        driver.switchTo().parentFrame();

        //switch to right index with index number
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.id("body")).getText());

        // Firstly we must switch to default-main frame
        driver.switchTo().defaultContent();

        //switch to bottom frame
        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.id("body")).getText());

    }
}
