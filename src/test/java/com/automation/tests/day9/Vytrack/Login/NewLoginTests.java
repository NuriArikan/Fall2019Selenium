package com.automation.tests.day9.Vytrack.Login;

import com.automation.pages.LoginPage;
import com.automation.tests.day9.Vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    // login and verify that page title is a "Dashboard"

    @Test
    public void verifyPageTitle(){

        LoginPage loginPage =new LoginPage();

        loginPage.login();

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }

    // enter wrong credentials and verify warning message
    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
    }
}
