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

    @FindBy(id = "noResultsMessage")
    private WebElement noResultsMessage;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

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
        if (data.containsKey("Passenger Count")) {
            type(passengerCountInput, data.get("Passenger Count"));
        }
        click(searchButton);
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
        // Implement sorting verification logic here
    }

    public void performRoundTripFlightSearch(DataTable table) {
        performFlightSearch(table);
    }

    public void verifyRoundTripResultsSeparation() {
        // Implement verification logic for round trip results separation
    }

    public void verifyNoFlightsMessage() {
        waitForElement(noResultsMessage);
        if (!isDisplayed(noResultsMessage)) {
            throw new AssertionError("No flights message is not displayed.");
        }
    }

    public void verifyInvalidCriteriaErrorMessage() {
        verifyErrorMessage("Invalid search criteria. Please check your inputs.");
    }

    public void verifyEmptyCriteriaErrorMessage() {
        verifyErrorMessage("Please fill in all required fields.");