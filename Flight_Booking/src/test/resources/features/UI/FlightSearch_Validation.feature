Feature: Flight Search Validation

  Scenario: Verify airline codes match backend data
    Given backend data for airline codes is available and up-to-date
    When I search for flights
    Then airline codes displayed match backend data

  Scenario: Verify airline names match backend data
    Given backend data for airline names is available and up-to-date
    When I search for flights
    Then airline names displayed match backend data

  Scenario: Verify date format is correct
    Given no prerequisites
    When I search for flights
    Then dates are displayed in dd-mm-yyyy format

  Scenario: Verify time format is correct
    Given no prerequisites
    When I search for flights
    Then times are displayed in HH:MM format

  Scenario: Verify duration calculation
    Given no prerequisites
    When I search for flights
    Then duration matches the difference between departure and arrival times

  Scenario: Verify price format is correct
    Given no prerequisites
    When I search for flights
    Then prices are displayed in USD with $ symbol

  Scenario: Verify invalid airline code handling
    Given backend data for airline codes is available and up-to-date
    When I search for flights with invalid airline code
    Then the system does not display flights with invalid airline codes

  Scenario: Verify invalid date format handling
    Given no prerequisites
    When I search for flights
    Then the system does not display dates in incorrect formats

  Scenario: Verify invalid time format handling
    Given no prerequisites
    When I search for flights
    Then the system does not display times in incorrect formats

  Scenario: Verify missing price symbol
    Given no prerequisites
    When I search for flights
    Then the system does not display prices without the $ symbol

  Scenario: Verify minimum duration
    Given no prerequisites
    When I search for flights
    Then duration is displayed as 0 for flights with the same departure and arrival times

  Scenario: Verify maximum duration
    Given no prerequisites
    When I search for flights
    Then duration is displayed correctly for long-haul flights

  Scenario: Verify readability of date/time format
    Given no prerequisites
    When I search for flights
    Then dates and times are displayed in a user-friendly and readable format

  Scenario: Verify response time for flight data
    Given no prerequisites
    When I search for flights
    Then flight data is displayed within acceptable response time

  Scenario: Verify consistency across multiple searches
    Given no prerequisites
    When I perform multiple searches for the same criteria
    Then flight data remains consistent across multiple searches

  Scenario: Verify data refresh on new search
    Given no prerequisites
    When I perform a new search with different criteria
    Then flight data is refreshed and updated based on the new search criteria

  Scenario: Verify handling of duplicate flights
    Given no prerequisites
    When I search for flights
    Then duplicate flights are not displayed in the search results

  Scenario: Verify handling of missing backend data
    Given backend data is temporarily unavailable
    When I search for flights
    Then the system displays an appropriate error message if backend data is missing

  Scenario: Verify price sorting
    Given no prerequisites
    When I search for flights and sort by price
    Then flights are sorted correctly by price in ascending or descending order

  Scenario: Verify airline name sorting
    Given no prerequisites
    When I search for flights and sort by airline name
    Then flights are sorted correctly by airline name in alphabetical order