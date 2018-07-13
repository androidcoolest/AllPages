package com.depositsolution.assignment;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.Assert.*;
import org.fluentlenium.adapter.junit.FluentTest;

import org.junit.Test;
//import com.depositsolution.assignment.Login;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTestOld extends FluentTest {
	@Override
    public String getWebDriver() {
	 WebDriverManager.chromedriver().setup();	
		//WebDriver driver = new ChromeDriver();
        return "chrome";
    } 
	Login loginPage = new Login ();
	@Test
	public void test() throws InterruptedException {
		//loginPage.getWebDriver();
		
		//loginPage.openUrl("https://duckduckgo.com");
		//loginPage.openUrl();
		//goTo("https://duckduckgo.com");
		//loginPage.titleOfDuckDuckGoShouldContainSearchQueryName();
		
		/*
		WebDriverManager.chromedriver().setup();	
	      goTo("http://85.93.17.135:9000/user/new");
	        $("#name").fill().with("NewUser");
	        $("#email").fill().with("newUser@gmail.com");
	        $("#password").fill().with("FluentLenium");
	        $("#confirmationPassword").fill().with("FluentLenium");
	        $(By.cssSelector("button[type=submit]")).click();
	        Thread.sleep(10000);
	        //$("submit").submit();
	        //$("button[type='submit']")
	        //assertThat(window().title()).contains("All User");*/
	    private WebDriver driver;
  
		@BeforeClass
	    public static void setupClass() {
	        WebDriverManager.chromedriver().setup();
	    }

	    @Before
	    public void setupTest() {
	        driver = new ChromeDriver();
	    }
		
	}
	private void setupClass() {
		// TODO Auto-generated method stub
		
	}
	

}
