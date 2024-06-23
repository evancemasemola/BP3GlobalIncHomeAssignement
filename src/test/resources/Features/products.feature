Feature: Testing products page

  @OrderBackpack
  Scenario Outline: Verify that user is able to checkout and item
    Given I am on the products page
    When I click on the Backpack add to cart button
    And I click on the cart icon
    And  I enter First Name "<FirstName>"
    And I enter Last Name "<LastName>"
    And I enter Zip code "<ZipCode>"
    And I click on the continue button
    And I click on the Finish button
    Then I should be displayed with an Checkout Completed Page

    Examples: OrderBackpack
      | FirstName | LastName | ZipCode |
      | Evance    | Masemola | 1449    |