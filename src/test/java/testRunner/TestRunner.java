package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:target/reports/Report1.html", "json:target/json-report/cucumber.json", "junit:target/reports/Report3.xml"},
        dryRun = false,
        monochrome = true
//,
//        name = {"Home", "Advanced", "iPhone", "Category"},
//        tags = "@Home or @Advanced or @setCookies"
//        tags = "@setCookies"
)
public class TestRunner {

}
