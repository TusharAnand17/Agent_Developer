Feature: Flight Search Validation

  # Scenario 1: Validate mandatory fields for round-trip search
  Scenario: Validate mandatory fields for round-trip search
    Given the flight search page is open
    When I leave all fields blank and try to click the "Search" button
    Then the "Search" button should remain disabled

  # Scenario 2: Validate "From" and "To" fields are not the same
  Scenario: Validate "From" and "To" fields are not the same
    Given the flight search page is open
    When I enter the same city "New York" in both "From" and "To" fields and click "Search"
    Then an error message "Departure and destination cities cannot be the same." should be displayed

  # Scenario 3: Validate "Departure Date" is mandatory
  Scenario: Validate "Departure Date" is mandatory
    Given the flight search page is open
    When I leave the "Departure Date" field blank and click "Search"
    Then an error message "Please select a departure date." should be displayed

  # Scenario 4: Validate "Return Date" is mandatory for round-trip
  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the flight search page is open
    And I uncheck "One Way"
    When I leave the "Return Date" field blank and click "Search"
    Then an error message "Please select a return date." should be displayed

  # Scenario 5: Validate "Return Date" is after "Departure Date"
  Scenario: Validate "Return Date" is after "Departure Date"
    Given the flight search page is open
    When I enter "Departure Date" as "10-10-2023" and "Return Date" as "09-10-2023" and click "Search"
    Then an error message "Return date must be after departure date." should be displayed

  # Scenario 6: Validate "Departure Date" cannot be in the past
  Scenario: Validate "Departure Date" cannot be in the past
    Given the flight search page is open
    When I enter a past date "01-01-2020" in the "Departure Date" field and click "Search"
    Then an error message "Departure date cannot be in the past." should be displayed

  # Scenario 7: Validate passenger count is within the allowed range
  Scenario: Validate passenger count is within the allowed range
    Given the flight search page is open
    When I enter a passenger count outside the allowed range (e.g., 0 or 10) and click "Search"
    Then an error message "Please enter a valid number of passengers." should be displayed

  # Scenario 8: Validate travel class selection
  Scenario: Validate travel class selection
    Given the flight search page is open
    When I leave the "Travel Class" field unselected and click "Search"
    Then an error message "Please select a travel class." should be displayed

  # Scenario 9: Validate successful search with valid inputs
  Scenario: Validate successful search with valid inputs
    Given the flight search page is open
    When I enter valid inputs for all fields:
      | From          | To            | Departure Date | Return Date | Passengers | Travel Class |
      | New York      | Los Angeles   | 10-10-2023     | 15-10-2023  | 2          | Economy      |
    And I click "Search"
    Then the results page should display departure and return flights sorted by departure time

  # Scenario 10: Validate error message for no flights available
  Scenario: Validate error message for no flights available
    Given the flight search page is open
    When I enter valid inputs for all fields but with no matching flights:
      | From          | To            | Departure Date | Return Date | Passengers | Travel Class |
      | City A        | City B        | 10-10-2023     | 15-10-2023  | 2          | Economy      |
    And I click "Search"
    Then a message "No flights available for selected criteria." should be displayed

  # Scenario 11: Validate calendar popup for date fields
  Scenario: Validate calendar popup for date fields
    Given the flight search page is open
    When I click on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  # Scenario 12: Validate manual date entry in "dd-mm-yyyy" format
  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the flight search page is open
    When I manually enter "10-10-2023" in the "Departure Date" and "15-10-2023" in the "Return Date" fields
    Then the dates should be accepted without errors