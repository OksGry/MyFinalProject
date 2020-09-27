package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.BasePage;
import com.BBC.MyFinalProject.pages.HomePage;
import com.BBC.MyFinalProject.pages.NewsPage;
import com.BBC.MyFinalProject.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
import io.cucumber.java.en.When;

public class News{

    private String SEARCH_KYE = "";

    private final String[] arrayNamesOfArticles = {
            "Lebanon rifts sink efforts to form new government",
            "Trump 'to pick Amy Coney Barrett' for Supreme Court",
            "Stabbings suspect 'was targeting Charlie Hebdo'",
            "Bollywood star questioned in India drugs case",
            "Sparks fly during police chase"};

    private final HomePage homePage = new HomePage(DriverManager.getDriver());
    private final NewsPage newsPage = new NewsPage(DriverManager.getDriver());
    private final SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());

    @Given("the user open BBC website")
    public void openWebSite() {
        String BBC_URL = "https://www.bbc.com/";
        DriverManager.getDriver().get(BBC_URL);
    }

    @Given("the user go to News")
    public void clickNewsButton() {
       homePage.clickNewsButton();
    }

    @Given("the user close popup")
    public void clickSignInLaterButton() {
       newsPage.clickSignInLaterButton();
    }

    @When("stores the text of the Category of the headline article")
    public void storesTheTextOfTheCategoryOfTheHeadlineArticle() {
        SEARCH_KYE = newsPage.getCategoryText();
    }

    @And("enter this text in the Search bar")
    public void enterThisTextInTheSearchBar() {
        newsPage.searchByKeyword();
    }

    @Then("the name of the headline article to match the expected <title>")
    public void checkTheNameOfTheHeadlineArticle(String expTitle){
        newsPage.waitForPageLoadComplete();
        assertThat(newsPage.getTextFromHeadlineArticle()).overridingErrorMessage("").isEqualTo(expTitle);
    }

    @Then("secondary article titles to match the list of expected titles")
    public void secondaryArticleTitlesToMatchTheListOfExpectedTitles() {
        assertThat(newsPage.checkWhatSecondLineArticlesMatch(arrayNamesOfArticles)).overridingErrorMessage("").isEqualTo(5);
    }


    @Then("the name of the first article include the text of the Category")
    public void theNameOfTheFirstArticleIncludeTheTextOfTheCategory() {
        assertThat(searchResultPage.getTextOfSearchResult()).overridingErrorMessage("").contains(SEARCH_KYE);
    }


}
