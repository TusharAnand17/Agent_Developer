package org.flight_booking.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightSearchValidationPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchValidationPage.class);

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = "#airlineCodes")
    private WebElement airlineCodes;

    public FlightSearchValidationPage(WebDriver driver) {
        super(driver);
    }

    public void ensureBackendDataForAirlineCodes() {
        logger.info("Ensuring backend data for airline codes is available.");
        // Implementation to ensure backend data is available.
    }

    public void searchForFlights() {
        logger.info("Clicking the search button to search for flights.");
        click(searchButton);
    }

    public void verifyAirlineCodesMatchBackendData() {
        logger.info("Verifying airline codes displayed match backend data.");
        String displayedCodes = getText(airlineCodes);
        // Logic to compare displayed codes with backend data.
    }

    // Additional methods for other scenarios will follow the same pattern.

    @Override
    public void verifyPageUrl(String expectedUrlPart) {
        // Implementation to verify the page URL.
    }
}