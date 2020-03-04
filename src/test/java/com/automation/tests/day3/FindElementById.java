package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";

        String actual = driver.findElement(By.tagName("h4")).getText();

        if ( expected.equalsIgnoreCase(actual)){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed");
        }

        // lets click logout, it looks like button, but it is actually a link
        // every element with <a> tag is a link
        // if you have couple spaces in the text, just use partialLinkText instead of linkText
        // LinkText --> equals()
        // PartialLinkText --> contains() --> complete match doesnt required
        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(href);
        System.out.println(className);

        logout.click();
        Thread.sleep(3000);

        // lets enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());

        Thread.sleep(3000);
        driver.quit();









    }


}
