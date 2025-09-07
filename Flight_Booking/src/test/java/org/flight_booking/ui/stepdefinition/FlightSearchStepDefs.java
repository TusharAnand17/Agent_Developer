package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.junit.Assert.*;

public class FlightSearchStepDefs extends BasePage {

    @FindBy(id = "fromDropdown")
    private WebElement fromDropdown;

    @FindBy(id = "toDropdown")
    private WebElement toDropdown;

    @FindBy(id = "passengersField")
    private WebElement passengersField;

    @FindBy(id = "travelClassDropdown")
    private WebElement travelClassDropdown;

    @FindBy(id = "departureDateField")
    private WebElement departureDateField;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "returnDateField")
    private WebElement returnDateField;

    @FindBy(id = "oneWayCheckbox")
    private WebElement oneWayCheckbox;

    @FindBy(className = "calendarPicker")
    private WebElement calendarPicker;

    @FindBy(className = "calendarClearButton")
    private WebElement calendarClearButton;

    @FindBy(className = "flightResults")
    private List<WebElement> flightResults;

    public FlightSearchStepDefs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Given("the flight search page is open")
    public void openFlightSearchPage() {
        goToUrl("http://example.com/flight-search");
    }

    @Then("the \"From\" dropdown should default to \"Select City\"")
    public void verifyFromDropdownDefault() {
        assertEquals("Select City", new Select(fromDropdown).getFirstSelectedOption().getText());
    }

    @Then("the \"To\" dropdown should default to \"Select City\"")
    public void verifyToDropdownDefault() {
        assertEquals("Select City", new Select(toDropdown).getFirstSelectedOption().getText());
    }

    @Then("the \"Passengers\" field should default to 1")
    public void verifyPassengersFieldDefault() {
        assertEquals("1", passengersField.getAttribute("value"));
    }

    @Then("the \"Travel Class\" dropdown should default to \"Economy\"")
    public void verifyTravelClassDefault() {
        assertEquals("Economy", new Select(travelClassDropdown).getFirstSelectedOption().getText());
    }

    @When("I leave the \"From\" field blank and click \"Search\"")
    public void leaveFromFieldBlankAndSearch() {
        new Select(fromDropdown).selectByVisibleText("Select City");
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a departure city.\"")
    public void verifyDepartureCityError() {
        assertEquals("Please select a departure city.", getText(errorMessage));
    }

    @When("I leave the \"To\" field blank and click \"Search\"")
    public void leaveToFieldBlankAndSearch() {
        new Select(toDropdown).selectByVisibleText("Select City");
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a destination city.\"")
    public void verifyDestinationCityError() {
        assertEquals("Please select a destination city.", getText(errorMessage));
    }

    @When("I select \"New York\" for both \"From\" and \"To\" fields and click \"Search\"")
    public void selectSameCityForFromAndTo() {
        new Select(fromDropdown).selectByVisibleText("New York");
        new Select(toDropdown).selectByVisibleText("New York");
        click(searchButton);
    }

    @Then("I should see an error message \"Departure and destination cannot be the same.\"")
    public void verifySameCityError() {
        assertEquals("Departure and destination cannot be the same.", getText(errorMessage));
    }

    @When("I leave the \"Departure Date\" field blank and click \"Search\"")
    public void leaveDepartureDateBlankAndSearch() {
        departureDateField.clear();
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a departure date.\"")
    public void verifyDepartureDateError() {
        assertEquals("Please select a departure date.", getText(errorMessage));
    }

    @When("I try to select a past date in the \"Departure Date\" field")
    public void tryToSelectPastDate() {
        // Assuming past dates are disabled in the calendar picker
        assertFalse(calendarPicker.isEnabled());
    }

    @Then("past dates should be disabled and cannot be selected")
    public void verifyPastDatesDisabled() {
        assertFalse(calendarPicker.isEnabled());
    }

    @When("I enter a non-numeric value \"abc\" in the \"Passengers\" field and click \"Search\"")
    public void enterNonNumericPassengers() {
        type(passengersField, "abc");
        click(searchButton);
    }

    @Then("I should see an error message \"Please enter between 1 and 9 passengers.\"")
    public void verifyPassengersError() {
        assertEquals("Please enter between 1 and 9 passengers.", getText(errorMessage));
    }

    @When("I enter {int} in the \"Passengers\" field and click \"Search\"")
    public void enterPassengersAndSearch(int passengers) {
        type(passengersField, String.valueOf(passengers));
        click(searchButton);
    }

    @Then("the search should proceed without any error message")
    public void verifySearchProceeds() {
        assertTrue(flightResults.size() > 0);
    }

    @When("I open the \"Travel Class\" dropdown")
    public void openTravelClassDropdown() {
        click(travelClassDropdown);
    }

    @Then("I should see the options \"Economy\", \"Business\", and \"First\"")
    public void verifyTravelClassOptions() {
        List<WebElement> options = new Select(travelClassDropdown).getOptions();
        assertTrue(options.stream().anyMatch(option -> option.getText().equals("Economy")));
        assertTrue(options.stream().anyMatch(option -> option.getText().equals("Business")));
        assertTrue(options.stream().anyMatch(option -> option.getText().equals("First")));
    }

    @When("I check the \"One Way\" checkbox")
    public void checkOneWayCheckbox() {
        if (!oneWayCheckbox.isSelected()) {
            click(oneWayCheckbox);
        }
    }

    @Then("the \"Return Date\" field should be hidden")
    public void verifyReturnDateHidden() {
        assertFalse(returnDateField.isDisplayed());
    }

    @When("I uncheck the \"One Way\" checkbox")
    public void uncheckOneWayCheckbox() {
        if (oneWayCheckbox.isSelected()) {
            click(oneWayCheckbox);
        }
    }

    @Then("the \"Return Date\" field should reappear")
    public void verifyReturnDateReappears() {
        assertTrue(returnDateField.isDisplayed());
    }

    @When("I leave mandatory fields blank")
    public void leaveMandatoryFieldsBlank() {
        new Select(fromDropdown).selectByVisibleText("Select City");
        new Select(toDropdown).selectByVisibleText("Select City");
        departureDateField.clear();
    }

    @Then("the \"Search\" button should be disabled")
    public void verifySearchButtonDisabled() {
        assertFalse(searchButton.isEnabled());
    }

    @When("I fill all mandatory fields with valid data")
    public void fillMandatoryFields(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        new Select(fromDropdown).selectByVisibleText(data.get(1).get(0));
        new Select(toDropdown).selectByVisibleText(data.get(1).get(1));
        type(departureDateField, data.get(1).get(2));
        type(passengersField, data.get(1).get(3));
        new Select(travelClassDropdown).selectByVisibleText(data.get(1).get(4));
    }

    @Then("the \"Search\" button should be enabled")
    public void verifySearchButtonEnabled() {
        assertTrue(searchButton.isEnabled());
    }

    @When("I fill all fields with valid data and click \"Search\"")
    public void fillAllFieldsAndSearch(io.cucumber.datatable.DataTable dataTable) {
        fillMandatoryFields(dataTable);
        click(searchButton);
    }

    @Then("the results page should display available flights sorted by departure time")
    public void verifyResultsPage() {
        assertTrue(flightResults.size() > 0);
        // Additional logic to verify sorting can be added here
    }

    @When("I fill all fields with valid data that yield no results and click \"Search\"")
    public void fillFieldsNoResults(io.cucumber.datatable.DataTable dataTable) {
        fillMandatoryFields(dataTable);
        click(searchButton);
    }

    @Then("I should see a message \"No flights available for selected criteria.\"")
    public void verifyNoFlightsMessage() {
        assertEquals("No flights available for selected criteria.", getText(errorMessage));
    }

    @When("I manually enter an invalid date format \"31-02-2023\" in the \"Departure Date\" field and click \"Search\"")
    public void enterInvalidDateFormat() {
        type(departureDateField, "31-02-2023");
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a valid date.\"")
    public void verifyInvalidDateError() {
        assertEquals("Please select a valid date.", getText(errorMessage));
    }

    @When("I open the calendar picker and navigate to future months")
    public void navigateToFutureMonths() {
        click(calendarPicker);
        // Logic to navigate to future months can be added here
    }

    @Then("future months should be accessible and past months should be disabled")
    public void verifyCalendarNavigation() {
        // Logic to verify calendar navigation can be added here
    }

    @When("I select a date in the calendar picker and click the \"Clear\" button")
    public void selectDateAndClear() {
        click(calendarPicker);
        // Logic to select a date can be added here
        click(calendarClearButton);
    }

    @Then("the selected date should be cleared and the field should be blank")
    public void verifyDateCleared() {
        assertEquals("", departureDateField.getAttribute("value"));
    }

    @Override
    public void verifyPageUrl(String expectedUrlPart) {
        assertTrue(driver.getCurrentUrl().contains(expectedUrlPart));
    }
}