package actions;

import elements.EbayHomeElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.CommonSteps;

public class EbayHomeActions {

    private final WebDriver        driver;
    private final EbayHomeElements ebayHomeElements;

    public EbayHomeActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        ebayHomeElements = new EbayHomeElements(this.driver);
    }

    public void clickAdvancedLink() {
        ebayHomeElements.advancedLink.click();
    }

    public void clickSearchButton() {
        ebayHomeElements.searchButton.click();
    }

    public int getSearchItemsCount() {
        return Integer.parseInt(ebayHomeElements.numberOfItems.getText().trim().replace(",", ""));
    }

    public void searchItem(String searchString) {
        ebayHomeElements.searchBox.sendKeys(searchString);
    }

    public void selectCategoryOption(String category) {
        ebayHomeElements.categoryOptions
                .stream()
                .filter(dropDownListBoxOption -> dropDownListBoxOption.getText().trim().equalsIgnoreCase(category.trim()))
                .findAny()
                .ifPresent(WebElement::click);
    }

    public void clickOnLinkByText(String text){
        driver.findElement(By.linkText(text)).click();
    }
}
