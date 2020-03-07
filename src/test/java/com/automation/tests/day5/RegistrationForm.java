package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(3);

        // enter first name
        driver.findElement(By.name("firstname")).sendKeys("John");

        // last name
        driver.findElement(By.name("lastname")).sendKeys("Smith");

        // user name
        driver.findElement(By.name("username")).sendKeys("jsmith");

        // email
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");

        // password
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");

        // phone number
        driver.findElement(By.name("phone")).sendKeys("973-202-7899");

        // gender
        List<WebElement> genders = driver.findElements(By.name("gender"));
        // select genders
        genders.get(0).click();

        // date of birth
        driver.findElement(By.name("birthday")).sendKeys("08/21/1985");

        // select programming
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(3);

        // submit button
        driver.findElement(By.id("wooden_spoon")).click();



    BrowserUtils.wait(3);
    driver.quit();
    }
}
