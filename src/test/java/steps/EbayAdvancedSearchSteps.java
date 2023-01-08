package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayAdvancedSearchSteps {

    private WebDriver driver;

    public EbayAdvancedSearchSteps(CommonSteps commonSteps) {
        this.driver = commonSteps.driver();
    }

    @Then("I am navigated to Ebay Home Page")
    public void iAmNavigatedToEbayHomePage() {
        String expected = "https://www.ebay.com/";
        String actual = driver.getCurrentUrl();

        if (!expected.equals(actual)) {
            fail("I did NOT navigate to the Home page (" + expected + "), but to " + actual + " instead.");
        }
    }

    @Given("I am on Ebay Advanced Search Page")
    public void iAmOnEbayAdvancedSearchPage() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void iClickOnEbayLogo() {
        driver.findElement(By.xpath("//a[@id='gh-la']")).click();
    }
}
