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

    public void inputData(WebElement inputField, String data) {
        if(!data.isEmpty()){
            inputField.sendKeys(data);
        }
    }

    public void clickCheckbox(WebElement checkbox, boolean check){
        if(check){
            checkbox.click();
        }
    }

    public StoryFormPage fillForm(String text, String name, String email, String phone, String location, boolean checkbox1, boolean checkbox2, boolean checkbox3){

        waitForPageLoadComplete(20);
        inputData(textFieldForStory,text);
        inputData(inputNameField,name);
        inputData(inputEmailField,email);
        inputData(inputNumberField,phone);
        inputData(inputLocationField,location);
        clickCheckbox(checkboxPublishingName, checkbox1);
        clickCheckbox(checkboxConfirmAge, checkbox2);
        clickCheckbox(checkboxTeamsOfService, checkbox3);
        submitButton.click();
        return new StoryFormPage(this.getDriver());
    }

    public String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
}
