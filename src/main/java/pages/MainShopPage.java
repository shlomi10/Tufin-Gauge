package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainShopPage extends BasePage {

    By addBikeLightToCart = By.cssSelector("button#add-to-cart-sauce-labs-bike-light");
    By cartBTN = By.cssSelector(".shopping_cart_link");

    public MainShopPage(WebDriver driver) {
        super(driver);
    }

    // click add item
    public boolean addItem() {
        return waitForElementToBePresentAndClickIt(addBikeLightToCart);
    }

    // click cart
    public boolean clickCart() {
        return waitForElementToBePresentAndClickIt(cartBTN);
    }
}
