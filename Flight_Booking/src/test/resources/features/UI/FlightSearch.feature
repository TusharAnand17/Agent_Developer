Feature: Flight Search

  Scenario: Verify default values for all fields
    Given the user opens the flight search page
    Then the "From" and "To" dropdowns should default to "Select City"
    And the "Passengers" field should default to 1
    And the "Travel Class" should default to "Economy"

  Scenario: Validate mandatory "From" field
    Given the user opens the flight search page
    When the user leaves the "From" field blank
    And clicks "Search"
    Then an error message "Please select a departure city." should be displayed

  Scenario: Validate mandatory "To" field
    Given the user opens the flight search page
    When the user leaves the "To" field blank
    And clicks "Search"
    Then an error message "Please select a destination city." should be displayed

  Scenario: Validate "From" and "To" cannot be the same
    Given the user opens the flight search page
    When the user selects "New York" in the "From" field
    And the user selects "New York" in the "To" field
    And clicks "Search"
    Then an error message "Departure and destination cannot be the same." should be displayed

  Scenario: Validate mandatory "Departure Date" field
    Given the user opens the flight search page
    When the user leaves the "Departure Date" field blank
    And clicks "Search"
    Then an error message "Please select a departure date." should be displayed

  Scenario: Validate past dates in "Departure Date"
    Given the user opens the flight search page
    When the user selects a past date in the "Departure Date" field
    Then past dates should be disabled and cannot be selected

  Scenario: Validate numeric input for "Passengers"
    Given the user opens the flight search page
    When the user enters "abc" in the "Passengers" field
    And clicks "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate boundary value for "Passengers"
    Given the user opens the flight search page
    When the user enters 0 in the "Passengers" field
    And clicks "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate upper boundary for "Passengers"
    Given the user opens the flight search page
    When the user enters 10 in the "Passengers" field
    And clicks "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate valid "Passengers" input
    Given the user opens the flight search page
    When the user enters 5 in the "Passengers" field
    And clicks "Search"
    Then the search should proceed without any error message

  Scenario: Validate "Travel Class" dropdown
    Given the user opens the flight search page
    When the user opens the "Travel Class" dropdown
    Then the options "Economy", "Business", and "First" should be displayed

  Scenario: Validate "One Way" checkbox functionality
    Given the user opens the flight search page
    When the user checks the "One Way" checkbox
    Then the "Return Date" field should be hidden

  Scenario: Validate "Return Date" reappears
    Given the user opens the flight search page
    When the user unchecks the "One Way" checkbox
    Then the "Return Date" field should reappear

  Scenario: Validate "Search" button disabled
    Given the user opens the flight search page
    When the user leaves all mandatory fields blank
    Then the "Search" button should be disabled

  Scenario: Validate "Search" button enabled
    Given the user opens the flight search page
    When the user fills all mandatory fields with valid data:
      | From       | To       | Departure Date | Passengers | Class   |
      | New York   | London   | valid date     | 1          | Economy |
    Then the "Search" button should be enabled

  Scenario: Validate search results display
    Given the user opens the flight search page
    When the user fills all fields with valid data:
      | From       | To       | Departure Date | Passengers | Class   |
      | New York   | London   | valid date     | 2          | Economy |
    And clicks "Search"
    Then the results page should display available flights sorted by departure time

  Scenario: Validate no flights available message
    Given the user opens the flight search page
    When the user fills all fields with valid data that yield no results:
      | From       | To       | Departure Date | Passengers | Class   |
      | New York   | Tokyo    | valid date     | 1          | Business |
    And clicks "Search"
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Validate manual date entry format
    Given the user opens the flight search page
    When the user manually enters "31-02-2023" in the "Departure Date" field
    And clicks "Search"
    Then an error message "Please select a valid date." should be displayed

  Scenario: Validate calendar navigation
    Given the user opens the flight search page
    When the user opens the calendar picker
    Then future months should be accessible
    And past months should be disabled

  Scenario: Validate clear button in calendar picker
    Given the user opens the flight search page
    When the user selects a date in the calendar picker
    And clicks the "Clear" button
    Then the selected date should be cleared and the field should be blank

  Scenario: Validate mandatory fields for round-trip search
    Given the user opens the flight search page
    When the user leaves all fields blank
    And clicks "Search"
    Then the "Search" button should remain disabled

  Scenario: Validate "From" and "To" fields are not the same
    Given the user opens the flight search page
    When the user enters "New York" in both "From" and "To" fields
    And clicks "Search"
    Then an error message "Departure and destination cities cannot be the same." should be displayed

  Scenario: Validate "Departure Date" is mandatory
    Given the user opens the flight search page
    When the user leaves the "Departure Date" field blank
    And clicks "Search"
    Then an error message "Please select a departure date." should be displayed

  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the user opens the flight search page
    When the user unchecks "One Way"
    And leaves the "Return Date" blank
    And clicks "Search"
    Then an error message "Please select a return date." should be displayed

  Scenario: Validate "Return Date" is after "Departure Date"
    Given the user opens the flight search page
    When the user enters "10-10-2023" as "Departure Date"
    And enters "09-10-2023" as "Return Date"
    And clicks "Search"
    Then an error message "Return date must be after departure date." should be displayed

  Scenario: Validate "Departure Date" cannot be in the past
    Given the user opens the flight search page
    When the user enters "01-01-2020" as "Departure Date"
    And clicks "Search"
    Then an error message "Departure date cannot be in the past." should be displayed

  Scenario: Validate passenger count is within the allowed range
    Given the user opens the flight search page
    When the user enters 0 as "Passengers"
    And clicks "Search"
    Then an error message "Please enter a valid number of passengers." should be displayed

  Scenario: Validate travel class selection
    Given the user opens the flight search page
    When the user leaves the "Travel Class" field unselected
    And clicks "Search"
    Then an error message "Please select a travel class." should be displayed

  Scenario: Validate successful search with valid inputs
    Given the user opens the flight search page
    When the user enters valid inputs for all fields:
      | From       | To       | Departure Date | Return Date | Passengers | Class   |
      | New York   | Los Angeles | 10-10-2023 | 15-10-2023 | 2          | Economy |
    And clicks "Search"
    Then the results page should display departure and return flights sorted by departure time

  Scenario: Validate error message for no flights available
    Given the user opens the flight search page
    When the user enters valid inputs for all fields but with no matching flights:
      | From       | To       | Departure Date | Return Date | Passengers | Class   |
      | City A     | City B   | 10-10-2023     | 15-10-2023 | 2          | Economy |
    And clicks "Search"
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Validate calendar popup for date fields
    Given the user opens the flight search page
    When the user clicks on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the user opens the flight search page
    When the user manually enters "10-10-2023" in the "Departure Date" and "Return Date" fields
    Then the dates should be accepted without errors