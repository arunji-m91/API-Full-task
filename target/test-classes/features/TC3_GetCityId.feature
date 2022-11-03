@CityId
Feature: CityId Module Api Automation

  Scenario Outline: Get CityId from CityList
    Given User add Header for CityList endpoint
    When User add request body for CityList "<StateId>"
    And User should send "POST" request for CityId endpoint
    Then User should verify the status code is 200
    Then User should verify the CityId response body message matches "Yercaud"

    Examples: 
      | StateId |
      |      35 |
