package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Pages.FacebookLoginPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import utils.BaseTest;

public class FacebookLoginSteps {

    private FacebookLoginPage fbLogin;

    /* ---------- GIVEN ---------- */
    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
        BaseTest.driver.get("https://www.facebook.com/");
        fbLogin = new FacebookLoginPage(BaseTest.driver);
    }

    /* ---------- WHEN (two sentence variants) ---------- */
    @When("I enter login Id: {string} and password: {string}")
    @When("I enter {string} and {string}")
    public void i_enter_email_and_password(String email, String password) {
        fbLogin.emailField.clear();
        fbLogin.emailField.sendKeys(email);

        fbLogin.passwordField.clear();
        fbLogin.passwordField.sendKeys(password);
    }

    /* ---------- AND ---------- */
    @And("Hit the Login button")
    public void hit_the_login_button() {
        fbLogin.loginBtn.click();
    }

    /* ---------- THEN #1 – generic message coming from Examples table ---------- */
    @Then("I should see {string} message")
    public void i_should_see_specific_error_message(String expectedMsg) {
        boolean found = BaseTest.driver.getPageSource().contains(expectedMsg);
        assert found : "Expected message not found: " + expectedMsg;
    }

    /* ---------- THEN #2 – simple login‑error keyword ---------- */
    @Then("I should see a login error")
    public void i_should_see_a_login_error() {
        // a quick generic check; refine with proper locators if needed
        boolean found = BaseTest.driver.getPageSource().toLowerCase().contains("incorrect")
                     || BaseTest.driver.getPageSource().toLowerCase().contains("not connected");
        assert found : "Login error message was NOT displayed.";
    }

    /* ---------- THEN #3 – success path ---------- */
    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        // simplest sanity check: URL contains facebook.com and NOT /login
        boolean onHome = BaseTest.driver.getCurrentUrl().startsWith("https://www.facebook.com/")
                      && !BaseTest.driver.getCurrentUrl().contains("login");
        assert onHome : "User was NOT redirected to the Facebook home page.";
    }

    /* ---------- Screenshot on failure ---------- */
    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] shot = ((TakesScreenshot) BaseTest.driver)
                          .getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", "failure");
        }
    }
}
