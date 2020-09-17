package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[text()='News']")
    private WebElement newsButton;

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement signInLater;

    public void clickNewsButton(){
        newsButton.click();
    }

    public WebElement getSignInLater(){ return signInLater;}

    public void clickSignInLaterButton(){

        waitVisibilityOfElement(10, signInLater);
        signInLater.click();
    }
}
