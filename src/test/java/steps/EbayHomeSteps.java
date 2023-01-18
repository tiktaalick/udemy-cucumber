package steps;

import actions.CommonActions;
import actions.EbayHomeActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.fail;

public class EbayHomeSteps {

    private final CommonActions   commonActions;
    private final EbayHomeActions ebayHomeActions;

    private int version;

    public EbayHomeSteps(CommonActions commonActions, EbayHomeActions ebayHomeActions) {
        this.commonActions = commonActions;
        this.ebayHomeActions = ebayHomeActions;
    }

    @Given("I am on Ebay Home page")
    public void iAmOnEbayHomePage() {
        commonActions.goToUrl("https://www.ebay.com/");
    }

    @When("I click on Advanced Link")
    public void iClickOnAdvancedLink() {
        ebayHomeActions.clickAdvancedLink();
    }

    @When("I click on {string}")
    public void iClickOnLink(String category) {
        ebayHomeActions.clickOnLinkByText(category);
    }

    @Then("I navigate to Advanced Search page")
    public void iNavigateToAdvancedSearchPage() {
        String expected = "https://www.ebay.com/sch/ebayadvsearch";
        String actual = commonActions.getCurrentPageUrl();

        if (!expected.equals(actual)) {
            fail("I did NOT navigate to the Advanced Search page (" + expected + "), but to " + actual + " instead.");
        }
    }

    @When("I search for {string} {int}")
    public void iSearchForIPhone(String searchString, int version) {
        ebayHomeActions.searchItem(searchString + " " + version);
        ebayHomeActions.clickSearchButton();

        this.version = version;
    }

    @When("I search for {string} in {string} category")
    public void iSearchForSoapInBabyCategory(String searchString, String category) {
        ebayHomeActions.searchItem(searchString);
        ebayHomeActions.selectCategoryOption(category);
        ebayHomeActions.clickSearchButton();
    }

    @Then("I validate at least {int} search items are present")
    public void iValidateAtLeastSearchItemsArePresent(int expected) {
        int actual = ebayHomeActions.getSearchItemsCount();

        if (actual < expected) {
            fail("There were only " + actual + " iPhone " + version + "'s, which is a smaller number than " + expected + ".");
        }
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void iValidateThatPageNavigatesToUrlAndTitleContainsTitle(String expectedUrl, String expectedTitle) {
        String actualUrl = commonActions.getCurrentPageUrl();
        String actualTitle = commonActions.getCurrentPageTitle();

        if (!actualUrl.equals(expectedUrl)) {
            fail("The page navigated to " + actualUrl + " instead of page " + expectedUrl + ".");
        }

        if (!actualTitle.contains(expectedTitle)) {
            fail("The page navigated to " + actualTitle + " instead of page " + expectedTitle + ".");
        }
    }
}
