package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report1.html", "json:Report2.json", "junit:Report3.xml"},
        dryRun = true,
        monochrome = true,
        tags = "@P1 or @P24",
        name = {"Logo"})
public class TestRunner {

}
