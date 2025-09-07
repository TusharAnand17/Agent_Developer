Feature: Round-Trip Flight Search

  Scenario: Validate mandatory fields for round-trip search
    Given the flight search page is open
    When I leave the "From" field blank and click "Search"
    Then an error message "Please select a departure city." should be displayed
    When I leave the "To" field blank and click "Search"
    Then an error message "Please select a destination city." should be displayed
    When I leave the "Departure Date" field blank and click "Search"
    Then an error message "Please select a departure date." should be displayed
    When I leave the "Return Date" field blank and click "Search"
    Then an error message "Please select a return date." should be displayed

  Scenario: Validate return date after departure date
    Given the flight search page is open
    When I select "15-12-2023" as the "Departure Date"
    And I select "10-12-2023" as the "Return Date" and click "Search"
    Then an error message "Return date must be after departure date." should be displayed

  Scenario: Validate round-trip search results
    Given the flight search page is open
    When I select "New York" as the "From" city
    And I select "Los Angeles" as the "To" city
    And I select "15-12-2023" as the "Departure Date"
    And I select "20-12-2023" as the "Return Date"
    And I select "2" as the number of passengers
    And I select "Economy" as the travel class
    And I click "Search"
    Then the results page should display available departure flights sorted by departure time
    And the results page should display available return flights sorted by departure time

  Scenario: Validate no flights available message for round-trip
    Given the flight search page is open
    When I select "New York" as the "From" city
    And I select "Los Angeles" as the "To" city
    And I select "15-12-2023" as the "Departure Date"
    And I select "20-12-2023" as the "Return Date"
    And I select "2" as the number of passengers
    And I select "Economy" as the travel class
    And I click "Search"
    Then a message "No flights available for selected criteria." should be displayed