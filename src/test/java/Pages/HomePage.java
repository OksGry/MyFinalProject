package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[text()='News']")
    private WebElement newsButton;

    public NewsPage clickNewsButton(){
        newsButton.click();
        return new NewsPage(getDriver());

    }

}
