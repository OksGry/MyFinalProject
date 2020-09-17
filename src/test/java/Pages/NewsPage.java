package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{

    public NewsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//h3")
    private WebElement headlineArticle;

    @FindBy(xpath = "//div[contains(@class,'secondary-item')]//h3")
    private List<WebElement> listSecondLineArticles;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchInput;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']")
    private WebElement coronaButton;

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement signInLater;


    public String getTextFromHeadlineArticle(){
        return  headlineArticle.getText();
    }

    public List<WebElement> getListSecondLineArticles(){
        return  listSecondLineArticles;
    }

    public SearchResultPage searchByKeyword( String keyword){
        searchInput.sendKeys(keyword, Keys.ENTER);
        return new SearchResultPage(getDriver());
    }

    public CoronavirusPage clickCoronaButton(){
        coronaButton.click();
        return new CoronavirusPage(getDriver());
    }

    public NewsPage clickSignInLaterButton(){

        waitVisibilityOfElement(10, signInLater);
        signInLater.click();
        return new NewsPage(getDriver());
    }

    public int checkWhatSecondLineArticlesMatch(String [] arrayNamesOfArticles) {
        waitForPageLoadComplete(10);
        int count = 0;
        for (WebElement webElement : listSecondLineArticles) {
            for (String name : arrayNamesOfArticles) {
                if (webElement.getText().equals(name)) {

                    count++;

                }
            }
        }
        return count;
    }

}
