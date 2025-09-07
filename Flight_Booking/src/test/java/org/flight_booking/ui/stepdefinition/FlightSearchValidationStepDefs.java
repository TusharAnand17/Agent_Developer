package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.openqa.selenium.WebDriver;

public class FlightSearchValidationStepDefs {

    private final FlightSearchValidationPage flightSearchValidationPage;

    public FlightSearchValidationStepDefs(WebDriver driver) {
        this.flightSearchValidationPage = new FlightSearchValidationPage(driver);
    }

    @Given("backend data for airline codes is available and up-to-date")
    public void backendDataForAirlineCodesIsAvailable() {
        flightSearchValidationPage.verifyBackendDataForAirlineCodes();
    }

    @When("I search for flights")
    public void iSearchForFlights() {
        flightSearchValidationPage.searchForFlights();
    }

    @Then("airline codes displayed match backend data")
    public void airlineCodesDisplayedMatchBackendData() {
        flightSearchValidationPage.verifyAirlineCodesMatchBackendData();
    }

    @Then("airline names displayed match backend data")
    public void airlineNamesDisplayedMatchBackendData() {
        flightSearchValidationPage.verifyAirlineNamesMatchBackendData();
    }

    @Then("dates are displayed in dd-mm-yyyy format")
    public void datesAreDisplayedInCorrectFormat() {
        flightSearchValidationPage.verifyDateFormat();
    }

    @Then("times are displayed in HH:MM format")
    public void timesAreDisplayedInCorrectFormat() {
        flightSearchValidationPage.verifyTimeFormat();
    }

    @Then("duration matches the difference between departure and arrival times")
    public void durationMatchesDifferenceBetweenTimes() {
        flightSearchValidationPage.verifyDurationCalculation();
    }

    @Then("prices are displayed in USD with $ symbol")
    public void pricesAreDisplayedInCorrectFormat() {
        flightSearchValidationPage.verifyPriceFormat();
    }

    @When("I search for flights with invalid airline code")
    public void iSearchForFlightsWithInvalidAirlineCode() {
        flightSearchValidationPage.searchForFlightsWithInvalidAirlineCode();
    }

    @Then("the system does not display flights with invalid airline codes")
    public void systemDoesNotDisplayFlightsWithInvalidAirlineCodes() {
        flightSearchValidationPage.verifyInvalidAirlineCodeHandling();
    }

    @Then("the system does not display dates in incorrect formats")
    public void systemDoesNotDisplayDatesInIncorrectFormats() {
        flightSearchValidationPage.verifyInvalidDateFormatHandling();
    }

    @Then("the system does not display times in incorrect formats")
    public void systemDoesNotDisplayTimesInIncorrectFormats() {
        flightSearchValidationPage.verifyInvalidTimeFormatHandling();
    }

    @Then("the system does not display prices without the $ symbol")
    public void systemDoesNotDisplayPricesWithoutSymbol() {
        flightSearchValidationPage.verifyMissingPriceSymbol();
    }

    @Then("duration is displayed as 0 for flights with the same departure and arrival times")
    public void durationIsDisplayedAsZeroForSameTimes() {
        flightSearchValidationPage.verifyMinimumDuration();
    }

    @Then("duration is displayed correctly for long-haul flights")
    public void durationIsDisplayedCorrectlyForLongHaulFlights() {
        flightSearchValidationPage.verifyMaximumDuration();
    }

    @Then("dates and times are displayed in a user-friendly and readable format")
    public void datesAndTimesAreDisplayedInReadableFormat() {
        flightSearchValidationPage.verifyReadabilityOfDateTimeFormat();
    }

    @Then("flight data is displayed within acceptable response time")
    public void flightDataIsDisplayedWithinResponseTime() {
        flightSearchValidationPage.verifyResponseTime();
    }

    @When("I perform multiple searches for the same criteria")
    public void iPerformMultipleSearchesForSameCriteria() {
        flightSearchValidationPage.performMultipleSearches();
    }

    @Then("flight data remains consistent across multiple searches")
    public void flightDataRemainsConsistentAcrossSearches() {
        flightSearchValidationPage.verifyConsistencyAcrossSearches();
    }

    @When("I perform a new search with different criteria")
    public void iPerformNewSearchWithDifferentCriteria() {
        flightSearchValidationPage.performNewSearch();
    }

    @Then("flight data is refreshed and updated based on the new search criteria")
    public void flightDataIsRefreshedAndUpdated() {
        flightSearchValidationPage.verifyDataRefreshOnNewSearch();
    }

    @Then("duplicate flights are not displayed in the search results")
    public void duplicateFlightsAreNotDisplayed() {
        flightSearchValidationPage.verifyHandlingOfDuplicateFlights();
    }

    @Given("backend data is temporarily unavailable")
    public void backendDataIsUnavailable() {
        flightSearchValidationPage.simulateBackendDataUnavailability();
    }

    @Then("the system displays an appropriate error message if backend data is missing")
    public void systemDisplaysErrorMessageForMissingBackendData() {
        flightSearchValidationPage.verifyHandlingOfMissingBackendData();
    }

    @When("I search for flights and sort by price")
    public void iSearchForFlightsAndSortByPrice() {
        flightSearchValidationPage.sortByPrice();
    }

    @Then("flights are sorted correctly by price in ascending or descending order")
    public void flightsAreSortedByPrice() {
        flightSearchValidationPage.verifyPriceSorting();
    }

    @When("I search for flights and sort by airline name")
    public void iSearchForFlightsAndSortByAirlineName() {
        flightSearchValidationPage.sortByAirlineName();
    }

    @Then("flights are sorted correctly by airline name in alphabetical order")
    public void flightsAreSortedByAirlineName() {
        flightSearchValidationPage.verifyAirlineNameSorting();
    }
}