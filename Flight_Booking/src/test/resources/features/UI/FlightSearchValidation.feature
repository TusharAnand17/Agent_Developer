Feature: Flight Search Validation

  Scenario: Verify default values for all fields
    Given the flight search page is open
    Then the default values should be set as follows:
      | Field          | Value          |
      | From           | Select City    |
      | To             | Select City    |
      | Passengers     | 1              |
      | Travel Class   | Economy        |

  Scenario: Validate mandatory 'From' field
    Given the flight search page is open
    When the user leaves the 'From' field blank and clicks 'Search'
    Then an error message should be displayed: "Please select a departure city."

  Scenario: Validate mandatory 'To' field
    Given the flight search page is open
    When the user leaves the 'To' field blank and clicks 'Search'
    Then an error message should be displayed: "Please select a destination city."

  Scenario: Validate 'From' and 'To' cannot be the same
    Given the flight search page is open
    When the user selects the same city for 'From' and 'To' fields and clicks 'Search'
    Then an error message should be displayed: "Departure and destination cannot be the same."

  Scenario: Validate mandatory 'Departure Date' field
    Given the flight search page is open
    When the user leaves the 'Departure Date' field blank and clicks 'Search'
    Then an error message should be displayed: "Please select a departure date."

  Scenario: Validate past dates disabled in calendar
    Given the flight search page is open
    When the user opens the calendar picker and tries selecting a past date
    Then past dates should be disabled and cannot be selected

  Scenario: Validate numeric input for 'Passengers'
    Given the flight search page is open
    When the user enters a non-numeric value in the 'Passengers' field and clicks 'Search'
    Then an error message should be displayed: "Please enter between 1 and 9 passengers."

  Scenario: Validate boundary value for 'Passengers'
    Given the flight search page is open
    When the user enters 0 in the 'Passengers' field and clicks 'Search'
    Then an error message should be displayed: "Please enter between 1 and 9 passengers."

  Scenario: Validate upper boundary for 'Passengers'
    Given the flight search page is open
    When the user enters 10 in the 'Passengers' field and clicks 'Search'
    Then an error message should be displayed: "Please enter between 1 and 9 passengers."

  Scenario: Validate valid 'Passengers' input
    Given the flight search page is open
    When the user enters 5 in the 'Passengers' field and clicks 'Search'
    Then the search should be successful and results should be displayed

  Scenario: Validate default 'Travel Class' selection
    Given the flight search page is open
    Then the 'Travel Class' should be set to 'Economy' by default

  Scenario: Validate 'One Way' checkbox functionality
    Given the flight search page is open
    When the user checks the 'One Way' checkbox
    Then the 'Return Date' field should be hidden

  Scenario: Validate 'Return Date' reappears
    Given the flight search page is open
    When the user unchecks the 'One Way' checkbox
    Then the 'Return Date' field should reappear

  Scenario: Validate search button disabled initially
    Given the flight search page is open
    Then the 'Search' button should be disabled

  Scenario: Validate search button enabled after input
    Given the flight search page is open
    When the user fills all mandatory fields with valid data:
      | From           | New York       |
      | To             | London         |
      | Departure Date | 15-12-2023     |
    Then the 'Search' button should be enabled

  Scenario: Validate error for invalid date format
    Given the flight search page is open
    When the user enters an invalid date format in the 'Departure Date' field and clicks 'Search'
    Then an error message should be displayed: "Please select a valid departure date."

  Scenario: Validate no flights available message
    Given the flight search page is open
    When the user enters valid data but no flights exist for the criteria:
      | From           | New York       |
      | To             | Tokyo          |
      | Departure Date | 15-12-2023     |
    Then a message should be displayed: "No flights available for selected criteria."

  Scenario: Validate results sorting by departure time
    Given the flight search page is open
    When the user performs a search with valid data:
      | From           | New York       |
      | To             | London         |
      | Departure Date | 15-12-2023     |
    Then the results should be sorted by departure time

  Scenario: Validate clear button in calendar picker
    Given the flight search page is open
    When the user opens the calendar picker and clicks 'Clear'
    Then the 'Departure Date' field should be cleared

  Scenario: Validate today highlight in calendar picker
    Given the flight search page is open
    When the user opens the calendar picker
    Then today's date should be highlighted