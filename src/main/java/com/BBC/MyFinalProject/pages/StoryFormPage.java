package com.BBC.MyFinalProject.pages;

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


    public void clickCheckbox(String nameCheckbox) {
        switch (nameCheckbox) {
            case "Please don't publish my name": {
                checkboxPublishingName.click();
                break;
            }
            case "I am over 16 years old": {
                checkboxConfirmAge.click();
                break;
            }
            default: {
                checkboxTeamsOfService.click();
            }
        }
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void fillField(String nameField, String valueForField) {

        switch (nameField) {
            case "Story": {
                textFieldForStory.sendKeys(valueForField);
                break;
            }
            case "Name": {
                inputNameField.sendKeys(valueForField);
                break;
            }
            case "Email address": {
                inputEmailField.sendKeys(valueForField);
                break;
            }
            case "Contact number": {
                inputNumberField.sendKeys(valueForField);
                break;
            }
            default: {
                inputLocationField.sendKeys(valueForField);
            }
        }
    }
}
