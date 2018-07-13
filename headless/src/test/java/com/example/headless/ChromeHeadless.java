package com.example.headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/sam/Downloads/selenium/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
	}
}
