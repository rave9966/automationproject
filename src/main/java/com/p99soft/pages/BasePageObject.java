package com.p99soft.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageObject {
	
	protected static WebDriver driver;
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// protected WebDriver driver;

	/*
	 * public BasePageObject(WebDriver driver) { this.driver = driver;
	 * 
	 * 
	 * }
	 * 
	 * @BeforeSuite public void initializeDriver() {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
	 * "\\src\\main\\resources\\drivers\\chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver(); driver.manage().window().maximize();
	 * driver.get("https://www.amazon.in"); }
	 */

	//public static WebDriver driver;
	public static Logger logger = Logger.getLogger(BasePageObject.class);

	public static void setUpConfiguration() {

		if (BaseConstants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			//driver = new ChromeDriver();
		}
		//driver.manage().window().maximize();
		logger.info("Chrome Maximized");
	}
	
	public void quitBrowser() {
		logger.info("Closed Chrome browser");
		driver.quit();

	}

}
