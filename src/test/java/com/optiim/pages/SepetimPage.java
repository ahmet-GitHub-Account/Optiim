package com.optiim.pages;

import com.optiim.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SepetimPage extends BasePage {

    @FindBy (xpath = "//a[text() = 'Samsung Galaxy Note 20 Ultra 256 GB (Samsung Türkiye Garantili)']")
    public WebElement sepettekiUrun;

    @FindBy(css = " .delete_product_3DFC0")
    public WebElement urunuSilButton;

    public void deleteTheProduct (){
        BrowserUtils.hover(urunuSilButton);
        urunuSilButton.click();
    }

}
