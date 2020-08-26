package pages.calculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoogleCloudHomePage extends AbstractPage {

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    private final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchButton;

    public GoogleCloudHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchButton));
        logger.info("Opened Google Cloud HomePage" );
        return this;
    }

    public GoogleCloudResultsPage searchResultsForTerms(String term) {
        searchButton.click();
        searchButton.sendKeys(term + Keys.ENTER);
        logger.info("Started to search: [" + term + "]" );
        return new GoogleCloudResultsPage(driver);
    }
}
