package com.optiim.pages;

import com.optiim.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListemPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'hb-eRkjGz dHezNd')]")
    public WebElement urunSecCheckBox;

    @FindBy (xpath = "//button[text() = 'Seçilenleri Sepete Ekle']")
    public WebElement secilenleriSepeteEkleButton;

    @FindBy(xpath = "//div[contains(@class ,'hb-jbctos bpqlul')]")
    public WebElement productImage;

    @FindBy(xpath = "//div[contains(@id,'Title')]")
    public WebElement listedekiUrunAdı;


    /**
     * 12. Beğendiklerime alınmış ürün bulunup seçilecek ve sepete eklenecek
     */
    public void addToBasketTheFavProduct(){
        BrowserUtils.hover(productImage);
        BrowserUtils.waitFor(3);
        urunSecCheckBox.click();

        BrowserUtils.waitFor(2);
        secilenleriSepeteEkleButton.click();

        BrowserUtils.waitFor(3);
    }

}
