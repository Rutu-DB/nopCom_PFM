package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(ComputerPage.class.getName());

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")
    WebElement _computerLink;

    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement _actualComputerMessage;

    //Mouse hove on Computer Menu and click on
    public void clickOnComputerLink() {
        Reporter.log("Registration Link Click " + _computerLink.toString() + "<br>");
        clickOnElement(_computerLink);
        log.info("Mouse Hovers on Computer Link " + _computerLink.toString());
    }


    // This method returns string to verify the Assert
    public String actualMessageComputer() {
        Reporter.log("Actual Message on Desktop Page " + _actualComputerMessage + "<br>");
        log.info("Desktop Message Verification " + _actualComputerMessage.toString());
        return getTextFromElement(_actualComputerMessage);


    }
}