package com.depositsolution.assignment;


import org.fluentlenium.adapter.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.fluentlenium.adapter.junit.FluentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {

	String strUrl="http://85.93.17.135:9000/user/new";
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here
        Login login = new Login(driver);
        login.openUrl(strUrl);
        login.setUserName("Ronaldo");
    	
    }

}