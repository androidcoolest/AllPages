package com.myprject.Fluentss;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import static org.assertj.core.api.Assertions.assertThat;

public class PlayTest extends FluentTest {
    public WebDriver driver;
    // Overrides the default driver
    public WebDriver getDefaultDriver() {
    	System.setProperty("webdriver.gecko.driver", "/home/sam/Downloads/selenium/geckodriver");
		WebDriver driver=new FirefoxDriver();
        return driver;
    }

    @Test
    public void title_of_bing_should_contain_search_query_name() {
        goTo("http://www.bing.com");
        //find("#sb_form_q").with("Teotti");
        //submit("#sb_form_go");
        //assertThat(title()).contains("Teotti");
    }
}