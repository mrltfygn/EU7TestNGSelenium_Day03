package com.cybertek.tests.day07_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("--Before Class--");
        System.out.println("executed one time before the class");
    }
    @AfterClass
    public void endOfClass(){
        System.out.println("--After Class--");
        System.out.println("executed one time before the class");
    }

    @Test
    public void test1(){
        System.out.println("First Test case");
    }
    //    @Ignore
    // how to ignore some @Test to run
    // we can put on top of the @Test that we want to ignore
    //we can commet out the @Test annotation
    @Test
    public void test2(){
        System.out.println("Second Test case");
    }

    @BeforeMethod
    //runs once before each method with @Test annotations
    public void setUp(){
        System.out.println("--Before Method--");
        System.out.println("Webdriver,Opening browser");
    }
    @AfterMethod
    //runs once after each of with  @Test annotations
    public void tearDown(){
        System.out.println("--After Method--");
        System.out.println("Closing Browser,Quit");
    }


}
