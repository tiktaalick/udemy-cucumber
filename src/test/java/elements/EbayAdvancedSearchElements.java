package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearchElements {

    @FindBy(xpath = "//a[@id='gh-la']")
    public WebElement ebayLogo;

    @FindBy(xpath = "//input[@id='_ex_kw']")
    public WebElement excludeString;

    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement maximumPrice;

    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement minimumPrice;

    @FindBy(xpath = "//button[@id='searchBtnLowerLnk']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@id='_nkw']")
    public WebElement searchString;

    private WebDriver driver;

    public EbayAdvancedSearchElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
