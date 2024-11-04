Feature: Number of rows in page

  Scenario: Return number of rows
    Given Browser is open
    And User navigates to Opensource website
    And User inserts Admin and admin123
    And User clicks login
    When Click on Admin tab
    Then Return number of rows
	#	And Close Browser