package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By checkOutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // click checkout
    public boolean clickCheckout() {
        return waitForElementToBePresentAndClickIt(checkOutBtn);
    }
}
