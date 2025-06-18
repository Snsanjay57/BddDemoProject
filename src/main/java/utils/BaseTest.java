package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
    // --> Why we use static WebDriver? Because we want to share the same WebDriver instance across all tests.
    public static WebDriver driver;
    
    
//    static BaseTest base = new BaseTest();    
 // --> why we use create static because @BeforeAll and @AfterAll must be static in JUnit 4/5 
//      (and also with Cucumber when integrated with TestNG).
//    
//    @BeforeAll 
//    public static void initBrowser() {
//    	// call setUp method by reference.
//    	         base.setUp();	
//    }
     
    /** called once per scenario by Hooks */
    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            LoggerHelper.info("Browser launched");
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
            LoggerHelper.info("Browser closed");
        }
    }
    
//    @AfterAll
//    public static void closeBrowser() {
//        base.tearDown();
//    }
}


// If We not using Hooks class then we can user annotations like @Before and @After in BaseTest class also.
// but it is better to keep them in a separate class for better organization.
// This class is used to set up and tear down the WebDriver before and after each scenario.