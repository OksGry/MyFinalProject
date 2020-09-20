package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;


public class StoryFormPage extends BasePage {

    @FindBy(tagName = "textarea")
    private WebElement textFieldForStory;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement inputNameField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    private WebElement inputNumberField;

    @FindBy(xpath = "//input[@placeholder='Location ']")
    private WebElement inputLocationField;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=5]//input[@type='checkbox']")
    private WebElement checkboxPublishingName;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=6]//input[@type='checkbox']")
    private WebElement checkboxConfirmAge;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=7]//input[@type='checkbox']")
    private WebElement checkboxTeamsOfService;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;


    public StoryFormPage(WebDriver driver) {
        super(driver);
    }

    public void inputData(WebElement inputField, String data) {
        if (!data.equals("")) {
            inputField.sendKeys(data);
        }
    }

    public void clickCheckbox(WebElement checkbox, String check) {
        if (check.equals("yes")) {
            checkbox.click();
        }
    }

    public StoryFormPage fillForm(Map<String,String> data) {

        waitForPageLoadComplete(20);

        inputData(textFieldForStory, data.get("text"));
        inputData(inputNameField, data.get("name"));
        inputData(inputEmailField, data.get("email"));
        inputData(inputNumberField, data.get("phone_number"));
        inputData(inputLocationField, data.get("location"));

        clickCheckbox(checkboxPublishingName, data.get("checkbox_publishing_name"));
        clickCheckbox(checkboxConfirmAge, data.get("checkbox_confirm_age"));
        clickCheckbox(checkboxTeamsOfService, data.get("checkbox_teams_of_service"));

        return this;
    }
    public StoryFormPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

    public String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
