package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RoundTripFlightSearchStepDefs extends BasePage {

    @FindBy(id = "from")
    private WebElement fromField;

    @FindBy(id = "to")
    private WebElement toField;

    @FindBy(id = "departureDate")
    private WebElement departureDateField;

    @FindBy(id = "returnDate")
    private WebElement returnDateField;

    @FindBy(id = "passengers")
    private WebElement passengersField;

    @FindBy(id = "travelClass")
    private WebElement travelClassField;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(css = ".error-message")
    private List<WebElement> errorMessages;

    @FindBy(css = ".departure-flights .flight")
    private List<WebElement> departureFlights;

    @FindBy(css = ".return-flights .flight")
    private List<WebElement> returnFlights;

    @FindBy(css = ".no-flights-message")
    private WebElement noFlightsMessage;

    public RoundTripFlightSearchStepDefs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Given("the flight search page is open")
    public void openFlightSearchPage() {
        goToUrl("https://example.com/flight-search");
    }

    @When("I leave the \"{string}\" field blank and click \"Search\"")
    public void leaveFieldBlankAndClickSearch(String fieldName) {
        switch (fieldName) {
            case "From":
                type(fromField, "");
                break;
            case "To":
                type(toField, "");
                break;
            case "Departure Date":
                type(departureDateField, "");
                break;
            case "Return Date":
                type(returnDateField, "");
                break;
        }
        click(searchButton);
    }

    @Then("an error message \"{string}\" should be displayed")
    public void verifyErrorMessage(String expectedMessage) {
        boolean isMessageDisplayed = errorMessages.stream()
                .anyMatch(element -> getText(element).equals(expectedMessage));
        if (!isMessageDisplayed) {
            throw new AssertionError("Expected error message not displayed: " + expectedMessage);
        }
    }

    @When("I select \"{string}\" as the \"{string}\")
    public void selectFieldValue(String value, String fieldName) {
        switch (fieldName) {
            case "From city":
                type(fromField, value);
                break;
            case "To city":
                type(toField, value);
                break;
            case "Departure Date":
                type(departureDateField, value);
                break;
            case "Return Date":
                type(returnDateField, value);
                break;
            case "number of passengers":
                type(passengersField, value);
                break;
            case "travel class":
                type(travelClassField, value);
                break;
        }
    }

    @When("I click \"Search\"")
    public void clickSearch() {
        click(searchButton);
    }

    @Then("the results page should display available departure flights sorted by departure time")
    public void verifyDepartureFlightsSorted() {
        if (departureFlights.isEmpty()) {
            throw new AssertionError("No departure flights displayed.");
        }
        // Add logic to verify sorting if needed
    }

    @Then("the results page should display available return flights sorted by departure time")
    public void verifyReturnFlightsSorted() {
        if (returnFlights.isEmpty()) {
            throw new AssertionError("No return flights displayed.");
        }
        // Add logic to verify sorting if needed
    }

    @Then("a message \"{string}\" should be displayed")
    public void verifyNoFlightsMessage(String expectedMessage) {
        if (!getText(noFlightsMessage).equals(expectedMessage)) {
            throw new AssertionError("Expected message not displayed: " + expectedMessage);
        }
    }

    @Override
    public void verifyPageUrl(String expectedUrlPart) {
        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {
            throw new AssertionError("URL does not contain expected part: " + expectedUrlPart);
        }
    }
}