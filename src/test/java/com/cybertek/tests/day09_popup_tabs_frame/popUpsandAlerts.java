package com.cybertek.tests.day09_popup_tabs_frame;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class popUpsandAlerts {

    WebDriver driver= WebDriverFactory.getDriver("Chrome");

    @BeforeMethod
    public void setUP(){
        driver=WebDriverFactory.getDriver("Chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the confirm button
        driver.findElement(By.className("ui-button-text ui-c")).click();

        //click confirm button popUp
        driver.findElement(By.className("ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-confirmdialog-no ui-button-flat")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click for js alert button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to js alert pop up
        Alert alert=driver.switchTo().alert();
        Thread.sleep(10000);
        alert.accept();

        //click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(5000);
        alert.dismiss();

        //click for JS promt
        driver.findElement(By.xpath("//button[3]")).click();

        //send keys from
        alert.sendKeys("omer");
        Thread.sleep(2000);

        alert.accept();


    }

}
