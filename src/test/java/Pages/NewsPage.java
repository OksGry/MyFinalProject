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


    public String getTextFromHeadlineArticle(){
        return  headlineArticle.getText();
    }

    public List<WebElement> getListSecondLineArticles(){
        return  listSecondLineArticles;
    }

    public void searchByKeyword( String keyword){
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickCoronaButton(){
        coronaButton.click();
    }

}
