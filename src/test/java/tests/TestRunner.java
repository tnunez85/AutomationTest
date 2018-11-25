package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "tests",
        plugin = {"json:cucumber.json"},
        tags = "@test")
// "~@inProgress")

public class TestRunner {


}
