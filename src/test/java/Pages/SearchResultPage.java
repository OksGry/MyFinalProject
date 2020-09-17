package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p//span[@aria-hidden='false']")
    private WebElement searchResult;

    public String getTextOfSearchResult(){
       return searchResult.getText();
    }
}
