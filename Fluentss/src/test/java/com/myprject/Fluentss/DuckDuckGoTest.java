package com.myprject.Fluentss;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//import static org.assertj.core.api.Assertions.assertThat;


@Wait
public class DuckDuckGoTest extends FluentTest {
	public WebDriver driver;
    // Overrides the default driver
    public WebDriver getDefaultDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/agenteo/Downloads/chromedriver");
        driver = new ChromeDriver();
        return driver;
        //getSharedWebDriver
    }

	@Test
        public void titleOfDuckDuckGoShouldContainSearchQueryName() {
    	 System.setProperty("webdriver.gecko.driver", "/home/sam/Downloads/selenium/geckodriver");
    	//WebDriver driver = new ChromeDriver();
    	//WebDriverManager.chromedriver().setup();	
    	//WebDriver driver = new ChromeDriver();
    	//ChromeDriver sharedWebDriver=new ChromeDriver();
    //	();
		WebDriverManager.chromedriver().setup();	
		goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        //assertThat(window().title()).contains("FluentLenium");
    }
}
