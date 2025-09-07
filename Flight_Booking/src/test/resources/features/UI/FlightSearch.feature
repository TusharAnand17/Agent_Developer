Feature: Flight Search Functionality

  Scenario: Verify results are displayed in list format
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 2023-12-15
    Then Results are displayed in a structured list format

  Scenario: Verify flight details are displayed
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 2023-12-15
    Then Each flight result includes airline, flight number, departure city, arrival city, times, duration, and price

  Scenario: Verify flights are sorted by departure time
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 2023-12-15
    Then Flights are sorted in ascending order of departure time

  Scenario: Verify round-trip results are split
    Given User is on the flight search page
    When User performs a round-trip flight search with Departure City: NYC, Arrival City: LAX, Departure Date: 2023-12-15, Return Date: 2023-12-20
    Then Results are split into Departure Flights and Return Flights sections

  Scenario: Verify message for no flights available
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 2023-12-25
    Then Message displayed: "No flights available for selected criteria."

  Scenario: Verify search with invalid departure city
    Given User is on the flight search page
    When User performs a flight search with Departure City: XYZ, Arrival City: LAX, Date: 2023-12-15
    Then Error message displayed: "Invalid departure city."

  Scenario: Verify search with invalid arrival city
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: XYZ, Date: 2023-12-15
    Then Error message displayed: "Invalid arrival city."

  Scenario: Verify search with past date
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 2022-12-15
    Then Error message displayed: "Date cannot be in the past."

  Scenario: Verify search with missing mandatory fields
    Given User is on the flight search page
    When User performs a flight search with missing mandatory fields (e.g., no departure city)
    Then Error message displayed: "Please fill in all mandatory fields."

  Scenario: Verify search with special characters
    Given User is on the flight search page
    When User performs a flight search with Departure City: @NYC, Arrival City: LAX, Date: 2023-12-15
    Then Error message displayed: "Invalid characters in departure city."

  Scenario: Verify search with long input in fields
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYCNYC, Arrival City: LAX, Date: 2023-12-15
    Then Error message displayed: "Input exceeds maximum allowed length."

  Scenario: Verify search with valid round-trip criteria
    Given User is on the flight search page
    When User performs a round-trip flight search with Departure City: NYC, Arrival City: LAX, Departure Date: 2023-12-15, Return Date: 2023-12-20
    Then Results are displayed for both departure and return flights

  Scenario: Verify search with invalid date format
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: LAX, Date: 15-12-2023
    Then Error message displayed: "Invalid date format."

  Scenario: Verify search with valid one-way criteria
    Given User is on the flight search page
    When User performs a one-way flight search with Departure City: NYC, Arrival City: LAX, Date: 2023-12-15
    Then Results are displayed for departure flights only

  Scenario: Verify search with duplicate cities
    Given User is on the flight search page
    When User performs a flight search with Departure City: NYC, Arrival City: NYC, Date: 2023-12-15
    Then Error message displayed: "Departure and arrival cities cannot be the same."