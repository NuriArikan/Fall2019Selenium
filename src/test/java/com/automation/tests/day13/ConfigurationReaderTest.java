package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import javax.swing.*;

public class ConfigurationReaderTest {

    // ConfigurationReader class ==> we need this class to load and to use configuration file
    // to get configuration.properties => call getProperty method

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        String color = ConfigurationReader.getProperty("color");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);

        String storeManager = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("driver");

        System.out.println(storeManager);
        System.out.println(driver);
        System.out.println(password);
    }
}
