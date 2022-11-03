@Address
Feature: Address Module Api Automation

  Scenario Outline: Verify add user address to the application through api
    Given User add Header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<addressType>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify the addUserAddress response message "Address added successfully"

    Examples: 
      | firstName | lastName | mobile     | apartment | state | city | country | zipcode | address      | addressType |
      | Arun      | Muni     | 7845486608 | Prince    |   123 |   11 |     101 |  604404 | Injamppakkam | Home        |

  Scenario Outline: Verify update user address to the application through api
    Given User add Header and bearer authorization for accessing address endpoints
    When User add request body for update address "<addressId>","<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<addressType>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify the updateUserAddress response message "Address updated successfully"

    Examples: 
      | addressId | firstName | lastName | mobile     | apartment | state | city | country | zipcode | address      | addressType |
      |     31108 | Arun      | Kumar    | 7845486608 | Prince    |   123 |   11 |     101 |  604404 | Injamppakkam | Home        |

  Scenario: Verify get user address to the application through api
    Given User add Header and bearer authorization for accessing address endpoints
    And User send "GET" request for getUserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify the getUserAddress response message "OK"

  Scenario Outline: Verify Delete user address to the application through api
    Given User add Header and bearer authorization for accessing address endpoints
    When User add request body for Delete user address "<addressId>"
    And User send "DELETE" request for DeleteUserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify the DeleteUserAddress response message "Address deleted successfully"

    Examples: 
      | addressId |
      |     31108 |
