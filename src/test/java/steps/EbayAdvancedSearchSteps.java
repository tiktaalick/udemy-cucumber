package steps;

import actions.CommonActions;
import actions.EbayAdvancedSearchActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.fail;

public class EbayAdvancedSearchSteps {

    private final CommonActions             commonActions;
    private final EbayAdvancedSearchActions ebayAdvancedSearchActions;

    public EbayAdvancedSearchSteps(CommonActions commonActions, EbayAdvancedSearchActions ebayAdvancedSearchActions) {
        this.commonActions = commonActions;
        this.ebayAdvancedSearchActions = ebayAdvancedSearchActions;
    }

    @Then("I am navigated to Ebay Home Page")
    public void iAmNavigatedToEbayHomePage() {
        String expected = "https://www.ebay.com/";
        String actual = commonActions.getCurrentPageUrl();

        if (!expected.equals(actual)) {
            fail("I did NOT navigate to the Home page (" + expected + "), but to " + actual + " instead.");
        }
    }

    @Given("I am on Ebay Advanced Search Page")
    public void iAmOnEbayAdvancedSearchPage() {
        commonActions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay Logo")
    public void iClickOnEbayLogo() {
        ebayAdvancedSearchActions.clickOnEbayLogo();
    }

    @When("I perform an advanced search")
    public void iPerformAnAdvancedSearch(DataTable dataTable) throws InterruptedException {
        ebayAdvancedSearchActions.enterSearchString(dataTable.cell(1, 0));
        ebayAdvancedSearchActions.enterExcludeString(dataTable.cell(1, 1));
        ebayAdvancedSearchActions.enterMinimumPrice(dataTable.cell(1, 2));
        ebayAdvancedSearchActions.enterMaximumPrice(dataTable.cell(1, 3));
        ebayAdvancedSearchActions.clickOnSearchButton();
    }
}
