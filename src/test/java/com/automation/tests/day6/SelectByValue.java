package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select statesSelect = new Select(driver.findElement(By.id("state")));
        statesSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = statesSelect.getFirstSelectedOption().getText();

        if (expected.equals(actual)) {

            System.out.println("Test Passed!");

        }else {
            System.out.println("Test Failed");
        }



    BrowserUtils.wait(2);
    driver.quit();

    }
}
