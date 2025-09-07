Feature: Round-trip Flight Search Validations
  This feature validates the round-trip flight search functionality, including field validations, error handling, and search results.

  Scenario: Validate mandatory fields for round-trip search
    Given the flight search page is open
    When I leave all fields blank and try to click the "Search" button
    Then the "Search" button should remain disabled

  Scenario: Validate "From" and "To" fields are not the same
    Given the flight search page is open
    When I enter "New York" in both "From" and "To" fields and click "Search"
    Then I should see an error message "Departure and destination cities cannot be the same."

  Scenario: Validate "Departure Date" is mandatory
    Given the flight search page is open
    When I leave the "Departure Date" field blank and click "Search"
    Then I should see an error message "Please select a departure date."

  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the flight search page is open
    When I uncheck "One Way", leave the "Return Date" field blank, and click "Search"
    Then I should see an error message "Please select a return date."

  Scenario: Validate "Return Date" is after "Departure Date"
    Given the flight search page is open
    When I enter "10-10-2023" as the "Departure Date" and "09-10-2023" as the "Return Date" and click "Search"
    Then I should see an error message "Return date must be after departure date."

  Scenario: Validate "Departure Date" cannot be in the past
    Given the flight search page is open
    When I enter "01-01-2020" as the "Departure Date" and click "Search"
    Then I should see an error message "Departure date cannot be in the past."

  Scenario: Validate passenger count is within the allowed range
    Given the flight search page is open
    When I enter 0 as the passenger count and click "Search"
    Then I should see an error message "Please enter a valid number of passengers."

  Scenario: Validate travel class selection
    Given the flight search page is open
    When I leave the "Travel Class" field unselected and click "Search"
    Then I should see an error message "Please select a travel class."

  Scenario: Validate successful search with valid inputs
    Given the flight search page is open
    When I enter valid inputs for all fields and click "Search"
      | From       | To         | Departure Date | Return Date | Passengers | Travel Class |
      | New York   | Los Angeles| 10-10-2023     | 15-10-2023  | 2          | Economy      |
    Then the results page should display departure and return flights sorted by departure time

  Scenario: Validate error message for no flights available
    Given the flight search page is open
    When I enter valid inputs for all fields but with no matching flights and click "Search"
      | From       | To         | Departure Date | Return Date | Passengers | Travel Class |
      | City A     | City B     | 10-10-2023     | 15-10-2023  | 2          | Economy      |
    Then I should see a message "No flights available for selected criteria."

  Scenario: Validate calendar popup for date fields
    Given the flight search page is open
    When I click on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the flight search page is open
    When I manually enter "10-10-2023" in the "Departure Date" and "15-10-2023" in the "Return Date" fields
    Then the dates should be accepted without errors