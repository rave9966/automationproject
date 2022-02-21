package com.p99soft.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	protected void sendKeys(WebElement element, String text) {
		try {
			logger.info("Setting text" + text + "in element" + element);
			element.clear();
			element.sendKeys(text);

		} catch (NoSuchElementException e) {
			logger.warn("Failed to send Keys" + e.getMessage());
		} catch (Exception e) {
			logger.warn("Failed to send Keys" + e.getMessage());
		}

	}
	
	public boolean isElementDisplayed(WebElement element, int timeOutSeconds) {
		boolean isPresent;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isPresent = element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		return isPresent;
	}

	
	protected boolean isElementEnabled(WebElement element, int timeInSeconds) {
		boolean isTrue = false;
		try {
			isTrue = element.isEnabled();
			logger.info("Element is enabled");
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
		}
		return isTrue;
	}

	protected void moveToElement(WebElement element) {
		try {
			logger.info("Moving to element" + element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to move to element " + e.getMessage());
		} 
	}

	
	public void readDataFromExcel(String[] args) throws IOException {
		// I have placed an excel file 'Test.xlsx' in my D Driver
		FileInputStream fis = new FileInputStream("user.dir" + "\\src\\test\\resources\\testdata\\chromedriver.exe");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		// I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		// Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);
		System.out.println(sheet.getRow(0).getCell(0));
//String cellval = cell.getStringCellValue();
//System.out.println(cellval);

	}

}
