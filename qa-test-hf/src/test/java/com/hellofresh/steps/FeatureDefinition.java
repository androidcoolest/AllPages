package com.hellofresh.steps;



import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.util.Date;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FeatureDefinition {
	WebDriver driver;
    WebDriverWait wait;
    String timestamp;
    String email; 
    String name;
    String surname;
    Select select;
    WebElement heading;
    String fullName;
    String existingUserEmail = "hf_challenge_123456@hf12345.com";
    String existingUserPassword = "12345678";

    
	@Before
	public void setup() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 50);
	}
	
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver=null;
	}
	
	@Given("^New User Opens Home page$")
	public void new_User_Opens_Home_page() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
	}

	@When("^Uses the first email textbox with new email ID$")
	public void uses_the_first_email_textbox_with_new_email_ID() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
        timestamp = String.valueOf(new Date().getTime());
        email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        name = "Firstname";
        surname = "Lastname";
        driver.findElement(By.id("email_create")).sendKeys(email);
	}

	@When("^Clicks to Create account$")
	public void clicks_to_Create_account() throws Throwable {
	       driver.findElement(By.id("SubmitCreate")).click();
	}

	@When("^On the new user form, fills all fields with correct data$")
	public void on_the_new_user_form_fills_all_fields_with_correct_data() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.id("passwd")).sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        driver.findElement(By.id("company")).sendKeys("Company");
        driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
        driver.findElement(By.id("address2")).sendKeys("zxcvb");
        driver.findElement(By.id("city")).sendKeys("Qwerty");
        select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("Qwerty");
        driver.findElement(By.id("phone")).sendKeys("12345123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");
        driver.findElement(By.id("alias")).sendKeys("hf");
	}

	@When("^Clicks Register button$")
	public void clicks_Register_button() throws Throwable {
        driver.findElement(By.id("submitAccount")).click();
	}

	@Then("^Account is Successfully created$")
	public void account_is_Successfully_created() throws Throwable {
		heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        assertEquals(heading.getText(), "MY ACCOUNT");
        assertEquals(driver.findElement(By.className("account")).getText(), name + " " + surname);
        assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
        assertTrue(driver.findElement(By.className("logout")).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

	@Given("^Existing customer Opens Home Page$")
	public void existing_customer_Opens_Home_Page() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
	}

	@Given("^Clicks Sign in button \\(in the header\\)$")
	public void clicks_Sign_in_button_in_the_header() throws Throwable {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
	}

	@Given("^Fills existing Email address and Password$")
	public void fills_existing_Email_address_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys(existingUserEmail);
        driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
	}

	@Given("^Click Sign in$")
	public void click_Sign_in() throws Throwable {
        driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("^User is logged on successfully$")
	public void user_is_logged_on_successfully() throws Throwable {
        String fullName = "Joe Black";
		heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        assertEquals("MY ACCOUNT", heading.getText());
        assertEquals(fullName, driver.findElement(By.className("account")).getText());
        assertTrue(driver.findElement(By.className("info-account")).getText().contains("Welcome to your account."));
        assertTrue(driver.findElement(By.className("logout")).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
	}

	@Given("^Existing customer Logs in to Purchase$")
	public void existing_customer_Logs_in_to_Purchase() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
        driver.findElement(By.id("email")).sendKeys(existingUserEmail);
        driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
        driver.findElement(By.id("SubmitLogin")).click();
	}

	@When("^Clicks Women button in the header$")
	public void clicks_Women_button_in_the_header() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
	}

	@When("^Clicks the product with name Faded Short Sleeve T-shirts$")
	public void clicks_the_product_with_name_Faded_Short_Sleeve_T_shirts() throws Throwable {
		  driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']")).click();
	      //driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
	}

	@When("^Continue all the steps of checkout$")
	public void continue_all_the_steps_of_checkout() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
        driver.findElement(By.name("processCarrier")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
	}

	@Then("^Order is Successful$")
	public void order_is_Successful() throws Throwable {
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        assertEquals("ORDER CONFIRMATION", heading.getText());
	    assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
	    assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
	    assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
	    assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
	}
}