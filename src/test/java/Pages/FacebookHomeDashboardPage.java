package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomeDashboardPage {

    public FacebookHomeDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Bewizor QA']")
    public WebElement profileNameOnPopup;

    @FindBy(className = "x1lliihq x2lah0s x1k90msu x2h7rmj x1qfuztq x198g3q0 xxk0z11 xvy4d1p")
    public WebElement closePopup;

    @FindBy(className = "x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f x1x80s81")
    public WebElement notNowBtn;
    
    @FindBy(className = "//span[text()='Bewizor QA']")
    public WebElement userNameOnDashboard;
    
    @FindBy(className = "x1n2onr6")
    public WebElement homeBtn;

    @FindBy(xpath ="//input[@aria-label='Search Facebook']")
    public WebElement searchbtn;
    
    
    @FindBy(xpath = "//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6\"]")
    public WebElement sanjayMeenaSearchedUser;
}
