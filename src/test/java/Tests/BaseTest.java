package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;

    private static  final String BBC_URL = "https://www.bbc.com/";

    @BeforeTest
    public void profileSetUP(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BBC_URL);
    }

    //@AfterMethod
    //public void tearDown() {driver.close();}

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(getDriver());
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public NewsPage getNewPage() {
        return new NewsPage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(getDriver());
    }

    public StoryFormPage getStoryFormPage() { return new StoryFormPage(getDriver());}
}
