package com.automation.tests.day9.Vytrack.sprint_01;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BO11_53_NonAuthorized {

    private WebDriver driver;
    private String username = "storemanager72";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    @Test
    public void verifyOdometerPage(){

        driver.findElement(usernameBy).sendKeys("storemanager72");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a")).click();
        BrowserUtils.wait(3);


        driver.findElement(By.partialLinkText("Vehicle Odometer")).click();
        BrowserUtils.wait(4);

        String expected = "You do not have permission to perform this action.";
        String actual = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div")).getText();

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
