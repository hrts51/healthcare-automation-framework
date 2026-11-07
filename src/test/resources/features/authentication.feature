Feature: Healthcare portal authentication
  As a healthcare portal user, I want secure access to the portal.
  Scenario: Administrator can log in
    Given the healthcare portal is open
    When the administrator logs in with valid credentials
    Then the dashboard should be displayed
    And the signed-in user should be "Administrator"
  Scenario: Staff member can log in
    Given the healthcare portal is open
    When the staff member logs in with valid credentials
    Then the dashboard should be displayed
    And the signed-in user should be "Healthcare Staff"
  Scenario: Invalid credentials are rejected
    Given the healthcare portal is open
    When the user logs in with email "wrong@care.local" and password "incorrect"
    Then an authentication error should be displayed
