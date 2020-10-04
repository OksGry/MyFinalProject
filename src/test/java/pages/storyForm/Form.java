package pages.storyForm;

import org.openqa.selenium.WebDriver;
import java.util.Map;

public class Form extends StoryFormPage {

    public Form(WebDriver driver) {
        super(driver);
    }

    public StoryFormPage fillForm(Map<String, String> data) {

        waitForPageLoadComplete(20);

        return new StoryFormPage(driver)
                .inputData(textFieldForStory, data.get("text"))
                .inputData(inputNameField, data.get("name"))
                .inputData(inputEmailField, data.get("email"))
                .inputData(inputNumberField, data.get("phone_number"))
                .inputData(inputLocationField, data.get("location"))

                .clickCheckbox(checkboxPublishingName, data.get("checkbox_publishing_name"))
                .clickCheckbox(checkboxConfirmAge, data.get("checkbox_confirm_age"))
                .clickCheckbox(checkboxTeamsOfService, data.get("checkbox_teams_of_service"));
    }
}
