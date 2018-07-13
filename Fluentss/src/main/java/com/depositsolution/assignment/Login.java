package com.depositsolution.assignment;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends FluentTest{
    WebDriver driver;
    public Login(WebDriver driver){

        this.driver = driver;

    }
	/*
	 * getWebDriver()
	 * Tells FluentLenium which browser to invoke
	 * @see org.fluentlenium.adapter.FluentAdapter#getWebDriver()
	 */
	@Override @Before
    public String getWebDriver() {
	 WebDriverManager.chromedriver().setup();	
     //goTo("http://85.93.17.135:9000/user/new");
	 return "chrome";
    }
	
	/*
	 * Open URL for the given webpage
	 */
	public void openUrl(String strUrl) {
		System.out.println(strUrl);
		//getWebDriver();
		this.driver.get(strUrl);//goTo(strUrl);
	}
    //$("#search_form_input_homepage").fill().with("FluentLenium");
    //$("#search_button_homepage").submit();
	
	public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        goTo("https://duckduckgo.com");
        $("#search_form_input_homepage").fill().with("FluentLenium");
        $("#search_button_homepage").submit();
        assertThat(window().title()).contains("FluentLenium");
    }

	public void setUserName(String strUserName) {
        $("#name").fill().with(strUserName);
	}
}