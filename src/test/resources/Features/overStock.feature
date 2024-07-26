Feature: Overstock

  Background:
    Given user is on the home page

  Scenario: check if user can navigate to homepage by clicking on the Logo
    When user click on the overstock Logo
    And user is navigated to the home page

  Scenario: check user can continue as a guest
    When user enters the login portal
    And  user click on Continue as Guest button
    Then user is navigated to the home page

  Scenario: Check login is successful with valid credentials
    When user enters Email "moumitaroy1995.mr@gmail.com" and password "overstock123"
    And click on Sign In button
    Then user is navigated to the home page

  Scenario Outline: Check login is unsuccessful with invalid credentials
    When user enters Email "<email>" and password "<password>"
    And click on Sign In button
    Then user is failed to login

    Examples:
    |email|password|
    |moumitaroy1995.mr@gmail.com|mou123|
    |moumitaroy1995.mr@gmail.com|hello456|
    |moumitaroy1995.mr@gmail.com|automation2024|

  Scenario: user can select a furniture through Navigation Bar
    When user navigate to mattresses through Navigation Bar
    And user can select the item

  Scenario: user can search an item through Search Bar
    When user enters value "Wedding Rings" in the Search Bar
    And click on the Search Button
    Then user is navigated to the Wedding Rings page

  Scenario Outline: user can search any item through Search Bar
    When user enters value "<item>" in the Search Bar
    And click on the Search Button
    Then user is on the item page

    Examples:
    |item|
    |iphone|
    |wine glasses|
    |eye shadow  |
    |gown        |

  Scenario: user can navigate to More page
    When click on the More button
    And user is navigated to the More page

  Scenario: user can navigate to Top Deals page
    When click on the Top Deals button
    And user is navigated to the Top Deals page

  Scenario: user can Logout
    When user is Logged In to their account entering Email "moumitaroy1995.mr@gmail.com" and password "overstock123"
    And user Logout from their account
    Then user is navigated to the home page