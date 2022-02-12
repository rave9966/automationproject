package com.p99soft.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.p99soft.pages.AmazonHomePage;
import com.p99soft.pages.BaseConstants;
import com.p99soft.pages.BasePageObject;
import com.p99soft.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	//LoginPage loginpage;
	@Test
	public void login() { 		
		System.out.println("Object value is " + amazonHomePage);
		loginPage.login();	
	}
	@Test(dependsOnMethods = {"login"})
	public void verifyLoginErrorwithBlankPhoneEmail() { 		
		//System.out.println("Object value is " + amazonHomePage);
		//assertTrue(true, loginPage.verifyLoginErrorwithBlankPhoneEmail());			
		assertTrue(loginPage.verifyLoginErrorwithBlankPhoneEmail(), "verified error message");
	}
		
	}
	

