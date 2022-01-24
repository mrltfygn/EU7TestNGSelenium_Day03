package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitle extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle="Quick Launchpad";
       //first we creat object that name DashboardPage
        DashboardPage dashboardPage=new DashboardPage();

        String actualSubTitle=dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle,expectedSubtitle,"Verify Subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");




    }
}
