package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.HomePage;
import com.BBC.MyFinalProject.pages.NewsPage;
import com.BBC.MyFinalProject.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class News {

    private final String[] arrayNamesOfArticles = {
            "Lebanon rifts sink efforts to form new government",
            "Trump 'to pick Amy Coney Barrett' for Supreme Court",
            "Stabbings suspect 'was targeting Charlie Hebdo'",
            "Bollywood star questioned in India drugs case",
            "Sparks fly during police chase"};
    private final HomePage homePage = new HomePage(DriverManager.getDriver());
    private final NewsPage newsPage = new NewsPage(DriverManager.getDriver());
    private final SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());
    private String searchKey = "";

    @Given("the user open BBC website")
    public void openWebSite() {
        String URL = "https://www.bbc.com/";
        DriverManager.getDriver().get(URL);
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
        searchKey = newsPage.getCategoryText();
    }

    @And("enter this text in the Search bar")
    public void enterThisTextInTheSearchBar() {
        newsPage.searchByKeyword();
    }

    // чи можно робити щось накшталт цього - створювати окрему змінну для методу який дає actual result перед асертом,
    // чи краще залишити як методах що нижче?
    @Then("the name of the headline article to match the expected <title>")
    public void checkTheNameOfTheHeadlineArticle(String expTitle) {
        String actualResult = newsPage.getTextFromHeadlineArticle();

        assertThat(actualResult)
                .overridingErrorMessage(
                        "The name of the headline article <%s> doesn't match the expected <%s>",
                        actualResult, expTitle)
                .isEqualTo(expTitle);
    }

    @Then("secondary article titles to match the list of expected titles")
    public void secondaryArticleTitlesToMatchTheListOfExpectedTitles() {
        assertThat(newsPage.checkWhatSecondLineArticlesMatch(arrayNamesOfArticles))
                .overridingErrorMessage("Secondary article titles doesn't match the list of expected titles")
                .isEqualTo(5);
    }

    @Then("the name of the first article include the text of the Category")
    public void theNameOfTheFirstArticleIncludeTheTextOfTheCategory() {
        assertThat(searchResultPage.getTextOfSearchResult())
                .overridingErrorMessage(
                        "The name of the first article <%s> doesn't include <%s>",
                        searchResultPage.getTextOfSearchResult(), searchKey)
                .contains(searchKey);
    }
}
