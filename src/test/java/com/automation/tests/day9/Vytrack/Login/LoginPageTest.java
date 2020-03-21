package com.automation.tests.day9.Vytrack.Login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// static import of all assertions
import static org.testng.Assert.*;

public class LoginPageTest {

    private WebDriver driver;
    // https is secured version of http protocol
    // http - it is hypertext transfer protocol that every single website is using nowadays
    // https - data encrypted , no chance for hackers to retrieve info
    // http- data as a plain text , very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By warningMessageBy = By.xpath("//fieldset//div");
    // private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    @Test (description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName(){

        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);


    }

    @Test (description = "login as store manager and verify that tile is equals to Dashboard")
    public void loginAsStoreManager(){

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard" ;
        String actual = driver.getTitle();
        assertEquals(actual, expected, "Page title is not correct!");

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(URL);
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        // if webdriver object alive
        if( driver != null){
            // close browser , close session
            BrowserUtils.wait(3);
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }
    }



}
