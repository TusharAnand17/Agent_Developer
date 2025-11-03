package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pageobjects.FlightSearchPage;

public class FlightSearch_ValidationStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("valid search criteria is entered")
    public void validSearchCriteriaIsEntered() {
        flightSearchPage.enterValidSearchCriteria();
    }

    @Given("valid round-trip search criteria is entered")
    public void validRoundTripSearchCriteriaIsEntered() {
        flightSearchPage.enterValidRoundTripSearchCriteria();
    }

    @Given("invalid search criteria is entered")
    public void invalidSearchCriteriaIsEntered() {
        flightSearchPage.enterInvalidSearchCriteria();
    }

    @When("a flight search is performed with Departure {string}, Destination {string}, Date {string}, Passengers {string}, Class {string}")
    public void flightSearchIsPerformed(String departure, String destination, String date, String passengers, String flightClass) {
        flightSearchPage.performFlightSearch(departure, destination, date, passengers, flightClass);
    }

    @When("a round-trip flight search is performed with Departure {string}, Destination {string}, Date {string}, Return Date {string}, Passengers {string}")
    public void roundTripFlightSearchIsPerformed(String departure, String destination, String date, String returnDate, String passengers) {
        flightSearchPage.performRoundTripFlightSearch(departure, destination, date, returnDate, passengers);
    }

    @When("a one-way flight search is performed with Departure {string}, Destination {string}, Date {string}, Passengers {string}, Class {string}")
    public void oneWayFlightSearchIsPerformed(String departure, String destination, String date, String passengers, String flightClass) {
        flightSearchPage.performOneWayFlightSearch(departure, destination, date, passengers, flightClass);
    }

    @Then("results should be displayed in a structured list format")
    public void resultsShouldBeDisplayedInStructuredListFormat() {
        flightSearchPage.verifyResultsInStructuredListFormat();
    }

    @Then("each flight should include airline, flight number, departure city, arrival city, departure/arrival times, duration, and price")
    public void eachFlightShouldIncludeDetails() {
        flightSearchPage.verifyFlightDetailsInResults();
    }

    @Then("flights should be sorted by departure time in ascending order")
    public void flightsShouldBeSortedByDepartureTime() {
        flightSearchPage.verifySortingByDepartureTime();
    }

    @Then("results should be split into Departure Flights and Return Flights")
    public void resultsShouldBeSplitIntoDepartureAndReturnFlights() {
        flightSearchPage.verifyRoundTripResultsSplit();
    }

    @Then("a message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        flightSearchPage.verifyMessageDisplayed(message);
    }

    @Then("Departure Flights and Return Flights should be sorted by departure time in ascending order")
    public void departureAndReturnFlightsShouldBeSortedByDepartureTime() {
        flightSearchPage.verifySortingForRoundTripResults();
    }

    @Then("an error message should be displayed for invalid data")
    public void errorMessageShouldBeDisplayedForInvalidData() {
        flightSearchPage.verifyErrorMessageForInvalidData();
    }

    @Then("the UI should update to display a message {string}")
    public void uiShouldUpdateToDisplayMessage(String message) {
        flightSearchPage.verifyUIUpdatesForNoFlights(message);
    }

    @Then("flight details should be displayed in the correct format")
    public void flightDetailsShouldBeDisplayedInCorrectFormat() {
        flightSearchPage.verifyFlightDetailsFormat();
    }

    @Then("an error message should be displayed for invalid criteria")
    public void errorMessageShouldBeDisplayedForInvalidCriteria() {
        flightSearchPage.verifyErrorMessageForInvalidCriteria();
    }
}