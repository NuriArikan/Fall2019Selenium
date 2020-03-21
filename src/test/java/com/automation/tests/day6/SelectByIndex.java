package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select statesSelect = new Select(driver.findElement(By.id("state")));

        // index starts from 0
        statesSelect.selectByIndex(9); // District Of Columbia

        // select last option
        statesSelect.selectByIndex(statesSelect.getOptions().size()-1);




        BrowserUtils.wait(2);
        driver.quit();
    }
}
