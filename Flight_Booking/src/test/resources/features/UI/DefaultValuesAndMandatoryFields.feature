Feature: Default Values and Mandatory Fields
  Verify default values and mandatory field validations on the flight search page.

  Scenario: Verify default values for all fields
    Given the flight search page is open
    Then the "From" and "To" dropdowns should default to "Select City"
    And the "Passengers" field should default to 1
    And the "Travel Class" field should default to "Economy"

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