package Tests;


import Pages.StoryFormPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NewsTests extends BaseTest{

    private final String NAME = "Kuhulin";
    private final String EMAIL = "IrishYersh@gmail.com";
    private final String PHONE_NUMBER = "7559066899";
    private final String LOCATION = "Dublin";



    @Test
    public void checkTheNameOfTheHeadlineArticle(){
        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        assertEquals(getNewPage().getTextFromHeadlineArticle(), "Venezuela accused of 'egregious' crimes by UN");

    }

    @Test
    public void checkTheNamesOfSecondLineArticles(){

        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getBasePage().waitForPageLoadComplete(10);
        String arrayNamesOfArticles[] = new String[] {"UK PM blames 'colossal spike' for testing issues","Former athletics head jailed for corruption", "Self-driving car operator charged over fatal crash", "Barbados to remove Queen as head of state", "'Catastrophic flooding' as Hurricane Sally hits US"};
        int  count = 0;
        for (WebElement webElement: getNewPage().getListSecondLineArticles()) {
            for (String name : arrayNamesOfArticles) {
                if (webElement.getText().equals(name)) {

                    count++;

                }
            }
        }
       assertEquals(count,5);

    }

    @Test
    public void checkSearchForArticleByName(){
        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getBasePage().waitForPageLoadComplete(10);
        getNewPage().searchByKeyword(getNewPage().getTextFromHeadlineArticle());
        assertTrue(getSearchResultPage().getTextOfSearchResult().contains("Venezuela accused of 'egregious' crimes by UN"));

    }

    @Test
    public void checkNoInputStory(){

        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getNewPage().clickCoronaButton();
        getBasePage().waitForPageLoadComplete(10);
        getCoronavirusPage().clickYourStoryButton();
        getBasePage().waitForPageLoadComplete(10);
        getCoronavirusPage().clickHowToShareButton();
        getBasePage().waitForPageLoadComplete(10);
        getStoryFormPage().inputName(NAME);
        getStoryFormPage().inputEmail(EMAIL);
        getStoryFormPage().inputPhoneNumber(PHONE_NUMBER);
        getStoryFormPage().inputLocation(LOCATION);
        getStoryFormPage().clickCheckboxPublishingName();
        getStoryFormPage().clickCheckboxConfirmAge();
        getStoryFormPage().clickCheckboxTeamsOfService();
        getStoryFormPage().clickSubmitButton();
        assertEquals(getStoryFormPage().getUrl(getDriver()), "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoConfirmAge(){

        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getNewPage().clickCoronaButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickYourStoryButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickHowToShareButton();
        getStoryFormPage().inputStory("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        getStoryFormPage().inputName(NAME);
        getStoryFormPage().inputEmail(EMAIL);
        getStoryFormPage().inputPhoneNumber(PHONE_NUMBER);
        getStoryFormPage().inputLocation(LOCATION);
        getStoryFormPage().clickCheckboxPublishingName();
        getStoryFormPage().clickCheckboxTeamsOfService();
        getStoryFormPage().clickSubmitButton();
        assertEquals(getStoryFormPage().getUrl(getDriver()), "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoInputName(){

        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getNewPage().clickCoronaButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickYourStoryButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickHowToShareButton();
        getStoryFormPage().inputStory("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        getStoryFormPage().inputEmail(EMAIL);
        getStoryFormPage().inputPhoneNumber(PHONE_NUMBER);
        getStoryFormPage().inputLocation(LOCATION);
        getStoryFormPage().clickCheckboxPublishingName();
        getStoryFormPage().clickCheckboxConfirmAge();
        getStoryFormPage().clickCheckboxTeamsOfService();
        getStoryFormPage().clickSubmitButton();
        assertEquals(getStoryFormPage().getUrl(getDriver()), "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoAcceptTeamsOfService(){

        getHomePage().clickNewsButton();
        getHomePage().clickSignInLaterButton();
        getNewPage().clickCoronaButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickYourStoryButton();
        getCoronavirusPage().implicitWait(10);
        getCoronavirusPage().clickHowToShareButton();
        getStoryFormPage().inputStory("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        getStoryFormPage().inputName(NAME);
        getStoryFormPage().inputEmail(EMAIL);
        getStoryFormPage().inputPhoneNumber(PHONE_NUMBER);
        getStoryFormPage().inputLocation(LOCATION);
        getStoryFormPage().clickCheckboxPublishingName();
        getStoryFormPage().clickCheckboxConfirmAge();
        getStoryFormPage().clickSubmitButton();
        assertEquals(getStoryFormPage().getUrl(getDriver()), "https://www.bbc.com/news/10725415");

    }


}
