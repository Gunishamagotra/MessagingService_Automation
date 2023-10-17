package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue="stepDefinitions", plugin= {"pretty","html:target/cucumber.html"}
        ,monochrome = true, dryRun = false,publish = true)
public class runner {
}
