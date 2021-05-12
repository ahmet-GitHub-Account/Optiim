package com.optiim.pages;

import com.optiim.utilities.BrowserUtils;
import com.optiim.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {

    @FindBy(css = "#txtUserName")
    public WebElement emailInputBox;

    @FindBy(css = "#txtPassword")
    public WebElement passwordInputBox;

    @FindBy(css = "#btnLogin")
    public WebElement loginButton;



    /**
     * 2. Login ekranını açıp, bir kullanıcı ile login olacak ( daha önce siteye üyeliğin varsa o olabilir )
     */
    public void loginWithValidCredentials() {
        BrowserUtils.hover(girisYapList);
        girisYapButton.click();
        BrowserUtils.waitFor(5);
        ExcelUtil datas = new ExcelUtil("src/test/resources/excelFileToGetCredentials.xlsx", "Sheet 1");
        List<Map<String, String>> dataList = datas.getDataList();
        emailInputBox.sendKeys(dataList.get(0).get("userEmail"));
        passwordInputBox.sendKeys(dataList.get(0).get("userPassword"));
        BrowserUtils.waitFor(2);
        loginButton.click();
        BrowserUtils.waitFor(4);
    }

}
