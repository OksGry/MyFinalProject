package Tests;


import Pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NewsTests extends BaseTest{

    private final String STORY = "Venezuela accused of 'egregious' crimes by UN";
    private final String NAME = "Kuhulin";
    private final String EMAIL = "IrishYersh@gmail.com";
    private final String PHONE_NUMBER = "7559066899";
    private final String LOCATION = "Dublin";
    private  final String SEARCH_QUERY = "WHO warns of 'very serious situation' in Europe";
    private final String[] arrayNamesOfArticles = new String[] {"Navalny's aides say poison found on water bottle","Why fires in Siberia threaten us all", "China defends Xinjiang 'education' camps", "Australia ex-PM hacked after Instagramming boarding pass", "Lionel Messi wins fight to trademark his surname"};



    @Test
    public void checkTheNameOfTheHeadlineArticle(){
        String textFromHeadlineArticle = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .getTextFromHeadlineArticle();

        assertEquals(textFromHeadlineArticle, SEARCH_QUERY);

    }

    @Test
    public void checkTheNamesOfSecondLineArticles(){
        int count = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .checkWhatSecondLineArticlesMatch(arrayNamesOfArticles);

        assertEquals(count,5);

    }

    @Test
    public void checkSearchForArticleByName(){
        String textOfSearchResult = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .searchByKeyword(SEARCH_QUERY)
                .getTextOfSearchResult();
        assertTrue(textOfSearchResult.contains(SEARCH_QUERY));

    }

    @Test
    public void checkNoInputStory(){
        String urlCurrentPage = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm("",NAME,EMAIL,PHONE_NUMBER,LOCATION, true,true,true)
                .getUrl(getDriver());

        assertEquals(urlCurrentPage, "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoConfirmAge(){

        String urlCurrentPage = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY,NAME,EMAIL,PHONE_NUMBER,LOCATION, true,false,true)
                .getUrl(getDriver());

        assertEquals(urlCurrentPage, "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoInputName(){

        String urlCurrentPage = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY,"",EMAIL,PHONE_NUMBER,LOCATION, true,true,true)
                .getUrl(getDriver());

        assertEquals(urlCurrentPage, "https://www.bbc.com/news/10725415");

    }

    @Test
    public void checkNoAcceptTeamsOfService(){

        String urlCurrentPage = new HomePage(getDriver())
                .clickNewsButton()
                .clickSignInLaterButton()
                .clickCoronaButton()
                .clickYourStoryButton()
                .clickHowToShareButton()
                .fillForm(STORY,NAME,EMAIL,PHONE_NUMBER,LOCATION, true,true,false)
                .getUrl(getDriver());

        assertEquals(urlCurrentPage, "https://www.bbc.com/news/10725415");

    }


}
