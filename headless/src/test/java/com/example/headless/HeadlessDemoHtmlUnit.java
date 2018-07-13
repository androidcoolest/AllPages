package com.example.headless;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.logging.*;

public class HeadlessDemoHtmlUnit {
	public static void main(String[] args) {
		//Set Logging off for HTMLUnit
		//java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		
		Logger.getLogger("").setLevel(Level.OFF);
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
	}
}
