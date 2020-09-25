package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.HomePage;
import com.BBC.MyFinalProject.pages.NewsPage;
import com.BBC.MyFinalProject.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
import io.cucumber.java.en.When;


public class News{

    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private NewsPage newsPage = new NewsPage(DriverManager.getDriver());
    private SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());

    @Then("the name of the headline article to match the expected <title>")
    public void checkTheNameOfTheHeadlineArticle(String expTitle){
        assertThat(newsPage.getTextFromHeadlineArticle()).overridingErrorMessage("").isEqualTo(expTitle);
    }

    @Then("secondary article titles to match the list of expected <titles>")
    public void secondaryArticleTitlesToMatchTheListOfExpectedTitles(String[] arrayNamesOfArticles) {
        assertThat(newsPage.checkWhatSecondLineArticlesMatch(arrayNamesOfArticles)).overridingErrorMessage("").isEqualTo(5);
    }

    @When("stores the text of the <Category> of the headline article")
    public void storesTheTextOfTheCategoryOfTheHeadlineArticle() {
        newsPage.getTextFromHeadlineArticle();
    }

    @And("enter this text in the Search bar")
    public void enterThisTextInTheSearchBar() {
        newsPage.searchByKeyword();
    }

    @Then("the name of the first article include the text of the <Category>")
    public void theNameOfTheFirstArticleIncludeTheTextOfTheCategory() {
        assertThat(searchResultPage.getTextOfSearchResult()).overridingErrorMessage("").contains(newsPage.getCategoryText());
    }


}
