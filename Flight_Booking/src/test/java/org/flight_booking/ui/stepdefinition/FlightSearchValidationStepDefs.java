package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.openqa.selenium.WebDriver;

public class FlightSearchValidationStepDefs {

    private WebDriver driver;
    private FlightSearchValidationPage flightSearchPage;

    public FlightSearchValidationStepDefs(WebDriver driver) {
        this.driver = driver;
        this.flightSearchPage = new FlightSearchValidationPage(driver);
    }

    @Given("backend data for airline codes is available and up-to-date")
    public void backendDataForAirlineCodes() {
        flightSearchPage.verifyBackendDataForAirlineCodes();
    }

    @When("I search for flights")
    public void searchForFlights() {
        flightSearchPage.searchForFlights();
    }

    @Then("airline codes displayed match backend data")
    public void verifyAirlineCodesMatch() {
        flightSearchPage.verifyAirlineCodesMatch();
    }

    @Then("airline names displayed match backend data")
    public void verifyAirlineNamesMatch() {
        flightSearchPage.verifyAirlineNamesMatch();
    }

    @Then("dates are displayed in dd-mm-yyyy format")
    public void verifyDateFormat() {
        flightSearchPage.verifyDateFormat();
    }

    @Then("times are displayed in HH:MM format")
    public void verifyTimeFormat() {
        flightSearchPage.verifyTimeFormat();
    }

    @Then("duration matches the difference between departure and arrival times")
    public void verifyDurationCalculation() {
        flightSearchPage.verifyDurationCalculation();
    }

    @Then("prices are displayed in USD with $ symbol")
    public void verifyPriceFormat() {
        flightSearchPage.verifyPriceFormat();
    }

    @When("I search for flights with invalid airline code")
    public void searchWithInvalidAirlineCode() {
        flightSearchPage.searchWithInvalidAirlineCode();
    }

    @Then("the system does not display flights with invalid airline codes")
    public void verifyInvalidAirlineCodeHandling() {
        flightSearchPage.verifyInvalidAirlineCodeHandling();
    }

    @Then("the system does not display dates in incorrect formats")
    public void verifyInvalidDateFormatHandling() {
        flightSearchPage.verifyInvalidDateFormatHandling();
    }

    @Then("the system does not display times in incorrect formats")
    public void verifyInvalidTimeFormatHandling() {
        flightSearchPage.verifyInvalidTimeFormatHandling();
    }

    @Then("the system does not display prices without the $ symbol")
    public void verifyMissingPriceSymbol() {
        flightSearchPage.verifyMissingPriceSymbol();
    }

    @Then("duration is displayed as 0 for flights with the same departure and arrival times")
    public void verifyMinimumDuration() {
        flightSearchPage.verifyMinimumDuration();
    }

    @Then("duration is displayed correctly for long-haul flights")
    public void verifyMaximumDuration() {
        flightSearchPage.verifyMaximumDuration();
    }

    @Then("dates and times are displayed in a user-friendly and readable format")
    public void verifyReadabilityOfDateTimeFormat() {
        flightSearchPage.verifyReadabilityOfDateTimeFormat();
    }

    @Then("flight data is displayed within acceptable response time")
    public void verifyResponseTime() {
        flightSearchPage.verifyResponseTime();
    }

    @When("I perform multiple searches for the same criteria")
    public void performMultipleSearches() {
        flightSearchPage.performMultipleSearches();
    }

    @Then("flight data remains consistent across multiple searches")
    public void verifyConsistencyAcrossSearches() {
        flightSearchPage.verifyConsistencyAcrossSearches();
    }

    @When("I perform a new search with different criteria")
    public void performNewSearch() {
        flightSearchPage.performNewSearch();
    }

    @Then("flight data is refreshed and updated based on the new search criteria")
    public void verifyDataRefreshOnNewSearch() {
        flightSearchPage.verifyDataRefreshOnNewSearch();
    }

    @Then("duplicate flights are not displayed in the search results")
    public void verifyHandlingOfDuplicateFlights() {
        flightSearchPage.verifyHandlingOfDuplicateFlights();
    }

    @Given("backend data is temporarily unavailable")
    public void backendDataUnavailable() {
        flightSearchPage.simulateBackendDataUnavailable();
    }

    @Then("the system displays an appropriate error message if backend data is missing")
    public void verifyErrorMessageForMissingBackendData() {
        flightSearchPage.verifyErrorMessageForMissingBackendData();
    }

    @When("I search for flights and sort by price")
    public void sortByPrice() {
        flightSearchPage.sortByPrice();
    }

    @Then("flights are sorted correctly by price in ascending or descending order")
    public void verifyPriceSorting() {
        flightSearchPage.verifyPriceSorting();
    }

    @When("I search for flights and sort by airline name")
    public void sortByAirlineName() {
        flightSearchPage.sortByAirlineName();
    }

    @Then("flights are sorted correctly by airline name in alphabetical order")
    public void verifyAirlineNameSorting() {
        flightSearchPage.verifyAirlineNameSorting();
    }
}