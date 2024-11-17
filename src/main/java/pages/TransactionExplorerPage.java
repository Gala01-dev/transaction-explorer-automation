package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TransactionExplorerPage {
    private WebDriver driver;

    // Locators
    private By transactionHeader = By.xpath("//h2[contains(text(),'Transactions')]");
    private By transactionItems = By.cssSelector(".transaction-item");
    private By txid = By.cssSelector(".txid");
    private By inputs = By.cssSelector(".inputs > .input");
    private By outputs = By.cssSelector(".outputs > .output");

    // Constructor
    public TransactionExplorerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean isTransactionHeaderVisible() {
        return driver.findElement(transactionHeader).isDisplayed();
    }

    public String getTransactionHeaderText() {
        return driver.findElement(transactionHeader).getText();
    }

    public void parseAndLogTransactions() {
        List<WebElement> transactions = driver.findElements(transactionItems);
        System.out.println("Found " + transactions.size() + " transactions.");

        for (WebElement transaction : transactions) {
            String hash = transaction.findElement(txid).getText();
            int inputCount = transaction.findElements(inputs).size();
            int outputCount = transaction.findElements(outputs).size();

            if (inputCount == 1 && outputCount == 2) {
                System.out.println("Transaction with hash " + hash + " matches criteria.");
            }
        }
    }
}
