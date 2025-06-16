package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {
	 
	WebDriver driver;
	
	@Given("launch the browser")
	public void launch_the_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.google.com");
	    
		System.out.println("Start the Chrome browser successfully");

	}

	@And("navigate to Google page")
	public void navigate_to() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']")).isDisplayed();
		driver.getPageSource().contains("Google");
		System.out.println("Google page lauched successfully");
		}

	@When("enter India Map in the search box field")
	public void enter_in_the_search_box() {
	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.name("q")).click();
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("India map");
		
		System.out.println("India map entered in the search box");
	}

	@And("click on the search button")
	public void click_on_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/descendant::input[@class='gNO89b']")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("CLick on the search button");
	}

	@Then("user is redirected to the search results page")
	public void user_is_redirected_to_the_search_results_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.xpath("//img[@alt='Map of India']")).isDisplayed();
		driver.getPageSource().contains("India map");
		System.out.println("India map search results page displayed successfully");
		Thread.sleep(300);
		driver.quit();
	}

}
