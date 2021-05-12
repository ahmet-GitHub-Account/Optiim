package com.optiim.pages;

import com.optiim.utilities.BrowserUtils;
import com.optiim.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends BasePage {


    @FindBy(xpath = "(//li[@class='category-level-0'])[1]")
    public WebElement telefonMenu;

    @FindBy(xpath = "//label[@for='category-2147483642_371965']")
    public WebElement cepTelefonuMenu;

    @FindBy(xpath = "//h1[@class = 'search-results-title']")
    public WebElement searchResultTitle;

    @FindBy(xpath = "//a[@class = 'page-2 ']")
    public WebElement secondPageButton;

    @FindBy(xpath = "//a[@class = 'page-2 active']")
    public WebElement activeSecondPage;

    @FindBy(xpath = "//li[@class = 'search-item col lg-1 md-1 sm-1  custom-hover not-fashion-flex'][5]")
    public WebElement fifthProduct;


    /**
     * 3. Ekranın üstündeki Search alanına 'samsung' yazip 'Ara' butonuna tıklayacak
     */
    public void searchForProduct(){
        searchInputBox.sendKeys(ConfigurationReader.get("searchedProduct"));
        searchButton.click();
        BrowserUtils.waitFor(3);
    }

    /**
     * 4. Sol menüden 'Telefon' sonrasında 'Cep Telefonu' tıklayacak
     */
    public void clickOnThePhoneAndCellPhone(){
        telefonMenu.click();
        BrowserUtils.waitFor(3);
        cepTelefonuMenu.click();
        BrowserUtils.waitFor(2);
    }




}
































