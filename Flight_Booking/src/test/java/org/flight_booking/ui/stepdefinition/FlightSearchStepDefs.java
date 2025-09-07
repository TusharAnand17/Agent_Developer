package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.flight_booking.ui.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class FlightSearchStepDefs {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchStepDefs.class);
    private final BasePage basePage = new BasePage();

    @Given("the flight search page is open")
    public void theFlightSearchPageIsOpen() {
        try {
            basePage.openPage("flightSearch");
            logger.info("Flight search page opened successfully.");
        } catch (Exception e) {
            logger.error("Error opening flight search page: ", e);
            throw e;
        }
    }

    @Then("the \"(.*)\" dropdown should default to \"(.*)\"")
    public void theDropdownShouldDefaultTo(String dropdown, String defaultValue) {
        try {
            basePage.verifyDropdownDefaultValue(dropdown, defaultValue);
            logger.info("Verified default value of {} dropdown is {}.", dropdown, defaultValue);
        } catch (Exception e) {
            logger.error("Error verifying default value for dropdown {}: ", dropdown, e);
            throw e;
        }
    }

    @Then("the \"(.*)\" field should default to (\d+)")
    public void theFieldShouldDefaultTo(String field, int defaultValue) {
        try {
            basePage.verifyFieldDefaultValue(field, defaultValue);
            logger.info("Verified default value of {} field is {}.", field, defaultValue);
        } catch (Exception e) {
            logger.error("Error verifying default value for field {}: ", field, e);
            throw e;
        }
    }

    @When("I leave the \"(.*)\" field blank and click \"(.*)\"")
    public void iLeaveTheFieldBlankAndClick(String field, String button) {
        try {
            basePage.clearField(field);
            basePage.clickButton(button);
            logger.info("Left {} field blank and clicked {} button.", field, button);
        } catch (Exception e) {
            logger.error("Error leaving field {} blank and clicking button {}: ", field, button, e);
            throw e;
        }
    }

    @Then("I should see an error message \"(.*)\"")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        try {
            basePage.verifyErrorMessage(errorMessage);
            logger.info("Verified error message: {}.", errorMessage);
        } catch (Exception e) {
            logger.error("Error verifying error message {}: ", errorMessage, e);
            throw e;
        }
    }

    @When("I select \"(.*)\" for both \"From\" and \"To\" fields and click \"(.*)\"")
    public void iSelectForBothFromAndToFieldsAndClick(String city, String button) {
        try {
            basePage.selectDropdownValue("From", city);
            basePage.selectDropdownValue("To", city);
            basePage.clickButton(button);
            logger.info("Selected {} for both From and To fields and clicked {} button.", city, button);
        } catch (Exception e) {
            logger.error("Error selecting {} for both From and To fields and clicking button {}: ", city, button, e);
            throw e;
        }
    }

    @When("I try to select a past date in the \"(.*)\" field")
    public void iTryToSelectAPastDateInTheField(String field) {
        try {
            basePage.verifyPastDatesDisabled(field);
            logger.info("Verified past dates are disabled for {} field.", field);
        } catch (Exception e) {
            logger.error("Error verifying past dates for field {}: ", field, e);
            throw e;
        }
    }

    @When("I enter a non-numeric value \"(.*)\" in the \"(.*)\" field and click \"(.*)\"")
    public void iEnterANonNumericValueInTheFieldAndClick(String value, String field, String button) {
        try {
            basePage.enterText(field, value);
            basePage.clickButton(button);
            logger.info("Entered non-numeric value {} in {} field and clicked {} button.", value, field, button);
        } catch (Exception e) {
            logger.error("Error entering non-numeric value {} in field {} and clicking button {}: ", value, field, button, e);
            throw e;
        }
    }

    @When("I fill all mandatory fields with valid data")
    public void iFillAllMandatoryFieldsWithValidData(DataTable dataTable) {
        try {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : data) {
                basePage.selectDropdownValue("From", row.get("From"));
                basePage.selectDropdownValue("To", row.get("To"));
                basePage.enterText("Departure Date", row.get("Departure Date"));
                basePage.enterText("Passengers", row.get("Passengers"));
                basePage.selectDropdownValue("Travel Class", row.get("Travel Class"));
            }
            logger.info("Filled all mandatory fields with valid data.");
        } catch (Exception e) {
            logger.error("Error filling mandatory fields with valid data: ", e);
            throw e;
        }
    }

    @Then("the \"(.*)\" button should be (enabled|disabled)")
    public void theButtonShouldBe(String button, String state) {
        try {
            boolean isEnabled = state.equals("enabled");
            basePage.verifyButtonState(button, isEnabled);
            logger.info("Verified {} button is {}.", button, state);
        } catch (Exception e) {
            logger.error("Error verifying button {} state {}: ", button, state, e);
            throw e;
        }
    }

    @Then("the results page should display available flights sorted by departure time")
    public void theResultsPageShouldDisplayAvailableFlightsSortedByDepartureTime() {
        try {
            basePage.verifyResultsSortedBy("departure time");
            logger.info("Verified results page displays available flights sorted by departure time.");
        } catch (Exception e) {
            logger.error("Error verifying results page sorting by departure time: ", e);
            throw e;
        }
    }

    @Then("I should see a message \"(.*)\"")
    public void iShouldSeeAMessage(String message) {
        try {
            basePage.verifyMessage(message);
            logger.info("Verified message: {}.", message);
        } catch (Exception e) {
            logger.error("Error verifying message {}: ", message, e);
            throw e;
        }
    }

    @When("I manually enter an invalid date format \"(.*)\" in the \"(.*)\" field and click \"(.*)\"")
    public void iManuallyEnterAnInvalidDateFormatInTheFieldAndClick(String date, String field, String button) {
        try {
            basePage.enterText(field, date);
            basePage.clickButton(button);
            logger.info("Manually entered invalid date format {} in {} field and clicked {} button.", date, field, button);
        } catch (Exception e) {
            logger.error("Error entering invalid date format {} in field {} and clicking button {}: ", date, field, button, e);
            throw e;
        }
    }

    @When("I open the calendar picker and navigate to future months")
    public void iOpenTheCalendarPickerAndNavigateToFutureMonths() {
        try {
            basePage.navigateCalendarToFutureMonths();
            logger.info("Navigated to future months in calendar picker.");
        } catch (Exception e) {
            logger.error("Error navigating to future months in calendar picker: ", e);
            throw e;
        }
    }

    @When("I select a date in the calendar picker and click the \"(.*)\" button")
    public void iSelectADateInTheCalendarPickerAndClickTheButton(String button) {
        try {
            basePage.clearSelectedDate();
            basePage.clickButton(button);
            logger.info("Selected a date in calendar picker and clicked {} button.", button);
        } catch (Exception e) {
            logger.error("Error selecting a date in calendar picker and clicking button {}: ", button, e);
            throw e;
        }
    }
}