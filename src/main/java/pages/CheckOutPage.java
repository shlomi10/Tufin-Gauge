package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueBTN = By.id("continue");
    String inputFirstName = "a";
    String inputLastName = "a";
    String inputZip = "a";

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    // send firstName
    public boolean sendFirstName() {
        return sendKeysToElement(firstNameField, inputFirstName);
    }

    // send lastName
    public boolean sendLastName() {
        return sendKeysToElement(lastNameField, inputLastName);
    }

    // send zipCode
    public boolean sendZipCode() {
        return sendKeysToElement(postalCodeField, inputZip);
    }

    // click on continue button
    public boolean clickOnContinue() {
        return waitForElementToBeClickableAndClickIt(continueBTN);
    }
}
