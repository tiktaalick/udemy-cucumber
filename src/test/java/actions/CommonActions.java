package actions;

import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class CommonActions {

    private final WebDriver driver;

    public CommonActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
    }

    public String getCurrentPageTitle() {
        return this.driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return this.driver.getCurrentUrl();
    }

    public void goToUrl(String url) {
        this.driver.get(url);
    }

    public void quitWebDriver() {
        driver.quit();
    }
}
