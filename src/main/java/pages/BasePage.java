package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    // function to get text from element
    public String getTextFromElement(By elem) {
        return getDriver().findElement(elem).getText();
    }

    // function to get title
    public String getSiteTitle() {
        return getDriver().getTitle();
    }

    // function to navigate to url
    public boolean navigateToURL(String site) {
        try {
            getDriver().navigate().to(site);
            return true;
        } catch (Exception e) {
            System.out.println("site was not loaded");
            return false;
        }
    }

    // function to send keys to element
    public boolean sendKeysToElement(By elem, String str) {
        try {
            getDriver().findElement(elem).sendKeys(str);
            return true;
        } catch (Exception e) {
            System.out.println("string was not sent to element");
            return false;
        }
    }

    // function to click on element
    public boolean clickOnElement(By elem) {
        try {
            getDriver().findElement(elem).click();
            return true;
        } catch (Exception e) {
            System.out.println("click on element failed");
            return false;
        }
    }

    //wait for element to be clickable and click it
    public Boolean waitForElementToBeClickableAndClickIt(By elem) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Wait for element to be clickable was not worked correct");
            return false;
        }
    }

    //wait for element to be present and click it
    public Boolean waitForElementToBePresentAndClickIt(By elem) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(elem)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Wait for element to be present was not worked correct");
            return false;
        }
    }

    //wait for element to be present
    public Boolean waitForElementToBePresent(By elem) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(elem));
            return true;
        } catch (Exception e) {
            System.out.println("Wait for element to be present was not worked correct");
            return false;
        }

    }
}
