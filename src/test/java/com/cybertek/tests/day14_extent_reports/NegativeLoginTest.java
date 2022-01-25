package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongPasswordTest(){
        //name of the test
        extentLogger=report.createTest("Wrong Password Test");

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username : user1");

        loginPage.loginButton.sendKeys("asdsaafa");
        extentLogger.info("Enter password : adasfasda");

        loginPage.loginButton.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password test is PASSED");
    }
    @Test
    public void wrongUsernameTest(){

        extentLogger=report.createTest("Wrong Username Test");
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("asggafgaga");
        extentLogger.info("Enter wrong username : asggafgaga ");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password : UserUser123");

        loginPage.passwordInput.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong username test is PASSED");
    }
    @Test
    public void wrongUsernameTestwithScreenshot(){

        extentLogger=report.createTest("Wrong Username Test");
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("asggafgaga");
        extentLogger.info("Enter wrong username : asggafgaga ");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password : UserUser123");

        loginPage.passwordInput.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify Page URL");
        // only  add different url because i wanna see take the screen shot
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong username test is PASSED");
    }
}
