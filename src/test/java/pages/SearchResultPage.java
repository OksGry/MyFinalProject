package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//p//span[@aria-hidden='false']")
    private WebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfSearchResult() {
        return searchResult.getText();
    }
}
