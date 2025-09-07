package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.openqa.selenium.WebDriver;

public class FlightSearchValidationStepDefs {

    private WebDriver driver;
    private FlightSearchValidationPage flightSearchValidationPage;

    public FlightSearchValidationStepDefs(WebDriver driver) {
        this.driver = driver;
        this.flightSearchValidationPage = new FlightSearchValidationPage(driver);
    }

    @Given("User is on the flight search page")
    public void userIsOnTheFlightSearchPage() {
        flightSearchValidationPage.navigateToFlightSearchPage();
    }

    @When("User performs a flight search with Departure City: {string}, Arrival City: {string}, Date: {string}")
    public void userPerformsAFlightSearch(String departureCity, String arrivalCity, String date) {
        flightSearchValidationPage.performFlightSearch(departureCity, arrivalCity, date);
    }

    @When("User performs a round-trip flight search with Departure City: {string}, Arrival City: {string}, Departure Date: {string}, Return Date: {string}")
    public void userPerformsARoundTripFlightSearch(String departureCity, String arrivalCity, String departureDate, String returnDate) {
        flightSearchValidationPage.performRoundTripFlightSearch(departureCity, arrivalCity, departureDate, returnDate);
    }

    @When("User performs a flight search with missing mandatory fields \(e.g., no departure city\)")
    public void userPerformsAFlightSearchWithMissingMandatoryFields() {
        flightSearchValidationPage.performSearchWithMissingMandatoryFields();
    }

    @Then("Results are displayed in a structured list format")
    public void resultsAreDisplayedInAStructuredListFormat() {
        flightSearchValidationPage.verifyResultsDisplayedInListFormat();
    }

    @Then("Each flight result includes airline, flight number, departure city, arrival city, times, duration, and price")
    public void eachFlightResultIncludesDetails() {
        flightSearchValidationPage.verifyFlightDetailsDisplayed();
    }

    @Then("Flights are sorted in ascending order of departure time")
    public void flightsAreSortedByDepartureTime() {
        flightSearchValidationPage.verifyFlightsSortedByDepartureTime();
    }

    @Then("Results are split into Departure Flights and Return Flights sections")
    public void resultsAreSplitIntoSections() {
        flightSearchValidationPage.verifyRoundTripResultsSplit();
    }

    @Then("Message displayed: \"No flights available for selected criteria.\"")
    public void messageDisplayedNoFlightsAvailable() {
        flightSearchValidationPage.verifyNoFlightsAvailableMessage();
    }

    @Then("Error message displayed: \"Invalid departure city.\"")
    public void errorMessageDisplayedInvalidDepartureCity() {
        flightSearchValidationPage.verifyInvalidDepartureCityMessage();
    }

    @Then("Error message displayed: \"Invalid arrival city.\"")
    public void errorMessageDisplayedInvalidArrivalCity() {
        flightSearchValidationPage.verifyInvalidArrivalCityMessage();
    }

    @Then("Error message displayed: \"Date cannot be in the past.\"")
    public void errorMessageDisplayedDateCannotBeInThePast() {
        flightSearchValidationPage.verifyDateCannotBeInThePastMessage();
    }

    @Then("Error message displayed: \"Please fill in all mandatory fields.\"")
    public void errorMessageDisplayedPleaseFillInAllMandatoryFields() {
        flightSearchValidationPage.verifyMandatoryFieldsErrorMessage();
    }

    @Then("Error message displayed: \"Invalid characters in departure city.\"")
    public void errorMessageDisplayedInvalidCharactersInDepartureCity() {
        flightSearchValidationPage.verifyInvalidCharactersInDepartureCityMessage();
    }

    @Then("Error message displayed: \"Input exceeds maximum allowed length.\"")
    public void errorMessageDisplayedInputExceedsMaximumLength() {
        flightSearchValidationPage.verifyInputExceedsMaximumLengthMessage();
    }

    @Then("Results are displayed for both departure and return flights")
    public void resultsAreDisplayedForBothFlights() {
        flightSearchValidationPage.verifyResultsForBothFlights();
    }

    @Then("Error message displayed: \"Invalid date format.\"")
    public void errorMessageDisplayedInvalidDateFormat() {
        flightSearchValidationPage.verifyInvalidDateFormatMessage();
    }

    @Then("Results are displayed for departure flights only")
    public void resultsAreDisplayedForDepartureFlightsOnly() {
        flightSearchValidationPage.verifyResultsForDepartureFlightsOnly();
    }

    @Then("Error message displayed: \"Departure and arrival cities cannot be the same.\"")
    public void errorMessageDisplayedDuplicateCities() {
        flightSearchValidationPage.verifyDuplicateCitiesErrorMessage();
    }
}