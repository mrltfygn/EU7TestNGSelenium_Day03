package com.cybertek.tests.day12_Properties_driver_tests;

public class Singleton {
    // singleton class  will have private constructor
    //it means other class

    private static String str;

    public static String getInstance(){
        //if str has no value initialize it
        if(str==null){
            System.out.println("str is null.add some value");
            str="Singleton";
        }
        else{
            //if it has just value just returnit
            System.out.println("it has value return same");
        }
        return str;
    }
}
