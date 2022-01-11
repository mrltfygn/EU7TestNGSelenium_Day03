package com.cybertek.tests.day10_file_Upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        // we use sendKeys method but we must use to find document by file path
        //windows => shift hold + file right click
        //mac  =>right click+cmd button hold
        chooseFile.sendKeys("C:\\Users\\a\\Desktop\\file.txt");
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        
        String actulaFileName=driver.findElement(By.id("uploaded-files")).getText();
        //Verify file name is file.txt
        Assert.assertEquals(actulaFileName,"file.txt");

    
    }
}
