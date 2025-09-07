Feature: Search Button and Results
  Verify the functionality of the "Search" button and search results.

  Scenario: Validate "Search" button disabled
    Given the flight search page is open
    When I leave mandatory fields blank
    Then the "Search" button should be disabled

  Scenario: Validate "Search" button enabled
    Given the flight search page is open
    When I fill all mandatory fields with valid data
    Then the "Search" button should be enabled

  Scenario: Validate search results display
    Given the flight search page is open
    When I fill all fields with valid data and click "Search"
    Then the results page should display available flights sorted by departure time

  Scenario: Validate no flights available message
    Given the flight search page is open
    When I fill all fields with valid data that yield no results and click "Search"
    Then a message "No flights available for selected criteria." should be displayed