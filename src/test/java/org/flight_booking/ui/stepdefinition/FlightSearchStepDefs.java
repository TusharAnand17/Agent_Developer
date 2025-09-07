package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class FlightSearchStepDefs {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchStepDefs.class);
    private final BasePage basePage = new BasePage();

    @Given("the flight search page is open")
    public void theFlightSearchPageIsOpen() {
        logger.info("Opening the flight search page.");
        basePage.openFlightSearchPage();
    }

    @Then("the \"{string}\" dropdown should default to \"{string}\"")
    public void theDropdownShouldDefaultTo(String field, String defaultValue) {
        logger.info("Validating default value for {} dropdown.", field);
        basePage.validateDropdownDefaultValue(field, defaultValue);
    }

    @Then("the \"{string}\" field should default to {int}")
    public void theFieldShouldDefaultTo(String field, int defaultValue) {
        logger.info("Validating default value for {} field.", field);
        basePage.validateFieldDefaultValue(field, defaultValue);
    }

    @When("I leave the \"{string}\" field blank and click \"{string}\"")
    public void iLeaveTheFieldBlankAndClick(String field, String button) {
        logger.info("Leaving {} field blank and clicking {} button.", field, button);
        basePage.leaveFieldBlankAndClick(field, button);
    }

    @Then("I should see an error message \"{string}\"")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        logger.info("Validating error message: {}", errorMessage);
        basePage.validateErrorMessage(errorMessage);
    }

    @When("I select \"{string}\" for both \"From\" and \"To\" fields and click \"Search\"")
    public void iSelectSameCityForFromAndToFields(String city) {
        logger.info("Selecting {} for both From and To fields and clicking Search.", city);
        basePage.selectSameCityForFromAndTo(city);
    }

    @When("I try to select a past date in the \"Departure Date\" field")
    public void iTryToSelectAPastDate() {
        logger.info("Attempting to select a past date in the Departure Date field.");
        basePage.validatePastDatesDisabled();
    }

    @When("I enter a non-numeric value \"{string}\" in the \"Passengers\" field and click \"Search\"")
    public void iEnterNonNumericValueInPassengersField(String value) {
        logger.info("Entering non-numeric value {} in Passengers field and clicking Search.", value);
        basePage.enterNonNumericValueInPassengersField(value);
    }

    @When("I enter {int} in the \"Passengers\" field and click \"Search\"")
    public void iEnterValueInPassengersField(int value) {
        logger.info("Entering value {} in Passengers field and clicking Search.", value);
        basePage.enterValueInPassengersField(value);
    }

    @When("I open the \"Travel Class\" dropdown")
    public void iOpenTheTravelClassDropdown() {
        logger.info("Opening the Travel Class dropdown.");
        basePage.openTravelClassDropdown();
    }

    @Then("I should see the options {string}")
    public void iShouldSeeTheOptions(String options) {
        logger.info("Validating options in dropdown: {}", options);
        basePage.validateDropdownOptions(options);
    }

    @When("I check the \"One Way\" checkbox")
    public void iCheckTheOneWayCheckbox() {
        logger.info("Checking the One Way checkbox.");
        basePage.checkOneWayCheckbox();
    }

    @Then("the \"Return Date\" field should be hidden")
    public void theReturnDateFieldShouldBeHidden() {
        logger.info("Validating that the Return Date field is hidden.");
        basePage.validateReturnDateFieldHidden();
    }

    @When("I uncheck the \"One Way\" checkbox")
    public void iUncheckTheOneWayCheckbox() {
        logger.info("Unchecking the One Way checkbox.");
        basePage.uncheckOneWayCheckbox();
    }

    @Then("the \"Return Date\" field should reappear")
    public void theReturnDateFieldShouldReappear() {
        logger.info("Validating that the Return Date field reappears.");
        basePage.validateReturnDateFieldReappears();
    }

    @When("I leave mandatory fields blank")
    public void iLeaveMandatoryFieldsBlank() {
        logger.info("Leaving mandatory fields blank.");
        basePage.leaveMandatoryFieldsBlank();
    }

    @Then("the \"Search\" button should be disabled")
    public void theSearchButtonShouldBeDisabled() {
        logger.info("Validating that the Search button is disabled.");
        basePage.validateSearchButtonDisabled();
    }

    @When("I fill all mandatory fields with valid data")
    public void iFillAllMandatoryFieldsWithValidData(Map<String, String> data) {
        logger.info("Filling all mandatory fields with valid data: {}", data);
        basePage.fillMandatoryFields(data);
    }

    @Then("the \"Search\" button should be enabled")
    public void theSearchButtonShouldBeEnabled() {
        logger.info("Validating that the Search button is enabled.");
        basePage.validateSearchButtonEnabled();
    }

    @When("I fill all fields with valid data and click \"Search\"")
    public void iFillAllFieldsWithValidDataAndClickSearch(Map<String, String> data) {
        logger.info("Filling all fields with valid data and clicking Search: {}", data);
        basePage.fillAllFieldsAndSearch(data);
    }

    @Then("the results page should display available flights sorted by departure time")
    public void theResultsPageShouldDisplayAvailableFlights() {
        logger.info("Validating that the results page displays available flights sorted by departure time.");
        basePage.validateSearchResultsSortedByTime();
    }

    @Then("I should see a message \"{string}\"")
    public void iShouldSeeAMessage(String message) {
        logger.info("Validating message: {}", message);
        basePage.validateMessage(message);
    }

    @When("I manually enter an invalid date format \"{string}\" in the \"Departure Date\" field and click \"Search\"")
    public void iManuallyEnterInvalidDateFormat(String date) {
        logger.info("Manually entering invalid date format {} in Departure Date field and clicking Search.", date);
        basePage.enterInvalidDateFormat(date);
    }

    @When("I open the calendar picker and navigate to future months")
    public void iOpenTheCalendarPickerAndNavigateToFutureMonths() {
        logger.info("Opening the calendar picker and navigating to future months.");
        basePage.navigateCalendarToFutureMonths();
    }

    @Then("future months should be accessible and past months should be disabled")
    public void futureMonthsShouldBeAccessibleAndPastMonthsShouldBeDisabled() {
        logger.info("Validating that future months are accessible and past months are disabled.");
        basePage.validateCalendarNavigation();
    }

    @When("I select a date in the calendar picker and click the \"Clear\" button")
    public void iSelectADateAndClickClear() {
        logger.info("Selecting a date in the calendar picker and clicking the Clear button.");
        basePage.clearSelectedDate();
    }

    @Then("the selected date should be cleared and the field should be blank")
    public void theSelectedDateShouldBeCleared() {
        logger.info("Validating that the selected date is cleared and the field is blank.");
        basePage.validateDateFieldCleared();
    }
}