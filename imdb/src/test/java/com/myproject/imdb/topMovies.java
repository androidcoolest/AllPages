package com.myproject.imdb;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@Test
public class topMovies {
	public void getTopMovies() {
		
		//Static Variables
		String baseUrl="https://www.imdb.com/search/title?groups=top_250&sort=user_rating&my_ratings=exclude";
		String commonXPath="//*[@id='main']/div/div/div[3]";
		
		//Create Selenium Driver
		System.setProperty("webdriver.chrome.driver","../imdb/src/test/resources/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		//Launch URL
		driver.get(baseUrl);
				
		//Browser to xPath
		for(int count=1;count<=3;count++)
		{
			String customXpath=commonXPath+"/div["+count+"]/div[3]/h3/a";
			String linkText=driver.findElement(By.xpath(customXpath)).getText();
			System.out.println(linkText);
		}
		
		//Close Brower
		driver.quit();
	}
}
