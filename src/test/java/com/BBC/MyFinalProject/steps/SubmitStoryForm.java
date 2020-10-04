package com.BBC.MyFinalProject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class SubmitStoryForm {

    private final PageProvider pageProvider = new PageProvider();

    @And("the user go to Coronavirus page")
    public void theUserGoToCoronavirusPage() {
        pageProvider.newsPage.clickCoronaButton();
    }

    @And("the user click on Your Coronavirus Stories")
    public void theUserClickOnYourCoronavirusStories() {
        pageProvider.coronavirusPage.clickYourStoryButton();
    }

    @And("the user click on How to share with BBC News")
    public void theUserClickOnHowToShareWithBBCNews() {
        pageProvider.coronavirusPage.clickHowToShareButton();
        pageProvider.coronavirusPage.waitForPageLoadComplete();
    }

    @When("the user fills the {string} field with a valid value {string}")
    public void theUserFillsTheFieldWithAValidValue(String nameField, String valueField) {
        pageProvider.storyFormPage.fillField(nameField, valueField);
    }

    @And("the user selects the {string} checkbox")
    public void theUserSelectsTheCheckbox(String nameCheckbox) {
        pageProvider.storyFormPage.clickCheckbox(nameCheckbox);
    }

    @And("the user submit form")
    public void theUserSubmitForm() {
        pageProvider.storyFormPage.clickSubmitButton();
    }

    @Then("url page the same what expected")
    public void urlPageTheSameWhatExpected() {
        final String EXPECTED_URL = "https://www.bbc.com/news/10725415";
        String ACTUAL_URL = pageProvider.storyFormPage.getUrl();
        assertThat(ACTUAL_URL)
                .overridingErrorMessage(
                        "The url current page %s does not match the expected %s",
                        ACTUAL_URL, EXPECTED_URL)
                .isEqualTo(EXPECTED_URL);
    }
}