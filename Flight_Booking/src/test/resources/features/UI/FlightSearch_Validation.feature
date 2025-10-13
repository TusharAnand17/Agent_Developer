Feature: Flight Search Validation

  Scenario: Verify results are displayed in a structured list
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed in a structured list format

  Scenario: Verify flight details in results
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then each flight result includes airline, flight number, departure city, arrival city, times, duration, and price

  Scenario: Verify results sorted by departure time
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then flights are sorted by departure time in ascending order

  Scenario: Verify round trip results are split into sections
    Given valid round-trip search criteria is entered
    When the user clicks the "Search" button
    Then results are split into "Departure Flights" and "Return Flights" sections

  Scenario: Verify message when no flights are available
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then a message is displayed: "No flights available for selected criteria."

  Scenario: Verify results for one-way trip
    Given valid one-way search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for one-way trip only

  Scenario: Verify results for multiple passengers
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for the specified number of passengers

  Scenario: Verify results for different travel classes
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for the selected travel class

  Scenario: Verify results when departure and destination cities are swapped
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for the swapped cities

  Scenario: Verify error handling for invalid date format
    Given invalid search criteria is entered
    When the user clicks the "Search" button
    Then an error message is displayed: "Invalid date format. Please use dd-mm-yyyy."

  Scenario: Verify error handling for past dates
    Given invalid search criteria is entered
    When the user clicks the "Search" button
    Then an error message is displayed: "Departure date cannot be in the past."

  Scenario: Verify results for edge case of maximum passengers
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for 9 passengers

  Scenario: Verify results for edge case of minimum passengers
    Given valid search criteria is entered
    When the user clicks the "Search" button
    Then results are displayed for 1 passenger

  Scenario: Verify error handling for passengers exceeding limit
    Given invalid search criteria is entered
    When the user clicks the "Search" button
    Then an error message is displayed: "Please enter between 1 and 9 passengers."

  Scenario: Verify error handling for zero passengers
    Given invalid search criteria is entered
    When the user clicks the "Search" button
    Then an error message is displayed: "Please enter between 1 and 9 passengers."