package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement _shoppingCartLink;

    @FindBy(xpath = "//div[@class='mini-shopping-cart']//div//input")
    WebElement _miniShoppingCartBtn;

    @FindBy(xpath = "//input[@class='qty-input']")
    WebElement _itemQtyField;

    @FindBy(xpath = "//div[@class='cart-options']//div//input[@class='button-2 update-cart-button']")
    WebElement _updateCartButton;


    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    WebElement _actualShoppingCartMessage;

    @FindBy(xpath = "//span[@class='close']")
    WebElement _closeOption;


    // This method is called when moving to Shopping cart
    public void moveToShoppingCart() throws InterruptedException {
        Reporter.log("Mini Shopping Cart Button " + _miniShoppingCartBtn.toString() + "<br>");
        waitFor(2);
        clickOnElement(_closeOption);
        waitFor(2);
        mouseHoverToElement(_shoppingCartLink); // selects the shopping Cart Link
        clickOnElement(_miniShoppingCartBtn);
        log.info("Mini shopping Cart " + _miniShoppingCartBtn.toString());
    }


    //This method changes Qty to 2
    public void amendQtyField() throws InterruptedException {
        Reporter.log("Item Field " + _itemQtyField.toString() + "<br>");
        waitFor(2);
        clickOnElement(_itemQtyField);// clicks in the item field
        clearText(_itemQtyField); // clears the text from the field
        sendTextToElement(_itemQtyField, "2"); // sends value to field
        log.info("Changes the qty to 2 " + _itemQtyField.toString());
    }

    //This method updates the Final Add to cart Button
    public void updateFinalCart() {
        Reporter.log("Update Cart Button " + _updateCartButton.toString() + "<br>");
        clickOnElement(_updateCartButton); // clicks update button
        log.info("Updates final Add button " + _updateCartButton.toString());

    }


}
