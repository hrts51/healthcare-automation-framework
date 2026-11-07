Feature: Session management
  Scenario: User logs out successfully
    Given the healthcare portal is open
    When the administrator logs in with valid credentials
    And the user logs out
    Then the login page should be displayed
