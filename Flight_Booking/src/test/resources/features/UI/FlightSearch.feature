Feature: Flight Search Functionality

  Scenario: Verify default values for all fields
    Given the flight search page is open
    Then the "From" and "To" dropdowns should default to "Select City"
    And the "Passengers" field should default to 1
    And the "Travel Class" should default to Economy

  Scenario: Validate mandatory "From" field
    Given the flight search page is open
    When I leave the "From" field blank and click "Search"
    Then an error message "Please select a departure city." should be displayed

  Scenario: Validate mandatory "To" field
    Given the flight search page is open
    When I leave the "To" field blank and click "Search"
    Then an error message "Please select a destination city." should be displayed

  Scenario: Validate "From" and "To" cannot be the same
    Given the flight search page is open
    When I select the same city for "From" and "To" fields and click "Search"
    Then an error message "Departure and destination cannot be the same." should be displayed

  Scenario: Validate mandatory "Departure Date" field
    Given the flight search page is open
    When I leave the "Departure Date" field blank and click "Search"
    Then an error message "Please select a departure date." should be displayed

  Scenario: Validate past dates in "Departure Date"
    Given the flight search page is open
    When I select a past date in the "Departure Date" field
    Then past dates should be disabled and cannot be selected

  Scenario: Validate numeric input for "Passengers"
    Given the flight search page is open
    When I enter a non-numeric value in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate boundary value for "Passengers"
    Given the flight search page is open
    When I enter 0 in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate upper boundary for "Passengers"
    Given the flight search page is open
    When I enter 10 in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate valid "Passengers" input
    Given the flight search page is open
    When I enter a valid number (e.g., 5) in the "Passengers" field and click "Search"
    Then no error message should be displayed
    And the search should proceed

  Scenario: Validate "Travel Class" dropdown
    Given the flight search page is open
    When I open the "Travel Class" dropdown
    Then the options "Economy", "Business", and "First" should be displayed

  Scenario: Validate "One Way" checkbox functionality
    Given the flight search page is open
    When I check the "One Way" checkbox
    Then the "Return Date" field should be hidden

  Scenario: Validate "Return Date" reappears
    Given the flight search page is open
    When I uncheck the "One Way" checkbox
    Then the "Return Date" field should reappear

  Scenario: Validate "Search" button disabled
    Given the flight search page is open
    When I leave mandatory fields blank
    Then the "Search" button should be disabled

  Scenario: Validate "Search" button enabled
    Given the flight search page is open
    When I fill all mandatory fields
    Then the "Search" button should be enabled

  Scenario: Validate search results display
    Given the flight search page is open
    When I fill all fields with valid data and click "Search"
    Then the results page should display available flights sorted by departure time

  Scenario: Validate no flights available message
    Given the flight search page is open
    When I fill all fields with valid data that yield no results and click "Search"
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Validate manual date entry format
    Given the flight search page is open
    When I manually enter an invalid date format in the "Departure Date" field and click "Search"
    Then an error message "Please select a valid date." should be displayed

  Scenario: Validate calendar navigation
    Given the flight search page is open
    When I open the calendar picker and navigate to future months
    Then future months should be accessible
    And past months should be disabled

  Scenario: Validate clear button in calendar picker
    Given the flight search page is open
    When I select a date in the calendar picker and click the "Clear" button
    Then the selected date should be cleared
    And the field should be blank