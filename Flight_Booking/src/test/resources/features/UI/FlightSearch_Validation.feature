Feature: Flight Search Validation

  Scenario: Verify search results are displayed
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed in a structured list format

  Scenario: Verify flight details in results
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then each flight includes airline, flight number, departure city, arrival city, times, duration, and price

  Scenario: Verify sorting by departure time
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then flights are sorted by departure time in ascending order

  Scenario: Verify round trip results separation
    Given the search form is functional and connected to the database
    When the user performs a round trip flight search with valid criteria:
      | Origin      | Destination | Departure Date | Return Date | Passengers |
      | NYC         | LAX         | 2023-12-01     | 2023-12-05  | 1          |
    Then results are split into Departure Flights and Return Flights sections

  Scenario: Verify no flights message
    Given the search form is functional and connected to the database
    When the user performs a flight search with criteria that yield no results:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-25 | 1          |
    Then a message is displayed: "No flights available for selected criteria."

  Scenario: Verify structured list format
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed in a clear, readable structured list format

  Scenario: Verify search with invalid criteria
    Given the search form is functional and connected to the database
    When the user performs a flight search with invalid criteria:
      | Origin      | Destination | Date         | Passengers |
      | NYC         | LAX         | InvalidDate  | 1          |
    Then an error message is displayed: "Invalid search criteria. Please check your inputs."

  Scenario: Verify empty search criteria
    Given the search form is functional and connected to the database
    When the user performs a flight search with empty criteria:
      | Origin | Destination | Date | Passengers |
      |        |             |      |            |
    Then an error message is displayed: "Please fill in all required fields."

  Scenario: Verify boundary for passenger count (minimum)
    Given the search form is functional and connected to the database
    When the user performs a flight search with minimum passenger count:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed successfully

  Scenario: Verify boundary for passenger count (maximum)
    Given the search form is functional and connected to the database
    When the user performs a flight search with maximum passenger count:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 9          |
    Then results are displayed successfully

  Scenario: Verify passenger count beyond max
    Given the search form is functional and connected to the database
    When the user performs a flight search with passenger count exceeding max:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 10         |
    Then an error message is displayed: "Maximum passenger count is 9."

  Scenario: Verify special characters in inputs
    Given the search form is functional and connected to the database
    When the user performs a flight search with special characters in input fields:
      | Origin      | Destination | Date       | Passengers |
      | NYC@        | LAX#        | 2023-12-01 | 1          |
    Then an error message is displayed: "Invalid characters in input fields."

  Scenario: Verify numeric input in text fields
    Given the search form is functional and connected to the database
    When the user performs a flight search with numeric input in text fields:
      | Origin      | Destination | Date       | Passengers |
      | 123         | 456         | 2023-12-01 | 1          |
    Then an error message is displayed: "Invalid input in text fields."

  Scenario: Verify duplicate search results
    Given the search form is functional and connected to the database
    When the user performs a flight search with criteria yielding duplicate results:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed without duplicates

  Scenario: Verify case sensitivity in inputs
    Given the search form is functional and connected to the database
    When the user performs a flight search with mixed case inputs:
      | Origin      | Destination | Date       | Passengers |
      | nyc         | lax         | 2023-12-01 | 1          |
    Then results are displayed successfully

  Scenario: Verify search with past date
    Given the search form is functional and connected to the database
    When the user performs a flight search with a past date:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2022-12-01 | 1          |
    Then an error message is displayed: "Date cannot be in the past."

  Scenario: Verify search with future date
    Given the search form is functional and connected to the database
    When the user performs a flight search with a valid future date:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed successfully

  Scenario: Verify system response time
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed within acceptable response time (e.g., < 3 seconds)

  Scenario: Verify UI alignment of results
    Given the search form is functional and connected to the database
    When the user performs a flight search with valid criteria:
      | Origin      | Destination | Date       | Passengers |
      | NYC         | LAX         | 2023-12-01 | 1          |
    Then results are displayed with proper UI alignment

  Scenario: Verify error logging for failures
    Given the search form is functional and connected to the database
    When the user performs a flight search with invalid criteria:
      | Origin      | Destination | Date         | Passengers |
      | NYC         | LAX         | InvalidDate  | 1          |
    Then the error is logged in the system logs