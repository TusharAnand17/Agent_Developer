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

    @Given("valid one-way search criteria is entered")
    public void validOneWaySearchCriteriaIsEntered() {
        flightSearchPage.enterValidOneWaySearchCriteria();
    }

    @Given("invalid search criteria is entered")
    public void invalidSearchCriteriaIsEntered() {
        flightSearchPage.enterInvalidSearchCriteria();
    }

    @When("the user clicks the \"Search\" button")
    public void theUserClicksTheSearchButton() {
        flightSearchPage.clickSearchButton();
    }

    @Then("results are displayed in a structured list format")
    public void resultsAreDisplayedInAStructuredListFormat() {
        flightSearchPage.verifyResultsInStructuredListFormat();
    }

    @Then("each flight result includes airline, flight number, departure city, arrival city, times, duration, and price")
    public void eachFlightResultIncludesDetails() {
        flightSearchPage.verifyFlightDetailsInResults();
    }

    @Then("flights are sorted by departure time in ascending order")
    public void flightsAreSortedByDepartureTimeInAscendingOrder() {
        flightSearchPage.verifyFlightsSortedByDepartureTime();
    }

    @Then("results are split into \"Departure Flights\" and \"Return Flights\" sections")
    public void resultsAreSplitIntoSections() {
        flightSearchPage.verifyRoundTripResultsSplitIntoSections();
    }

    @Then("a message is displayed: \"No flights available for selected criteria.\"")
    public void aMessageIsDisplayedNoFlightsAvailable() {
        flightSearchPage.verifyNoFlightsAvailableMessage();
    }

    @Then("results are displayed for one-way trip only")
    public void resultsAreDisplayedForOneWayTripOnly() {
        flightSearchPage.verifyResultsForOneWayTrip();
    }

    @Then("results are displayed for the specified number of passengers")
    public void resultsAreDisplayedForTheSpecifiedNumberOfPassengers() {
        flightSearchPage.verifyResultsForSpecifiedPassengers();
    }

    @Then("results are displayed for the selected travel class")
    public void resultsAreDisplayedForTheSelectedTravelClass() {
        flightSearchPage.verifyResultsForSelectedTravelClass();
    }

    @Then("results are displayed for the swapped cities")
    public void resultsAreDisplayedForTheSwappedCities() {
        flightSearchPage.verifyResultsForSwappedCities();
    }

    @Then("an error message is displayed: \"Invalid date format. Please use dd-mm-yyyy.\"")
    public void anErrorMessageIsDisplayedInvalidDateFormat() {
        flightSearchPage.verifyInvalidDateFormatErrorMessage();
    }

    @Then("an error message is displayed: \"Departure date cannot be in the past.\"")
    public void anErrorMessageIsDisplayedDepartureDateCannotBeInThePast() {
        flightSearchPage.verifyPastDateErrorMessage();
    }

    @Then("results are displayed for 9 passengers")
    public void resultsAreDisplayedFor9Passengers() {
        flightSearchPage.verifyResultsForMaximumPassengers();
    }

    @Then("results are displayed for 1 passenger")
    public void resultsAreDisplayedFor1Passenger() {
        flightSearchPage.verifyResultsForMinimumPassengers();
    }

    @Then("an error message is displayed: \"Please enter between 1 and 9 passengers.\"")
    public void anErrorMessageIsDisplayedPassengerLimitExceeded() {
        flightSearchPage.verifyPassengerLimitErrorMessage();
    }
}