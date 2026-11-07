Feature: Patient management
  Scenario: Administrator registers a new patient
    Given the healthcare portal is open
    When the administrator logs in with valid credentials
    And the administrator opens patient management
    And the administrator registers a patient named "Aarav Sharma" with email "aarav@example.test" and phone "9000000001"
    Then the patient registration confirmation should be displayed
