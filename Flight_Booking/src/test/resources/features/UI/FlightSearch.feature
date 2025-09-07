Feature: Flight Search Functionality

  # Scenario 1: Verify default values for all fields
  Scenario: Verify default values for all fields
    Given the flight search page is open
    Then the "From" dropdown should default to "Select City"
    And the "To" dropdown should default to "Select City"
    And the "Passengers" field should default to 1
    And the "Travel Class" dropdown should default to "Economy"

  # Scenario 2: Validate mandatory "From" field
  Scenario: Validate mandatory "From" field
    Given the flight search page is open
    When I leave the "From" field blank and click "Search"
    Then an error message "Please select a departure city." should be displayed

  # Scenario 3: Validate mandatory "To" field
  Scenario: Validate mandatory "To" field
    Given the flight search page is open
    When I leave the "To" field blank and click "Search"
    Then an error message "Please select a destination city." should be displayed

  # Scenario 4: Validate "From" and "To" cannot be the same
  Scenario: Validate "From" and "To" cannot be the same
    Given the flight search page is open
    When I select "New York" for both "From" and "To" fields and click "Search"
    Then an error message "Departure and destination cannot be the same." should be displayed

  # Scenario 5: Validate mandatory "Departure Date" field
  Scenario: Validate mandatory "Departure Date" field
    Given the flight search page is open
    When I leave the "Departure Date" field blank and click "Search"
    Then an error message "Please select a departure date." should be displayed

  # Scenario 6: Validate past dates in "Departure Date"
  Scenario: Validate past dates in "Departure Date"
    Given the flight search page is open
    When I select a past date in the "Departure Date" field
    Then past dates should be disabled and cannot be selected

  # Scenario 7: Validate numeric input for "Passengers"
  Scenario: Validate numeric input for "Passengers"
    Given the flight search page is open
    When I enter "abc" in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  # Scenario 8: Validate boundary value for "Passengers"
  Scenario: Validate boundary value for "Passengers"
    Given the flight search page is open
    When I enter 0 in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  # Scenario 9: Validate upper boundary for "Passengers"
  Scenario: Validate upper boundary for "Passengers"
    Given the flight search page is open
    When I enter 10 in the "Passengers" field and click "Search"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  # Scenario 10: Validate valid "Passengers" input
  Scenario: Validate valid "Passengers" input
    Given the flight search page is open
    When I enter 5 in the "Passengers" field and click "Search"
    Then no error message should be displayed and the search should proceed

  # Scenario 11: Validate "Travel Class" dropdown
  Scenario: Validate "Travel Class" dropdown
    Given the flight search page is open
    When I open the "Travel Class" dropdown
    Then the options "Economy", "Business", and "First" should be displayed

  # Scenario 12: Validate "One Way" checkbox functionality
  Scenario: Validate "One Way" checkbox functionality
    Given the flight search page is open
    When I check the "One Way" checkbox
    Then the "Return Date" field should be hidden

  # Scenario 13: Validate "Return Date" reappears
  Scenario: Validate "Return Date" reappears
    Given the flight search page is open
    When I uncheck the "One Way" checkbox
    Then the "Return Date" field should reappear

  # Scenario 14: Validate "Search" button disabled
  Scenario: Validate "Search" button disabled
    Given the flight search page is open
    When I leave the "From", "To", and "Departure Date" fields blank
    Then the "Search" button should be disabled

  # Scenario 15: Validate "Search" button enabled
  Scenario: Validate "Search" button enabled
    Given the flight search page is open
    When I fill "From" with "New York", "To" with "London", and "Departure Date" with a valid date
    Then the "Search" button should be enabled

  # Scenario 16: Validate search results display
  Scenario: Validate search results display
    Given the flight search page is open
    When I fill "From" with "New York", "To" with "London", "Departure Date" with a valid date, "Passengers" with 2, and "Class" with "Economy"
    And I click "Search"
    Then the results page should display available flights sorted by departure time

  # Scenario 17: Validate no flights available message
  Scenario: Validate no flights available message
    Given the flight search page is open
    When I fill "From" with "New York", "To" with "Tokyo", "Departure Date" with a valid date, "Passengers" with 1, and "Class" with "Business"
    And I click "Search"
    Then a message "No flights available for selected criteria." should be displayed

  # Scenario 18: Validate manual date entry format
  Scenario: Validate manual date entry format
    Given the flight search page is open
    When I manually enter "31-02-2023" in the "Departure Date" field and click "Search"
    Then an error message "Please select a valid date." should be displayed

  # Scenario 19: Validate calendar navigation
  Scenario: Validate calendar navigation
    Given the flight search page is open
    When I open the calendar picker and navigate to future months
    Then future months should be accessible and past months should be disabled

  # Scenario 20: Validate clear button in calendar picker
  Scenario: Validate clear button in calendar picker
    Given the flight search page is open
    When I select a date in the calendar picker and click the "Clear" button
    Then the selected date should be cleared and the field should be blank
