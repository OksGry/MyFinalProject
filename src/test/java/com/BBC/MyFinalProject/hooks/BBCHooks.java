package com.BBC.MyFinalProject.hooks;

import com.BBC.MyFinalProject.driver.DriverManager;
import com.BBC.MyFinalProject.pages.NewsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BBCHooks {



    @Before
    public void setDriver(){
        DriverManager.getDriver("chrome");
    }



//    @After
//    public void quitDriver(){
//        DriverManager.quitDriver();
//    }
}
