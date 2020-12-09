package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegistrationPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    HomePage homepage;

    @FindBy(xpath = "//label[contains(text(),'Male')]")
    WebElement _gender;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement _firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement _lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']//option[contains(text(),'11')]")
    WebElement _selectDate;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']//option[contains(text(),'November')]")
    WebElement _selectMonth;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']//option[contains(text(),'2011')]")
    WebElement _selectYear;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement _emailField;


    @FindBy(xpath = "//input[@id='Company']")
    WebElement _company;

    @FindBy(xpath = "//input[@id='Newsletter']")
    WebElement _newsletter;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement _passwordField;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement _confirmPwd;

    @FindBy(xpath = "//input[@id='register-button']")
    WebElement _registerButton;

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement _registerMessage;


    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement _registerScuccessMessage;

    //This method clicks on Gender Radio Button
    public void clickOnGender() {
        Reporter.log("Gender " + _gender.toString() + " <br>");
        clickOnElement(_gender);
        log.info("click on Gender " + _gender.toString());
    }

    //This method sends FirstName
    public void enterFirstName(String fName) {
        Reporter.log("First Name: " + fName + " to First Name Field " + _firstName.toString() + " <br>");
        clickOnElement(_firstName);
        sendTextToElement(_firstName, fName);
        log.info("clicks and sends First Name " + _firstName.toString());
    }

    //This method sends Last Name
    public void enterLastName(String lName) {
        Reporter.log("Last Name " + lName + " to Last Name Field  " + _lastName.toString() + " <br>");
        sendTextToElement(_lastName, lName);
        log.info("clicks and sends Last Name " + _lastName.toString());
    }

    // This method selects Date from the drop down
    public void setDate() {
        Reporter.log("Date: " + _selectDate.toString() + " <br>");
        clickOnElement(_selectDate);
        log.info("selects date from the DropDown " + _selectDate.toString());
    }
    // This method selects Month from the drop down
    public void setMonth() {
        Reporter.log("Selects Month from Dropdown : " + _selectMonth.toString() + " <br>");
        clickOnElement(_selectMonth);
        log.info("selects month from the Dropdown " + _selectMonth.toString());
    }
    // This method selects Year from the drop down
    public void setYear() {
        Reporter.log("Date: " + _selectYear.toString() + " <br>");
        clickOnElement(_selectYear);
        log.info("Selects Year from Dropdown " + _selectYear.toString());
    }
    // This method sends email Id to the field
    public void enterEmailId(String emailId) {
        Reporter.log(" Email Id: " + emailId + " to Email ID Field " + _emailField.toString() + " <br>");
        clickOnElement(_emailField);
        sendTextToElement(_emailField, emailId);
        log.info("send Email Id to " + _emailField.toString());
    }
    //This method sends Company information
    public void enterCompanyField(String companyName) {
        Reporter.log("Company Name " + _company.toString() + "<br>");
        clickOnElement(_company);
        sendTextToElement(_company, companyName);
        log.info("send Company Name " + _company.toString());
    }
    // This method clicks on Newletter Checkbox
    public void clickOnNewsletterChkBox() {
        Reporter.log("News Letter " + _newsletter.toString() + "<br>");
        clickOnElement(_newsletter);
        log.info("Selects Newsletter Checkbox " + _newsletter.toString());
    }
    // This method sends Password to the field
    public void enterPassword(String password1) {
        Reporter.log("Password Field : " + _passwordField.toString() + "<br>");
        clickOnElement(_passwordField);
        sendTextToElement(_passwordField, password1);
        log.info("send password to field" + _passwordField.toString());
    }
    // This method send password to Confirm Password Field
    public void confirmPasswordField(String password2) {
        Reporter.log("Confirm Password " + _confirmPwd.toString() + "<br>");
        clickOnElement(_confirmPwd);
        sendTextToElement(_confirmPwd, password2);
        log.info("send password to confirm password field " + _confirmPwd.toString());
    }
    //This method click on register button
    public void clickonRegisterButton() {
        Reporter.log("Registration Button Click " + _registerButton.toString() + "<br>");
        clickOnElement(_registerButton);
        log.info("Clicks on Registeration Button " + _registerButton.toString());
    }
    //This method verifies Register Message
    public String verifyRegisterPageMessage (){
        Reporter.log("Registration Message " + _registerMessage.toString() + "<br>");
        log.info("Verify Registration Message " + _registerMessage.toString());
        return getTextFromElement(_registerMessage);

    }
    // This method verifies Successful registration
    public String verifyRegisterSuccessMessage(){
        log.info("Verifies Successful Registration");
        return getTextFromElement(_registerScuccessMessage);
    }

    public void registerSuccessfully(String newEmail) throws InterruptedException {
       homepage.clickOnRegisterLink();
        waitFor(2);
        enterFirstName("Alpha");
        waitFor(2);
        enterLastName("Beta");
        waitFor(2);
        setDate();
        waitFor(2);
        setMonth();
        waitFor(2);
        setYear();
        waitFor(2);
        enterEmailId(newEmail);
        waitFor(2);
        enterCompanyField("Alpha Test Ltd.");
        waitFor(2);
        clickOnNewsletterChkBox();
        waitFor(2);
        enterPassword("123456");
        waitFor(2);
        confirmPasswordField("123456");
        waitFor(2);
        clickonRegisterButton();
    }
}