@ProductSearch
Feature: Product Search Module Api Automation

  Scenario Outline: Verify Search Product to the application through Api
    Given User add Header for Search Product endpoint
    When User add request body for Search Product "<productName>"
    And User should send "POST" for Search Product endpoint
    Then User should verify the status code is 200
    Then User should verify Search Product response body message "OK"

    Examples: 
      | productName |
      | nuts        |
