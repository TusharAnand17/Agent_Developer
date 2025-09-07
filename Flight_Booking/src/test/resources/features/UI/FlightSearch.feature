Feature: Flight Search Validation

  # Scenario 1: Validate mandatory fields for round-trip search
  Scenario: Validate mandatory fields for round-trip search
    Given the application is running and the search page is loaded
    When the user leaves all fields blank
    Then the "Search" button should remain disabled

  # Scenario 2: Validate "From" and "To" fields are not the same
  Scenario: Validate "From" and "To" fields are not the same
    Given the application is running and the search page is loaded
    When the user enters "New York" in both "From" and "To" fields and clicks "Search"
    Then an error message "Departure and destination cities cannot be the same." should be displayed

  # Scenario 3: Validate "Departure Date" is mandatory
  Scenario: Validate "Departure Date" is mandatory
    Given the application is running and the search page is loaded
    When the user leaves the "Departure Date" field blank and clicks "Search"
    Then an error message "Please select a departure date." should be displayed

  # Scenario 4: Validate "Return Date" is mandatory for round-trip
  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the application is running and the search page is loaded
    When the user unchecks "One Way", leaves "Return Date" blank, and clicks "Search"
    Then an error message "Please select a return date." should be displayed

  # Scenario 5: Validate "Return Date" is after "Departure Date"
  Scenario: Validate "Return Date" is after "Departure Date"
    Given the application is running and the search page is loaded
    When the user enters "10-10-2023" as "Departure Date" and "09-10-2023" as "Return Date" and clicks "Search"
    Then an error message "Return date must be after departure date." should be displayed

  # Scenario 6: Validate "Departure Date" cannot be in the past
  Scenario: Validate "Departure Date" cannot be in the past
    Given the application is running and the search page is loaded
    When the user enters "01-01-2020" as "Departure Date" and clicks "Search"
    Then an error message "Departure date cannot be in the past." should be displayed

  # Scenario 7: Validate passenger count is within the allowed range
  Scenario: Validate passenger count is within the allowed range
    Given the application is running and the search page is loaded
    When the user enters a passenger count of "0" or "10" and clicks "Search"
    Then an error message "Please enter a valid number of passengers." should be displayed

  # Scenario 8: Validate travel class selection
  Scenario: Validate travel class selection
    Given the application is running and the search page is loaded
    When the user leaves the "Travel Class" field unselected and clicks "Search"
    Then an error message "Please select a travel class." should be displayed

  # Scenario 9: Validate successful search with valid inputs
  Scenario: Validate successful search with valid inputs
    Given the application is running and the search page is loaded
    When the user enters valid inputs:
      | Field          | Value           |
      | From           | New York        |
      | To             | Los Angeles     |
      | Departure Date | 10-10-2023      |
      | Return Date    | 15-10-2023      |
      | Passengers     | 2               |
      | Travel Class   | Economy         |
    And clicks "Search"
    Then the results page should display departure and return flights sorted by departure time

  # Scenario 10: Validate error message for no flights available
  Scenario: Validate error message for no flights available
    Given the application is running and the search page is loaded
    When the user enters valid inputs:
      | Field          | Value           |
      | From           | City A          |
      | To             | City B          |
      | Departure Date | 10-10-2023      |
      | Return Date    | 15-10-2023      |
      | Passengers     | 2               |
      | Travel Class   | Economy         |
    And clicks "Search"
    Then a message "No flights available for selected criteria." should be displayed

  # Scenario 11: Validate calendar popup for date fields
  Scenario: Validate calendar popup for date fields
    Given the application is running and the search page is loaded
    When the user clicks on the "Departure Date" and "Return Date" fields
    Then the calendar popup should appear for both fields

  # Scenario 12: Validate manual date entry in "dd-mm-yyyy" format
  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the application is running and the search page is loaded
    When the user manually enters "10-10-2023" as "Departure Date" and "15-10-2023" as "Return Date"
    Then the dates should be accepted without errors