package com.p99soft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePageObject {

	public SignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
	 WebElement login;
	@FindBy(css="#createAccountSubmit")
	 WebElement createAccount;
	@FindBy(css = "#id=ap_customer_name")
	 WebElement name;
	@FindBy(css = "#id=ap_email")
	 WebElement email;
	@FindBy(id="ap_password")
	 WebElement password;
	@FindBy(xpath="//input[@name='passwordCheck']")
	 WebElement againPassword;

	public  void signUP() {
		logger.info("Click on sign button");
		this.click(login);
		this.click(createAccount);
		this.sendKeys(name, "Test");
		this.sendKeys(email, "Test");
		this.sendKeys(password, "Test12!@");
		this.sendKeys(againPassword, "Test12!@");
		
		//login.click();
		logger.info("");
	}
	
	
	

}
