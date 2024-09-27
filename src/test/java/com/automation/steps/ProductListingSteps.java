package com.automation.steps;

import com.automation.pages.ProductListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingSteps {

    ProductListingPage productListingPage = new ProductListingPage();

    @Then("verify user is on {string} product page")
    public void verifyUserIsOnProductPage(String productName) {
        productListingPage.clickOnNotification();
        Assert.assertTrue(productListingPage.isOnProductPage(ConfigReader.getValue(productName)));

    }

    @When("user apply laptop filter option {string}")
    public void userApplyLaptopFilterOption(String category) {
        productListingPage.laptopFiltering(category);
    }


    @And("user apply subCategory {string} from category")
    public void userApplySubCategoryFromCategory(String subCategory) {
        productListingPage.subFiltering(subCategory);
    }

    @And("user apply subCategory {string} from Shipping category")
    public void userApplySubCategoryFromShippingCategory(String subCategory) {
        productListingPage.subFilteringFromShipping(subCategory);
    }

    @Then("verify the product are displayed contains {string} based on filtering")
    public void verifyTheProductAreDisplayedContainsBasedOnFiltering(String data) {
        Assert.assertTrue(productListingPage.isLaptopFiltered(ConfigReader.getValue(data)));
    }

    @And("user search for result")
    public void userSearchForResult() {
        productListingPage.clickOnSearchBtn();
    }



}
