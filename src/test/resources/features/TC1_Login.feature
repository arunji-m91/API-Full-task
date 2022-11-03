@Login
Feature: Login Module Api Automation

  Scenario: Get User logtoken from login endpoint
    Given User add Header
    When User add basic authentication for login
    And User should send "POST" request for login endpoint
    Then User should verify the status code is 200
    Then User should verify the login response body firstName present as "ARUN" and get the logtoken saved
