package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ActionsTests {
    private WebDriver driver;
    private Actions actions;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }
    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions
        //always end with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);
        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());
        actions.moveToElement(img1).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText2.isDisplayed());
    }
    @Test
    public void jgueryMenuTest(){

        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        //hover on "enabled"
        WebElement enabled = driver.findElement(By.xpath("//a[text()='Enabled']"));
        //hover on "downloads"
        WebElement downloads = driver.findElement(By.xpath("//a[text()='Downloads']"));
        //click on PDF
        WebElement PDF = driver.findElement(By.xpath("//a[text()='PDF']"));
        actions.moveToElement(enabled)
                .pause(1000)
                .moveToElement(downloads)
                .pause(1000)
                .click(PDF)
                .build()
                .perform();
        BrowserUtils.wait(3);

    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        //click on accept cookies

        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}
