package com.automation.tests.day9.Vytrack.sprint_01;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BO11_53  {

    private WebDriver driver;
    private String username = "user30";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    @Test
    public void verifyOdometerPage(){

        driver.findElement(usernameBy).sendKeys("user30");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);

        driver.findElement(By.className("unclickable")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.partialLinkText("Vehicle Odometer")).click();
        BrowserUtils.wait(4);

        String expected = "Vehicles Odometers";
        String actual = driver.findElement(By.className("oro-subtitle")).getText();

        Assert.assertEquals(actual,expected,"Test Failed");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
