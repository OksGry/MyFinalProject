package com.BBC.MyFinalProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoryFormPage extends BasePage {

    @FindBy(tagName = "textarea")
    private WebElement textFieldForStory;
    public WebElement getTextFieldForStory(){return textFieldForStory;}

    @FindBy(xpath = "//input[@placeholder='Name']")
    private   WebElement inputNameField;
    public WebElement getInputNameField(){return inputNameField;}

    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement inputEmailField;
    public WebElement getInputEmailField(){return inputEmailField;}

    @FindBy(xpath = "//input[@placeholder='Contact number ']")
    private WebElement inputNumberField;
    public WebElement getInputNumberField(){return inputNumberField;}

    @FindBy(xpath = "//input[@placeholder='Location ']")
    private WebElement inputLocationField;
    public WebElement getInputLocationField(){return inputLocationField;}

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=5]//input[@type='checkbox']")
    private WebElement checkboxPublishingName;
    public WebElement getCheckboxPublishingName(){return checkboxPublishingName;}

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=6]//input[@type='checkbox']")
    private WebElement checkboxConfirmAge;
    public WebElement getCheckboxConfirmAge(){return checkboxConfirmAge;}

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='checkbox' and position()=7]//input[@type='checkbox']")
    private WebElement checkboxTeamsOfService;
    public WebElement getCheckboxTeamsOfService(){return checkboxTeamsOfService;}

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;


    public StoryFormPage(WebDriver driver) {
        super(driver);
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

    public String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
