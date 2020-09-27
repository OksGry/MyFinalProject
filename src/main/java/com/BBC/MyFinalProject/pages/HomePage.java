package com.BBC.MyFinalProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[text()='News']")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickNewsButton() {
        newsButton.click();
    }
}
