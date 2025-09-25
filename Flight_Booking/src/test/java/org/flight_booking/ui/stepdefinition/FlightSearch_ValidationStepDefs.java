package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.page.FlightSearchPage;

public class FlightSearch_ValidationStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("the search form is functional and connected to the database")
    public void theSearchFormIsFunctionalAndConnectedToTheDatabase() {
        flightSearchPage.verifySearchFormConnection();
    }

    @When("the user performs a flight search with valid criteria:")
    public void theUserPerformsAFlightSearchWithValidCriteria(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("results are displayed in a structured list format")
    public void resultsAreDisplayedInAStructuredListFormat() {
        flightSearchPage.verifyResultsStructuredListFormat();
    }

    @Then("each flight includes airline, flight number, departure city, arrival city, times, duration, and price")
    public void eachFlightIncludesDetails() {
        flightSearchPage.verifyFlightDetails();
    }

    @Then("flights are sorted by departure time in ascending order")
    public void flightsAreSortedByDepartureTimeInAscendingOrder() {
        flightSearchPage.verifySortingByDepartureTime();
    }

    @When("the user performs a round trip flight search with valid criteria:")
    public void theUserPerformsARoundTripFlightSearchWithValidCriteria(DataTable table) {
        flightSearchPage.performRoundTripFlightSearch(table);
    }

    @Then("results are split into Departure Flights and Return Flights sections")
    public void resultsAreSplitIntoDepartureAndReturnFlightsSections() {
        flightSearchPage.verifyRoundTripResultsSeparation();
    }

    @When("the user performs a flight search with criteria that yield no results:")
    public void theUserPerformsAFlightSearchWithCriteriaThatYieldNoResults(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("a message is displayed: \"No flights available for selected criteria.\"")
    public void aMessageIsDisplayedNoFlightsAvailableForSelectedCriteria() {
        flightSearchPage.verifyNoFlightsMessage();
    }

    @Then("results are displayed in a clear, readable structured list format")
    public void resultsAreDisplayedInAClearReadableStructuredListFormat() {
        flightSearchPage.verifyResultsStructuredListFormat();
    }

    @When("the user performs a flight search with invalid criteria:")
    public void theUserPerformsAFlightSearchWithInvalidCriteria(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Invalid search criteria. Please check your inputs.\"")
    public void anErrorMessageIsDisplayedInvalidSearchCriteria() {
        flightSearchPage.verifyInvalidCriteriaErrorMessage();
    }

    @When("the user performs a flight search with empty criteria:")
    public void theUserPerformsAFlightSearchWithEmptyCriteria(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Please fill in all required fields.\"")
    public void anErrorMessageIsDisplayedPleaseFillInAllRequiredFields() {
        flightSearchPage.verifyEmptyCriteriaErrorMessage();
    }

    @When("the user performs a flight search with minimum passenger count:")
    public void theUserPerformsAFlightSearchWithMinimumPassengerCount(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("results are displayed successfully")
    public void resultsAreDisplayedSuccessfully() {
        flightSearchPage.verifyResultsDisplayedSuccessfully();
    }

    @When("the user performs a flight search with maximum passenger count:")
    public void theUserPerformsAFlightSearchWithMaximumPassengerCount(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @When("the user performs a flight search with passenger count exceeding max:")
    public void theUserPerformsAFlightSearchWithPassengerCountExceedingMax(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Maximum passenger count is 9.\"")
    public void anErrorMessageIsDisplayedMaximumPassengerCountIs9() {
        flightSearchPage.verifyMaxPassengerCountErrorMessage();
    }

    @When("the user performs a flight search with special characters in input fields:")
    public void theUserPerformsAFlightSearchWithSpecialCharactersInInputFields(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Invalid characters in input fields.\"")
    public void anErrorMessageIsDisplayedInvalidCharactersInInputFields() {
        flightSearchPage.verifySpecialCharactersErrorMessage();
    }

    @When("the user performs a flight search with numeric input in text fields:")
    public void theUserPerformsAFlightSearchWithNumericInputInTextFields(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Invalid input in text fields.\"")
    public void anErrorMessageIsDisplayedInvalidInputInTextFields() {
        flightSearchPage.verifyNumericInputErrorMessage();
    }

    @When("the user performs a flight search with criteria yielding duplicate results:")
    public void theUserPerformsAFlightSearchWithCriteriaYieldingDuplicateResults(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("results are displayed without duplicates")
    public void resultsAreDisplayedWithoutDuplicates() {
        flightSearchPage.verifyNoDuplicateResults();
    }

    @When("the user performs a flight search with mixed case inputs:")
    public void theUserPerformsAFlightSearchWithMixedCaseInputs(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @When("the user performs a flight search with a past date:")
    public void theUserPerformsAFlightSearchWithAPastDate(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("an error message is displayed: \"Date cannot be in the past.\"")
    public void anErrorMessageIsDisplayedDateCannotBeInThePast() {
        flightSearchPage.verifyPastDateErrorMessage();
    }

    @When("the user performs a flight search with a valid future date:")
    public void theUserPerformsAFlightSearchWithAValidFutureDate(DataTable table) {
        flightSearchPage.performFlightSearch(table);
    }

    @Then("results are displayed within acceptable response time \(e.g., < 3 seconds\)")
    public void resultsAreDisplayedWithinAcceptableResponseTime() {
        flightSearchPage.verifyResponseTime();
    }

    @Then("results are displayed with proper UI alignment")
    public void resultsAreDisplayedWithProperUIAlignment() {
        flightSearchPage.verifyUIAlignment();
    }

    @Then("the error is logged in the system logs")
    public void theErrorIsLoggedInTheSystemLogs() {
        flightSearchPage.verifyErrorLogging();
    }
}