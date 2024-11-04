Feature: API testing feature

  Scenario: Test Adding Candidiate through API
    Given API Auth
    When Add candidate
    And Delete Candidate