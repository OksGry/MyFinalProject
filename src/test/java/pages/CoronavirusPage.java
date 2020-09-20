package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//nav[@class = 'nw-c-nav__wide-secondary']//span[text()='Your Coronavirus Stories']")
    private WebElement yourStoryButton;

    @FindBy(xpath = "//a[@href = '/news/10725415']")
    private WebElement howToShareButton;

    public CoronavirusPage(WebDriver driver) {

        super(driver);
    }

    public CoronavirusPage clickYourStoryButton() {
        waitForPageLoadComplete();
        yourStoryButton.click();
        return this;
    }

    public Form clickHowToShareButton() {
        waitForPageLoadComplete();
        howToShareButton.click();
        return new Form(driver);
    }
}
