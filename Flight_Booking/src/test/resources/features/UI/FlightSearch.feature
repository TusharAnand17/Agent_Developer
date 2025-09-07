Feature: Flight Search Functionality

  Scenario: Verify default values for all fields
    Given I open the flight search page
    Then the "From" and "To" dropdowns should default to "Select City"
    And the "Passengers" field should default to 1
    And the "Travel Class" field should default to Economy

  Scenario: Validate mandatory "From" field
    Given I open the flight search page
    When I leave the "From" field blank and click "Search"
    Then I should see an error message "Please select a departure city."

  Scenario: Validate mandatory "To" field
    Given I open the flight search page
    When I leave the "To" field blank and click "Search"
    Then I should see an error message "Please select a destination city."

  Scenario: Validate "From" and "To" cannot be the same
    Given I open the flight search page
    When I select "New York" for both "From" and "To" fields and click "Search"
    Then I should see an error message "Departure and destination cannot be the same."

  Scenario: Validate mandatory "Departure Date" field
    Given I open the flight search page
    When I leave the "Departure Date" field blank and click "Search"
    Then I should see an error message "Please select a departure date."

  Scenario: Validate past dates in "Departure Date"
    Given I open the flight search page
    When I select a past date in the "Departure Date" field
    Then past dates should be disabled and cannot be selected

  Scenario: Validate numeric input for "Passengers"
    Given I open the flight search page
    When I enter "abc" in the "Passengers" field and click "Search"
    Then I should see an error message "Please enter between 1 and 9 passengers."

  Scenario: Validate boundary value for "Passengers"
    Given I open the flight search page
    When I enter 0 in the "Passengers" field and click "Search"
    Then I should see an error message "Please enter between 1 and 9 passengers."

  Scenario: Validate upper boundary for "Passengers"
    Given I open the flight search page
    When I enter 10 in the "Passengers" field and click "Search"
    Then I should see an error message "Please enter between 1 and 9 passengers."

  Scenario: Validate valid "Passengers" input
    Given I open the flight search page
    When I enter 5 in the "Passengers" field and click "Search"
    Then the search should proceed without any error message

  Scenario: Validate "Travel Class" dropdown
    Given I open the flight search page
    When I open the "Travel Class" dropdown
    Then I should see the options "Economy", "Business", and "First"

  Scenario: Validate "One Way" checkbox functionality
    Given I open the flight search page
    When I check the "One Way" checkbox
    Then the "Return Date" field should be hidden

  Scenario: Validate "Return Date" reappears
    Given I open the flight search page
    When I uncheck the "One Way" checkbox
    Then the "Return Date" field should reappear

  Scenario: Validate "Search" button disabled
    Given I open the flight search page
    When I leave the mandatory fields blank
    Then the "Search" button should be disabled

  Scenario: Validate "Search" button enabled
    Given I open the flight search page
    When I fill all mandatory fields with valid data:
      | From       | To         | Departure Date |
      | New York   | London     | valid date     |
    Then the "Search" button should be enabled

  Scenario: Validate search results display
    Given I open the flight search page
    When I fill all fields with valid data and click "Search":
      | From       | To         | Departure Date | Passengers | Class   |
      | New York   | London     | valid date     | 2          | Economy |
    Then the results page should display available flights sorted by departure time

  Scenario: Validate no flights available message
    Given I open the flight search page
    When I fill all fields with valid data that yield no results and click "Search":
      | From       | To         | Departure Date | Passengers | Class   |
      | New York   | Tokyo      | valid date     | 1          | Business|
    Then I should see a message "No flights available for selected criteria."

  Scenario: Validate manual date entry format
    Given I open the flight search page
    When I manually enter "31-02-2023" in the "Departure Date" field and click "Search"
    Then I should see an error message "Please select a valid date."

  Scenario: Validate calendar navigation
    Given I open the flight search page
    When I open the calendar picker and navigate to future months
    Then future months should be accessible and past months should be disabled

  Scenario: Validate clear button in calendar picker
    Given I open the flight search page
    When I select a date in the calendar picker and click the "Clear" button
    Then the selected date should be cleared and the field should be blank