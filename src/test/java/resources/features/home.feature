@homeRegression
Feature: Homepage related scenarios

  Scenario: Verifying store page link
    Given I am on the homepage
    When I click on store link
    Then I should see the store page
    And Store image logo should be loaded

  Scenario Outline: : Verifying courses on the homepage
    Given I am on the homepage
    Then I should see "<course>" displayed
    Examples:
      | course                                                 |
      | Selenium Webdriver & Java                              |
      | Cucumber BDD with Selenium & Java                      |
      | Cypress.io 10 using Javascript                         |
      | Webdriver IO using Javascript                          |
      | Mastering Selectors/Locators                           |
      | Selenium Webdriver 4 - New Features                    |
      | Intro to Cucumber BDD, Selenium & Java (Free - 2.5hrs) |