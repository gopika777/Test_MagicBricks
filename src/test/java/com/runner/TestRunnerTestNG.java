package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Features",
    glue = "com.stepDefinition",
    plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
    monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
