package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * Step definitions for the Flight Search Functionality feature.
 */
public class FlightSearchFunctionalityStepDefs {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchFunctionalityStepDefs.class);
    private final BasePage basePage = new BasePage();

    @Given("the flight search page is open")
    public void theFlightSearchPageIsOpen() {
        try {
            logger.info("Opening the flight search page.");
            basePage.openPage("/flight-search");
        } catch (Exception e) {
            logger.error("Failed to open the flight search page.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"From\" dropdown should default to \"Select City\"")
    public void theFromDropdownShouldDefaultToSelectCity() {
        try {
            logger.info("Verifying default value of 'From' dropdown.");
            basePage.verifyDropdownDefaultValue("fromDropdown", "Select City");
        } catch (Exception e) {
            logger.error("Failed to verify default value of 'From' dropdown.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"To\" dropdown should default to \"Select City\"")
    public void theToDropdownShouldDefaultToSelectCity() {
        try {
            logger.info("Verifying default value of 'To' dropdown.");
            basePage.verifyDropdownDefaultValue("toDropdown", "Select City");
        } catch (Exception e) {
            logger.error("Failed to verify default value of 'To' dropdown.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"Passengers\" field should default to 1")
    public void thePassengersFieldShouldDefaultTo1() {
        try {
            logger.info("Verifying default value of 'Passengers' field.");
            basePage.verifyFieldDefaultValue("passengersField", "1");
        } catch (Exception e) {
            logger.error("Failed to verify default value of 'Passengers' field.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"Travel Class\" dropdown should default to \"Economy\"")
    public void theTravelClassDropdownShouldDefaultToEconomy() {
        try {
            logger.info("Verifying default value of 'Travel Class' dropdown.");
            basePage.verifyDropdownDefaultValue("travelClassDropdown", "Economy");
        } catch (Exception e) {
            logger.error("Failed to verify default value of 'Travel Class' dropdown.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I leave the \"From\" field blank and click \"Search\"")
    public void iLeaveTheFromFieldBlankAndClickSearch() {
        try {
            logger.info("Leaving 'From' field blank and clicking 'Search'.");
            basePage.clearField("fromDropdown");
            basePage.clickButton("searchButton");
        } catch (Exception e) {
            logger.error("Failed to leave 'From' field blank and click 'Search'.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("I should see an error message \"Please select a departure city.\"")
    public void iShouldSeeAnErrorMessagePleaseSelectADepartureCity() {
        try {
            logger.info("Verifying error message for blank 'From' field.");
            basePage.verifyErrorMessage("Please select a departure city.");
        } catch (Exception e) {
            logger.error("Failed to verify error message for blank 'From' field.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I leave the \"To\" field blank and click \"Search\"")
    public void iLeaveTheToFieldBlankAndClickSearch() {
        try {
            logger.info("Leaving 'To' field blank and clicking 'Search'.");
            basePage.clearField("toDropdown");
            basePage.clickButton("searchButton");
        } catch (Exception e) {
            logger.error("Failed to leave 'To' field blank and click 'Search'.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("I should see an error message \"Please select a destination city.\"")
    public void iShouldSeeAnErrorMessagePleaseSelectADestinationCity() {
        try {
            logger.info("Verifying error message for blank 'To' field.");
            basePage.verifyErrorMessage("Please select a destination city.");
        } catch (Exception e) {
            logger.error("Failed to verify error message for blank 'To' field.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I select \"New York\" for both \"From\" and \"To\" fields and click \"Search\"")
    public void iSelectNewYorkForBothFromAndToFieldsAndClickSearch() {
        try {
            logger.info("Selecting 'New York' for both 'From' and 'To' fields and clicking 'Search'.");
            basePage.selectDropdownValue("fromDropdown", "New York");
            basePage.selectDropdownValue("toDropdown", "New York");
            basePage.clickButton("searchButton");
        } catch (Exception e) {
            logger.error("Failed to select 'New York' for both 'From' and 'To' fields and click 'Search'.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("I should see an error message \"Departure and destination cannot be the same.\"")
    public void iShouldSeeAnErrorMessageDepartureAndDestinationCannotBeTheSame() {
        try {
            logger.info("Verifying error message for same 'From' and 'To' fields.");
            basePage.verifyErrorMessage("Departure and destination cannot be the same.");
        } catch (Exception e) {
            logger.error("Failed to verify error message for same 'From' and 'To' fields.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I leave the \"Departure Date\" field blank and click \"Search\"")
    public void iLeaveTheDepartureDateFieldBlankAndClickSearch() {
        try {
            logger.info("Leaving 'Departure Date' field blank and clicking 'Search'.");
            basePage.clearField("departureDateField");
            basePage.clickButton("searchButton");
        } catch (Exception e) {
            logger.error("Failed to leave 'Departure Date' field blank and click 'Search'.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("I should see an error message \"Please select a departure date.\"")
    public void iShouldSeeAnErrorMessagePleaseSelectADepartureDate() {
        try {
            logger.info("Verifying error message for blank 'Departure Date' field.");
            basePage.verifyErrorMessage("Please select a departure date.");
        } catch (Exception e) {
            logger.error("Failed to verify error message for blank 'Departure Date' field.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I try to select a past date in the \"Departure Date\" field")
    public void iTryToSelectAPastDateInTheDepartureDateField() {
        try {
            logger.info("Attempting to select a past date in the 'Departure Date' field.");
            basePage.selectPastDate("departureDateField");
        } catch (Exception e) {
            logger.error("Failed to attempt selecting a past date in the 'Departure Date' field.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("past dates should be disabled and cannot be selected")
    public void pastDatesShouldBeDisabledAndCannotBeSelected() {
        try {
            logger.info("Verifying that past dates are disabled in the 'Departure Date' field.");
            basePage.verifyPastDatesDisabled("departureDateField");
        } catch (Exception e) {
            logger.error("Failed to verify that past dates are disabled in the 'Departure Date' field.", e);
            throw new RuntimeException(e);
        }
    }

    // Additional step definitions for remaining scenarios would follow the same pattern
}