package org.flight_booking.ui.pages;

import org.flight_booking.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FlightSearchPage extends BasePage {

    private By departureCityField = By.id("departureCity");
    private By destinationCityField = By.id("destinationCity");
    private By departureDateField = By.id("departureDate");
    private By returnDateField = By.id("returnDate");
    private By passengersField = By.id("passengers");
    private By flightClassDropdown = By.id("flightClass");
    private By searchButton = By.id("searchButton");
    private By resultsList = By.id("resultsList");
    private By errorMessage = By.id("errorMessage");

    public void enterValidSearchCriteria() {
        try {
            type(departureCityField, "New York");
            type(destinationCityField, "Los Angeles");
            type(departureDateField, "2023-12-01");
            type(passengersField, "2");
            selectFromDropdown(flightClassDropdown, "Economy");
            log.info("Entered valid search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid search criteria", e);
        }
    }

    public void enterValidRoundTripSearchCriteria() {
        try {
            type(departureCityField, "New York");
            type(destinationCityField, "Los Angeles");
            type(departureDateField, "2023-12-01");
            type(returnDateField, "2023-12-10");
            type(passengersField, "2");
            selectFromDropdown(flightClassDropdown, "Economy");
            log.info("Entered valid round-trip search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid round-trip search criteria", e);
        }
    }

    public void enterInvalidSearchCriteria() {
        try {
            type(departureCityField, "InvalidCity");
            type(destinationCityField, "InvalidCity");
            type(departureDateField, "InvalidDate");
            type(passengersField, "InvalidPassengers");
            selectFromDropdown(flightClassDropdown, "InvalidClass");
            log.info("Entered invalid search criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter invalid search criteria", e);
        }
    }

    public void performFlightSearch(String departure, String destination, String date, String passengers, String flightClass) {
        try {
            type(departureCityField, departure);
            type(destinationCityField, destination);
            type(departureDateField, date);
            type(passengersField, passengers);
            selectFromDropdown(flightClassDropdown, flightClass);
            click(searchButton);
            log.info("Performed flight search with criteria: Departure=" + departure + ", Destination=" + destination + ", Date=" + date + ", Passengers=" + passengers + ", Class=" + flightClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform flight search", e);
        }
    }

    public void performRoundTripFlightSearch(String departure, String destination, String date, String returnDate, String passengers) {
        try {
            type(departureCityField, departure);
            type(destinationCityField, destination);
            type(departureDateField, date);
            type(returnDateField, returnDate);
            type(passengersField, passengers);
            click(searchButton);
            log.info("Performed round-trip flight search with criteria: Departure=" + departure + ", Destination=" + destination + ", Date=" + date + ", Return Date=" + returnDate + ", Passengers=" + passengers);
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform round-trip flight search", e);
        }
    }

    public void performOneWayFlightSearch(String departure, String destination, String date, String passengers, String flightClass) {
        try {
            type(departureCityField, departure);
            type(destinationCityField, destination);
            type(departureDateField, date);
            type(passengersField, passengers);
            selectFromDropdown(flightClassDropdown, flightClass);
            click(searchButton);
            log.info("Performed one-way flight search with criteria: Departure=" + departure + ", Destination=" + destination + ", Date=" + date + ", Passengers=" + passengers + ", Class=" + flightClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform one-way flight search", e);
        }
    }

    public void verifyResultsInStructuredListFormat() {
        try {
            waitForVisibility(resultsList);
            List<WebElement> results = getElements(resultsList);
            if (results.isEmpty()) {
                throw new AssertionError("No results found.");
            }
            log.info("Results are displayed in a structured list format.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify results in structured list format", e);
        }
    }

    public void verifyFlightDetailsInResults() {
        try {
            waitForVisibility(resultsList);
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String airline = result.findElement(By.className("airline")).getText();
                String flightNumber = result.findElement(By.className("flightNumber")).getText();
                String departureCity = result.findElement(By.className("departureCity")).getText();
                String arrivalCity = result.findElement(By.className("arrivalCity")).getText();
                String departureTime = result.findElement(By.className("departureTime")).getText();
                String arrivalTime = result.findElement(By.className("arrivalTime")).getText();
                String duration = result.findElement(By.className("duration")).getText();
                String price = result.findElement(By.className("price")).getText();

                if (airline.isEmpty() || flightNumber.isEmpty() || departureCity.isEmpty() || arrivalCity.isEmpty() || departureTime.isEmpty() || arrivalTime.isEmpty() || duration.isEmpty() || price.isEmpty()) {
                    throw new AssertionError("Flight details are incomplete.");
                }
            }
            log.info("Verified flight details in results.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify flight details in results", e);
        }
    }

    public void verifySortingByDepartureTime() {
        try {
            waitForVisibility(resultsList);
            List<WebElement> results = getElements(resultsList);
            String previousDepartureTime = "";
            for (WebElement result : results) {
                String currentDepartureTime = result.findElement(By.className("departureTime")).getText();
                if (!previousDepartureTime.isEmpty() && previousDepartureTime.compareTo(currentDepartureTime) > 0) {
                    throw new AssertionError("Results are not sorted by departure time.");
                }
                previousDepartureTime = currentDepartureTime;
            }
            log.info("Verified sorting by departure time.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify sorting by departure time", e);
        }
    }

    public void verifyRoundTripResultsSplit() {
        try {
            WebElement departureFlights = findElement(By.id("departureFlights"));
            WebElement returnFlights = findElement(By.id("returnFlights"));
            if (departureFlights == null || returnFlights == null) {
                throw new AssertionError("Round-trip results are not split correctly.");
            }
            log.info("Verified round-trip results are split into Departure Flights and Return Flights.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify round-trip results split", e);
        }
    }

    public void verifyMessageDisplayed(String message) {
        try {
            waitForVisibility(errorMessage);
            String displayedMessage = getText(errorMessage);
            if (!displayedMessage.equals(message)) {
                throw new AssertionError("Expected message: " + message + ", but found: " + displayedMessage);
            }
            log.info("Verified message displayed: " + message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify message displayed", e);
        }
    }

    public void verifySortingForRoundTripResults() {
        try {
            WebElement departureFlights = findElement(By.id("departureFlights"));
            WebElement returnFlights = findElement(By.id("returnFlights"));

            List<WebElement> departureResults = departureFlights.findElements(By.className("flightResult"));
            List<WebElement> returnResults = returnFlights.findElements(By.className("flightResult"));

            String previousDepartureTime = "";
            for (WebElement result : departureResults) {
                String currentDepartureTime = result.findElement(By.className("departureTime")).getText();
                if (!previousDepartureTime.isEmpty() && previousDepartureTime.compareTo(currentDepartureTime) > 0) {
                    throw new AssertionError("Departure flights are not sorted by departure time.");
                }
                previousDepartureTime = currentDepartureTime;
            }

            previousDepartureTime = "";
            for (WebElement result : returnResults) {
                String currentDepartureTime = result.findElement(By.className("departureTime")).getText();
                if (!previousDepartureTime.isEmpty() && previousDepartureTime.compareTo(currentDepartureTime) > 0) {
                    throw new AssertionError("Return flights are not sorted by departure time.");
                }
                previousDepartureTime = currentDepartureTime;
            }
            log.info("Verified sorting for round-trip results.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify sorting for round-trip results", e);
        }
    }

    public void verifyErrorMessageForInvalidData() {
        try {
            waitForVisibility(errorMessage);
            String displayedMessage = getText(errorMessage);
            if (displayedMessage.isEmpty()) {
                throw new AssertionError("Error message is not displayed for invalid data.");
            }
            log.info("Verified error message for invalid data.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify error message for invalid data", e);
        }
    }

    public void verifyUIUpdatesForNoFlights(String message) {
        try {
            waitForVisibility(errorMessage);
            String displayedMessage = getText(errorMessage);
            if (!displayedMessage.equals(message)) {
                throw new AssertionError("Expected UI message: " + message + ", but found: " + displayedMessage);
            }
            log.info("Verified UI updates for no flights with message: " + message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify UI updates for no flights", e);
        }
    }

    public void verifyFlightDetailsFormat() {
        try {
            waitForVisibility(resultsList);
            List<WebElement> results = getElements(resultsList);
            for (WebElement result : results) {
                String airline = result.findElement(By.className("airline")).getText();
                String flightNumber = result.findElement(By.className("flightNumber")).getText();
                String departureCity = result.findElement(By.className("departureCity")).getText();
                String arrivalCity = result.findElement(By.className("arrivalCity")).getText();
                String departureTime = result.findElement(By.className("departureTime")).getText();
                String arrivalTime = result.findElement(By.className("arrivalTime")).getText();
                String duration = result.findElement(By.className("duration")).getText();
                String price = result.findElement(By.className("price")).getText();

                if (airline.isEmpty() || flightNumber.isEmpty() || departureCity.isEmpty() || arrivalCity.isEmpty() || departureTime.isEmpty() || arrivalTime.isEmpty() || duration.isEmpty() || price.isEmpty()) {
                    throw new AssertionError("Flight details are not displayed in the correct format.");
                }
            }
            log.info("Verified flight details are displayed in the correct format.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify flight details format", e);
        }
    }

    public void verifyErrorMessageForInvalidCriteria() {
        try {
            waitForVisibility(errorMessage);
            String displayedMessage = getText(errorMessage);
            if (displayedMessage.isEmpty()) {
                throw new AssertionError("Error message is not displayed for invalid criteria.");
            }
            log.info("Verified error message for invalid criteria.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to verify error message for invalid criteria", e);
        }
    }
}