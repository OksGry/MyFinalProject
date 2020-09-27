package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.CoronavirusPage;
import com.BBC.MyFinalProject.pages.NewsPage;
import com.BBC.MyFinalProject.pages.StoryFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


public class SubmitStoryForm {

    private final NewsPage newsPage = new NewsPage(DriverManager.getDriver());
    private final CoronavirusPage coronavirusPage = new CoronavirusPage(DriverManager.getDriver());
    private final StoryFormPage storyFormPage = new StoryFormPage(DriverManager.getDriver());

    @Given("the user go to Coronavirus page")
    public void theUserGoToCoronavirusPage() {
        newsPage.clickCoronaButton();
    }

    @Given("the user click on Your Coronavirus Stories")
    public void theUserClickOnYourCoronavirusStories() {
        coronavirusPage.clickYourStoryButton();
    }

    @Given("the user click on How to share with BBC News")
    public void theUserClickOnHowToShareWithBBCNews() {
        coronavirusPage.clickHowToShareButton();
        coronavirusPage.waitForPageLoadComplete();
    }

    @When("the user fills the Name field with a valid value")
    public void theUserFillsTheNameField() {
        final String NAME = "Kuhulin";
        storyFormPage.inputData(storyFormPage.getInputNameField(), NAME);
    }

    @And("the user fills the Email field with a valid value")
    public void theUserFillsTheEmailField() {
        final String EMAIL = "IrishYersh@gmail.com";
        storyFormPage.inputData(storyFormPage.getInputEmailField(), EMAIL);
    }

    @And("the user fills the Phone field with a valid value")
    public void theUserFillsThePhoneField() {
        final String PHONE_NUMBER = "7559066899";
        storyFormPage.inputData(storyFormPage.getInputNumberField(), PHONE_NUMBER);
    }

    @And("the user fills the Location field with a valid value")
    public void theUserFillsTheLocationField() {
        final String LOCATION = "Dublin";
        storyFormPage.inputData(storyFormPage.getInputLocationField(), LOCATION);
    }

    @When("the user fills the Tell us your story field with a valid value")
    public void theUserFillsTheTellUsYourStoryField() {
        final String STORY = "Venezuela accused of 'egregious' crimes by UN";
        storyFormPage.inputData(storyFormPage.getTextFieldForStory(), STORY);
    }

    @And("the user selects the 'Please don't publish my name' checkbox")
    public void theUserSelectsTheCheckboxPublishingName() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxPublishingName());
    }

    @And("the user selects the 'I am over 16 years old' checkbox")
    public void theUserSelectsTheCheckboxConfirmAge() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxConfirmAge());
    }

    @And("the user selects the 'I accept the Terms of Service' checkbox")
    public void theUserSelectsTheCheckboxTeamsOfService() {
        storyFormPage.clickCheckbox(storyFormPage.getCheckboxTeamsOfService());
    }

    @And("the user submit form")
    public void theUserSubmitForm() {
        storyFormPage.clickSubmitButton();
    }

    @Then("url page the same what expected")
    public void urlPageTheSameWhatExpected() {
        final String URL_STORY_PAGE = "https://www.bbc.com/news/10725415";
        assertThat(storyFormPage.getUrl())
                .overridingErrorMessage(
                        "The url current page %s does not match the expected %s",
                        storyFormPage.getUrl(), URL_STORY_PAGE)
                .isEqualTo(URL_STORY_PAGE);
    }
}
