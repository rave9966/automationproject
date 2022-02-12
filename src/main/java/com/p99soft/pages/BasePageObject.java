package com.p99soft.pages;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	// public static WebDriver driver;
	public static Logger logger = Logger.getLogger(BasePageObject.class);

	public static void setUpConfiguration() {

		if (BaseConstants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			// driver = new ChromeDriver();
		}
		// driver.manage().window().maximize();
		logger.info("Chrome Maximized");
	}

	public void quitBrowser() {
		logger.info("Closed Chrome browser");
		driver.quit();

	}

	protected void click(WebElement element) {
		logger.info("CLicking on Element");
		try {
			element.click();

		} catch (NoSuchElementException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void sendKeys(WebElement element, String text, boolean logInputText) {
		try {
			if (logInputText)
				logger.info("Setting text" + text + "in element" + element);
			element.clear();
			element.sendKeys(text);

		} catch (NoSuchElementException e) {
			logger.warn("Failed to send Keys" + e.getMessage());
		} catch (Exception e) {
			logger.warn("Failed to send Keys" + e.getMessage());
		}

	}

}
