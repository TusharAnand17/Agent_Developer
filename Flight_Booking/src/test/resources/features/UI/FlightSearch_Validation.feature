Feature: Flight Search Validation

  Scenario: Verify airline codes/names accuracy
    Given Backend database with airline codes/names available
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then Airline codes/names displayed in results match backend data

  Scenario: Verify date/time format consistency
    Given Backend database with flight schedules available
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then Dates and times in results follow dd-mm-yyyy HH:MM format

  Scenario: Verify flight duration calculation
    Given Backend database with flight schedules available
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then Duration displayed matches the difference between departure and arrival times

  Scenario: Verify price format in USD
    Given Backend database with flight pricing available
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then Prices displayed include $ symbol and are in USD

  Scenario: Verify airline code mismatch
    Given Backend database with incorrect airline codes/names
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then Error or inconsistency if airline codes/names do not match backend data

  Scenario: Verify invalid date/time format
    Given Backend database with incorrect date/time format
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then Error or inconsistency if dates/times are not in dd-mm-yyyy HH:MM format

  Scenario: Verify incorrect flight duration
    Given Backend database with incorrect flight duration
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then Error or inconsistency if flight duration does not match the difference between departure/arrival

  Scenario: Verify incorrect price format
    Given Backend database with incorrect price format
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then Error or inconsistency if prices are not displayed in USD or missing $ symbol

  Scenario: Verify minimum flight duration
    Given Backend database with flights having minimum duration
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then Flight duration displayed matches the minimum possible duration

  Scenario: Verify maximum flight duration
    Given Backend database with flights having maximum duration
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then Flight duration displayed matches the maximum possible duration

  Scenario: Verify minimum price
    Given Backend database with flights having minimum price
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then Price displayed matches the minimum possible price in USD

  Scenario: Verify maximum price
    Given Backend database with flights having maximum price
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then Price displayed matches the maximum possible price in USD

  Scenario: Verify airline code/name display
    Given Backend database with airline codes/names available
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then Airline codes/names are displayed correctly in the UI

  Scenario: Verify date/time display format
    Given Backend database with flight schedules available
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then Dates/times are displayed correctly in the UI

  Scenario: Verify price display format
    Given Backend database with flight pricing available
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then Prices are displayed correctly in the UI

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