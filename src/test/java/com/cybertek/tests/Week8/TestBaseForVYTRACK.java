package com.cybertek.tests.Week8;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.module.Configuration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestBaseForVYTRACK {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //For extent report methods
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    CalendarEventsPage page;


    @BeforeTest
    public void setUpTest(){
        report=new ExtentReports();
        String projectPath=System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack HomeWork");
        report.setSystemInfo("Environmet","Test");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @BeforeMethod
    public void setUpEachCase(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("qa2_url"));


        page =new CalendarEventsPage();
        page.navigateToModule("Activities","Calender Events");

    }





}
