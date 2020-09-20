package pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Form extends BasePage {

    public Form(WebDriver driver) {
        super(driver);
    }

    public StoryFormPage fillForm(Map<String, String> data) {

        waitForPageLoadComplete(20);

        return new StoryFormPage(driver)
                .inputData(StoryFormPage.textFieldForStory, data.get("text"))
                .inputData(StoryFormPage.inputNameField, data.get("name"))
                .inputData(StoryFormPage.inputEmailField, data.get("email"))
                .inputData(StoryFormPage.inputNumberField, data.get("phone_number"))
                .inputData(StoryFormPage.inputLocationField, data.get("location"))

                .clickCheckbox(StoryFormPage.checkboxPublishingName, data.get("checkbox_publishing_name"))
                .clickCheckbox(StoryFormPage.checkboxConfirmAge, data.get("checkbox_confirm_age"))
                .clickCheckbox(StoryFormPage.checkboxTeamsOfService, data.get("checkbox_teams_of_service"));
    }
}
