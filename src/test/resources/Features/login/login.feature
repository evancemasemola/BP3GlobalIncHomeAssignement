
Feature: Testing saucedemo.com login page

  @locked
  Scenario Outline: Verify an error is displayed when user tries to login with locked out user
    Given I am on the sauce demo website "https://www.saucedemo.com/"
    When I enter UserName '<LockedUsername>'
    And  I enter Password '<Password>'
    And I click on the login button
    Then I should be displayed with an error message

    Examples: Locked out user
      | LockedUsername  | Password     |  |
      | locked_out_user | secret_sauce |  |

  @StandardUser
  Scenario Outline: Verify user is displayed with the product page when they login to sauce demo
    Given I am on the sauce demo website "https://www.saucedemo.com/"
    When I enter UserName '<StandardUsername>'
    And  I enter Password '<Password>'
    And I click on the login button
    Then I should be redirected to the products page

    Examples: StandardUser
      | StandardUsername  | Password     |  |
      | standard_user | secret_sauce |  |