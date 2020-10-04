package com.BBC.MyFinalProject.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private  static WebDriver driver;
    private static Browser driverType;


    private DriverManager() {
    }

    public  static WebDriver getDriver(Browser driverName) {
        driverType = driverName;

        if (null == driver) {
            switch (driverName) {
                case firefox: {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case edge: {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? getDriver(driverType) : driver;
    }

    public static void quitDriver() {
        if (driver!= null) {
            driver.quit();
            driver = null;
        }
    }

    public enum Browser {
        firefox,
        edge,
        chrome
    }
}
