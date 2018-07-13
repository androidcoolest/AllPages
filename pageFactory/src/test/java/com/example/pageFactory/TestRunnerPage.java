package com.example.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.pageFactory.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunnerPage {

	private static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openUrl("https://www.screener.in");
		loginPage.clickLogin();
	}

}
