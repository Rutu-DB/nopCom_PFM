package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(BuildYourComputerPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement _actualBuildYourOwnComputerMessage;


    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement _dropDownProcessor;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement _dropDownRAM;

    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    WebElement _radioBtnOS;

    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement _radioBtnHdd;

    @FindBy(xpath = "//input[@id='product_attribute_5_10']")
    WebElement _chkBoxMSOffice;

    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    WebElement _chkBoxCommander;

    @FindBy(xpath = "//span[@class='price-value-1']")
    WebElement _actualAmountVerify;

    @FindBy(xpath = "//input[@id='add-to-cart-button-1']")
    WebElement _addToCartButton2;

    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]")
    WebElement _barNotificationDisplay;


    //This method is to verify user is on build your computer page
    public String buildYourComputerPageVerify() {
        Reporter.log("Actual Message on Build your commputer Page " + _actualBuildYourOwnComputerMessage + "<br>");
        log.info("Actual Message to verify user is on Build your computer page " + _actualBuildYourOwnComputerMessage.toString());
        System.out.println(getTextFromElement(_actualBuildYourOwnComputerMessage));
        return getTextFromElement(_actualBuildYourOwnComputerMessage);
    }

    //This method selects Processor from dropdown
    public void buildYourOwnComputerSelectProcessor() throws InterruptedException {
        Reporter.log("Drop Down Processor " + _dropDownProcessor.toString() + "<br>");
        waitFor(2);
        clickOnElement(_dropDownProcessor); // clicks on dropdown processor
        //waitUntilPresenceOfElementLocated(_dropDownProcessor,2);
        selectByIndexFromDropDown(_dropDownProcessor, 0); // selects the 0th Index for 2.2GB processor
        log.info(" Selects Processor " + _dropDownProcessor.toString());
    }

    // This method selects RAM from Dropdown
    public void buildYourOwnComputerSelectRAM() {
        Reporter.log("Drop Down for RAM " + _dropDownRAM.toString() + "<br>");
        waitFor(2);
        clickOnElement(_dropDownRAM); // clicks on RAM Dropdown
        waitFor(2);
        //waitUntilPresenceOfElementLocated(dropDownRAM);
        selectByVisibleTextFromDropDown(_dropDownRAM, "8GB [+$60.00]");// selects 8GB RAM
        log.info(" select RAM from dropdow " + _dropDownRAM.toString());
    }

    // This method selects HDD & OS Radio Button
    public void buildYourOwnComputerRadioButton() throws InterruptedException {
        Reporter.log("Clicks on Radio Button - HDD " + _radioBtnHdd.toString() + "<br>");
        clickOnElement(_radioBtnHdd); // Clicks on Radio Button HDD - 400 GB
        log.info("Click HDD radio button " + _radioBtnHdd.toString());
        Reporter.log("Clicks on Radio Button OS " + _radioBtnOS.toString() + "<br>");
        clickOnElement(_radioBtnOS);// Clicks on Radio Button OS - Vista Premium $60
        log.info("Clicks OS Radio Button " + _radioBtnOS.toString());
    }

    // This method checks Commander Check Box
    public void buildYourOwnComputerCheckBox() throws InterruptedException {
        Reporter.log("Check Box Commander " + _chkBoxCommander.toString() + "<br>");
        waitFor(2);
        clickOnElement(_chkBoxCommander); // selects Commander CheckBox
        log.info("Check Commander Check Box " + _chkBoxCommander.toString());
    }

    // This method verifies Actual Amount
    public String actualAmountMessage() throws InterruptedException {
        Reporter.log("Acutal Amount Verify " + _actualAmountVerify.toString() + "<br>");
        log.info("verify Message " + _actualAmountVerify.toString());
        waitFor(2);
        return getTextFromElement(_actualAmountVerify);

    }

    // This method add to cart button
    public void buildYourOwnComputerAddToCartBtn() throws InterruptedException {
        Reporter.log("Add to Cart Button " + _addToCartButton2.toString() + "<br>");
        waitFor(2);
        //waitUntilElementToBeClickable(_addToCartButton2);
        clickOnElement(_addToCartButton2); // Clicks on ~Add to cart button
        log.info("Click on Add to Cart Button " + _addToCartButton2.toString());
    }

    //This method clicks on Notification popup
    public void notificationDisplay() throws InterruptedException {
        Reporter.log("Bar Notification Display " + _barNotificationDisplay.toString() + "<br>");
        waitFor(2);
        clickOnElement(_barNotificationDisplay); // clicks on Bar Notification pop up
        log.info(" Click on Display Notification " + _barNotificationDisplay.toString());
    }


}

