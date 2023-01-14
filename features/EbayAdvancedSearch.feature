Feature: Ebay Advanced Search Page

  @Advanced
  Scenario: Navigating from Advanced Search page to Home
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @Advanced
  Scenario: Performing an advanced search
    Given I am on Ebay Advanced Search Page
    When I perform an advanced search
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |
