package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHomeElements {

    @FindBy(linkText = "Advanced")
    public WebElement advancedLink;

    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child")
    public WebElement numberOfItems;

    @FindBy(xpath = "//select[@id='gh-cat']/option")
    public List<WebElement> categoryOptions;

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement searchButton;

    private WebDriver driver;

    public EbayHomeElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}