package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class SubmitStoryFormTests extends BaseTest {

    private final String URL_STORY_PAGE = "https://www.bbc.com/news/10725415";

    @Test
    public void checkNoInputStory() {
        Map<String,String> dataForForm = new HashMap<String, String>();
        dataForForm.put("text", "");
        dataForForm.put("name", "Kuhulin");
        dataForForm.put("email", "IrishYersh@gmail.com");
        dataForForm.put("phone_number", "7559066899");
        dataForForm.put("location", "Dublin");
        dataForForm.put("checkbox_publishing_name", "yes");
        dataForForm.put("checkbox_confirm_age", "yes");
        dataForForm.put("checkbox_teams_of_service", "yes");


        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(dataForForm)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoConfirmAge() {
        Map<String,String> dataForForm = new HashMap<String, String>();
        dataForForm.put("text", "Venezuela accused of 'egregious' crimes by UN");
        dataForForm.put("name", "Kuhulin");
        dataForForm.put("email", "IrishYersh@gmail.com");
        dataForForm.put("phone_number", "7559066899");
        dataForForm.put("location", "Dublin");
        dataForForm.put("checkbox_publishing_name", "yes");
        dataForForm.put("checkbox_confirm_age", "");
        dataForForm.put("checkbox_teams_of_service", "yes");

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(dataForForm)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoInputName() {
        Map<String,String> dataForForm = new HashMap<String, String>();
        dataForForm.put("text", "Venezuela accused of 'egregious' crimes by UN");
        dataForForm.put("name", "");
        dataForForm.put("email", "IrishYersh@gmail.com");
        dataForForm.put("phone_number", "7559066899");
        dataForForm.put("location", "Dublin");
        dataForForm.put("checkbox_publishing_name", "yes");
        dataForForm.put("checkbox_confirm_age", "yes");
        dataForForm.put("checkbox_teams_of_service", "yes");

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(dataForForm)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }

    @Test
    public void checkNoAcceptTeamsOfService() {
        Map<String,String> dataForForm = new HashMap<String, String>();
        dataForForm.put("text", "Venezuela accused of 'egregious' crimes by UN");
        dataForForm.put("name", "Kuhulin");
        dataForForm.put("email", "IrishYersh@gmail.com");
        dataForForm.put("phone_number", "7559066899");
        dataForForm.put("location", "Dublin");
        dataForForm.put("checkbox_publishing_name", "yes");
        dataForForm.put("checkbox_confirm_age", "yes");
        dataForForm.put("checkbox_teams_of_service", "no");

        String urlCurrentPage = new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(dataForForm)
                .clickSubmitButton()
                .getUrl(driver);

        assertEquals(urlCurrentPage, URL_STORY_PAGE);
    }
}
