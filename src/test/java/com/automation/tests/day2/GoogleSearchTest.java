package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("htpps://google.com");
        Thread.sleep(4000);

        // By.name("q") --> will look for name='q'
        WebElement search = driver.findElement(By.name("google"));

        // once we found element, how to enter text
        // to enter text , use sendKeys() method
        // how to press Enter after entering the text?
        // use Key.Enter
        // Keys.ENTER --> perform keyboard click
        search.sendKeys("Java",Keys.ENTER);
        Thread.sleep(4000);

        // if see <a> element , it calls link
        // visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(4000);



        driver.quit();










    }
}
