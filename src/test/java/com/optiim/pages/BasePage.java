package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.optiim.utilities.Driver;
import org.testng.Assert;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@class = 'desktopOldAutosuggestTheme-input']")
    public WebElement searchInputBox;

    @FindBy(xpath = "//div[@class = 'SearchBoxOld-buttonContainer']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@title = 'Giriş Yap']")
    public WebElement girisYapList;

    @FindBy(xpath = "//a[@title = 'Giriş yap']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//span[text() = 'Hesabım']")
    public WebElement hesabımButton;

    @FindBy(xpath = "//span[text() = 'Sepetim']")
    public WebElement sepetimButton;


    /**
     * 1. <http://www.hepsiburada.com/> sitesini açılacak ve anasayfanın açıldığını onaylayacak
     */
    public String openTheMainPage() {

        // get the current window's title
        String currentTitle = Driver.get().getTitle();

        // which is the our expected main page title
//        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";

        // assert the two title is same or not
//        Assert.assertEquals(currentTitle, expectedTitle);

        return currentTitle;
    }

}
