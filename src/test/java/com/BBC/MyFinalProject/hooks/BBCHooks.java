package com.BBC.MyFinalProject.hooks;

import com.BBC.MyFinalProject.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BBCHooks {

    @Before
    public void setDriver() {
        DriverManager.getDriver("chrome");
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
