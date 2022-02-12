package com.p99soft.test;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.p99soft.pages.AmazonHomePage;
import com.p99soft.pages.BaseConstants;
import com.p99soft.pages.BasePageObject;
import com.p99soft.pages.LoginPage;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	public LoginPage loginPage;
	public AmazonHomePage amazonHomePage;
	public BasePageObject basePageObject;
	
	
	public void loadPageObjects(WebDriver driver) {
		loginPage = new LoginPage(driver);
		amazonHomePage = new AmazonHomePage(driver);
		basePageObject = new BasePageObject(driver);
		}
	
	@BeforeClass
	public void initialization() throws IOException {
		/*
		 * prop = new Properties();
		 * 
		 * // FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
		 * "\\src\\main\\java\\com\\crm\\qa\\config\\config.propeties"); //
		 * prop.load(ip); //String browserName = prop.getProperty("browser"); String
		 * browserName = "chrome"; if(browserName.equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\src\\main\\resources\\drivers\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 * 
		 * }
		 */
		
		if (BaseConstants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//driver.manage().window().maximize();
		//logger.info("Chrome Maximized");
		
		loadPageObjects(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		
		//driver.get("https://www.amazon.in");
		driver.get(BaseConstants.testsiteurl);
	}
	
	@AfterClass
	public void afterClass(ITestContext context) {
		System.out.println("entred after class, dirver quit");
			driver.quit();
		}
}
