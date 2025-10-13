package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pageobjects.FlightSearchPage;

public class FlightSearch_EnhancedStepDefs {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Given("valid search criteria is entered")
    public void validSearchCriteriaIsEntered() {
        flightSearchPage.enterValidSearchCriteria();
    }

    @Given("backend data is unavailable")
    public void backendDataIsUnavailable() {
        flightSearchPage.simulateBackendDataUnavailability();
    }

    @Given("invalid search criteria is entered")
    public void invalidSearchCriteriaIsEntered() {
        flightSearchPage.enterInvalidSearchCriteria();
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
    public void datesTimesDisplayedInResultsFollowFormat() {
        flightSearchPage.verifyDateTimeFormat();
    }

    @Then("duration displayed in results matches the difference between departure and arrival times")
    public void durationDisplayedInResultsMatchesDifference() {
        flightSearchPage.verifyFlightDurationCalculation();
    }

    @Then("prices displayed in results are in USD with $ symbol")
    public void pricesDisplayedInResultsAreInUSDWithSymbol() {
        flightSearchPage.verifyPriceFormat();
    }

    @Then("error or no results if airline codes/names do not match backend data")
    public void errorOrNoResultsIfAirlineCodesNamesDoNotMatchBackendData() {
        flightSearchPage.verifyInvalidAirlineCodesOrNames();
    }

    @Then("error or no results if dates/times do not follow dd-mm-yyyy HH:MM format")
    public void errorOrNoResultsIfDatesTimesDoNotFollowFormat() {
        flightSearchPage.verifyInvalidDateTimeFormat();
    }

    @Then("error or no results if flight duration does not match the difference between departure and arrival times")
    public void errorOrNoResultsIfFlightDurationDoesNotMatchDifference() {
        flightSearchPage.verifyIncorrectFlightDuration();
    }

    @Then("error or no results if prices are not displayed in USD with $ symbol")
    public void errorOrNoResultsIfPricesAreNotDisplayedInUSDWithSymbol() {
        flightSearchPage.verifyIncorrectPriceFormat();
    }

    @Then("duration displayed in results matches the minimum possible flight duration")
    public void durationDisplayedInResultsMatchesMinimumPossibleFlightDuration() {
        flightSearchPage.verifyMinimumFlightDuration();
    }

    @Then("duration displayed in results matches the maximum possible flight duration")
    public void durationDisplayedInResultsMatchesMaximumPossibleFlightDuration() {
        flightSearchPage.verifyMaximumFlightDuration();
    }

    @Then("prices displayed in results match the minimum possible price")
    public void pricesDisplayedInResultsMatchMinimumPossiblePrice() {
        flightSearchPage.verifyMinimumPrice();
    }

    @Then("prices displayed in results match the maximum possible price")
    public void pricesDisplayedInResultsMatchMaximumPossiblePrice() {
        flightSearchPage.verifyMaximumPrice();
    }

    @Then("results displayed in the UI match backend data")
    public void resultsDisplayedInTheUIMatchBackendData() {
        flightSearchPage.verifyBackendDataConsistency();
    }

    @Then("error message displayed in UI indicating backend data failure")
    public void errorMessageDisplayedInUIIndicatingBackendDataFailure() {
        flightSearchPage.verifyBackendDataFailureMessage();
    }

    @Then("results are displayed for 9 passengers")
    public void resultsAreDisplayedFor9Passengers() {
        flightSearchPage.verifyResultsForMaxPassengers();
    }

    @Then("results are displayed for 1 passenger")
    public void resultsAreDisplayedFor1Passenger() {
        flightSearchPage.verifyResultsForMinPassengers();
    }

    @Then("an error message is displayed: \"Please enter between 1 and 9 passengers.\"")
    public void anErrorMessageIsDisplayed() {
        flightSearchPage.verifyPassengerLimitErrorMessage();
    }
}