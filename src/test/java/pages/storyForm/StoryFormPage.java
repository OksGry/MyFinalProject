package pages.storyForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class StoryFormPage extends BasePage {

    @FindBy(tagName = "textarea")
    protected WebElement textFieldForStory;

    @FindBy(xpath = "//input[@placeholder='Name']")
    protected  WebElement inputNameField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    protected  WebElement inputEmailField;

    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    protected  WebElement inputNumberField;

    @FindBy(xpath = "//input[@placeholder='Location ']")
    protected  WebElement inputLocationField;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=5]//input[@type='checkbox']")
    protected  WebElement checkboxPublishingName;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=6]//input[@type='checkbox']")
    protected  WebElement checkboxConfirmAge;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=7]//input[@type='checkbox']")
    protected  WebElement checkboxTeamsOfService;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;


    public StoryFormPage(WebDriver driver) {
        super(driver);
    }

    public StoryFormPage inputData(WebElement inputField, String data) {
        if (!data.trim().isEmpty()) {
            inputField.sendKeys(data);
        }
        return this;
    }

    public StoryFormPage clickCheckbox(WebElement checkbox, String check) {
        if (check.equalsIgnoreCase("yes")) {
            checkbox.click();
        }
        return this;
    }

    public StoryFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
