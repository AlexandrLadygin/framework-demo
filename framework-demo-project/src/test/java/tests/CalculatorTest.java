package tests;

import pages.calculator.CalculatorHomePage;
import pages.calculator.GoogleCloudHomePage;
import pages.calculator.TempEmailPage;
import org.junit.Assert;
import org.junit.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CalculatorTest extends CommonConditions {

    @Test
    public void GoogleCloudCalculatorTestWithSendingEmail () throws IOException, UnsupportedFlavorException {
        CalculatorHomePage calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchResultsForTerms("Google Cloud Platform Pricing Calculator")
                .clickOnTheFirstTerm()
                .activateComputeEngine()
                .pasteNumberOfInstance("4")
                .pasteWhatAreTheseInstancesFor("")
                .chooseOperatingSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .chooseMachineClass("Regular")
                .chooseMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .addGPUs()
                .chooseNumberOfGPUs("1")
                .chooseGPUType("NVIDIA Tesla V100")
                .chooseLocalSSD("2x375 GB")
                .chooseDataCenterLocation("Frankfurt (europe-west3)")
                .chooseCommittedUsage("1 Year")
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

        Assert.assertEquals("Total Cost Is WRONG!", "Estimated Monthly Cost: USD 1,082.77", totalCostInfo);
    }

}
