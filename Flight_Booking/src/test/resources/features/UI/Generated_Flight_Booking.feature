Feature: Flight Booking Scenarios

  Scenario: Verify airline codes/names accuracy
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-11-2023", Passengers "1", Class "Economy"
    Then Airline codes/names displayed in results match backend data

  Scenario: Verify date/time format consistency
    Given valid search criteria is entered
    When a flight search is performed with Departure "Tokyo", Destination "Paris", Date "20-11-2023", Passengers "2", Class "Business"
    Then Dates and times in results follow dd-mm-yyyy HH:MM format

  Scenario: Verify flight duration calculation
    Given valid search criteria is entered
    When a flight search is performed with Departure "Sydney", Destination "Mumbai", Date "25-11-2023", Passengers "3", Class "Economy"
    Then Duration displayed matches the difference between departure and arrival times

  Scenario: Verify price format in USD
    Given valid search criteria is entered
    When a flight search is performed with Departure "Dubai", Destination "Singapore", Date "30-11-2023", Passengers "4", Class "First"
    Then Prices displayed include $ symbol and are in USD

  Scenario: Verify airline code mismatch
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-11-2023", Passengers "1", Class "Economy"
    Then Error or inconsistency if airline codes/names do not match backend data

  Scenario: Verify invalid date/time format
    Given valid search criteria is entered
    When a flight search is performed with Departure "Tokyo", Destination "Paris", Date "20-11-2023", Passengers "2", Class "Business"
    Then Error or inconsistency if dates/times are not in dd-mm-yyyy HH:MM format

  Scenario: Verify incorrect flight duration
    Given valid search criteria is entered
    When a flight search is performed with Departure "Sydney", Destination "Mumbai", Date "25-11-2023", Passengers "3", Class "Economy"
    Then Error or inconsistency if flight duration does not match the difference between departure/arrival

  Scenario: Verify incorrect price format
    Given valid search criteria is entered
    When a flight search is performed with Departure "Dubai", Destination "Singapore", Date "30-11-2023", Passengers "4", Class "First"
    Then Error or inconsistency if prices are not displayed in USD or missing $ symbol

  Scenario: Verify minimum flight duration
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-11-2023", Passengers "1", Class "Economy"
    Then Flight duration displayed matches the minimum possible duration

  Scenario: Verify maximum flight duration
    Given valid search criteria is entered
    When a flight search is performed with Departure "Tokyo", Destination "Paris", Date "20-11-2023", Passengers "2", Class "Business"
    Then Flight duration displayed matches the maximum possible duration

  Scenario: Verify minimum price
    Given valid search criteria is entered
    When a flight search is performed with Departure "Sydney", Destination "Mumbai", Date "25-11-2023", Passengers "3", Class "Economy"
    Then Price displayed matches the minimum possible price in USD

  Scenario: Verify maximum price
    Given valid search criteria is entered
    When a flight search is performed with Departure "Dubai", Destination "Singapore", Date "30-11-2023", Passengers "4", Class "First"
    Then Price displayed matches the maximum possible price in USD

  Scenario: Verify airline code/name display
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-11-2023", Passengers "1", Class "Economy"
    Then Airline codes/names are displayed correctly in the UI

  Scenario: Verify date/time display format
    Given valid search criteria is entered
    When a flight search is performed with Departure "Tokyo", Destination "Paris", Date "20-11-2023", Passengers "2", Class "Business"
    Then Dates/times are displayed correctly in the UI

  Scenario: Verify price display format
    Given valid search criteria is entered
    When a flight search is performed with Departure "Dubai", Destination "Singapore", Date "30-11-2023", Passengers "4", Class "First"
    Then Prices are displayed correctly in the UI