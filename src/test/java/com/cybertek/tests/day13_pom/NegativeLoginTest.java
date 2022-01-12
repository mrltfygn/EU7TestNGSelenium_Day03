package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        loginPage.loginButton.sendKeys("asdsaafa");
        loginPage.loginButton.click();
//        driver.findElement(By.id("prependedInput")).sendKeys("user1");
//        driver.findElement(By.id("prependedInput2")).sendKeys("asdagfag");
//        driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void wrongUsernamTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.usernameInput.sendKeys("asggafgaga");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.passwordInput.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }

}
