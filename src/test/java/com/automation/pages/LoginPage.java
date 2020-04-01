package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy ( id = "prependedInput")
    private WebElement username;

    @FindBy (id = "prependedInput2")
    private WebElement password;

    @FindBy ( id = "_submit")
    private WebElement login;

    @FindBy (linkText = "Forgot your password")
    private WebElement forgotPassword;

    @FindBy(linkText = "[class='alert alert-error']")
    private WebElement warningMessage;


    public  LoginPage(){
        // to connect our webdriver, page class and page factory
        // PageFactory -> used to use @FindBy annotations
        // PageFactory -> helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }


    // method to login, version1
    public void login (String usernameValue, String passwordValue){
    this.username.sendKeys(usernameValue);
    this.password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    // method to login version2
    // login as a default user
    // credentials will be retrieved from configuration.properties file
    public void login (){
        this.username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

}
