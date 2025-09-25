package org.flight_booking.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class FlightSearchPage extends BasePage {

    // Locators
    @FindBy(id = "searchForm")
    private WebElement searchForm;

    @FindBy(id = "fromCity")
    private WebElement fromCityDropdown;

    @FindBy(id = "toCity")
    private WebElement toCityDropdown;

    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @FindBy(id = "returnDate")
    private WebElement returnDateInput;

    @FindBy(id = "passengerCount")
    private WebElement passengerCountInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = ".results-list")
    private WebElement resultsList;

    @FindBy(css = ".flight-item")
    private List<WebElement> flightItems;

    @FindBy(css = ".departure-section")
    private WebElement departureSection;

    @FindBy(css = ".return-section")
    private WebElement returnSection;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @FindBy(css = ".system-logs")
    private WebElement systemLogs;

    // Constructor
    public FlightSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void verifySearchFormConnection() {
        waitForElement(searchForm);
        if (!isDisplayed(searchForm)) {
            throw new AssertionError("Search form is not connected or not visible.");
        }
    }

    public void performFlightSearch(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        selectDropdownByVisibleText(fromCityDropdown, data.get("From"));
        selectDropdownByVisibleText(toCityDropdown, data.get("To"));
        type(departureDateInput, data.get("Departure Date"));
        if (data.containsKey("Return Date")) {
            type(returnDateInput, data.get("Return Date"));
        }
        if (data.containsKey("Passengers")) {
            type(passengerCountInput, data.get("Passengers"));
        }
        click(searchButton);
    }

    public void performRoundTripFlightSearch(DataTable table) {
        performFlightSearch(table);
    }

    public void verifyResultsStructuredListFormat() {
        waitForElement(resultsList);
        if (!isDisplayed(resultsList)) {
            throw new AssertionError("Results list is not displayed.");
        }
    }

    public void verifyFlightDetails() {
        waitForElements(flightItems);
        for (WebElement flight : flightItems) {
            String flightText = getText(flight);
            if (!(flightText.contains("Airline") &&
                  flightText.contains("Flight") &&
                  flightText.contains("Departure") &&
                  flightText.contains("Arrival") &&
                  flightText.contains("Duration") &&
                  flightText.contains("Price"))) {
                throw new AssertionError("Flight details are incomplete: " + flightText);
            }
        }
    }

    public void verifySortingByDepartureTime() {
        // Logic to verify sorting by departure time
    }

    public void verifyRoundTripResultsSeparation() {
        waitForElement(departureSection);
        waitForElement(returnSection);
        if (!isDisplayed(departureSection) || !isDisplayed(returnSection)) {
            throw new AssertionError("Round trip results are not properly separated.");
        }
    }

    public void verifyNoFlightsMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("No flights available for selected criteria.")) {
            throw new AssertionError("Expected 'No flights available for selected criteria.' message not displayed.");
        }
    }

    public void verifyInvalidCriteriaErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Invalid search criteria. Please check your inputs.")) {
            throw new AssertionError("Expected 'Invalid search criteria' message not displayed.");
        }
    }

    public void verifyEmptyCriteriaErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Please fill in all required fields.")) {
            throw new AssertionError("Expected 'Please fill in all required fields.' message not displayed.");
        }
    }

    public void verifyMaxPassengerCountErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Maximum passenger count is 9.")) {
            throw new AssertionError("Expected 'Maximum passenger count is 9.' message not displayed.");
        }
    }

    public void verifySpecialCharactersErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Invalid characters in input fields.")) {
            throw new AssertionError("Expected 'Invalid characters in input fields.' message not displayed.");
        }
    }

    public void verifyNumericInputErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Invalid input in text fields.")) {
            throw new AssertionError("Expected 'Invalid input in text fields.' message not displayed.");
        }
    }

    public void verifyNoDuplicateResults() {
        // Logic to verify no duplicate results
    }

    public void verifyPastDateErrorMessage() {
        waitForElement(errorMessage);
        if (!getText(errorMessage).equals("Date cannot be in the past.")) {
            throw new AssertionError("Expected 'Date cannot be in the past.' message not displayed.");
        }
    }

    public void verifyResponseTime() {
        // Logic to verify response time is within acceptable limits
    }

    public void verifyUIAlignment() {
        // Logic to verify UI alignment
    }

    public void verifyErrorLogging() {
        waitForElement(systemLogs);
        if (!isDisplayed(systemLogs)) {
            throw new AssertionError("Error is not logged in the system logs.");
        }
    }

    public void verifyResultsDisplayedSuccessfully() {
        verifyResultsStructuredListFormat();
    }
}