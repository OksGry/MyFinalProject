package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.*;
import org.openqa.selenium.WebDriver;

public class PageProvider {

    private final WebDriver driver = DriverManager.getDriver();


    protected final HomePage homePage = new HomePage(driver);
    protected final NewsPage newsPage = new NewsPage(driver);
    protected final CoronavirusPage coronavirusPage = new CoronavirusPage(driver);
    protected final SearchResultPage searchResultPage = new SearchResultPage(driver);
    protected final StoryFormPage storyFormPage = new StoryFormPage(driver);

}
