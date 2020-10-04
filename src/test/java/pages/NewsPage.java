package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//h3")
    private WebElement headlineArticle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//li[@class ='nw-c-promo-meta']//span")
    private WebElement categoryLink;

    @FindBy(xpath = "//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> listSecondLineArticles;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchInput;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']")
    private WebElement coronaButton;

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement signInLater;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromHeadlineArticle() {
        return headlineArticle.getText();
    }

    public String getCategoryText() {
        return categoryLink.getText();
    }

    public SearchResultPage searchByKeyword() {
        searchInput.sendKeys(categoryLink.getText(), Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public CoronavirusPage clickCoronaButton() {
        coronaButton.click();
        return new CoronavirusPage(driver);
    }

    public NewsPage clickSignInLaterButton() {

        waitVisibilityOfElement(signInLater);
        signInLater.click();
        return this;
    }

    public int checkWhatSecondLineArticlesMatch(String[] arrayNamesOfArticles) {
        waitForPageLoadComplete();
        int count = 0;
        for (WebElement webElement : listSecondLineArticles) {
            for (String name : arrayNamesOfArticles) {
                if (webElement.getText().equals(name))
                    count++;
            }
        }
        return count;
    }

}
