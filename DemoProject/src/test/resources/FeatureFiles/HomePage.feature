Feature: Validate the the search functionality for the product from the Luma Home page

  Scenario: Check the search functionality
    Given User launches the Luma Project application on a browser
    When user enter the searchtext and clicks the enter button
    Then user must be able to see the matched products on the screen
