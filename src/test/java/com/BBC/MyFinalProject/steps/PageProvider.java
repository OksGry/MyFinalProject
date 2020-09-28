package com.BBC.MyFinalProject.steps;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.*;
import org.openqa.selenium.WebDriver;

public class PageProvider {

    private static final WebDriver driver = DriverManager.getDriver();

    public static final HomePage homePage = new HomePage(driver);
    public static final NewsPage newsPage = new NewsPage(driver);
    public static final CoronavirusPage  coronavirusPage = new CoronavirusPage(driver);
    public static final SearchResultPage searchResultPage = new SearchResultPage(driver);
    public static final StoryFormPage storyFormPage = new StoryFormPage(driver);

}
