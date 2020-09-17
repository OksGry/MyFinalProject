package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoryFormPage extends BasePage{

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


    public StoryFormPage(WebDriver driver){
        super(driver);
    }

    public void inputStory(String story){
        textFieldForStory.sendKeys(story);
    }

    public void inputName(String name){
        inputNameField.sendKeys(name);
    }

    public void inputEmail(String email){
        inputEmailField.sendKeys(email);
    }

    public void inputPhoneNumber(String number){
        inputNumberField.sendKeys(number);
    }

    public void inputLocation(String location){
        inputLocationField.sendKeys(location);
    }

    public void clickCheckboxPublishingName(){
        checkboxPublishingName.click();
    }

    public void clickCheckboxConfirmAge(){
        checkboxConfirmAge.click();
    }

    public void clickCheckboxTeamsOfService(){
        checkboxTeamsOfService.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
}
