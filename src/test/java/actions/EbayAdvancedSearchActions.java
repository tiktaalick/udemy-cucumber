package actions;

import elements.EbayAdvancedSearchElements;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class EbayAdvancedSearchActions {

    private final WebDriver                  driver;
    private final EbayAdvancedSearchElements ebayAdvancedSearchElements;

    public EbayAdvancedSearchActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        this.ebayAdvancedSearchElements = new EbayAdvancedSearchElements(driver);
    }

    public void clickOnEbayLogo() {
        ebayAdvancedSearchElements.ebayLogo.click();
    }

    public void clickOnSearchButton() {
        ebayAdvancedSearchElements.searchButton.click();
    }

    public void enterExcludeString(String excludeString) {
        ebayAdvancedSearchElements.excludeString.sendKeys(excludeString);
    }

    public void enterMaximumPrice(String maximumPrice) {
        ebayAdvancedSearchElements.maximumPrice.sendKeys(maximumPrice);
    }

    public void enterMinimumPrice(String minimumPrice) {
        ebayAdvancedSearchElements.minimumPrice.sendKeys(minimumPrice);
    }

    public void enterSearchString(String searchString) {
        ebayAdvancedSearchElements.searchString.sendKeys(searchString);
    }
}
