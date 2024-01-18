package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckOutSecondPage extends BasePage {

    By getTotalPriceWithoutTax = By.cssSelector(".inventory_item_price");
    By totalPriceWithTaxElem = By.cssSelector(".summary_info_label.summary_total_label");
    By finishBTN = By.id("finish");

    public CheckOutSecondPage(WebDriver driver) {
        super(driver);
    }

    // get total price without tax
    public String[] getTotalPriceWithoutTaxFunc() {
        return getTextFromElement(getTotalPriceWithoutTax).split(" ");
    }

    // get total price with tax
    public String[] getTotalPriceWithTaxFunc() {
        return getTextFromElement(totalPriceWithTaxElem).split(" ");
    }

    //get expected total price after tax
    public double getExpectedTotalPriceAfterTax(double priceInDouble){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(priceInDouble * 1.08));
    }

    // click finish
    public Boolean clickFinish() {
        return waitForElementToBeClickableAndClickIt(finishBTN);
    }

    // calculate regex
    public Matcher getMatcher(String actualPrice){
        String regex = "\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(actualPrice);
    }
}
