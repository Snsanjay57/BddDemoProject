package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    public FacebookLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "pass")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginBtn;
    
}
