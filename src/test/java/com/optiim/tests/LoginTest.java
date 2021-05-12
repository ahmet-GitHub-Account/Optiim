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

        extentLogger= report.createTest("Hepsiburada Test");

        /**
         * 1. <http://www.hepsiburada.com/> sitesini açılacak ve anasayfanın açıldığını onaylayacak
         */
        String actualMainPageTitle = loginPage.openTheMainPage();
        String expectedMainPageTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        Assert.assertEquals(actualMainPageTitle, expectedMainPageTitle);

        extentLogger.info("Hepsiburada anasayfayı aç");

        /**
         * 2. Login ekranını açıp, bir kullanıcı ile login olacak ( daha önce siteye üyeliğin varsa o olabilir )
         */
        loginPage.loginWithValidCredentials();

        extentLogger.info("Bir kullanıcı ile login ol");

        /**
         * 3. Ekranın üstündeki Search alanına 'samsung' yazip 'Ara' butonuna tıklayacak
         */
        productsPage.searchForProduct();
        String productsPageCurrentTitle = driver.getTitle();
        System.out.println("after the has searched the " + ConfigurationReader.get("searchedProduct") + " the current title is : " + productsPageCurrentTitle);
        Assert.assertTrue(productsPageCurrentTitle.contains(ConfigurationReader.get("searchedProduct")));

        extentLogger.info("Search alanına Samsung yaz ve ara butonuna tıkla");

        /**
         * 4. Sol menüden 'Telefon' sonrasında 'Cep Telefonu' tıklayacak
         */
        productsPage.clickOnThePhoneAndCellPhone();

        extentLogger.info("Telefon ve ardında Cep Telefonu modüllerine tıkla");

        /**
         * 5. Gelen sayfada samsung için sonuç bulunduğunu onaylayacak
         */
        String actualSearchResultTitle = productsPage.searchResultTitle.getText();
        String expectedSearchResultTitle = ConfigurationReader.get("searchedProduct");

        System.out.println("actualSearchResultTitleText = " + actualSearchResultTitle);
        System.out.println("expectedSearchResultTitle = " + expectedSearchResultTitle);
        Assert.assertEquals(actualSearchResultTitle, expectedSearchResultTitle);

        extentLogger.info("Samsung ile ilgili sonuçlar bulunduğunu onayla");

        /**
         * 6. Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak
         */
        productsPage.secondPageButton.click();
        Assert.assertTrue(productsPage.activeSecondPage.isDisplayed());

        extentLogger.info("2. sayfaya tıkla ve onayla");

        /**
         * 7. Üstten 5. ürünü tıklayacak
         */
        productsPage.fifthProduct.click();

        extentLogger.info("Sayfadaki 5. ürüne tıkla");

        /**
         * 8. Ürün detayında 'Beğen' butonuna tıklayacak
         */
        selectedProductPage.clickOnTheBegenButton();

        extentLogger.info("Ürün detay sayfasındaki 'Beğen' butonuna tıkla");


        /**
         * 9. 'Ürün listenize eklendi.' popup kontrolü yapacak
         */
        System.out.println("Ürün listenize eklendi message is here : " + selectedProductPage.popUpMessage.getText());

        String expectedProduct = selectedProductPage.productName.getText();
        System.out.println("expectedProduct = " + expectedProduct);
        BrowserUtils.waitFor(3);
        Assert.assertEquals(selectedProductPage.popUpMessage.getText(), "Ürün listenize eklendi.");
        BrowserUtils.waitFor(7);

        extentLogger.info("'Ürün listenize eklendi.' popUp kontrolü yap");

        /**
         * 10. Ekranın en üstündeki hesabım alanında 'Beğendiklerim' tıklayacak
         */
        selectedProductPage.clickOnTheBegendiklerimButton();

        extentLogger.info("Hesabım altındaki Beğendiklerim butonuna tıkla");


        /**
         * 11. Açılan sayfada bir önceki sayfada beğendiklerime alınmış ürünün bulunduğunu onaylayacak
         */

        String actualProduct = listemPage.listedekiUrunAdı.getText();
        Assert.assertEquals(actualProduct, expectedProduct);

        BrowserUtils.waitFor(3);

        extentLogger.info("Açılan sayfada bir önceki sayfada beğendiklerime alınmış ürünün bulunduğunu onayla");


        /**
         * 12. Beğendiklerime alınmış ürün bulunup seçilecek ve sepete eklenecek
         */
        listemPage.addToBasketTheFavProduct();

        extentLogger.info("Beğendiklerime alınmış ürünü seç ve sepete ekle");



        /**
         * 13. 'Ürün sepete eklendi' popup kontrolü yapacak
         */
        System.out.println("Ürün sepete eklendi message is here : " + selectedProductPage.popUpMessage.getText());
        Assert.assertEquals(selectedProductPage.popUpMessage.getText(), "Ürün sepete eklendi");

        BrowserUtils.waitFor(5);

        extentLogger.info("'Ürün sepete eklendi' popUp kontrolü yap");


        /**
         * 14. Sepetim sayfasına gidecek
         */
        sepetimPage.sepetimButton.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Sepetim sayfasına git");

        /**
         * 15. Sepete eklenen bu ürünün içine girilip 'Kaldır' butonuna basılacak, sepetimden çıkarılacak
         */
        sepetimPage.deleteTheProduct();

        extentLogger.info("Sepete eklenen bu ürünü kaldır");

        /**
         * 16. Bu ürünün artik sepette olmadığını onaylayacak
         */
        BrowserUtils.waitFor(3);
        BrowserUtils.verifyElementNotDisplayed(sepetimPage.sepettekiUrun);

        extentLogger.info("Kaldırılan ürünün sepette olmadığını onayla");

    }
}


