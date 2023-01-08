package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EbayHomeSteps {

    private WebDriver driver;
    private int       version;

    public EbayHomeSteps(CommonSteps commonSteps) {
        this.driver = commonSteps.driver();
    }

    @Given("I am on Ebay Home page")
    public void iAmOnEbayHomePage() {
        driver.get("https://www.ebay.com/");
    }

    @When("I click on Advanced Link")
    public void iClickOnAdvancedLink() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advanced Search page")
    public void iNavigateToAdvancedSearchPage() {
        String expected = "https://www.ebay.com/sch/ebayadvsearch";
        String actual = driver.getCurrentUrl();

        if (!expected.equals(actual)) {
            fail("I did NOT navigate to the Advanced Search page (" + expected + "), but to " + actual + " instead.");
        }
    }

    @When("I search for iPhone {int}")
    public void iSearchForIPhone(int version) {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iPhone " + version);
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        this.version = version;
    }

    @Then("I validate at least {int} search items are present")
    public void iValidateAtLeastSearchItemsArePresent(int expected) {
        String text = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText();
        int actual = Integer.parseInt(text.replaceAll(",", "").trim());

        if (actual < expected) {
            fail("There were only " + actual + " iPhone " + version + "'s, which is a smaller number than " + expected + ".");
        }
    }
}
