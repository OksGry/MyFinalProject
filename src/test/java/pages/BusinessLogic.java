package pages;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class BusinessLogic extends BasePage {

    public BusinessLogic(WebDriver driver) {
        super(driver);
    }

    public StoryFormPage userCanSubmitStory(Map<String, String> data) {
        new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(data)
                .clickSubmitButton();

        return new StoryFormPage(driver);
    }

    public NewsPage userGoToNews() {
        new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton();

        return new NewsPage(driver);
    }

    public SearchResultPage userSearch() {
        new HomePage(driver)
                .clickNewsButton()
                .clickSignInLaterButton()
                .searchByKeyword();

        return new SearchResultPage(driver);
    }
}
