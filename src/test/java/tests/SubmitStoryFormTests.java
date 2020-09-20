package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class SubmitStoryFormTests extends BaseTest {

    private final String STORY = "Venezuela accused of 'egregious' crimes by UN";
    private final String NAME = "Kuhulin";
    private final String EMAIL = "IrishYersh@gmail.com";
    private final String PHONE_NUMBER = "7559066899";
    private final String LOCATION = "Dublin";
    private final String URL_STORY_PAGE = "https://www.bbc.com/news/10725415";

    @Test
    public void checkNoInputStory() {
        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm("", NAME, EMAIL, PHONE_NUMBER, LOCATION, true, true, true)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoConfirmAge() {

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY, NAME, EMAIL, PHONE_NUMBER, LOCATION, true, false, true)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoInputName() {

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY, "", EMAIL, PHONE_NUMBER, LOCATION, true, true, true)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoAcceptTeamsOfService() {

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY, NAME, EMAIL, PHONE_NUMBER, LOCATION, true, true, false)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }
}
