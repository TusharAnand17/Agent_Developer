package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pageobjects.FlightSearchPage;

public class FlightBooking_ValidationStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("the backend database contains airline codes/names")
    public void theBackendDatabaseContainsAirlineCodesNames() {
        flightSearchPage.verifyBackendAirlineCodesNames();
    }

    @Given("the backend database contains flight schedules")
    public void theBackendDatabaseContainsFlightSchedules() {
        flightSearchPage.verifyBackendFlightSchedules();
    }

    @Given("the backend database contains flight pricing")
    public void theBackendDatabaseContainsFlightPricing() {
        flightSearchPage.verifyBackendFlightPricing();
    }

    @Given("the backend database contains incorrect airline codes/names")
    public void theBackendDatabaseContainsIncorrectAirlineCodesNames() {
        flightSearchPage.verifyBackendIncorrectAirlineCodesNames();
    }

    @Given("the backend database contains incorrect date/time format")
    public void theBackendDatabaseContainsIncorrectDateTimeFormat() {
        flightSearchPage.verifyBackendIncorrectDateTimeFormat();
    }

    @Given("the backend database contains incorrect flight duration")
    public void theBackendDatabaseContainsIncorrectFlightDuration() {
        flightSearchPage.verifyBackendIncorrectFlightDuration();
    }

    @Given("the backend database contains incorrect price format")
    public void theBackendDatabaseContainsIncorrectPriceFormat() {
        flightSearchPage.verifyBackendIncorrectPriceFormat();
    }

    @Given("the backend database contains flights with minimum duration")
    public void theBackendDatabaseContainsFlightsWithMinimumDuration() {
        flightSearchPage.verifyBackendMinimumDurationFlights();
    }

    @Given("the backend database contains flights with maximum duration")
    public void theBackendDatabaseContainsFlightsWithMaximumDuration() {
        flightSearchPage.verifyBackendMaximumDurationFlights();
    }

    @Given("the backend database contains flights with minimum price")
    public void theBackendDatabaseContainsFlightsWithMinimumPrice() {
        flightSearchPage.verifyBackendMinimumPriceFlights();
    }

    @Given("the backend database contains flights with maximum price")
    public void theBackendDatabaseContainsFlightsWithMaximumPrice() {
        flightSearchPage.verifyBackendMaximumPriceFlights();
    }

    @When("I search for a flight with Departure: {string}, Destination: {string}, Date: {string}, Passengers: {int}, Class: {string}")
    public void iSearchForAFlight(String departure, String destination, String date, int passengers, String flightClass) {
        flightSearchPage.searchFlight(departure, destination, date, passengers, flightClass);
    }

    @Then("the airline codes/names displayed in the results should match the backend data")
    public void theAirlineCodesNamesDisplayedShouldMatchBackendData() {
        flightSearchPage.validateAirlineCodesNames();
    }

    @Then("the dates and times in the results should follow the dd-mm-yyyy HH:MM format")
    public void theDatesAndTimesShouldFollowFormat() {
        flightSearchPage.validateDateTimeFormat();
    }

    @Then("the flight duration displayed should match the difference between departure and arrival times")
    public void theFlightDurationShouldMatchDifference() {
        flightSearchPage.validateFlightDuration();
    }

    @Then("the prices displayed should include the $ symbol and be in USD")
    public void thePricesShouldIncludeDollarSymbolAndBeInUSD() {
        flightSearchPage.validatePriceFormat();
    }

    @Then("an error or inconsistency should be displayed if the airline codes/names do not match the backend data")
    public void anErrorShouldBeDisplayedForAirlineCodeMismatch() {
        flightSearchPage.validateAirlineCodeMismatchError();
    }

    @Then("an error or inconsistency should be displayed if the dates/times are not in the dd-mm-yyyy HH:MM format")
    public void anErrorShouldBeDisplayedForInvalidDateTimeFormat() {
        flightSearchPage.validateDateTimeFormatError();
    }

    @Then("an error or inconsistency should be displayed if the flight duration does not match the difference between departure and arrival times")
    public void anErrorShouldBeDisplayedForIncorrectFlightDuration() {
        flightSearchPage.validateFlightDurationError();
    }

    @Then("an error or inconsistency should be displayed if the prices are not displayed in USD or missing the $ symbol")
    public void anErrorShouldBeDisplayedForIncorrectPriceFormat() {
        flightSearchPage.validatePriceFormatError();
    }

    @Then("the flight duration displayed should match the minimum possible duration")
    public void theFlightDurationShouldMatchMinimumDuration() {
        flightSearchPage.validateMinimumFlightDuration();
    }

    @Then("the flight duration displayed should match the maximum possible duration")
    public void theFlightDurationShouldMatchMaximumDuration() {
        flightSearchPage.validateMaximumFlightDuration();
    }

    @Then("the price displayed should match the minimum possible price in USD")
    public void thePriceShouldMatchMinimumPriceInUSD() {
        flightSearchPage.validateMinimumPrice();
    }

    @Then("the price displayed should match the maximum possible price in USD")
    public void thePriceShouldMatchMaximumPriceInUSD() {
        flightSearchPage.validateMaximumPrice();
    }

    @Then("the airline codes/names should be displayed correctly in the UI")
    public void theAirlineCodesNamesShouldBeDisplayedCorrectly() {
        flightSearchPage.validateAirlineCodeDisplay();
    }

    @Then("the dates and times should be displayed correctly in the UI")
    public void theDatesAndTimesShouldBeDisplayedCorrectly() {
        flightSearchPage.validateDateTimeDisplay();
    }

    @Then("the prices should be displayed correctly in the UI")
    public void thePricesShouldBeDisplayedCorrectly() {
        flightSearchPage.validatePriceDisplay();
    }
}