package com.example.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[text()=' Login']") static WebElement wLogin;
	@FindBy(xpath="//a[contains(text(),'Login')]") static WebElement wLoginNew;
	
	
	public void openUrl(String strUrl) {
		driver.get(strUrl);
	}
	
	public void clickLogin() {
		wLogin.click();
	}
}
