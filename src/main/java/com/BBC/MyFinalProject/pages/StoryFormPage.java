package com.BBC.MyFinalProject.pages;

import com.BBC.MyFinalProject.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public WebElement getTextFieldForStory() {
        return textFieldForStory;
    }

    public WebElement getInputNameField() {
        return inputNameField;
    }

    public WebElement getInputEmailField() {
        return inputEmailField;
    }

    public WebElement getInputNumberField() {
        return inputNumberField;
    }

    public WebElement getInputLocationField() {
        return inputLocationField;
    }

    public WebElement getCheckboxPublishingName() {
        return checkboxPublishingName;
    }

    public WebElement getCheckboxConfirmAge() {
        return checkboxConfirmAge;
    }

    public WebElement getCheckboxTeamsOfService() {
        return checkboxTeamsOfService;
    }

    public void inputData(WebElement inputField, String data) {
        inputField.sendKeys(data);
    }

    public void clickCheckbox(WebElement checkbox) {
        checkbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
