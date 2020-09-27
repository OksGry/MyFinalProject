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

    private final String URL_STORY_PAGE = "https://www.bbc.com/news/10725415";
    private final String STORY = "Venezuela accused of 'egregious' crimes by UN";
    private final String NAME = "Kuhulin";
    private final String EMAIL = "IrishYersh@gmail.com";
    private final String PHONE_NUMBER = "7559066899";
    private final String LOCATION = "Dublin";

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
    public void theUserFillsTheNameFieldWithAValidValue() {
        storyFormPage.inputData(storyFormPage.getInputNameField(),NAME);
    }

    @And("the user fills the Email field with a valid value")
    public void theUserFillsTheEmailFieldWithAValidValue() {
        storyFormPage.inputData(storyFormPage.getInputEmailField(),EMAIL);
    }

    @And("the user fills the Phone field with a valid value")
    public void theUserFillsThePhoneFieldWithAValidValue() {
        storyFormPage.inputData(storyFormPage.getInputNumberField(),PHONE_NUMBER);
    }

    @And("the user fills the Location field with a valid value")
    public void theUserFillsTheLocationFieldWithAValidValue() {
        storyFormPage.inputData(storyFormPage.getInputLocationField(), LOCATION);
    }

    @When("the user fills the Tell us your story field with a valid value")
    public void theUserFillsTheTellUsYourStoryFieldWithAValidValue() {
        storyFormPage.inputData(storyFormPage.getTextFieldForStory(),STORY);
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
        assertThat(storyFormPage.getUrl(DriverManager.getDriver())).overridingErrorMessage("").isEqualTo(URL_STORY_PAGE);
    }

}
