package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutComplete extends BasePage {

    By successMessage = By.cssSelector(".complete-header");

    public CheckOutComplete(WebDriver driver) {
        super(driver);
    }

    // send firstName
    public String getSuccessMessage() {
        waitForElementToBePresent(successMessage);
        return getTextFromElement(successMessage);
    }

}
