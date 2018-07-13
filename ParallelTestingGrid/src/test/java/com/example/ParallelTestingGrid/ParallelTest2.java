package com.example.ParallelTestingGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest2 {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	long startTime;
	long endTime;
	long totalTime;
    //private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//private static WebDriver driver = (WebDriver) new ThreadLocal<Object>();

	@BeforeClass
	public void startTime() throws MalformedURLException {
		startTime = System.currentTimeMillis();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	       //dd driver = new ThreadLocal<RemoteWebDriver>();
	        driver= (new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
	        
			DesiredCapabilities capabilitiesFF = DesiredCapabilities.firefox();
			driverFF = (new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilitiesFF));

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws MalformedURLException {
        	}

	@Test
	public void first() {
		//driver.get("https://www.google.com/");
		driverFF.get("https://www.google.com/");
		System.out.println((driverFF).getTitle());
		System.out.println("First");
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
	}

	@Test
	public void second() throws InterruptedException, MalformedURLException {

		System.out.println("Second");
		driverFF.get("https://www.facebook.com/");
		System.out.println(driverFF.getTitle());
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
	}

	@Test
	public void third() throws InterruptedException, MalformedURLException {
		driverFF.get("https://twitter.com/");
		System.out.println(driverFF.getTitle());
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
	}

	@Test
	public void firstChrome() throws InterruptedException, MalformedURLException {
		System.out.println("1");
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
	}

	@Test
	public void secondChrome() throws InterruptedException, MalformedURLException {
		System.out.println("2");
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
	}

	@Test
	public void thirdChrome() throws InterruptedException, MalformedURLException {

		System.out.println("3");
		driver.get("https://twitter.com/");
		System.out.println(driver.getTitle());
		System.out.println("Thread Id:- " + Thread.currentThread().getId());
		driver.quit();
		driver = null;

	}

	@AfterMethod
	public void myAfterTest() {
		// driver.quit();
		
	}

	@AfterClass
	public void afterClassMethod() {
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;

		System.out.println("Total Page Load Time: " + totalTime + "milliseconds");
		driverFF.quit();
		driver.quit();
	}
}
