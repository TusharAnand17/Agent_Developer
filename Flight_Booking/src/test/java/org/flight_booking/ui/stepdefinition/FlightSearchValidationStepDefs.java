package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;

/**
 * Step Definitions for Flight Search Validation feature.
 */
public class FlightSearchValidationStepDefs {

    private WebDriver driver;
    private FlightSearchValidationPage flightSearchPage;

    @Given("the search form is functional and connected to the database")
    public void theSearchFormIsFunctionalAndConnectedToTheDatabase() {
        driver = new ChromeDriver();
        driver.get("http://flight-booking-app.com");
        flightSearchPage = new FlightSearchValidationPage(driver);
    }

    @When("the user performs a flight search with valid criteria:")
    public void theUserPerformsAFlightSearchWithValidCriteria(Map<String, String> criteria) {
        flightSearchPage.performFlightSearch(criteria.get("Origin"), criteria.get("Destination"), criteria.get("Date"), criteria.get("Passengers"));
    }

    @Then("results are displayed in a structured list format")
    public void resultsAreDisplayedInAStructuredListFormat() {
        if (!flightSearchPage.areResultsDisplayed()) {
            throw new AssertionError("Flight results are not displayed in a structured list format.");
        }
    }

    @Then("an error message is displayed: {string}")
    public void anErrorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = flightSearchPage.getErrorMessage();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected error message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    @Then("results are split into Departure Flights and Return Flights sections")
    public void resultsAreSplitIntoDepartureFlightsAndReturnFlightsSections() {
        if (!flightSearchPage.areRoundTripSectionsDisplayed()) {
            throw new AssertionError("Departure and Return Flights sections are not displayed.");
        }
    }

    @Then("results are displayed successfully")
    public void resultsAreDisplayedSuccessfully() {
        if (!flightSearchPage.areResultsDisplayed()) {
            throw new AssertionError("Flight results are not displayed successfully.");
        }
    }

    @Then("results are displayed without duplicates")
    public void resultsAreDisplayedWithoutDuplicates() {
        // Implement logic to verify no duplicate results
    }

    @Then("results are displayed within acceptable response time \(e.g., < 3 seconds\)")
    public void resultsAreDisplayedWithinAcceptableResponseTime() {
        // Implement logic to measure response time
    }

    @Then("results are displayed with proper UI alignment")
    public void resultsAreDisplayedWithProperUIAlignment() {
        // Implement logic to verify UI alignment
    }

    @Then("the error is logged in the system logs")
    public void theErrorIsLoggedInTheSystemLogs() {
        // Implement logic to verify error logging
    }
}