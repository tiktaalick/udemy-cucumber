Feature: Ebay Home Page Scenarios

  @Home
  Scenario: Navigating from Home to Advanced Search page
    Given I am on Ebay Home page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @iPhone
  Scenario: Count the number of iPhone 11's
    Given I am on Ebay Home page
    When I search for iPhone 11
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhone 12's
    Given I am on Ebay Home page
    When I search for iPhone 12
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhone 13's
    Given I am on Ebay Home page
    When I search for iPhone 13
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhone 14's
    Given I am on Ebay Home page
    When I search for iPhone 14
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhone 15's
    Given I am on Ebay Home page
    When I search for iPhone 15
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhone 16's
    Given I am on Ebay Home page
    When I search for iPhone 16
    Then I validate at least 1000 search items are present

  @ThisTestFails
  Scenario: Count the number of iPhone 17's
    Given I am on Ebay Home page
    When I search for iPhone 17
    Then I validate at least 1000 search items are present
