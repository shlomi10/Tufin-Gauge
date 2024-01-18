package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userNameField = By.id("user-name");
    By pwdField = By.id("password");
    By submitBTN = By.cssSelector(".submit-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // navigate to the site
    public boolean getWebSite(String site) {
        return navigateToURL(site);
    }

    // get web site title
    public String getWebSiteTitle() {
        return getSiteTitle();
    }

    // send username
    public boolean sendUserName(String userName) {
        return sendKeysToElement(userNameField, userName);
    }

    // send password
    public boolean sendPassword(String password) {
        return sendKeysToElement(pwdField, password);
    }

    // click on submit button
    public boolean clickSubmit(){
        return waitForElementToBeClickableAndClickIt(submitBTN);
    }
}
