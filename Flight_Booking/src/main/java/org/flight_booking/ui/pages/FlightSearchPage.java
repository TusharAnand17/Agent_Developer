package org.flight_booking.ui.pages;

import org.flight_booking.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FlightSearchPage extends BasePage {

    private By departureCityField = By.id("departure-city");
    private By arrivalCityField = By.id("arrival-city");
    private By departureDateField = By.id("departure-date");
    private By returnDateField = By.id("return-date");
    private By passengerCountField = By.id("passenger-count");
    private By travelClassDropdown = By.id("travel-class");
    private By searchButton = By.id("search-button");
    private By resultsList = By.id("results-list");
    private By noFlightsMessage = By.id("no-flights-message");
    private By errorMessage = By.id("error-message");

    public void enterValidSearchCriteria() {
        try {
            type(departureCityField, "New York");
            type(arrivalCityField, "Los Angeles");
            type(departureDateField, "15-12-2023");
            type(returnDateField, "20-12-2023");
            type(passengerCountField, "2");
            selectFromDropdown(travelClassDropdown, "Economy");
            log.info("Entered valid search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid search criteria", e);
        }
    }

    public void enterValidRoundTripSearchCriteria() {
        try {
            enterValidSearchCriteria();
            log.info("Entered valid round-trip search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid round-trip search criteria", e);
        }
    }

    public void enterValidOneWaySearchCriteria() {
        try {
            type(departureCityField, "New York");
            type(arrivalCityField, "Los Angeles");
            type(departureDateField, "15-12-2023");
            type(passengerCountField, "1");
            selectFromDropdown(travelClassDropdown, "Economy");
            log.info("Entered valid one-way search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid one-way search criteria", e);
        }
    }

    public void enterInvalidSearchCriteria() {
        try {
            type(departureCityField, "InvalidCity");
            type(arrivalCityField, "InvalidCity");
            type(departureDateField, "32-13-2023");
            type(passengerCountField, "10");
            selectFromDropdown(travelClassDropdown, "InvalidClass");
            log.info("Entered invalid search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter invalid search criteria", e);
        }
    }

    public void clickSearchButton() {
        try {
            click(searchButton);
            log.info("Clicked the Search button.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to click the Search button", e);
        }
    }

    public void verifyResultsInStructuredListFormat() {
        try {
            waitForVisibility(resultsList);
            List<WebElement> results = getElements(resultsList);
            if (results.isEmpty()) {
                throw new RuntimeException("No results displayed.");
            }
            log.info("Results are displayed in a structured list format.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results in structured list format", e);
        }
    }

    public void verifyFlightDetailsInResults() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String airline = result.findElement(By.className("airline")).getText();
                String flightNumber = result.findElement(By.className("flight-number")).getText();
                String departureCity = result.findElement(By.className("departure-city")).getText();
                String arrivalCity = result.findElement(By.className("arrival-city")).getText();
                String times = result.findElement(By.className("times")).getText();
                String duration = result.findElement(By.className("duration")).getText();
                String price = result.findElement(By.className("price")).getText();

                if (airline.isEmpty() || flightNumber.isEmpty() || departureCity.isEmpty() || arrivalCity.isEmpty() || times.isEmpty() || duration.isEmpty() || price.isEmpty()) {
                    throw new RuntimeException("Missing flight details in results.");
                }
            }
            log.info("Verified flight details in results.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify flight details in results", e);
        }
    }

    public void verifyFlightsSortedByDepartureTime() {
        try {
            List<WebElement> results = getElements(resultsList);
            String previousTime = "00:00";
            for (WebElement result : results) {
                String currentTime = result.findElement(By.className("departure-time")).getText();
                if (currentTime.compareTo(previousTime) < 0) {
                    throw new RuntimeException("Flights are not sorted by departure time.");
                }
                previousTime = currentTime;
            }
            log.info("Verified flights are sorted by departure time in ascending order.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify flights sorted by departure time", e);
        }
    }

    public void verifyRoundTripResultsSplitIntoSections() {
        try {
            WebElement departureSection = driver.findElement(By.id("departure-section"));
            WebElement returnSection = driver.findElement(By.id("return-section"));
            if (!departureSection.isDisplayed() || !returnSection.isDisplayed()) {
                throw new RuntimeException("Round-trip results are not split into sections.");
            }
            log.info("Verified round-trip results are split into sections.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify round-trip results split into sections", e);
        }
    }

    public void verifyNoFlightsAvailableMessage() {
        try {
            waitForVisibility(noFlightsMessage);
            String message = getText(noFlightsMessage);
            if (!message.equals("No flights available for selected criteria.")) {
                throw new RuntimeException("Incorrect no flights available message displayed.");
            }
            log.info("Verified no flights available message.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify no flights available message", e);
        }
    }

    public void verifyResultsForOneWayTrip() {
        try {
            WebElement oneWaySection = driver.findElement(By.id("one-way-section"));
            if (!oneWaySection.isDisplayed()) {
                throw new RuntimeException("Results for one-way trip are not displayed.");
            }
            log.info("Verified results for one-way trip.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for one-way trip", e);
        }
    }

    public void verifyResultsForSpecifiedPassengers() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String passengers = result.findElement(By.className("passenger-count")).getText();
                if (!passengers.equals("2")) {
                    throw new RuntimeException("Results do not match the specified number of passengers.");
                }
            }
            log.info("Verified results for specified number of passengers.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for specified number of passengers", e);
        }
    }

    public void verifyResultsForSelectedTravelClass() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String travelClass = result.findElement(By.className("travel-class")).getText();
                if (!travelClass.equals("Economy")) {
                    throw new RuntimeException("Results do not match the selected travel class.");
                }
            }
            log.info("Verified results for selected travel class.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for selected travel class", e);
        }
    }

    public void verifyResultsForSwappedCities() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String departureCity = result.findElement(By.className("departure-city")).getText();
                String arrivalCity = result.findElement(By.className("arrival-city")).getText();
                if (!departureCity.equals("Los Angeles") || !arrivalCity.equals("New York")) {
                    throw new RuntimeException("Results do not match the swapped cities.");
                }
            }
            log.info("Verified results for swapped cities.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for swapped cities", e);
        }
    }

    public void verifyInvalidDateFormatErrorMessage() {
        try {
            waitForVisibility(errorMessage);
            String message = getText(errorMessage);
            if (!message.equals("Invalid date format. Please use dd-mm-yyyy.")) {
                throw new RuntimeException("Incorrect invalid date format error message displayed.");
            }
            log.info("Verified invalid date format error message.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify invalid date format error message", e);
        }
    }

    public void verifyPastDateErrorMessage() {
        try {
            waitForVisibility(errorMessage);
            String message = getText(errorMessage);
            if (!message.equals("Departure date cannot be in the past.")) {
                throw new RuntimeException("Incorrect past date error message displayed.");
            }
            log.info("Verified past date error message.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify past date error message", e);
        }
    }

    public void verifyResultsForMaximumPassengers() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String passengers = result.findElement(By.className("passenger-count")).getText();
                if (!passengers.equals("9")) {
                    throw new RuntimeException("Results do not match the maximum number of passengers.");
                }
            }
            log.info("Verified results for maximum passengers.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for maximum passengers", e);
        }
    }

    public void verifyResultsForMinimumPassengers() {
        try {
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String passengers = result.findElement(By.className("passenger-count")).getText();
                if (!passengers.equals("1")) {
                    throw new RuntimeException("Results do not match the minimum number of passengers.");
                }
            }
            log.info("Verified results for minimum passengers.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results for minimum passengers", e);
        }
    }

    public void verifyPassengerLimitErrorMessage() {
        try {
            waitForVisibility(errorMessage);
            String message = getText(errorMessage);
            if (!message.equals("Please enter between 1 and 9 passengers.")) {
                throw new RuntimeException("Incorrect passenger limit error message displayed.");
            }
            log.info("Verified passenger limit error message.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify passenger limit error message", e);
        }
    }
}