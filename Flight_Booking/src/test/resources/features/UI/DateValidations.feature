Feature: Date Validations
  Verify date-related validations on the flight search page.

  Scenario: Validate past dates in "Departure Date"
    Given the flight search page is open
    When I select a past date in the "Departure Date" field
    Then past dates should be disabled and cannot be selected

  Scenario: Validate manual date entry format
    Given the flight search page is open
    When I manually enter an invalid date format "31-02-2023" in the "Departure Date" field and click "Search"
    Then an error message "Please select a valid date." should be displayed

  Scenario: Validate calendar navigation
    Given the flight search page is open
    When I open the calendar picker and navigate to future months
    Then future months should be accessible and past months should be disabled

  Scenario: Validate clear button in calendar picker
    Given the flight search page is open
    When I select a date in the calendar picker and click the "Clear" button
    Then the selected date should be cleared and the field should be blank