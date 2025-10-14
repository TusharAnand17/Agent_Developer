package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pageobjects.FlightSearchPage;

public class FlightBookingStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("valid search criteria is entered")
    public void validSearchCriteriaIsEntered() {
        flightSearchPage.enterValidSearchCriteria();
    }

    @When("a flight search is performed with Departure {string}, Destination {string}, Date {string}, Passengers {string}, Class {string}")
    public void aFlightSearchIsPerformed(String departure, String destination, String date, String passengers, String flightClass) {
        flightSearchPage.performFlightSearch(departure, destination, date, passengers, flightClass);
    }

    @Then("Airline codes/names displayed in results match backend data")
    public void airlineCodesNamesMatchBackendData() {
        flightSearchPage.verifyAirlineCodesNamesAccuracy();
    }

    @Then("Dates and times in results follow dd-mm-yyyy HH:MM format")
    public void datesAndTimesFollowFormat() {
        flightSearchPage.verifyDateTimeFormatConsistency();
    }

    @Then("Duration displayed matches the difference between departure and arrival times")
    public void durationMatchesDifference() {
        flightSearchPage.verifyFlightDurationCalculation();
    }

    @Then("Prices displayed include $ symbol and are in USD")
    public void pricesIncludeSymbolAndUSD() {
        flightSearchPage.verifyPriceFormatInUSD();
    }

    @Then("Error or inconsistency if airline codes/names do not match backend data")
    public void errorIfAirlineCodesNamesMismatch() {
        flightSearchPage.verifyAirlineCodeMismatch();
    }

    @Then("Error or inconsistency if dates/times are not in dd-mm-yyyy HH:MM format")
    public void errorIfDatesTimesInvalidFormat() {
        flightSearchPage.verifyInvalidDateTimeFormat();
    }

    @Then("Error or inconsistency if flight duration does not match the difference between departure/arrival")
    public void errorIfFlightDurationIncorrect() {
        flightSearchPage.verifyIncorrectFlightDuration();
    }

    @Then("Error or inconsistency if prices are not displayed in USD or missing $ symbol")
    public void errorIfPricesIncorrectFormat() {
        flightSearchPage.verifyIncorrectPriceFormat();
    }

    @Then("Flight duration displayed matches the minimum possible duration")
    public void flightDurationMatchesMinimum() {
        flightSearchPage.verifyMinimumFlightDuration();
    }

    @Then("Flight duration displayed matches the maximum possible duration")
    public void flightDurationMatchesMaximum() {
        flightSearchPage.verifyMaximumFlightDuration();
    }

    @Then("Price displayed matches the minimum possible price in USD")
    public void priceMatchesMinimum() {
        flightSearchPage.verifyMinimumPrice();
    }

    @Then("Price displayed matches the maximum possible price in USD")
    public void priceMatchesMaximum() {
        flightSearchPage.verifyMaximumPrice();
    }

    @Then("Airline codes/names are displayed correctly in the UI")
    public void airlineCodesNamesDisplayedCorrectly() {
        flightSearchPage.verifyAirlineCodeNameDisplay();
    }

    @Then("Dates/times are displayed correctly in the UI")
    public void datesTimesDisplayedCorrectly() {
        flightSearchPage.verifyDateTimeDisplayFormat();
    }

    @Then("Prices are displayed correctly in the UI")
    public void pricesDisplayedCorrectly() {
        flightSearchPage.verifyPriceDisplayFormat();
    }
}