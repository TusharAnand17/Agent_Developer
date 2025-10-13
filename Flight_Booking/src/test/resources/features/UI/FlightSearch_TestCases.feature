Feature: Flight Search Test Cases

  Scenario: Verify airline codes/names accuracy
    Given valid search criteria is entered
    When the user searches for flights
    Then airline codes/names displayed in results match backend data

  Scenario: Validate date/time format in results
    Given valid search criteria is entered
    When the user searches for flights
    Then dates/times displayed in results follow dd-mm-yyyy HH:MM format

  Scenario: Verify flight duration calculation
    Given valid search criteria is entered
    When the user searches for flights
    Then duration displayed in results matches the difference between departure and arrival times

  Scenario: Validate price format in results
    Given valid search criteria is entered
    When the user searches for flights
    Then prices displayed in results are in USD with $ symbol

  Scenario: Test invalid airline codes/names
    Given valid search criteria is entered
    When the user searches for flights
    Then error or no results if airline codes/names do not match backend data

  Scenario: Test invalid date/time format
    Given valid search criteria is entered
    When the user searches for flights
    Then error or no results if dates/times do not follow dd-mm-yyyy HH:MM format

  Scenario: Test incorrect flight duration calculation
    Given valid search criteria is entered
    When the user searches for flights
    Then error or no results if flight duration does not match the difference between departure and arrival times

  Scenario: Test incorrect price format
    Given valid search criteria is entered
    When the user searches for flights
    Then error or no results if prices are not displayed in USD with $ symbol

  Scenario: Test minimum duration value
    Given valid search criteria is entered
    When the user searches for flights
    Then duration displayed in results matches the minimum possible flight duration

  Scenario: Test maximum duration value
    Given valid search criteria is entered
    When the user searches for flights
    Then duration displayed in results matches the maximum possible flight duration

  Scenario: Test minimum price value
    Given valid search criteria is entered
    When the user searches for flights
    Then prices displayed in results match the minimum possible price

  Scenario: Test maximum price value
    Given valid search criteria is entered
    When the user searches for flights
    Then prices displayed in results match the maximum possible price

  Scenario: Verify date/time format in UI
    Given valid search criteria is entered
    When the user searches for flights
    Then dates/times displayed in results follow dd-mm-yyyy HH:MM format

  Scenario: Verify price format in UI
    Given valid search criteria is entered
    When the user searches for flights
    Then prices displayed in results are in USD with $ symbol

  Scenario: Validate backend data consistency
    Given valid search criteria is entered
    When the user searches for flights
    Then results displayed in the UI match backend data

  Scenario: Test backend data failure
    Given backend data is unavailable
    When the user searches for flights
    Then error message displayed in UI indicating backend data failure