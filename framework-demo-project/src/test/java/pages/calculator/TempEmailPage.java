package pages.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TempEmailPage extends AbstractPage {

    public TempEmailPage(WebDriver driver) {
        super(driver);
    }
    private static final String HOMEPAGE_URL = "https://dropmail.me/ru/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//span[@class='email']")
    private WebElement xpathMailAddressField;
    @FindBy(xpath = "//pre[contains(@data-bind, 'html')]")
    private WebElement xpathTextOfMessage;
    @FindBy(xpath = "//a[contains(@class, 'btn btn-default btn-xs')]")
    private WebElement xpathHTMLFormButton;
    @FindBy(xpath = "//h2")
    private WebElement xpathCostField;


    public TempEmailPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(xpathMailAddressField));
        logger.info("Opened Temp Email Page");
        return this;
    }

    public String copyTempEmailAddress() {
        new WebDriverWait(driver,20000).until(ExpectedConditions.elementToBeClickable(xpathMailAddressField));
        String textEmail = xpathMailAddressField.getText();
        logger.info("Copied Temp Email Address: [" + textEmail + "]" );
        return textEmail;
    }

    public TempEmailPage getMessageWithEstimatedCost() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//pre[contains(@data-bind, 'html')]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", xpathHTMLFormButton);
        xpathHTMLFormButton.click();
        logger.info("Get Message With Estimated Cost" );
        return  this;
    }

    public String getTextFromMessage(){
        driver.switchTo().frame(0);
        String resultingValue = null;
        String txtFromMess = xpathCostField.getText();
        String [] arr = txtFromMess.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains(",")) {
                 resultingValue = arr[i];
            }
        }
        logger.info("Text From Message: [" + txtFromMess + "]" );
        logger.info("Resulting Value: [" + resultingValue + "]" );
        return resultingValue;
    }
}
