package com.cybertek.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        try{
            String path="configuration.properties";
            //READ THE FILE INTO JAVA FINDS THE FILE THE STRING PATH
            FileInputStream input=new FileInputStream(path);
            properties=new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName){

        return properties.getProperty(keyName);
    }
}
