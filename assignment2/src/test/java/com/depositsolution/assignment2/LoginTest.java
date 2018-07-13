package com.depositsolution.assignment2;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginTest {
	
	/*
	 * Variables Section
	 */
    private WebDriver driver;
	//URL to navigate to:
    String strUrl="http://85.93.17.135:9000/";
    String strGetApiUrl = "http://85.93.17.135:9000/user/all/json";
	String strDeleteApiUrl = "http://85.93.17.135:9000/user/all";
	String strNextPageTitle = "All User";
	int iResponseCode;
	
	//Test Data Variables
	String testUserName = "sameer";
	String testPassword = "sameer1234";
	String testRepeatPassword = "sameer1234";
	String testEmailId = "sameer@gmail.com";
	String testShorterPassword = "sam";
	String testEmailWithoutAtSymbol="samgmail";
	//Variable section ends here
	 
	//Error MEssages
	String usernameEmptyError = "Required";
	String usernameDuplicateError = "Must be unique";
	String emailidEmptyError = "Required";
	String emailidDuplicateError = "Must be unique";
	String passwordEmptyError = "Required";
	String passwordNotSameError = "passwords are not the same"; 
	String invalidEmailError = "Invalid email address";
	String passwordShorterThan6Error = "Minimum size is 6";
	/*
	 * Initial Setup before running the complete test suite
	 */
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    /*
	 * Creating ChromeDriver instance to run the test
	 */
    @BeforeMethod
	public void setupTest() {
        driver = new ChromeDriver();
    }

    /*
	 * Quitting all the broswer instances opened by Selenium
	 */
    @AfterMethod
	public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*
     * Delete all users - to start clean
     * using DELETE API
     * Expected - All users are deleted
     */
    @Test
    public void deleteAllUsersApi() throws ClientProtocolException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        //loginPage.openUrl(strGetApiUrl);
        iResponseCode = loginPage.deleteAllUsersApi(strDeleteApiUrl);
        assertEquals(iResponseCode, 200);
        //Validations
        //assert(driver.getPageSource().contains("{"));
        
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * First Positive Flow
     * Create a single user using all write inputs
     * Expected User successfully created
     */
    @Test
    public void checkPositiveFlow() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setUserName(testUserName);
        loginPage.setEmailId(testEmailId);
        loginPage.setPassword(testPassword);
        loginPage.setRepeatPassword(testRepeatPassword);
        loginPage.submitButtonClick();
        
        //Validations
        assertEquals(loginPage.checkPageTitle(), strNextPageTitle);
        assert(driver.getPageSource().contains(testEmailId));
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Pass empty username and click submit
     * Expected - Error messsage userrname "Required"
     */
    @Test
    public void checkUserNameEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setUserName("");
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getUsernameErrorText(), usernameEmptyError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Use existing username
     * Expected - Error message "Must be unique"
     */
    @Test
    public void checkUsernameIsUnique() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setUserName(testUserName);
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getUsernameErrorText(), usernameDuplicateError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Pass empty Email and click submit
     * Expected - Error messsage Email "Required"
     */    
    @Test
    public void checkEmailFieldEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setEmailId("");
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getEmailIdErrorText(), emailidEmptyError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Use existing emailID
     * Expected - Error message "Must be unique"
     */
    @Test
    public void checkEmailIdIsUnique() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setEmailId(testEmailId);
        loginPage.submitButtonClick();
       
        //Validation
        assertEquals(loginPage.getEmailIdErrorText(),emailidDuplicateError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Try with email ID without @ symbol
     * Expected - Error message "Invalid email address"
     */
    @Test
    public void checkEmailIdWithoutAtSymbol() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setEmailId(testEmailWithoutAtSymbol);
        loginPage.submitButtonClick();
       
        //Validation
        assertEquals(loginPage.getEmailIdErrorText(), invalidEmailError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Pass empty Password and click submit
     * Expected - Error messsage Password "Required"
     */
    @Test
    public void checkPasswordEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setPassword("");
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getPasswordErrorText(), passwordEmptyError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Negative Test: Pass lesser than 6 characters in Password and click submit
     * Expected - Error messsage Password "Required"
     */
    @Test
    public void checkPasswordShorterThan6Char() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setPassword(testShorterPassword);
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getPasswordErrorText(), passwordShorterThan6Error);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
       
    /*
     * Negative Test: Pass different repeatPassword and click submit
     * Expected - Error messsage Password "passwords are not the same"
     */
    @Test
    public void checkRepeatPasswordDifferent() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.setPassword(testPassword);
        loginPage.setRepeatPassword(testPassword+"123");
        loginPage.submitButtonClick();
       
        //Validations
        assertEquals(loginPage.getRepeatPasswordErrorText(), passwordNotSameError);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
      
    /*
     * Click All User button - should naviagate to New user page
     * Expected - Navigate to new user Page
     */
    @Test
    public void clickAllUserButton() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        loginPage.openUrl(strUrl);
        loginPage.allUserButtonClick();
       
        //Validations
        assertEquals(loginPage.checkPageTitle(), strNextPageTitle);
       
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Check - GET /user/all/json Get all Users
     * Expected - Navigate to new user Page and contains JSon
     */
    @Test
    public void getUserAPI() throws ClientProtocolException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        //loginPage.openUrl(strGetApiUrl);
        iResponseCode = loginPage.getUserApi(strGetApiUrl);
        assertEquals(iResponseCode, 200);
        //Validations
        //assert(driver.getPageSource().contains("{"));
        
        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
    /*
     * Multiple User Test - Create 10 Users on the fly
     * Expected Users are created
     */
    
    @Test
    public void createMultipleValidUsers() {
        LoginPage loginPage = new LoginPage(driver);
        // User Inputs
        for (int i=1;i<=10;i++) {
        loginPage.openUrl(strUrl);
        loginPage.setUserName(testUserName + i);
        loginPage.setEmailId(testEmailId + i);
        loginPage.setPassword(testPassword + i);
        loginPage.setRepeatPassword(testPassword + i);
        loginPage.submitButtonClick();
        }
        //Validations
        assertEquals(loginPage.checkPageTitle(), strNextPageTitle);
        //assert(driver.getPageSource().contains(testEmailId));

        //Explicitly Close Browser
        loginPage.closeBrowser();
    }
    
}