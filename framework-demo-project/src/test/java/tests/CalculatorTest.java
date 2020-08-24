package tests;

import model.ComputeEngine;
import org.testng.Assert;
import pages.calculator.CalculatorHomePage;
import pages.calculator.GoogleCloudHomePage;
import pages.calculator.TempEmailPage;
import org.testng.annotations.*;
import service.ComputeEngineCreator;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CalculatorTest extends CommonConditions {

    @Test
    public void GoogleCloudCalculatorTestWithSendingEmail () throws IOException, UnsupportedFlavorException {

        ComputeEngine engine = ComputeEngineCreator.withCredentialsProperties();

        CalculatorHomePage calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchResultsForTerms("Google Cloud Platform Pricing Calculator")
                .clickOnTheFirstTerm()
                .useProperties(engine)
                .clickAddToEstimate()
                .clickEmailEstimate();

        TempEmailPage tempEmailPage = new TempEmailPage(driver);
        tempEmailPage.createNewTab();
        tempEmailPage.switchTabByIndex(1);
        String tempEmailAddress = tempEmailPage.openPage().copyTempEmailAddress();

        calculatorPage. switchTabByIndex(0);
        calculatorPage.pasteEmailAddress(tempEmailAddress).clickSendEmail();

        tempEmailPage.switchTabByIndex(1);
        String totalCostInfo = tempEmailPage.getMessageWithEstimatedCost().getTextFromMessage();

        Assert.assertEquals(totalCostInfo, engine.getExpectedEstimate());
    }

}
