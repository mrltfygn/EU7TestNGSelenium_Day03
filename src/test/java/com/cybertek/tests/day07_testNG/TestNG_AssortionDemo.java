package com.cybertek.tests.day07_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_AssortionDemo {
    @BeforeMethod
    public void setUP(){
        System.out.println("Set up Browser");
    }

    @Test
    public void Test1(){

        System.out.println("First assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
