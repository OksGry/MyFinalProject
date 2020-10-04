package tests;

import org.testng.annotations.Test;
import pages.BusinessLogic;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NewsTests extends BaseTest {


    private final String NAME_ARTICLE = "US to ban TikTok and WeChat downloads in 48 hours";
    private final String[] arrayNamesOfArticles = new String[]
            {"Navalny's aides say poison found on water bottle",
                    "Why fires in Siberia threaten us all",
                    "China defends Xinjiang 'education' camps",
                    "Australia ex-PM hacked after Instagramming boarding pass",
                    "Lionel Messi wins fight to trademark his surname"};


    @Test
    public void checkTheNameOfTheHeadlineArticle() {
        String textFromHeadlineArticle = new BusinessLogic(driver)
                .userGoToNews()
                .getTextFromHeadlineArticle();

        assertEquals(textFromHeadlineArticle, NAME_ARTICLE);
    }

    @Test
    public void checkTheNamesOfSecondLineArticles() {
        int theNumberOfMatchingPages = new BusinessLogic(driver)
                .userGoToNews()
                .checkWhatSecondLineArticlesMatch(arrayNamesOfArticles);

        assertEquals(theNumberOfMatchingPages, 5);
    }

    @Test
    public void checkSearchForArticleByCategory() {
        String searchKey = "World";
        String textOfSearchResult = new BusinessLogic(driver)
                .userSearch()
                .getTextOfSearchResult();

        assertTrue(textOfSearchResult.contains(searchKey));
    }
}
