package io.github.sb;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = "io.github.sb.stepdefs", plugin = {"pretty", "html:target/report"})
public class TestRunner {
}
