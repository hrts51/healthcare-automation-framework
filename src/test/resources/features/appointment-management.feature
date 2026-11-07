Feature: Appointment management
  Scenario: Administrator books a patient appointment
    Given the healthcare portal is open
    When the administrator logs in with valid credentials
    And the administrator opens appointment management
    And the administrator books an appointment for "Aarav Sharma" on "2026-12-01" for "General consultation"
    Then the appointment confirmation should be displayed
