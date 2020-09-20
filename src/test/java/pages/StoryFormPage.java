package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoryFormPage extends BasePage {

    @FindBy(tagName = "textarea")
    protected static WebElement textFieldForStory;

    @FindBy(xpath = "//input[@placeholder='Name']")
    protected static WebElement inputNameField;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    protected static WebElement inputEmailField;

    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    protected static WebElement inputNumberField;

    @FindBy(xpath = "//input[@placeholder='Location ']")
    protected static WebElement inputLocationField;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=5]//input[@type='checkbox']")
    protected static WebElement checkboxPublishingName;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=6]//input[@type='checkbox']")
    protected static WebElement checkboxConfirmAge;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=7]//input[@type='checkbox']")
    protected static WebElement checkboxTeamsOfService;

    @FindBy(xpath = "//button[text()='Submit']")
    protected static WebElement submitButton;


    public StoryFormPage(WebDriver driver) {
        super(driver);
    }

    public StoryFormPage inputData(WebElement inputField, String data) {
        if (!data.equals("")) {
            inputField.sendKeys(data);
        }
        return this;
    }

    public StoryFormPage clickCheckbox(WebElement checkbox, String check) {
        if (check.equals("yes")) {
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
