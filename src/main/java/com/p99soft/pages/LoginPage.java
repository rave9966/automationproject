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
	@FindBy(id = "continue")
	WebElement continueButton;
	@FindBy(xpath = "//div[contains(text(),'Enter your email or mobile phone number')]")
	WebElement errorMessage;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//h1[contains(text(),'Sign-In')]")
	WebElement signInLabel;
	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;
	@FindBy(xpath = "//label[@for='ap_email']")
	WebElement emailPhoneLabel;
	@FindBy(xpath = "//div[@id='legalTextRow']")
	WebElement legalText;
	@FindBy(xpath = "//a[contains(text(),'Create your Amazon account')]")
	WebElement createAccountLink;
	@FindBy(xpath = "//span[text()='Account & Lists']")
	WebElement accountLists;
	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signOut;
	
	
	

	public boolean login() {
		boolean isTrue = false;
		boolean lablesDisplayed =false;
		try {
			logger.info("Click on Login button");
			this.click(login);
			verifyLoginErrorwithBlankPhoneEmail();
			this.sendKeys(email, "ravi89614@gmail.com");
			//lablesDisplayed = areLabelsDisplayed();
			this.click(continueButton);						
			this.sendKeys(password, "ravi*1122");
			this.click(signInSubmit);
			this.moveToElement(accountLists);
		isTrue = this.isElementDisplayed(signOut, 30);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isTrue;
	}

	public boolean areLabelsDisplayed() {
		boolean isSigILabelDisplayed = false;
		boolean isEmailPhonelabel = false;
		boolean isLegalTextDisplayed = false;
		boolean isCreateAccountLinkDisplayed = false;
		boolean isContinueButtonEnabled = false;
		
		boolean isTrue = false;

		isSigILabelDisplayed = this.isElementDisplayed(signInLabel, 10);
		isEmailPhonelabel = this.isElementDisplayed(emailPhoneLabel, 10);
		isLegalTextDisplayed = this.isElementDisplayed(legalText, 10);
		isCreateAccountLinkDisplayed = this.isElementDisplayed(createAccountLink, 10);
		isContinueButtonEnabled = this.isElementEnabled(continueButton, 10);
		this.click(continueButton);
		
		if (isSigILabelDisplayed && isEmailPhonelabel && isLegalTextDisplayed && isCreateAccountLinkDisplayed && isContinueButtonEnabled) {
			isTrue = true;
		}
		return isTrue;
	}

	public boolean verifyLoginErrorwithBlankPhoneEmail() {
		boolean isTrue = false;
		logger.info("Verify Error message with blank phone or email");
		this.click(continueButton);
		// continueButton.click();
		isTrue = errorMessage.isDisplayed();
		System.out.println("Login clicked");
		return isTrue;
	}

}
