package com.BBC.MyFinalProject.ranner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com/bbc/myfinalproject",
        features = "src/test/resources/com.BBC.MyFinalProject/")

public class BBCTestRunner extends AbstractTestNGCucumberTests { }
