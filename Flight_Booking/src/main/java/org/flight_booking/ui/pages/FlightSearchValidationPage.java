package org.flight_booking.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchValidationPage extends BasePage {

    @FindBy(id = "departureCity")
    private WebElement departureCityInput;

    @FindBy(id = "arrivalCity")
    private WebElement arrivalCityInput;

    @FindBy(id = "departureDate")
    private WebElement departureDateInput;

    @FindBy(id = "returnDate")
    private WebElement returnDateInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "resultsList")
    private WebElement resultsList;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public FlightSearchValidationPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToFlightSearchPage() {
        goToUrl("https://example.com/flight-search");
    }

    public void performFlightSearch(String departureCity, String arrivalCity, String date) {
        type(departureCityInput, departureCity);
        type(arrivalCityInput, arrivalCity);
        type(departureDateInput, date);
        click(searchButton);
    }

    public void performRoundTripFlightSearch(String departureCity, String arrivalCity, String departureDate, String returnDate) {
        type(departureCityInput, departureCity);
        type(arrivalCityInput, arrivalCity);
        type(departureDateInput, departureDate);
        type(returnDateInput, returnDate);
        click(searchButton);
    }

    public void performSearchWithMissingMandatoryFields() {
        click(searchButton);
    }

    public void verifyResultsDisplayedInListFormat() {
        waitForElementToBeVisible(resultsList);
    }

    public void verifyFlightDetailsDisplayed() {
        // Add logic to verify flight details
    }

    public void verifyFlightsSortedByDepartureTime() {
        // Add logic to verify sorting
    }

    public void verifyRoundTripResultsSplit() {
        // Add logic to verify split results
    }

    public void verifyNoFlightsAvailableMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("No flights available for selected criteria.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyInvalidDepartureCityMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Invalid departure city.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyInvalidArrivalCityMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Invalid arrival city.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyDateCannotBeInThePastMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Date cannot be in the past.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyMandatoryFieldsErrorMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Please fill in all mandatory fields.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyInvalidCharactersInDepartureCityMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Invalid characters in departure city.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyInputExceedsMaximumLengthMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Input exceeds maximum allowed length.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyResultsForBothFlights() {
        waitForElementToBeVisible(resultsList);
        // Add logic to verify results for both flights
    }

    public void verifyInvalidDateFormatMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Invalid date format.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }

    public void verifyResultsForDepartureFlightsOnly() {
        waitForElementToBeVisible(resultsList);
        // Add logic to verify results for departure flights only
    }

    public void verifyDuplicateCitiesErrorMessage() {
        waitForElementToBeVisible(errorMessage);
        if (!getText(errorMessage).equals("Departure and arrival cities cannot be the same.")) {
            throw new AssertionError("Expected error message not displayed");
        }
    }
}