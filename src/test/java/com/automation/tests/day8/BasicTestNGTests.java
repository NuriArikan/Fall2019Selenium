package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    // runs only once after @AfterClass after @AfterMethod
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }


    // Runs only once in the class before @beforeMethod and before any test
    // regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        // something should be done only once in the class before all tests
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        // something should be done only once in the class after all tests
        System.out.println("After Class");
    }


    // runs before every each test automatically
    // works as a pre-condition or setup
    @BeforeMethod
    public void  setup(){
        System.out.println("Before Method");
    }


    // runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After Method");
    }


    @Test (description =  "Verify expected and actual result")
    public void test1(){
        System.out.println("Test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }

    @Test (description =  "Verify primitives")
    public void test2(){
        System.out.println("Test 2");
        int num1 = 5;
        int num2 = 10;
        // it calls hard essertion
        // if assertion fails - it stops yhe execution (due to exception)
        Assert.assertTrue(num1 < num2);
    }
}
