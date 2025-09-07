Feature: Round-Trip Flight Search Validation
  This feature validates the round-trip flight search functionality for various scenarios.

  Scenario: Validate mandatory fields for round-trip search
    Given I open the flight search page
    When I leave all fields blank and try to click the "Search" button
    Then the "Search" button should remain disabled

  Scenario: Validate "From" and "To" fields are not the same
    Given I open the flight search page
    When I enter the same city in both "From" and "To" fields and click "Search"
    Then I should see an error message "Departure and destination cities cannot be the same."

  Scenario: Validate "Departure Date" is mandatory
    Given I open the flight search page
    When I leave the "Departure Date" field blank and click "Search"
    Then I should see an error message "Please select a departure date."

  Scenario: Validate "Return Date" is mandatory for round-trip
    Given I open the flight search page
    When I uncheck "One Way", leave "Return Date" blank, and click "Search"
    Then I should see an error message "Please select a return date."

  Scenario: Validate "Return Date" is after "Departure Date"
    Given I open the flight search page
    When I enter a "Return Date" earlier than or equal to the "Departure Date" and click "Search"
    Then I should see an error message "Return date must be after departure date."

  Scenario: Validate "Departure Date" cannot be in the past
    Given I open the flight search page
    When I enter a past date in the "Departure Date" field and click "Search"
    Then I should see an error message "Departure date cannot be in the past."

  Scenario: Validate passenger count is within the allowed range
    Given I open the flight search page
    When I enter a passenger count outside the allowed range (e.g., 0 or 10) and click "Search"
    Then I should see an error message "Please enter a valid number of passengers."

  Scenario: Validate travel class selection
    Given I open the flight search page
    When I leave the "Travel Class" field unselected and click "Search"
    Then I should see an error message "Please select a travel class."

  Scenario: Validate successful search with valid inputs
    Given I open the flight search page
    When I fill all fields with valid data:
      | From         | To           | Departure Date | Return Date  | Passengers | Travel Class |
      | New York     | Los Angeles  | 10-10-2023     | 15-10-2023   | 2          | Economy      |
    And I click "Search"
    Then the results page should display departure and return flights sorted by departure time

  Scenario: Validate error message for no flights available
    Given I open the flight search page
    When I fill all fields with valid data:
      | From         | To           | Departure Date | Return Date  | Passengers | Travel Class |
      | City A       | City B       | 10-10-2023     | 15-10-2023   | 2          | Economy      |
    And I click "Search"
    Then I should see a message "No flights available for selected criteria."

  Scenario: Validate calendar popup for date fields
    Given I open the flight search page
    When I click on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given I open the flight search page
    When I manually enter a valid date in the "Departure Date" and "Return Date" fields
    Then the dates should be accepted without errors
