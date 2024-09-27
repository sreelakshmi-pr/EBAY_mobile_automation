package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListingPage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ebay.mobile:id/up_arrow']")
    WebElement saveThisNotification;

    @FindBy(xpath = "((//android.widget.RelativeLayout[@resource-id=\"com.ebay.mobile:id/search_item_card_header\"])[1]//android.widget.TextView)[1]")
    WebElement productPageText;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Filter']")
    WebElement filterTab;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.ebay.mobile:id/call_to_action_button']")
    WebElement showResultBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Back to all refinements']")
    WebElement filterBackButton;

    public void clickOnNotification() {
        if (isDisplayed(saveThisNotification)) {
            saveThisNotification.click();
        }
    }

    public boolean isOnProductPage(String productName) {
        System.out.println(productPageText.getText().toLowerCase());
        System.out.println(productName.toLowerCase());
        return productPageText.getText().toLowerCase().contains(productName.toLowerCase());
    }


    public void laptopFiltering(String filterCategory) {

//        if (showResultBtn.isDisplayed()) {
//            showResultBtn.click();
//        }
        if(filterTab.isDisplayed()){
            filterTab.click();
        }

//        if(isPresent(filterBackButton)){
//            filterBackButton.click();
//        }
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, filterCategory);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void subFiltering(String subCategory){
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, subCategory);
        driver.findElement(By.xpath(xpath)).click();

    }

    public boolean isLaptopFiltered(String data) {
        List<WebElement> currentProductList = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));

        int x = currentProductList.get(0).getLocation().getX();
        int y = currentProductList.get(0).getLocation().getY();
        int cardWidth = currentProductList.get(0).getSize().getWidth();
        int cardHeight = currentProductList.get(0).getSize().getHeight();
        for(int i=0;i<=5;i++){

            String xpath = "//android.widget.TextView[contains(@content-desc,'%s')]";
            xpath = String.format(xpath, data);
            WebElement refurbishedText = driver.findElement(By.xpath(xpath));

             if (!isDisplayed(refurbishedText)) {
                return false;
             }

            scrollOrSwipe(x+cardWidth/2,y+cardHeight/2,x+cardWidth/2,0);

    }

        return true;
    }



    public void filter(String filter) {
        if (isDisplayed(filterTab)) {

            filterTab.click();
        }

        String xpath = "//android.widget.Button[@resource-id=\"com.ebay.mobile:id/filter_pill\" and @text='%s']";
        xpath = String.format(xpath, filter);
        driver.findElement(By.xpath(xpath)).click();

        if (isDisplayed(showResultBtn)) {
            showResultBtn.click();
        }

    }


    public void subFilteringFromShipping(String subCategory) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String xpath = "//android.widget.Switch[@text='%s']";
        xpath = String.format(xpath, subCategory);
        WebElement subCategoryText = driver.findElement(By.xpath(xpath));
        if(isDisplayed(subCategoryText)){
            subCategoryText.click();
        }

    }

    public void clickOnSearchBtn() {
        if(isDisplayed(showResultBtn)){
            showResultBtn.click();
        }
    }



}
