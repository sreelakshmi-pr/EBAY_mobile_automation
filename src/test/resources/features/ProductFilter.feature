Feature: Laptop Filter Functionality

  Background:
    Given user opens the application
    Then verify user is on home Page
    When user search for product "product2.name"
    Then verify user is on "product2.name" product page

  Scenario: Verify user can apply filter using condition
    When user apply laptop filter option "Condition"
    And user apply subCategory "Good - Refurbished" from category
    And user search for result
    Then verify the product are displayed contains "Refurbished.Data" based on filtering

  Scenario: Verify user can apply filter using shipping option
    When user apply laptop filter option "Shipping Options"
    And user apply subCategory "Free International Shipping" from Shipping category
    And user search for result
    Then verify the product are displayed contains "FreeShipping.data" based on filtering






