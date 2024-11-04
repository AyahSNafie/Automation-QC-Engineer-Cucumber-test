Feature: Login feature

  Scenario: Logging in the website
    Given Browser is open
    When User navigates to Opensource website
    And User inserts Admin and admin123
    And User clicks login
    Then User is navigated to landing page
	#	And Close Browser