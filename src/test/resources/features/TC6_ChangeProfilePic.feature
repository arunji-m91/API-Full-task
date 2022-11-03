@ChangeProfilePic
Feature: Change Profile Picture Module Api Automation

  Scenario: Verifying Change Profile Picture through Api Automation
    Given User add Header and bearer authorization for accessing profile picture endpoints
    When User add form data for add profile picture
    And User should send "POST" request for change profile picture endpoint
    Then User should verify the status code is 200
    Then User should verify change profile picture success message "Profile updated Successfully"
