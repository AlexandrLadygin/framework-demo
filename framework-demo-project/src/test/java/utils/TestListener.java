package utils;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private final Logger logger = LogManager.getRootLogger();

    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot)DriverSingleton
                .getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                    + getCurrentTimeAsString() + ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot " + e.getLocalizedMessage());
        }
    }
    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
