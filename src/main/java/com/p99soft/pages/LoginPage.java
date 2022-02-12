package com.p99soft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	 WebElement login;
	@FindBy(id="continue")
	 WebElement continueButton;
	@FindBy(xpath = "//div[contains(text(),'Enter your email or mobile phone number')]")
	 WebElement errorMessage;
	

	public  void login() {
		logger.info("Click on Login button");
		this.click(login);
		//login.click();
		System.out.println("Login clicked");
	}
	
	public  boolean verifyLoginErrorwithBlankPhoneEmail() {
		boolean isTrue = false;
		logger.info("Verify Error message with blank phone or email");
		this.click(continueButton);
		//continueButton.click();
		isTrue = errorMessage.isDisplayed();
		System.out.println("Login clicked");
		return isTrue;
	}
	
	

}
