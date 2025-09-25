package org.flight_booking.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * Page Object for Flight Search Validation.
 */
public class FlightSearchValidationPage extends BasePage {

    @FindBy(id = "searchForm")
    private WebElement searchForm;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = ".flight-result")
    private List<WebElement> flightResults;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    @FindBy(css = ".departure-section")
    private WebElement departureSection;

    @FindBy(css = ".return-section")
    private WebElement returnSection;

    public FlightSearchValidationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Perform a flight search by filling the form and clicking the search button.
     */
    public void performFlightSearch(String origin, String destination, String date, String passengers) {
        type(searchForm.findElement(By.name("origin")), origin);
        type(searchForm.findElement(By.name("destination")), destination);
        type(searchForm.findElement(By.name("date")), date);
        type(searchForm.findElement(By.name("passengers")), passengers);
        click(searchButton);
    }

    /**
     * Validate if flight results are displayed.
     */
    public boolean areResultsDisplayed() {
        return !flightResults.isEmpty();
    }

    /**
     * Get the error message displayed on the page.
     */
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    /**
     * Validate if departure and return sections are displayed for round trip.
     */
    public boolean areRoundTripSectionsDisplayed() {
        return departureSection.isDisplayed() && returnSection.isDisplayed();
    }

    @Override
    public void verifyPageUrl(String expectedUrlPart) {
        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {
            throw new IllegalStateException("Expected URL part not found: " + expectedUrlPart);
        }
    }
}