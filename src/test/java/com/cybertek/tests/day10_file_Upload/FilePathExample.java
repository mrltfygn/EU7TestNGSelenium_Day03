package com.cybertek.tests.day10_file_Upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilePathExample {
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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        String projectPath=System.getProperty("user.dir");
        String filepath="src/test/resources/file.txt";
        String fullpath=projectPath+"/"+filepath;
        chooseFile.sendKeys(fullpath);

        driver.findElement(By.id("file-submit")).click();

        String actulaFileName=driver.findElement(By.id("uploaded-files")).getText();
        //Verify file name is file.txt
        Assert.assertEquals(actulaFileName,"file.txt");

    }
}
