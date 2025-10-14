Feature: Flight Booking Validation

  Scenario: Verify airline codes/names accuracy
    Given the backend database contains airline codes/names
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then the airline codes/names displayed in the results should match the backend data

  Scenario: Verify date/time format consistency
    Given the backend database contains flight schedules
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then the dates and times in the results should follow the dd-mm-yyyy HH:MM format

  Scenario: Verify flight duration calculation
    Given the backend database contains flight schedules
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then the flight duration displayed should match the difference between departure and arrival times

  Scenario: Verify price format in USD
    Given the backend database contains flight pricing
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then the prices displayed should include the $ symbol and be in USD

  Scenario: Verify airline code mismatch
    Given the backend database contains incorrect airline codes/names
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then an error or inconsistency should be displayed if the airline codes/names do not match the backend data

  Scenario: Verify invalid date/time format
    Given the backend database contains incorrect date/time format
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then an error or inconsistency should be displayed if the dates/times are not in the dd-mm-yyyy HH:MM format

  Scenario: Verify incorrect flight duration
    Given the backend database contains incorrect flight duration
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then an error or inconsistency should be displayed if the flight duration does not match the difference between departure and arrival times

  Scenario: Verify incorrect price format
    Given the backend database contains incorrect price format
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then an error or inconsistency should be displayed if the prices are not displayed in USD or missing the $ symbol

  Scenario: Verify minimum flight duration
    Given the backend database contains flights with minimum duration
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then the flight duration displayed should match the minimum possible duration

  Scenario: Verify maximum flight duration
    Given the backend database contains flights with maximum duration
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then the flight duration displayed should match the maximum possible duration

  Scenario: Verify minimum price
    Given the backend database contains flights with minimum price
    When I search for a flight with Departure: Sydney, Destination: Mumbai, Date: 25-11-2023, Passengers: 3, Class: Economy
    Then the price displayed should match the minimum possible price in USD

  Scenario: Verify maximum price
    Given the backend database contains flights with maximum price
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then the price displayed should match the maximum possible price in USD

  Scenario: Verify airline code/name display
    Given the backend database contains airline codes/names
    When I search for a flight with Departure: New York, Destination: London, Date: 15-11-2023, Passengers: 1, Class: Economy
    Then the airline codes/names should be displayed correctly in the UI

  Scenario: Verify date/time display format
    Given the backend database contains flight schedules
    When I search for a flight with Departure: Tokyo, Destination: Paris, Date: 20-11-2023, Passengers: 2, Class: Business
    Then the dates and times should be displayed correctly in the UI

  Scenario: Verify price display format
    Given the backend database contains flight pricing
    When I search for a flight with Departure: Dubai, Destination: Singapore, Date: 30-11-2023, Passengers: 4, Class: First
    Then the prices should be displayed correctly in the UI