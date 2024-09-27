package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryListPage extends BasePage{


    public void clickOnTheProductCategory(String category) {

        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        String categoryXpath = "//android.widget.TextView[@text='%s']";
        String categoryXpathLocation = String.format(categoryXpath, category);
        WebElement productCategory = driver.findElement(By.xpath(categoryXpathLocation));

//        while (!isPresent(productCategory)){
//            scrollOrSwipe(width/2,height/2,width/2,0);
//        }
        productCategory.click();


    }

    public void clickOnTheProductSubCategory(String subCategory) {
        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, subCategory);
        WebElement productSubCategory = driver.findElement(By.xpath(xpath));
        while(!isPresent(productSubCategory)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        productSubCategory.click();

    }

    public void clickOnTheProductInnerSubCategory(String innerSubCategory) {

        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, innerSubCategory);
        WebElement productInnerSubCategory = driver.findElement(By.xpath(xpath));
        while(!isPresent(productInnerSubCategory)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        productInnerSubCategory.click();

    }
}
