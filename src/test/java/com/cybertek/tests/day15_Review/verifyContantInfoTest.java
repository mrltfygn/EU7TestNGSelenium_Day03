package com.cybertek.tests.day15_Review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContantInfoTest extends TestBase {
    /*open the chrome
go to qa1.vytrack
login as a sales manager
navigate to customers ->contactsclick on email mbrackstone9@example.com
verify that full name is Mariam Brackstone
verify that email is mbrackstone9@example.com
verify that phone number is +18982323434

     */
    @Test
    public void contentDetailsTest(){
        extentLogger= report.createTest(" contentDetailsTest");

        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("salesmanager_username");
        String password=ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username :"+username);
        extentLogger.info("password :"+password);
        extentLogger.info("Login as a Sales Maneger");
        loginPage.login(username,password);

        //lazy way
        //new DashboardPage().navigateToModule();
        extentLogger.info("Navigate to --> Customers>Contacts");
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Customers","Contacts");

        //td[contains(text(),='mbrackstone9@example.com')][@data-column-label='Email']

        ContactsPage contactsPage=new ContactsPage();

        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on this email-mbrackstone9@example.com");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage=new ContactInfoPage();

        String expectedFullname="Mariam Brackstone";

        String actualFullname=contactInfoPage.fullname.getText();
        extentLogger.info("Verify fullname : "+expectedFullname);
        Assert.assertEquals(actualFullname,expectedFullname,"Verify fullname");
        extentLogger.info("Verify email is  mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");
        extentLogger.info("Verify phone number is +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify phone number");





    }


}
