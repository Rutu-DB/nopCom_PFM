package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
   // private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "Email")
    WebElement _emailField;

    @FindBy(css = "#Password")
    WebElement _passwordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement _loginBtn;

    @FindBy(xpath = "//div[@class='page-title']//h1")
    WebElement _welcomeText;

    @FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
    WebElement _loginErrorMessage;

    public void enterEmailId(String email) {
        Reporter.log("Entering email address : " + email + " to email field : " + _emailField.toString() + "<br>");
        clickOnElement(_emailField);
        sendTextToElement(_emailField, email);
        log.info("Entering email address : " + email + " to email field : " + _emailField.toString());
    }

    public void enterPassword(String password) {
        Reporter.log("Entering password : " + password + " to password field : " + _passwordField.toString() + "<br>");
        clickOnElement(_passwordField);
        sendTextToElement(_passwordField, password);
        log.info("Entering password : " + password + " to password field : " + _passwordField.toString());
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on login button : " + _loginBtn.toString() + "<br>");
        clickOnElement(_loginBtn);
        log.info("Clicking on login button : " + _loginBtn.toString());
    }

    public String getWelcomeText() {
        Reporter.log("Getting text from : " + _welcomeText.toString() + "<br>");
        log.info("Getting text from : " + _welcomeText.toString());
        return getTextFromElement(_welcomeText);
    }

    public String getErrorMessage(){
        Reporter.log("Getting error text from " + _loginErrorMessage.toString() + "<br>" );
        log.info("Getting error text from " + _loginErrorMessage.toString());
        return getTextFromElement(_loginErrorMessage);
    }

    public void loginToApplication(String username, String password) {
        enterEmailId(username);
        enterPassword(password);
        clickOnLoginButton();
    }


}
