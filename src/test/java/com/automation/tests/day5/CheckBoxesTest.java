package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        // verify that 1st checkbox is not selected and 2nd is selected

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        // TASK:
        // verify that 1st checkbox is not selected and 2nd is selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        BrowserUtils.wait(2);

        // let's click on the first checkbox and verify it is clicked
//        checkBoxes.get(0).click(); // same as below
        WebElement checkbox1 = checkBoxes.get(0); // same as above
        checkbox1.click();

        BrowserUtils.wait(2);

        if ( checkbox1.isSelected()){
            System.out.println("Test Passed");
            System.out.println("checkbox #1 is selected");
        }else {
            System.out.println("Test Failed");
            System.out.println("checkbox #1 is selected");
        }




        BrowserUtils.wait(2);
        driver.quit();
    }
}
