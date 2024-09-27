package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Close']")
    WebElement closeIcon;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Search Keyword Search on eBay']")
    WebElement searchTab;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.ebay.mobile:id/navigation_bar_item_icon_view\"])[1]")
    WebElement homeIcon;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.ebay.mobile:id/navigation_bar_item_icon_view\"])[3]")
    WebElement searchIcon;

    @FindBy(xpath = "//android.widget.Button[@text = 'Categories']")
    WebElement categoryElement;


    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/search_suggestion_text']")
    List<WebElement> searchedProductNameList;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@text='Search on eBay']")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    WebElement allowButton;


    public void openApplication() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            closeIcon.isDisplayed();
            closeIcon.click();

        }catch (Exception e){
            System.out.println("no pop up");
        }finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
//        if (isDisplayed(closeIcon)) {
//            closeIcon.click();
//        }
    }

    public boolean isHomePageDispalyed() {
//        if(isDisplayed(allowButton)){
//            allowButton.click();
//        }

        return isDisplayed(searchTab);
    }


    public void clickOnCategories() {
        categoryElement.click();
    }

    public void searchProduct(String productName) {
        searchTab.click();
        searchBar.sendKeys(productName);
        searchedProductNameList.get(0).click();

    }


    public void clickOnHome(){
        homeIcon.click();
    }


    public void clickOnSearch() {
        searchIcon.click();
    }
}


