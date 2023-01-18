package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @After(value = "@setCookies",
            order = 0)
    public void removeCookies() {
        System.out.println("Scenario specific hook - removeCookies executed");
    }

    @Before(value = "@setCookies",
            order = 0)
    public void setCookies() {
        System.out.println("Scenario specific hook - setCookies executed");
    }

    @Before(order = 1)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        driver.quit();

        Thread.sleep(1000);
    }
}
