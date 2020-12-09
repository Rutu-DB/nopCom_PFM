package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegistrationPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    public static String nEmail;


    @BeforeMethod(groups = {"Sanity", "Smoke", "Regression"})
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {

        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        homePage.clickOnLoginLink();
        waitFor(2);
        nEmail = randomEmail();
        loginPage.enterEmailId(nEmail);
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"Regression"})
    public void verifyUserShouldNotLoginSuccessfullyWithInValidCredentials() throws InterruptedException {
        homePage.clickOnLoginLink();
        waitFor(2);
        loginPage.enterEmailId("betatest123@me.com.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        driver.quit();
    }
}
