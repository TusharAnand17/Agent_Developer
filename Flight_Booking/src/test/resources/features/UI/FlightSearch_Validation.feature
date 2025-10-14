Feature: Flight Search Validation

  Scenario: Verify structured list format for results
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "2", Class "Economy"
    Then results should be displayed in a structured list format

  Scenario: Verify flight details in results
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "2", Class "Economy"
    Then each flight should include airline, flight number, departure city, arrival city, departure/arrival times, duration, and price

  Scenario: Verify sorting by departure time
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "2", Class "Economy"
    Then flights should be sorted by departure time in ascending order

  Scenario: Verify round-trip results split
    Given valid round-trip search criteria is entered
    When a round-trip flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Return Date "20-12-2023", Passengers "2"
    Then results should be split into Departure Flights and Return Flights

  Scenario: Verify message for no flights available
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "Tokyo", Date "01-01-2023", Passengers "1", Class "Economy"
    Then a message "No flights available for selected criteria." should be displayed

  Scenario: Verify results for one-way search
    Given valid one-way search criteria is entered
    When a one-way flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "1", Class "Economy"
    Then results should be displayed in a structured list format

  Scenario: Verify results for round-trip search
    Given valid round-trip search criteria is entered
    When a round-trip flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Return Date "20-12-2023", Passengers "2"
    Then results should be split into Departure Flights and Return Flights

  Scenario: Verify sorting for round-trip results
    Given valid round-trip search criteria is entered
    When a round-trip flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Return Date "20-12-2023", Passengers "2"
    Then Departure Flights and Return Flights should be sorted by departure time in ascending order

  Scenario: Verify structured list for round-trip
    Given valid round-trip search criteria is entered
    When a round-trip flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Return Date "20-12-2023", Passengers "2"
    Then results should be displayed in a structured list format

  Scenario: Verify error handling for invalid data
    Given invalid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "0", Class "Economy"
    Then an error message should be displayed for invalid data

  Scenario: Verify UI updates for no flights
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "Tokyo", Date "01-01-2023", Passengers "1", Class "Economy"
    Then the UI should update to display a message "No flights available for selected criteria."

  Scenario: Verify flight details format
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "2", Class "Economy"
    Then flight details should be displayed in the correct format

  Scenario: Verify sorting for one-way results
    Given valid one-way search criteria is entered
    When a one-way flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "1", Class "Economy"
    Then flights should be sorted by departure time in ascending order

  Scenario: Verify message for invalid criteria
    Given invalid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "10", Class "Economy"
    Then an error message should be displayed for invalid criteria

  Scenario: Verify results for maximum passengers
    Given valid search criteria is entered
    When a flight search is performed with Departure "New York", Destination "London", Date "15-12-2023", Passengers "9", Class "Economy"
    Then results should be displayed in a structured list format