package com.optiim.pages;

import com.optiim.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectedProductPage extends BasePage {

    @FindBy(xpath = "//div[text() = 'Listeme ekle']")
    public WebElement listemeEkleButton;

    @FindBy(xpath = "//span[text() = 'Beğendiklerim']")
    public WebElement begendiklerimButton;

    @FindBy(xpath = "//a[text() = 'Beğendiklerim']")
    public WebElement begendiklerimSayfasınaGidis;

    @FindBy(xpath = "//div[@class = 'hb-toast-text']")
    public WebElement popUpMessage;

    @FindBy(xpath = "//div[text() = 'Beğen']")
    public WebElement begenButton;

    @FindBy(xpath = "//div[text() = 'Beğen']")
    public List<WebElement> begenButtonisDisplayed;

    @FindBy(id = "product-name")
    public WebElement productName;

    /**
     * 8. Ürün detayında 'Beğen' butonuna tıklayacak
     */
    public void clickOnTheBegenButton(){
        // Here can be two different locator type for the begenButton. So I used the if condition
        if (begenButtonisDisplayed.size() > 0) {
            begenButton.click();
        } else {
            listemeEkleButton.click();
            BrowserUtils.waitFor(2);
            begendiklerimButton.click();
        }

//        BrowserUtils.waitFor(3);
    }

    public void clickOnTheBegendiklerimButton() {
        BrowserUtils.hover(hesabımButton);
        BrowserUtils.waitFor(2);
        begendiklerimSayfasınaGidis.click();
    }

}
