package com.automation.tests.day8;

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
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("https://google.com");
        BrowserUtils.wait(2);

        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(2);

        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));

        for ( WebElement searchItem : searchItems){
            System.out.println(searchItem.getText());

            // if there is a text - print it
            String var = searchItem.getText();
            if( !var.isEmpty()){
                System.out.println(var);

                // verify that very search result contains java
                // is some of the search results
                // doesnt contain java word , it will fail the rest
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }

    // Task:
    // Given user is on the amazon.com page
    // Then user clicks on the search item
    // Then user clicks on the search button
    // and user clicks on the first search item
    // and user verifies that title of the search item contains "Java"

    @Test (description = "Search for Java book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        // there is a chance that is not visible
        // so we need to maximize window before clicking on it
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(2);

        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));
        // click on the first item
        for ( WebElement searchItem : searchItems){
            System.out.println("Title = " + searchItem.getText());
        }

        searchItems.get(0).click();
        BrowserUtils.wait(2);

        WebElement productTitle = driver.findElement(By.id("title"));

        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

    }


    @BeforeMethod
    public void setup(){
        // setup driver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown(){
        // close browser and destroy webdriver object
        BrowserUtils.wait(2);
        driver.quit();
    }


}
