package com.healthcare.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue={"com.healthcare.steps","com.healthcare.hooks"}, plugin={"pretty","html:reports/cucumber.html","json:reports/cucumber.json","junit:reports/cucumber.xml"}, monochrome=true, publish=false)
public class RunCucumberTest {}
