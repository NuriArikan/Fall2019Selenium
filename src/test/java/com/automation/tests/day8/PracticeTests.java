package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

//####TASK for 10 minutes: until 4:17
//        Create a class called PracticeTests
//- setup before/after methods
//        - in before method. instantiate webdriver
//        and navigate to: http://practice.cybertekschool.com/
//        - in after method - just close webdriver.
//        - create a test called loginTest
//        - go to “Form Authentication” page
//        - enter valid credentials
//        - verify that following sub-header message is
//        displayed: “Welcome to the Secure Area. When you are done click logout below.”
public class PracticeTests {

    private WebDriver driver;


    @Test (description = "Task for what we learned")
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual  = driver.findElement(By.className("subheader")).getText();

        // if assertion fails - it will throw exception and message will be printed
        // 3 parameters : (expected, actual, message in case of error)
        Assert.assertEquals(actual,expected,"Sub-header message is not matching");
    }

    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("nuri@cornelldecor.com",Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();

        Assert.assertEquals(actual,expected,"Name message is not matching");

    }

    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox #1
     * Then user verifies that checkbox #1 is selected
     */
    @Test
    public void checkBoxesTest1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(3);
        WebElement click = driver.findElement(By.cssSelector("input[type='checkbox']"));
        click.click();
        BrowserUtils.wait(3);
        Assert.assertTrue(click.isSelected());
        BrowserUtils.wait(3);

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void teardown(){
        // close browser and destroy webdriver object
        BrowserUtils.wait(2);
        driver.quit();
    }
}
