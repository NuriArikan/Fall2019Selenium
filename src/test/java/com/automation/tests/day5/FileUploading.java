package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);

        WebElement upload = driver.findElement(By.id("file-upload"));

        // i am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir") +  "/pom.xml";

        upload.sendKeys(filePath);

        System.out.println(filePath);

        BrowserUtils.wait(3);

        driver.findElement(By.id("file-submit")).click(); // click to upload





        BrowserUtils.wait(3);
        driver.quit();
    }
}
