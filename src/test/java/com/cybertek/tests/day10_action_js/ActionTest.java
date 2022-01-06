package com.cybertek.tests.day10_action_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1=driver.findElement(By.tagName("img"));
//Action-->class that contains all the user interactions
//how to creat actions object -->passing driver as a constructor
        Actions actions=new Actions(driver);
        // perform()-->perform the action complete the action
        //moveToElement()-->move your mouse to webelement
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink=driver.findElement(By.xpath("//*[.='View profile']"));

        Assert.assertTrue(viewLink.isDisplayed(),"Link is displayed");

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

         driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(2000);

        actions.dragAndDrop(source,target).perform();


    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(2000);

        // same way like  drag and drop
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();


    }
}
