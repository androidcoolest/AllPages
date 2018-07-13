package steps;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Login {
	WebDriver driver;
	
	@Before
	public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver=null;
	}
	
	@Given("^User navigates to Stackoverflow\\.com$")
	public void user_navigates_to_Stackoverflow_com() throws Throwable {
	   driver.get("https://stackoverflow.com/");
	   driver.findElement(By.linkText("Log In")).click();
	}

	@When("^User Provides correct username and passsoword$")
	public void user_Provides_correct_username_and_passsoword() throws Throwable {
	   driver.findElement(By.id("email")).sendKeys("dcoolsam@gmail.com");
	   driver.findElement(By.id("password")).sendKeys("sameer12");

	}

	@And("^Clicks Log In button$")
	public void clicks_Log_In_button() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,250)", "");
	   driver.findElement(By.id("submit-button")).click();
	}

	@Then("^Login is Successful$")
	public void login_is_Successful() throws Throwable {
	   Thread.sleep(3000);
		String askQuestionText = driver.findElement(By.linkText("Ask Question")).getText();
	   Assert.assertEquals(askQuestionText, "Ask Question");

	}

}
