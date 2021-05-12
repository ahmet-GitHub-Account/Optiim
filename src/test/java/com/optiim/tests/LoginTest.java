package com.optiim.tests;


import com.optiim.pages.*;
import com.optiim.utilities.BrowserUtils;
import com.optiim.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    SelectedProductPage selectedProductPage = new SelectedProductPage();
    ListemPage listemPage = new ListemPage();
    SepetimPage sepetimPage = new SepetimPage();


    @Test
    public void endToEnd() {

        /**
         * 1
         */
        String actualMainPageTitle = loginPage.openTheMainPage();
        String expectedMainPageTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(actualMainPageTitle, expectedMainPageTitle);

        /**
         * 2
         */
        loginPage.loginWithValidCredentials();

        /**
         * 3
         */
        productsPage.searchForProduct();
        String productsPageCurrentTitle = driver.getTitle();
        System.out.println("after the has searched the " + ConfigurationReader.get("searchedProduct") + " the current title is : " + productsPageCurrentTitle);
        Assert.assertTrue(productsPageCurrentTitle.contains(ConfigurationReader.get("searchedProduct")));

        /**
         * 4
         */
        productsPage.clickOnThePhoneAndCellPhone();

        /**
         * 5
         */
        String actualSearchResultTitle = productsPage.searchResultTitle.getText();
        String expectedSearchResultTitle = ConfigurationReader.get("searchedProduct");

        System.out.println("actualSearchResultTitleText = " + actualSearchResultTitle);
        System.out.println("expectedSearchResultTitle = " + expectedSearchResultTitle);
        Assert.assertEquals(actualSearchResultTitle, expectedSearchResultTitle);

        /**
         * 6
         */
        productsPage.secondPageButton.click();
        Assert.assertTrue(productsPage.activeSecondPage.isDisplayed());

        /**
         * 7
         */
        productsPage.fifthProduct.click();

        /**
         * 8
         */
        selectedProductPage.clickOnTheBegenButton();


        /**
         * 9
         */
        System.out.println("Ürün listenize eklendi message is here : " + selectedProductPage.popUpMessage.getText());

        String expectedProduct = selectedProductPage.productName.getText();
        Assert.assertEquals(selectedProductPage.popUpMessage.getText(), "Ürün listenize eklendi.");
        BrowserUtils.waitFor(7);

        /**
         * 10
         */
        selectedProductPage.clickOnTheBegendiklerimButton();

        /**
         * 11
         */

        String actualProduct = listemPage.listedekiUrunAdı.getText();
        Assert.assertEquals(actualProduct, expectedProduct);

        BrowserUtils.waitFor(3);

        /**
         * 12
         */
        listemPage.addToBasketTheFavProduct();

        /**
         * 13
         */
        System.out.println("Ürün sepete eklendi message is here : " + selectedProductPage.popUpMessage.getText());
        Assert.assertEquals(selectedProductPage.popUpMessage.getText(), "Ürün sepete eklendi");

        BrowserUtils.waitFor(5);

        /**
         * 14
         */
        sepetimPage.sepetimButton.click();
        BrowserUtils.waitFor(3);

        /**
         * 15
         */
        sepetimPage.deleteTheProduct();

        /**
         * 16
         */
        BrowserUtils.waitFor(3);
        BrowserUtils.verifyElementNotDisplayed(sepetimPage.sepettekiUrun);

    }
}


