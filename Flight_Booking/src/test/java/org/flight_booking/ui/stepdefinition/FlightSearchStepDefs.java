package org.flight_booking.ui.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Step Definitions for Flight Search Functionality.
 */
public class FlightSearchStepDefs extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(FlightSearchStepDefs.class);

    @FindBy(id = "fromDropdown")
    private WebElement fromDropdown;

    @FindBy(id = "toDropdown")
    private WebElement toDropdown;

    @FindBy(id = "passengersField")
    private WebElement passengersField;

    @FindBy(id = "travelClassDropdown")
    private WebElement travelClassDropdown;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "returnDateField")
    private WebElement returnDateField;

    public FlightSearchStepDefs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Given("the flight search page is open")
    public void openFlightSearchPage() {
        try {
            goToUrl("https://example.com/flight-search");
            logger.info("Navigated to the flight search page.");
        } catch (Exception e) {
            logger.error("Failed to open the flight search page.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"From\" dropdown should default to \"{string}\"")
    public void verifyFromDropdownDefault(String expectedValue) {
        try {
            String actualValue = getText(fromDropdown);
            if (!actualValue.equals(expectedValue)) {
                throw new AssertionError("Expected: " + expectedValue + ", but got: " + actualValue);
            }
            logger.info("Verified 'From' dropdown default value: {}", expectedValue);
        } catch (Exception e) {
            logger.error("Failed to verify 'From' dropdown default value.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"To\" dropdown should default to \"{string}\"")
    public void verifyToDropdownDefault(String expectedValue) {
        try {
            String actualValue = getText(toDropdown);
            if (!actualValue.equals(expectedValue)) {
                throw new AssertionError("Expected: " + expectedValue + ", but got: " + actualValue);
            }
            logger.info("Verified 'To' dropdown default value: {}", expectedValue);
        } catch (Exception e) {
            logger.error("Failed to verify 'To' dropdown default value.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"Passengers\" field should default to {int}")
    public void verifyPassengersFieldDefault(int expectedValue) {
        try {
            String actualValue = passengersField.getAttribute("value");
            if (!actualValue.equals(String.valueOf(expectedValue))) {
                throw new AssertionError("Expected: " + expectedValue + ", but got: " + actualValue);
            }
            logger.info("Verified 'Passengers' field default value: {}", expectedValue);
        } catch (Exception e) {
            logger.error("Failed to verify 'Passengers' field default value.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("the \"Travel Class\" dropdown should default to \"{string}\"")
    public void verifyTravelClassDropdownDefault(String expectedValue) {
        try {
            String actualValue = getText(travelClassDropdown);
            if (!actualValue.equals(expectedValue)) {
                throw new AssertionError("Expected: " + expectedValue + ", but got: " + actualValue);
            }
            logger.info("Verified 'Travel Class' dropdown default value: {}", expectedValue);
        } catch (Exception e) {
            logger.error("Failed to verify 'Travel Class' dropdown default value.", e);
            throw new RuntimeException(e);
        }
    }

    @When("I leave the \"From\" field blank and click \"Search\"")
    public void leaveFromFieldBlankAndSearch() {
        try {
            type(fromDropdown, "");
            click(searchButton);
            logger.info("Left 'From' field blank and clicked 'Search'.");
        } catch (Exception e) {
            logger.error("Failed to leave 'From' field blank and click 'Search'.", e);
            throw new RuntimeException(e);
        }
    }

    @Then("I should see an error message \"{string}\"")
    public void verifyErrorMessage(String expectedMessage) {
        try {
            String actualMessage = getText(errorMessage);
            if (!actualMessage.equals(expectedMessage)) {
                throw new AssertionError("Expected: " + expectedMessage + ", but got: " + actualMessage);
            }
            logger.info("Verified error message: {}", expectedMessage);
        } catch (Exception e) {
            logger.error("Failed to verify error message.", e);
            throw new RuntimeException(e);
        }
    }

    // Additional step definitions for other scenarios can be implemented similarly.
}