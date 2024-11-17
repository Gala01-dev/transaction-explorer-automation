package tests;

import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TransactionExplorerPage;

public class TransactionExplorerTest {
    private WebDriverFactory factory;
    private WebDriver driver;
    private TransactionExplorerPage explorerPage;

    @BeforeClass
    public void setUp() {
        factory = new WebDriverFactory();
        driver = factory.initDriver();
        explorerPage = new TransactionExplorerPage(driver);
        driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
    }

    @Test(priority = 1)
    public void validateTransactionHeader() {
        Assert.assertTrue(explorerPage.isTransactionHeaderVisible(), "Transaction header is not visible!");
        System.out.println("Header Text: " + explorerPage.getTransactionHeaderText());
    }

    @Test(priority = 2)
    public void logTransactionsWithSpecificCriteria() {
        explorerPage.parseAndLogTransactions();
    }

    @AfterClass
    public void tearDown() {
        factory.quitDriver();
    }
}
