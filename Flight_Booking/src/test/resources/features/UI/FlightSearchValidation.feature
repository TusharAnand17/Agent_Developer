Feature: Flight Search Validation
  As a user, I want to ensure that the flight search functionality works correctly by validating all mandatory fields and inputs.

  Scenario: Validate mandatory fields for round-trip search
    Given the application is running and the search page is loaded
    When I leave all fields blank
    Then the "Search" button should remain disabled

  Scenario: Validate "From" and "To" fields are not the same
    Given the application is running and the search page is loaded
    When I enter "New York" in both "From" and "To" fields
    Then I should see an error message "Departure and destination cities cannot be the same."

  Scenario: Validate "Departure Date" is mandatory
    Given the application is running and the search page is loaded
    When I leave the "Departure Date" field blank
    Then I should see an error message "Please select a departure date."

  Scenario: Validate "Return Date" is mandatory for round-trip
    Given the application is running and the search page is loaded
    When I uncheck "One Way" and leave the "Return Date" field blank
    Then I should see an error message "Please select a return date."

  Scenario: Validate "Return Date" is after "Departure Date"
    Given the application is running and the search page is loaded
    When I enter "10-10-2023" as the "Departure Date" and "09-10-2023" as the "Return Date"
    Then I should see an error message "Return date must be after departure date."

  Scenario: Validate "Departure Date" cannot be in the past
    Given the application is running and the search page is loaded
    When I enter "01-01-2020" as the "Departure Date"
    Then I should see an error message "Departure date cannot be in the past."

  Scenario: Validate passenger count is within the allowed range
    Given the application is running and the search page is loaded
    When I enter "0" or "10" as the passenger count
    Then I should see an error message "Please enter a valid number of passengers."

  Scenario: Validate travel class selection
    Given the application is running and the search page is loaded
    When I leave the "Travel Class" field unselected
    Then I should see an error message "Please select a travel class."

  Scenario: Validate successful search with valid inputs
    Given the application is running and the search page is loaded
    When I enter "New York" as the "From" field, "Los Angeles" as the "To" field, "10-10-2023" as the "Departure Date", "15-10-2023" as the "Return Date", "2" as the passenger count, and "Economy" as the travel class
    Then the results page should display departure and return flights sorted by departure time

  Scenario: Validate error message for no flights available
    Given the application is running and the search page is loaded
    When I enter "City A" as the "From" field, "City B" as the "To" field, "10-10-2023" as the "Departure Date", "15-10-2023" as the "Return Date", "2" as the passenger count, and "Economy" as the travel class
    Then I should see a message "No flights available for selected criteria."

  Scenario: Validate calendar popup for date fields
    Given the application is running and the search page is loaded
    When I click on the "Departure Date" and "Return Date" fields
    Then a calendar popup should appear for both fields

  Scenario: Validate manual date entry in "dd-mm-yyyy" format
    Given the application is running and the search page is loaded
    When I manually enter "10-10-2023" as the "Departure Date" and "15-10-2023" as the "Return Date"
    Then the dates should be accepted without errors