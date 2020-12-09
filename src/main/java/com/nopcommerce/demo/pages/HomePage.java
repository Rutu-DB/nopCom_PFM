package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement _loginLink;

    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement _registrationLink;

    //This method clicks on Login Link
    public void clickOnLoginLink() throws InterruptedException {
        Reporter.log("Clicking on login link : " + _loginLink.toString() + "<br>");
        Thread.sleep(500);
        clickOnElement(_loginLink);
        log.info("Clicking on Login link : " + _loginLink.toString());
    }

    //This method clicks on Registration Link
    public void clickOnRegisterLink() {
        Reporter.log("Clicking on login link : " + _registrationLink.toString() + "<br>");
        clickOnElement(_registrationLink);
        log.info("Clicking on login link : " + _registrationLink.toString());
    }

}
