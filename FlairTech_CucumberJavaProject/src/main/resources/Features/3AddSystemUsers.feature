Feature: Add SystemUsers 

  Scenario: Add users to system
    Given Browser is open
    And User navigates to Opensource website
    And User inserts Admin and admin123
    And User clicks login
    And Click on Admin tab
    When User clicks Add
    And Choose User Role
    And Choose Status
    And Insert Password and Confirm Password
    And Username
    And Insert Employee Name
   	And Clicks save
  	And Click on Admin tab
   Then Return number of rows
  # And Close Browser
    