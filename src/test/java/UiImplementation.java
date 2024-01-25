import com.thoughtworks.gauge.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.regex.Matcher;

public class UiImplementation {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainShopPage mainShopPage = new MainShopPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    CheckOutSecondPage checkOutSecondPage = new CheckOutSecondPage(driver);
    CheckOutComplete checkOutComplete = new CheckOutComplete(driver);

    String expectedSuccessMessage = "Thank you for your order!";

    @Step("Go to <url>, and validate <title>")
    public void navigateTo(String url, String title) {
        loginPage.getWebSite(url);
        assert loginPage.getWebSiteTitle().equals(title);
    }

    @Step("Log in with <user>, <pwd>")
    public void logInPage(String user, String pwd) {
        loginPage.sendUserName(user);
        loginPage.sendPassword(pwd);
        loginPage.clickSubmit();
    }

    @Step("Add to cart item")
    public void addToCartItem() {
        mainShopPage.addItem();
        mainShopPage.clickCart();
        cartPage.clickCheckout();
        checkOutPage.sendFirstName();
        checkOutPage.sendLastName();
        checkOutPage.sendZipCode();
        checkOutPage.clickOnContinue();
    }

    @Step("calculate right price")
    public void calculateRightPrice() {
        String totalPriceBeforeTax = checkOutSecondPage.getTotalPriceWithoutTaxFunc()[0];
        Matcher matcher = checkOutSecondPage.getMatcher(totalPriceBeforeTax);
        String extractedVal = "";
        extractedVal = checkOutSecondPage.getVal(matcher);
        double priceInDouble = checkOutSecondPage.getExpectedTotalPriceAfterTax(Double.parseDouble(extractedVal));
        String totalPriceAfterTax = checkOutSecondPage.getTotalPriceWithTaxFunc()[1];
        matcher = checkOutSecondPage.getMatcher(totalPriceAfterTax);
        String extractedValAfterTax = "";
        extractedValAfterTax= checkOutSecondPage.getVal(matcher);
        Assertions.assertThat(priceInDouble).describedAs("Assertion of price was failed").isEqualTo(Double.parseDouble(extractedValAfterTax));
        checkOutSecondPage.clickFinish();
    }

    @Step("Validate success message")
    public void validateSuccessMessage() {
        Assertions.assertThat(checkOutComplete.getSuccessMessage()).describedAs("There is no success message").isEqualTo(expectedSuccessMessage);
    }

    @Step("Close driver")
    public void closeDriver() {
        driver.quit();
    }
}