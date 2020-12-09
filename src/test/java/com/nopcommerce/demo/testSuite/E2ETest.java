package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E2ETest extends TestBase {
    HomePage homePage;
    ComputerPage computerPage;
    DesktopPage desktopPage;
    BuildYourComputerPage buildYourComputerPage;
    ShoppingCartPage shoppingCartPage;
    static String actualMessage;

    @BeforeMethod(groups = {"Smoke", "Regression"})
    public void setUp() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyProductSortedAlphabetically() throws InterruptedException {
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();

        computerPage.clickOnComputerLink();
        desktopPage.clickDesktopLink();
        desktopPage.sortProductsOrderByZToA();
        desktopPage.deskTopPageAction();
    }


    @Test(groups = {"Sanity", "Regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();
        buildYourComputerPage = new BuildYourComputerPage();
        shoppingCartPage = new ShoppingCartPage();
        computerPage.clickOnComputerLink();// clicks computer link and clicks on desktop
        desktopPage.clickDesktopLink();
        //verifying user is on Desktop page
        actualMessage = desktopPage.actualMessageDesktop();
        Assert.assertEquals(actualMessage, "Desktops");// verifying on DesktopPage

        desktopPage.sortProductsOrderByZToA();//sorts ztoa
        desktopPage.deskTopPageAction();// // clicks on dropDown, selects A to Z and clicks on Add to cart button
        desktopPage.clickonAddToCartBtn();

        // Moving to Build your computer
        waitFor(2);
        actualMessage = buildYourComputerPage.buildYourComputerPageVerify();
        Assert.assertEquals(actualMessage, "Build your own computer");
        // Selecting various Elements from build your own computer page
        buildYourComputerPage.buildYourOwnComputerSelectProcessor(); // Selects 2.2GHz Processor
        buildYourComputerPage.buildYourOwnComputerSelectRAM(); // selects 8GB RAM
        buildYourComputerPage.buildYourOwnComputerRadioButton(); // Selects OS & HDD radio button
        buildYourComputerPage.buildYourOwnComputerCheckBox();// Selects Microsoft Office and Commander CheckBox
        //verify Amount total is $1,475.00
        String actualMessage1 = buildYourComputerPage.actualAmountMessage();
        Assert.assertEquals(actualMessage1, "$1,475.00");
        buildYourComputerPage.buildYourOwnComputerAddToCartBtn();//clicks on Add to cart button
        buildYourComputerPage.notificationDisplay();// verifying the notification popup
        shoppingCartPage.moveToShoppingCart();// clicks on Shopping cart Link and 'Go to Cart button'
        shoppingCartPage.amendQtyField(); // clears the field and amends the quantity to 2
        shoppingCartPage.updateFinalCart(); // Final Add to cart button


    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        driver.quit();
    }
}