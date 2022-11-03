@StateId
Feature: StateId Module Api Automation

  Scenario: Get StateId from StateList endpoint
    Given User add Header for StateList endpoint
    And User should send "GET" request for StateId endpoint
    Then User should verify the status code is 200
    Then User should verify the getStateId response message matches "Tamil Nadu"
