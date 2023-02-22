@storeRegression
Feature: Store page related scenarios
  Background:
    Given I am on the store page

  Scenario: Finding product in the searchbar
    When I search for "Sweater" in the searchbar
    Then I should see "Sweater" displayed in the results

  Scenario: Adding product to the cart
    When I search for "Sweater" in the searchbar
    And I click on the "Sweater" item result
    Then I should be able to select "M" size and add item to the cart

