package com.myprject.Fluentss;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WbDrvr extends WebDriverManager{

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		// Your test code here
	System.out.print("Got it till here");
	driver.get("www.amazon.com");
	}
}
