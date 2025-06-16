package hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.BaseTest;

public class Hooks {
    // --> Why we use Hooks class? Because it allows us to set up and tear down the WebDriver before and after each scenario.

	// If We not using Hooks class then we can user annotations like @Before and @After in BaseTest class also.
	// but it is better to keep them in a separate class for better organization.
	// This class is used to set up and tear down the WebDriver before and after each scenario.

	static BaseTest base = new BaseTest();

    @BeforeAll
    public static void initBrowser() {
        base.setUp();
    }

    @AfterAll
    public static void closeBrowser() {
        base.tearDown();
    }
}

// --> why we use create static because @BeforeAll and @AfterAll must be static in JUnit 4/5 
//(and also with Cucumber when integrated with TestNG).