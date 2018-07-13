package com.myprject.Fluentss;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;

//import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class DuckDuckGoTest2 extends FluentTest {
	 @Override
	    public String getWebDriver() {
		 WebDriverManager.chromedriver().setup();	
			//WebDriver driver = new ChromeDriver();
	        return "chrome";
	    }
    @Test
    public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        assertThat(window().title()).contains("FluentLenium");
    }
}
