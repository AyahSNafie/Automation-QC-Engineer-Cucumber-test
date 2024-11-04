Feature: Add SystemUsers 

  Scenario: Add users to system
    Given Browser is open
    And User navigates to Opensource website
    And User inserts Admin and admin123
    And User clicks login
    And Click on Admin tab
    And Return number of rows
    When Search username for added user
    When Delete the new user
    Then Return number of rows
   # And Close Browser
    