package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
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

    private String searchKey = "";

    private final PageProvider pageProvider = new PageProvider();


    @Given("the user open BBC website")
    public void openWebSite() {
        DriverManager.getDriver().get("https://www.bbc.com/");
    }

    @And("the user go to News")
    public void clickNewsButton() {
        pageProvider.homePage.clickNewsButton();
    }

    @And("the user close popup")
    public void clickSignInLaterButton() {
        pageProvider.newsPage.clickSignInLaterButton();
    }

    @When("stores the text of the Category of the headline article")
    public void storesTheTextOfTheCategoryOfTheHeadlineArticle() {
        searchKey = pageProvider.newsPage.getCategoryText();
    }

    @And("enter this text in the Search bar")
    public void enterTextOfCategoryInTheSearchBar() {
        pageProvider.newsPage.searchByKeyword();
    }

    @Then("the name of the headline article to match the expected <title>")
    public void checkTheNameOfTheHeadlineArticle(String expTitle) {
        String actualResult = pageProvider.newsPage.getTextFromHeadlineArticle();

        assertThat(actualResult)
                .overridingErrorMessage(
                        "The name of the headline article <%s> doesn't match the expected <%s>",
                        actualResult, expTitle)
                .isEqualTo(expTitle);
    }

    @Then("secondary article titles to match the list of expected titles")
    public void secondaryArticleTitlesToMatchTheListOfExpectedTitles() {
        int actualResult = pageProvider.newsPage.checkWhatSecondLineArticlesMatch(arrayNamesOfArticles);

        assertThat(actualResult)
                .overridingErrorMessage("Secondary article titles doesn't match the list of expected titles")
                .isEqualTo(5);
    }

    @Then("the name of the first article include the text of the Category")
    public void theNameOfTheFirstArticleIncludeTheTextOfTheCategory() {
        String actualResult = pageProvider.searchResultPage.getTextOfSearchResult();

        assertThat(actualResult)
                .overridingErrorMessage(
                        "The name of the first article <%s> doesn't include <%s>",
                        actualResult, searchKey)
                .contains(searchKey);
    }
}
