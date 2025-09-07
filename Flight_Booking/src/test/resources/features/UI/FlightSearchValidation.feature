Feature: Flight Search Validation

  Scenario: Validate mandatory fields for round-trip search
    Given the flight search page is open
    When I leave all fields blank and try to click the "Search" button
    Then the "Search" button should remain disabled

  Scenario: Validate "From" and "To" fields are not the same
    Given the flight search page is open
    When I enter the same city in both "From" and "To" fields and click "Search"
    Then an error message "Departure and destination cities cannot be the same." should be displayed

  Scenario: Validate "Departure Date" is mandatory
    Given the flight search page is open
    When I leave the "Departure Date" field blank and click "Search"
    Then an error message "Please select a departure date." should be displayed

  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the flight search page is open
    When I uncheck "One Way", leave "Return Date" blank, and click "Search"
    Then an error message "Please select a return date." should be displayed

  Scenario: Validate "Return Date" is after "Departure Date"
    Given the flight search page is open
    When I enter a "Return Date" earlier than or equal to the "Departure Date" and click "Search"
    Then an error message "Return date must be after departure date." should be displayed

  Scenario: Validate "Departure Date" cannot be in the past
    Given the flight search page is open
    When I enter a past date in the "Departure Date" field and click "Search"
    Then an error message "Departure date cannot be in the past." should be displayed

  Scenario: Validate passenger count is within the allowed range
    Given the flight search page is open
    When I enter a passenger count outside the allowed range (e.g., 0 or 10) and click "Search"
    Then an error message "Please enter a valid number of passengers." should be displayed

  Scenario: Validate travel class selection
    Given the flight search page is open
    When I leave the "Travel Class" field unselected and click "Search"
    Then an error message "Please select a travel class." should be displayed

  Scenario: Validate successful search with valid inputs
    Given the flight search page is open
    When I enter valid inputs for all fields and click "Search"
    Then the results page should display departure and return flights sorted by departure time

  Scenario: Validate error message for no flights available
    Given the flight search page is open
    When I enter valid inputs for all fields but with no matching flights and click "Search"
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Validate calendar popup for date fields
    Given the flight search page is open
    When I click on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the flight search page is open
    When I enter a valid date manually in the "Departure Date" and "Return Date" fields
    Then the dates should be accepted without errors