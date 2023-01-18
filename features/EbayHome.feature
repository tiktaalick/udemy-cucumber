Feature: Ebay Home Page Scenarios

  @Home
  Scenario: Navigating from Home to Advanced Search page
    Given I am on Ebay Home page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @iPhone @setCookies
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 11
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 12
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 13
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 14
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 15
    Then I validate at least 1000 search items are present

  @iPhone
  Scenario: Count the number of iPhones
    Given I am on Ebay Home page
    When I search for 'iPhone' 16
    Then I validate at least 1000 search items are present

  @ThisTestFails
#  Scenario: Count the number of iPhones
#    Given I am on Ebay Home page
#    When I search for 'iPhone' 17
#    Then I validate at least 1000 search items are present

  @Category @setCookies @iPhone
  Scenario: Search an item in category
    Given I am on Ebay Home page
    When I search for 'soap' in 'bAbY' category
    Then I validate at least 1000 search items are present

  @Outline
  Scenario Outline: Home page links
    Given I am on Ebay Home page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples:
      | link    | url                                                                | title                         |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors                   |
      | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing, Shoes & Accessories |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys & Hobbies                |