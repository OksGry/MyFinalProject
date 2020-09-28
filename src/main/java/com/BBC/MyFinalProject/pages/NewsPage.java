package com.BBC.MyFinalProject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//h3")
    private WebElement headlineArticle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//a//span[@aria-hidden='true']")
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
        waitForPageLoadComplete();
        return headlineArticle.getText();
    }

    public String getCategoryText() {
        return categoryLink.getText();
    }

    public void searchByKeyword() {
        searchInput.sendKeys(this.getCategoryText(), Keys.ENTER);
    }

    public void clickCoronaButton() {

        coronaButton.click();
    }

    public void clickSignInLaterButton() {
        waitVisibilityOfElement(signInLater);
        signInLater.click();
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
