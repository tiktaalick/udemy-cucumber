package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    @When("I click on {string}")
    public void iClickOnLink(String category) throws InterruptedException {
        driver.findElement(By.linkText(category)).click();
    }

    @Then("I navigate to Advanced Search page")
    public void iNavigateToAdvancedSearchPage() {
        String expected = "https://www.ebay.com/sch/ebayadvsearch";
        String actual = driver.getCurrentUrl();

        if (!expected.equals(actual)) {
            fail("I did NOT navigate to the Advanced Search page (" + expected + "), but to " + actual + " instead.");
        }
    }

    @When("I search for {string} {int}")
    public void iSearchForIPhone(String searchString, int version) {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(searchString + " " + version);
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        this.version = version;
    }

    @When("I search for {string} in {string} category")
    public void iSearchForSoapInBabyCategory(String searchString, String category) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(searchString);
        driver
                .findElements(By.xpath("//select[@id='gh-cat']/option"))
                .stream()
                .filter(dropDownListBoxOption -> dropDownListBoxOption.getText().trim().equalsIgnoreCase(category.trim()))
                .findAny()
                .ifPresent(WebElement::click);

        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
    }

    @Then("I validate at least {int} search items are present")
    public void iValidateAtLeastSearchItemsArePresent(int expected) {
        String text = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText();
        int actual = Integer.parseInt(text.replaceAll(",", "").trim());

        if (actual < expected) {
            fail("There were only " + actual + " iPhone " + version + "'s, which is a smaller number than " + expected + ".");
        }
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void iValidateThatPageNavigatesToUrlAndTitleContainsTitle(String expectedUrl, String expectedTitle) {
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        if (!actualUrl.equals(expectedUrl)) {
            fail("The page navigated to " + actualUrl + " instead of page " + expectedUrl + ".");
        }

        if (!actualTitle.contains(expectedTitle)) {
            fail("The page navigated to " + actualTitle + " instead of page " + expectedTitle + ".");
        }
    }
}
