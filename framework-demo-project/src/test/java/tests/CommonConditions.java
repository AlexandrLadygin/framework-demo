package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public abstract class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
