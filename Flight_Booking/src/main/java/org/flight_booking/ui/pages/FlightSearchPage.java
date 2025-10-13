package org.flight_booking.ui.pages;

import org.flight_booking.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FlightSearchPage extends BasePage {

    private final By departureCityField = By.id("departure-city");
    private final By arrivalCityField = By.id("arrival-city");
    private final By departureDateField = By.id("departure-date");
    private final By returnDateField = By.id("return-date");
    private final By passengerCountField = By.id("passenger-count");
    private final By travelClassDropdown = By.id("travel-class");
    private final By searchButton = By.id("search-button");
    private final By resultsList = By.id("results-list");
    private final By noFlightsMessage = By.xpath("//*[text()='No flights available for selected criteria.']");
    private final By invalidDateMessage = By.xpath("//*[text()='Invalid date format. Please use dd-mm-yyyy.']");
    private final By pastDateMessage = By.xpath("//*[text()='Departure date cannot be in the past."]");
    private final By passengerLimitMessage = By.xpath("//*[text()='Please enter between 1 and 9 passengers."]");

    public void enterValidSearchCriteria() {
        type(departureCityField, "New York");
        type(arrivalCityField, "Los Angeles");
        type(departureDateField, "25-12-2023");
        type(returnDateField, "30-12-2023");
        type(passengerCountField, "2");
        selectFromDropdown(travelClassDropdown, "Economy");
        log.info("Entered valid search criteria.");
    }

    public void enterValidRoundTripSearchCriteria() {
        enterValidSearchCriteria();
        log.info("Entered valid round-trip search criteria.");
    }

    public void enterValidOneWaySearchCriteria() {
        type(departureCityField, "New York");
        type(arrivalCityField, "Los Angeles");
        type(departureDateField, "25-12-2023");
        type(passengerCountField, "1");
        selectFromDropdown(travelClassDropdown, "Economy");
        log.info("Entered valid one-way search criteria.");
    }

    public void enterInvalidSearchCriteria() {
        type(departureCityField, "");
        type(arrivalCityField, "");
        type(departureDateField, "invalid-date");
        log.info("Entered invalid search criteria.");
    }

    public void clickSearchButton() {
        click(searchButton);
        log.info("Clicked the Search button.");
    }

    public void verifyResultsInStructuredListFormat() {
        waitForVisibility(resultsList);
        List<WebElement> results = getElements(resultsList);
        if (results.isEmpty()) {
            throw new AssertionError("No results displayed in structured list format.");
        }
        log.info("Results are displayed in a structured list format.");
    }

    public void verifyFlightDetailsInResults() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Airline") ||
                !result.getText().contains("Flight Number") ||
                !result.getText().contains("Departure City") ||
                !result.getText().contains("Arrival City") ||
                !result.getText().contains("Times") ||
                !result.getText().contains("Duration") ||
                !result.getText().contains("Price")) {
                throw new AssertionError("Flight details are missing in the results.");
            }
        }
        log.info("Verified that each flight result includes all necessary details.");
    }

    public void verifyFlightsSortedByDepartureTime() {
        List<WebElement> results = getElements(resultsList);
        String previousTime = "00:00";
        for (WebElement result : results) {
            String currentTime = result.findElement(By.className("departure-time")).getText();
            if (currentTime.compareTo(previousTime) < 0) {
                throw new AssertionError("Flights are not sorted by departure time.");
            }
            previousTime = currentTime;
        }
        log.info("Verified that flights are sorted by departure time in ascending order.");
    }

    public void verifyResultsSplitIntoSections() {
        WebElement departureSection = findElement(By.id("departure-flights"));
        WebElement returnSection = findElement(By.id("return-flights"));
        if (departureSection == null || returnSection == null) {
            throw new AssertionError("Results are not split into 'Departure Flights' and 'Return Flights' sections.");
        }
        log.info("Verified that results are split into 'Departure Flights' and 'Return Flights' sections.");
    }

    public void verifyNoFlightsAvailableMessage() {
        waitForVisibility(noFlightsMessage);
        log.info("Verified that the 'No flights available' message is displayed.");
    }

    public void verifyResultsForOneWayTrip() {
        WebElement returnSection = findElement(By.id("return-flights"));
        if (returnSection != null) {
            throw new AssertionError("Results are not displayed for one-way trip only.");
        }
        log.info("Verified that results are displayed for one-way trip only.");
    }

    public void verifyResultsForSpecifiedPassengers() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Passengers: 2")) {
                throw new AssertionError("Results are not displayed for the specified number of passengers.");
            }
        }
        log.info("Verified that results are displayed for the specified number of passengers.");
    }

    public void verifyResultsForSelectedTravelClass() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Class: Economy")) {
                throw new AssertionError("Results are not displayed for the selected travel class.");
            }
        }
        log.info("Verified that results are displayed for the selected travel class.");
    }

    public void verifyResultsForSwappedCities() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Departure: Los Angeles") || !result.getText().contains("Arrival: New York")) {
                throw new AssertionError("Results are not displayed for the swapped cities.");
            }
        }
        log.info("Verified that results are displayed for the swapped cities.");
    }

    public void verifyInvalidDateFormatMessage() {
        waitForVisibility(invalidDateMessage);
        log.info("Verified that the 'Invalid date format' error message is displayed.");
    }

    public void verifyPastDateErrorMessage() {
        waitForVisibility(pastDateMessage);
        log.info("Verified that the 'Departure date cannot be in the past' error message is displayed.");
    }

    public void verifyResultsForMaximumPassengers() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Passengers: 9")) {
                throw new AssertionError("Results are not displayed for 9 passengers.");
            }
        }
        log.info("Verified that results are displayed for 9 passengers.");
    }

    public void verifyResultsForMinimumPassengers() {
        List<WebElement> results = getElements(resultsList);
        for (WebElement result : results) {
            if (!result.getText().contains("Passengers: 1")) {
                throw new AssertionError("Results are not displayed for 1 passenger.");
            }
        }
        log.info("Verified that results are displayed for 1 passenger.");
    }

    public void verifyPassengerLimitErrorMessage() {
        waitForVisibility(passengerLimitMessage);
        log.info("Verified that the 'Please enter between 1 and 9 passengers' error message is displayed.");
    }
}