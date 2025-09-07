package org.flight_booking.ui.stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
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
        logger.info("Leaving {} field blank and clicking {}.", field, button);
        basePage.leaveFieldBlankAndClick(field, button);
    }

    @Then("I should see an error message \"{string}\"")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        logger.info("Validating error message: {}", errorMessage);
        basePage.validateErrorMessage(errorMessage);
    }

    @When("I select \"{string}\" for both \"{string}\" and \"{string}\" fields and click \"{string}\"")
    public void iSelectForBothFieldsAndClick(String value, String field1, String field2, String button) {
        logger.info("Selecting {} for both {} and {} fields and clicking {}.", value, field1, field2, button);
        basePage.selectSameValueForFieldsAndClick(value, field1, field2, button);
    }

    @When("I try to select a past date in the \"{string}\" field")
    public void iTryToSelectAPastDateInTheField(String field) {
        logger.info("Trying to select a past date in the {} field.", field);
        basePage.validatePastDatesDisabled(field);
    }

    @When("I enter a non-numeric value \"{string}\" in the \"{string}\" field and click \"{string}\"")
    public void iEnterANonNumericValueInTheFieldAndClick(String value, String field, String button) {
        logger.info("Entering non-numeric value {} in {} field and clicking {}.", value, field, button);
        basePage.enterNonNumericValueAndClick(value, field, button);
    }

    @When("I enter {int} in the \"{string}\" field and click \"{string}\"")
    public void iEnterInTheFieldAndClick(int value, String field, String button) {
        logger.info("Entering value {} in {} field and clicking {}.", value, field, button);
        basePage.enterValueAndClick(value, field, button);
    }

    @Then("the search should proceed without any error message")
    public void theSearchShouldProceedWithoutAnyErrorMessage() {
        logger.info("Validating that search proceeds without any error message.");
        basePage.validateNoErrorMessage();
    }

    @When("I open the \"{string}\" dropdown")
    public void iOpenTheDropdown(String dropdown) {
        logger.info("Opening the {} dropdown.", dropdown);
        basePage.openDropdown(dropdown);
    }

    @Then("I should see the options {string}")
    public void iShouldSeeTheOptions(String options) {
        logger.info("Validating options in dropdown: {}", options);
        basePage.validateDropdownOptions(options);
    }

    @When("I check the \"{string}\" checkbox")
    public void iCheckTheCheckbox(String checkbox) {
        logger.info("Checking the {} checkbox.", checkbox);
        basePage.checkCheckbox(checkbox);
    }

    @Then("the \"{string}\" field should be hidden")
    public void theFieldShouldBeHidden(String field) {
        logger.info("Validating that {} field is hidden.", field);
        basePage.validateFieldHidden(field);
    }

    @When("I uncheck the \"{string}\" checkbox")
    public void iUncheckTheCheckbox(String checkbox) {
        logger.info("Unchecking the {} checkbox.", checkbox);
        basePage.uncheckCheckbox(checkbox);
    }

    @Then("the \"{string}\" field should reappear")
    public void theFieldShouldReappear(String field) {
        logger.info("Validating that {} field reappears.", field);
        basePage.validateFieldReappears(field);
    }

    @Then("the \"{string}\" button should be disabled")
    public void theButtonShouldBeDisabled(String button) {
        logger.info("Validating that {} button is disabled.", button);
        basePage.validateButtonDisabled(button);
    }

    @Then("the \"{string}\" button should be enabled")
    public void theButtonShouldBeEnabled(String button) {
        logger.info("Validating that {} button is enabled.", button);
        basePage.validateButtonEnabled(button);
    }

    @When("I fill all mandatory fields with valid data")
    public void iFillAllMandatoryFieldsWithValidData(DataTable dataTable) {
        logger.info("Filling all mandatory fields with valid data.");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        basePage.fillMandatoryFields(data);
    }

    @When("I fill all fields with valid data and click \"{string}\"")
    public void iFillAllFieldsWithValidDataAndClick(String button, DataTable dataTable) {
        logger.info("Filling all fields with valid data and clicking {}.", button);
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        basePage.fillAllFieldsAndClick(data, button);
    }

    @Then("the results page should display available flights sorted by departure time")
    public void theResultsPageShouldDisplayAvailableFlightsSortedByDepartureTime() {
        logger.info("Validating that results page displays available flights sorted by departure time.");
        basePage.validateSearchResultsSortedByDepartureTime();
    }

    @Then("I should see a message \"{string}\"")
    public void iShouldSeeAMessage(String message) {
        logger.info("Validating message: {}", message);
        basePage.validateMessage(message);
    }

    @When("I manually enter an invalid date format \"{string}\" in the \"{string}\" field and click \"{string}\"")
    public void iManuallyEnterAnInvalidDateFormatInTheFieldAndClick(String date, String field, String button) {
        logger.info("Manually entering invalid date format {} in {} field and clicking {}.", date, field, button);
        basePage.enterInvalidDateFormatAndClick(date, field, button);
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

    @When("I select a date in the calendar picker and click the \"{string}\" button")
    public void iSelectADateInTheCalendarPickerAndClickTheButton(String button) {
        logger.info("Selecting a date in the calendar picker and clicking {} button.", button);
        basePage.selectDateAndClickClear(button);
    }

    @Then("the selected date should be cleared and the field should be blank")
    public void theSelectedDateShouldBeClearedAndTheFieldShouldBeBlank() {
        logger.info("Validating that the selected date is cleared and the field is blank.");
        basePage.validateDateCleared();
    }
}