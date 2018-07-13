package com.depositsolution.assignment2;

/*
 * Necessary Imports
 */
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	//Constructor
	public class LoginPage {
		WebDriver driver;
		public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /* Object Repository
     * Locator Names
     * 
     */
	By nameLocator = By.id("name");
	By emailLocator = By.id("email");
	By passwordLocator = By.id("password");
	By repeatPasswordLocator = By.id("confirmationPassword");
	By allUserButtonLocator = By.linkText("All User");
	By submitButtonLocator = By.cssSelector("button[type=submit]");
	By usernameErrorLocator = By.id("user.name.error");
	By passwordErrorLocator = By.id("user.password.error");
	By repeatPasswordErrorLocator = By.id("user.confirmationPassword.error");
	By userEmailErrorLocator = By.id("user.email.error");
	By tableIdLocator = By.id("users");
	//End of Object Repository
	
	/*
	 * HttpClient Variables
	 */
	HttpClient httpClient;; 
	HttpResponse httpResponse;
	
	/*
	 * openUrl method - Opens the webpage URL using webdriver
	 */
	
	public void openUrl(String strUrl) {
		driver.get(strUrl);
	}
	
	/*
	 * setUserName method sets the username using the given string
	 */
	public void setUserName (String strUserName) {
		driver.findElement(nameLocator).sendKeys(strUserName);
	}
	
	/*
	 * setEmailId method sets the email field on the page using the given string
	 */
	public void setEmailId (String strEmail) {
		driver.findElement(emailLocator).sendKeys(strEmail);
	}
	
	/*
	 * setPassword - Sets the password using the given string
	 */
	public void setPassword (String strPassword) {
		driver.findElement(passwordLocator).sendKeys(strPassword);
	}
	
	/*
	 * setRepeatPassword - Sets the repeated Password field using the given string
	 */
	public void setRepeatPassword (String strRepeatPassword) {
		driver.findElement(repeatPasswordLocator).sendKeys(strRepeatPassword);
	}
	
	/*
	 * submitButtonClick - Clicks the submit button
	 */
	public void submitButtonClick () {
		driver.findElement(submitButtonLocator).click();
	}
	
	/*
	 * allUserButtonClick - Click the All User Button
	 */
	public void allUserButtonClick () {
		driver.findElement(allUserButtonLocator).click();
	}
	
	/*
	 * checkPageTitle - Returns the page Title
	 */
	public String checkPageTitle() {
		return driver.getTitle();
	}
	
	/*
	 * Check if the user is in the list
	 */
	public boolean checkUserInList(String strEmailId) {
		if (driver.findElement(tableIdLocator).getText().contains(strEmailId))	{
			System.out.println(driver.findElement(tableIdLocator).getText());
			return true;}
		else
			return false;
	}
	
	/*
	 * getUsernameErrorText - Get the errors displayed by Username
	 */
	public String getUsernameErrorText() {
		return driver.findElement(usernameErrorLocator).getText();
	}
	
	/*
	 * getEmailIdErrorText - Gets the errors displayed by Email ID field
	 */
	public String getEmailIdErrorText() {
		return driver.findElement(userEmailErrorLocator).getText();
	}
	
	/*
	 * getPasswordErrorText - Gets the errors displayed by Password field
	 */
	public String getPasswordErrorText() {
		return driver.findElement(passwordErrorLocator).getText();
	}
	
	/*
	 *  getRepeatPasswordErrorText - gets the error by RepeatedPassword field
	 */
	public String getRepeatPasswordErrorText() {
		return driver.findElement(repeatPasswordErrorLocator).getText();
	}
	
	/*
	 * Close the browser opened by Selenium
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/*
	 * getUserApi - Executes the GET call and returns the response code
	 */
	public int getUserApi(String strApiUrl) throws ClientProtocolException, IOException {
		httpClient = HttpClientBuilder.create().build(); 
		httpResponse = httpClient.execute(new HttpGet(strApiUrl));
		return httpResponse.getStatusLine().getStatusCode();
	}
	
	/*
	 * deleteAllUsersApi - Deletes all the users using DELETE API calls
	 */
	public int deleteAllUsersApi(String strDeleteApiUrl) throws ClientProtocolException, IOException {
		httpClient = HttpClientBuilder.create().build(); 
		httpResponse= httpClient.execute(new HttpDelete(strDeleteApiUrl));
		return httpResponse.getStatusLine().getStatusCode();
	}
}//End of Class
