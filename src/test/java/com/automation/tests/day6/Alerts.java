package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowserUtils.wait(2);
        // to get the text from popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept(); // to click ok

        String  expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        // if it will fail, because there is a typo #BUG#
        if ( expected.equals(actual)){
            System.out.println("Test 1st Passed");
        }else {
            System.out.println("Test 1st Failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }

        BrowserUtils.wait(2);

        buttons.get(1).click(); // to click 2nd button
        BrowserUtils.wait(2);
        // to click cancel
        driver.switchTo().alert().dismiss(); // must be: You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)){
            System.out.println("Test 2nd Passed!");
        } else {
            System.out.println("Test 2nd Failed");
            System.out.println("Expected: " + expected2);
            System.out.println("Actual: " + actual2);
        }
        BrowserUtils.wait(2);

        // Task , click last one and write "Hello World"
        buttons.get(2).click();
        BrowserUtils.wait(3);

       Alert alert = driver.switchTo().alert();

       alert.sendKeys("Hello, World!");
       alert.accept();// click ok

        BrowserUtils.wait(3);

       String actual3 =driver.findElement(By.id("result")).getText();
       String expected3 = "Hello, World!";

        if(actual3.endsWith(expected3)){
            System.out.println("TEST 3rd PASSED!");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:   "+actual3);
        }


        BrowserUtils.wait(3);
        driver.quit();
    }
}
