package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps {

    @Given("I am on Ebay Home page")
    public void iAmOnEbayHomePage() {
        System.out.println("I am on Ebay Home PAge");
    }

    @When("I click on Advanced Link")
    public void iClickOnAdvancedLink() {
        System.out.println("I click on Advanced Link");
    }

    @Then("I navigate to Advanced Search page")
    public void iNavigateToAdvancedSearchPage() {
        System.out.println("I navigate to Advanced Search page");
    }
}
