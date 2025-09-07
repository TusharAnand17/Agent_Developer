  Scenario: Verify default values for all fields
    And the "Passengers" field should default to 1

  Scenario: Validate mandatory "From" field
    Then an error message "Please select a departure city." should be displayed

  Scenario: Validate mandatory "To" field
    Then an error message "Please select a destination city." should be displayed

  Scenario: Validate "From" and "To" cannot be the same
    Then an error message "Departure and destination cannot be the same." should be displayed

  Scenario: Validate mandatory "Departure Date" field
    Then an error message "Please select a departure date." should be displayed

  Scenario: Validate past dates in "Departure Date"
    Then past dates should be disabled and cannot be selected

  Scenario: Validate numeric input for "Passengers"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate boundary value for "Passengers"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate upper boundary for "Passengers"
    Then an error message "Please enter between 1 and 9 passengers." should be displayed

  Scenario: Validate valid "Passengers" input

  Scenario: Validate "Travel Class" dropdown
    Then the options "Economy", "Business", and "First" should be displayed

  Scenario: Validate "One Way" checkbox functionality
    Then the "Return Date" field should be hidden

  Scenario: Validate "Return Date" reappears
    Then the "Return Date" field should reappear

  Scenario: Validate "Search" button disabled
    Then the "Search" button should be disabled

  Scenario: Validate "Search" button enabled
    Then the "Search" button should be enabled

  Scenario: Validate search results display
    Then the results page should display available flights sorted by departure time

  Scenario: Validate no flights available message
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Validate manual date entry format
    Then an error message "Please select a valid date." should be displayed

  Scenario: Validate calendar navigation

  Scenario: Validate clear button in calendar picker
    Then the selected date should be cleared and the field should be blank