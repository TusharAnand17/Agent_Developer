package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightSearchValidationStepDefs {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchValidationStepDefs.class);
    private final FlightSearchValidationPage flightSearchValidationPage = new FlightSearchValidationPage();

    @Given("^backend data for airline codes is available and up-to-date$")
    public void backendDataForAirlineCodesAvailable() {
        logger.info("Ensuring backend data for airline codes is available and up-to-date.");
        flightSearchValidationPage.ensureBackendDataForAirlineCodes();
    }

    @When("^I search for flights$")
    public void searchForFlights() {
        logger.info("Searching for flights.");
        flightSearchValidationPage.searchForFlights();
    }

    @Then("^airline codes displayed match backend data$")
    public void verifyAirlineCodesMatchBackendData() {
        logger.info("Verifying airline codes displayed match backend data.");
        flightSearchValidationPage.verifyAirlineCodesMatchBackendData();
    }

    // Additional step definitions for other scenarios will follow the same pattern.
}