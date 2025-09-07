Feature: Passengers Field Validations
  Verify validations for the "Passengers" field on the flight search page.

  Scenario: Validate numeric input for "Passengers"
    Given the flight search page is open
    When I enter a non-numeric value "abc" in the "Passengers" field and click "Search"
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
    When I enter a valid number 5 in the "Passengers" field and click "Search"
    Then no error message should be displayed and the search should proceed