package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pageobjects.FlightSearchPage;

public class FlightSearch_TestCasesStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("valid search criteria is entered")
    public void validSearchCriteriaIsEntered() {
        flightSearchPage.enterValidSearchCriteria();
    }

    @When("the user searches for flights")
    public void theUserSearchesForFlights() {
        flightSearchPage.searchForFlights();
    }

    @Then("airline codes/names displayed in results match backend data")
    public void airlineCodesNamesDisplayedInResultsMatchBackendData() {
        flightSearchPage.verifyAirlineCodesAndNames();
    }

    @Then("dates/times displayed in results follow dd-mm-yyyy HH:MM format")
    public void datesTimesDisplayedInResultsFollowDdMmYyyyHhMmFormat() {
        flightSearchPage.verifyDateTimeFormat();
    }

    @Then("duration displayed in results matches the difference between departure and arrival times")
    public void durationDisplayedInResultsMatchesTheDifferenceBetweenDepartureAndArrivalTimes() {
        flightSearchPage.verifyFlightDurationCalculation();
    }

    @Then("prices displayed in results are in USD with $ symbol")
    public void pricesDisplayedInResultsAreInUsdWithSymbol() {
        flightSearchPage.verifyPriceFormat();
    }

    @Then("error or no results if airline codes/names do not match backend data")
    public void errorOrNoResultsIfAirlineCodesNamesDoNotMatchBackendData() {
        flightSearchPage.verifyInvalidAirlineCodesOrNames();
    }

    @Then("error or no results if dates/times do not follow dd-mm-yyyy HH:MM format")
    public void errorOrNoResultsIfDatesTimesDoNotFollowDdMmYyyyHhMmFormat() {
        flightSearchPage.verifyInvalidDateTimeFormat();
    }

    @Then("error or no results if flight duration does not match the difference between departure and arrival times")
    public void errorOrNoResultsIfFlightDurationDoesNotMatchTheDifferenceBetweenDepartureAndArrivalTimes() {
        flightSearchPage.verifyIncorrectFlightDurationCalculation();
    }

    @Then("error or no results if prices are not displayed in USD with $ symbol")
    public void errorOrNoResultsIfPricesAreNotDisplayedInUsdWithSymbol() {
        flightSearchPage.verifyIncorrectPriceFormat();
    }

    @Then("duration displayed in results matches the minimum possible flight duration")
    public void durationDisplayedInResultsMatchesTheMinimumPossibleFlightDuration() {
        flightSearchPage.verifyMinimumFlightDuration();
    }

    @Then("duration displayed in results matches the maximum possible flight duration")
    public void durationDisplayedInResultsMatchesTheMaximumPossibleFlightDuration() {
        flightSearchPage.verifyMaximumFlightDuration();
    }

    @Then("prices displayed in results match the minimum possible price")
    public void pricesDisplayedInResultsMatchTheMinimumPossiblePrice() {
        flightSearchPage.verifyMinimumPriceValue();
    }

    @Then("prices displayed in results match the maximum possible price")
    public void pricesDisplayedInResultsMatchTheMaximumPossiblePrice() {
        flightSearchPage.verifyMaximumPriceValue();
    }

    @Then("results displayed in the UI match backend data")
    public void resultsDisplayedInTheUiMatchBackendData() {
        flightSearchPage.verifyBackendDataConsistency();
    }

    @Given("backend data is unavailable")
    public void backendDataIsUnavailable() {
        flightSearchPage.simulateBackendDataFailure();
    }

    @Then("error message displayed in UI indicating backend data failure")
    public void errorMessageDisplayedInUiIndicatingBackendDataFailure() {
        flightSearchPage.verifyBackendDataFailureMessage();
    }
}