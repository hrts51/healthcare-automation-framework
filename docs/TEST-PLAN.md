# Test Plan – CarePoint Demo Portal

## Scope
UI-level functional validation of authentication, patient registration, appointment booking and logout.

## Test scenarios
| ID | Scenario | Type | Expected result |
|---|---|---|---|
| AUTH-001 | Administrator signs in with valid credentials | Positive | Administrator dashboard shown |
| AUTH-002 | Healthcare staff signs in with valid credentials | Positive | Staff dashboard shown |
| AUTH-003 | Invalid credentials are submitted | Negative | Authentication error shown |
| PAT-001 | Administrator registers a patient with valid details | Positive | Patient confirmation shown |
| APT-001 | Administrator books an appointment with complete details | Positive | Appointment confirmation shown |
| SES-001 | Signed-in user logs out | Positive | Login screen shown |

## Additional scenarios to implement
- Empty email/password; malformed email; whitespace-only values.
- Duplicate patient email; invalid phone; missing patient name.
- Appointment with past date; missing patient; missing reason; duplicate booking.
- Staff role access restrictions for administrative actions.
- Browser refresh, session timeout, keyboard navigation and responsive layout.

## Entry / exit criteria
Entry: demo portal reachable, JDK/Maven installed, browser available. Exit: all critical scenarios pass; failures triaged and documented; report artifact retained.

## Test data
Use fabricated names and reserved `.test` email addresses. Never use real patient information.
