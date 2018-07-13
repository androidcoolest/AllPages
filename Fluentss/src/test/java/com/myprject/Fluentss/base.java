package com.myprject.Fluentss;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class base {
	@Test
	public static void main (String args[]) {
//		System.setProperty("webdriver.gecko.driver", "/home/sam/Downloads/selenium/geckodriver");
	WebDriverManager.chromedriver().setup();	
	WebDriver driver = new ChromeDriver();
	driver.get("http://85.93.17.135:9000/user/new");
	}
}