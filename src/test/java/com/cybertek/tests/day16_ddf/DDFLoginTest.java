package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.tests.day12_Properties_driver_tests.LoginTest;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {



    @DataProvider
    public Object [][] userdata(){
        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        String[][] data=qa3short.getDataArrayWithoutFirstRow();
        return data;
    }
    @Test(dataProvider = "userdata")
    public void test1(String username,String password,String firstname,String lastname){
        extentLogger=report.createTest("Test "+firstname+" "+lastname);
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualResult=dashboardPage.getUserName();
        String expectedResult=firstname+" "+lastname;

        Assert.assertEquals(actualResult,expectedResult,"Verify");
        extentLogger.pass("PASSED");
    }

}
