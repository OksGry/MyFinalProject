package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.StoryFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class SubmitStoryForm {

    private final String URL_STORY_PAGE = "https://www.bbc.com/news/10725415";
    private StoryFormPage storyFormPage = new StoryFormPage(DriverManager.getDriver());


    @And("the user selects the 'Please don't publish my name' checkbox")
    public void theUserSelectsTheCheckboxPublishingName() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxPublishingName());
    }

    @And("the user selects the 'I am over 16 years old' checkbox")
    public void theUserSelectsTheCheckboxConfirmAge() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxPublishingName());
    }

    @And("the user selects the 'I accept the Terms of Service' checkbox")
    public void theUserSelectsTheCheckboxTeamsOfService() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxPublishingName());
    }

    @And("the user submit form")
    public void theUserSubmitForm() {
    }

    @Then("url page the same what expected")
    public void urlPageTheSameWhatExpected() {
        assertThat(storyFormPage.getUrl(DriverManager.getDriver())).overridingErrorMessage("").isEqualTo(URL_STORY_PAGE);
    }


    @When("the user fills the <name> field with a valid value")
    public void theUserFillsTheNameFieldWithAValidValue(String name) {
        storyFormPage.inputData(storyFormPage.getInputNameField(), name);
    }
}
