package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegistrationPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    HomePage homePage;
    RegistrationPage registrationPage;
    public String nEmail = randomEmail();

    @BeforeMethod(groups = {"Sanity", "Smoke", "Regression"})
    public void setUp() {
        homePage = new HomePage();
        registrationPage = new RegistrationPage();
    }


    @Test (groups = {"Smoke","Regression"})
    public void verifyThatUserIsOnRegistrationPage(){
        homePage.clickOnRegisterLink();
        String actualResult = registrationPage.verifyRegisterPageMessage();
        Assert.assertEquals(actualResult,"Register");

    }
    @Test (groups = {"Sanity","Regression"})
    public void verifyRegistrationSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        waitFor(2);
        registrationPage.clickOnGender();
        registrationPage.enterFirstName("Alpha");
        registrationPage.enterLastName("Beta");
        registrationPage.setDate();
        registrationPage.setMonth();
        registrationPage.setYear();
        registrationPage.enterEmailId(nEmail);
        registrationPage.enterCompanyField("Alpha Beta Ltd.");
        registrationPage.clickOnNewsletterChkBox();
        registrationPage.enterPassword("123456");
        registrationPage.confirmPasswordField("123456");
        registrationPage.clickonRegisterButton();
        String actualResult = registrationPage.verifyRegisterSuccessMessage();
        Assert.assertEquals(actualResult,"Your registration completed");
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        driver.quit();

    }

}
