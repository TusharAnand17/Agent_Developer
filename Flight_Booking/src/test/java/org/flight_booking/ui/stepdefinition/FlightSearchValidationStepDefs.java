package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.flight_booking.ui.pages.FlightSearchValidationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class FlightSearchValidationStepDefs {

    private WebDriver driver;
    private WebDriverWait wait;
    private FlightSearchValidationPage flightSearchValidationPage;

    public FlightSearchValidationStepDefs() {
        // Initialize WebDriver and Page Object
        this.flightSearchValidationPage = new FlightSearchValidationPage(driver);
    }

    @Given("backend data for airline codes is available and up-to-date")
    public void backendDataForAirlineCodesIsAvailable() {
        System.out.println("Verifying backend data for airline codes is available.");
        flightSearchValidationPage.verifyBackendDataAvailability("airline codes");
    }

    @When("I search for flights")
    public void iSearchForFlights() {
        System.out.println("Searching for flights.");
        flightSearchValidationPage.searchForFlights();
    }

    @Then("airline codes displayed match backend data")
    public void airlineCodesDisplayedMatchBackendData() {
        System.out.println("Validating airline codes match backend data.");
        Assert.assertTrue("Airline codes do not match backend data!", flightSearchValidationPage.validateAirlineCodes());
    }

    @Given("backend data for airline names is available and up-to-date")
    public void backendDataForAirlineNamesIsAvailable() {
        System.out.println("Verifying backend data for airline names is available.");
        flightSearchValidationPage.verifyBackendDataAvailability("airline names");
    }

    @Then("airline names displayed match backend data")
    public void airlineNamesDisplayedMatchBackendData() {
        System.out.println("Validating airline names match backend data.");
        Assert.assertTrue("Airline names do not match backend data!", flightSearchValidationPage.validateAirlineNames());
    }

    @Given("no prerequisites")
    public void noPrerequisites() {
        System.out.println("No prerequisites for this scenario.");
    }

    @Then("dates are displayed in dd-mm-yyyy format")
    public void datesAreDisplayedInCorrectFormat() {
        System.out.println("Validating date format.");
        Assert.assertTrue("Date format is incorrect!", flightSearchValidationPage.validateDateFormat());
    }

    @Then("times are displayed in HH:MM format")
    public void timesAreDisplayedInCorrectFormat() {
        System.out.println("Validating time format.");
        Assert.assertTrue("Time format is incorrect!", flightSearchValidationPage.validateTimeFormat());
    }

    @Then("duration matches the difference between departure and arrival times")
    public void durationMatchesDifference() {
        System.out.println("Validating duration calculation.");
        Assert.assertTrue("Duration calculation is incorrect!", flightSearchValidationPage.validateDurationCalculation());
    }

    @Then("prices are displayed in USD with $ symbol")
    public void pricesAreDisplayedInUSD() {
        System.out.println("Validating price format.");
        Assert.assertTrue("Price format is incorrect!", flightSearchValidationPage.validatePriceFormat());
    }

    @When("I search for flights with invalid airline code")
    public void iSearchForFlightsWithInvalidAirlineCode() {
        System.out.println("Searching for flights with invalid airline code.");
        flightSearchValidationPage.searchForFlightsWithInvalidAirlineCode();
    }

    @Then("the system does not display flights with invalid airline codes")
    public void systemDoesNotDisplayInvalidAirlineCodes() {
        System.out.println("Validating no flights are displayed with invalid airline codes.");
        Assert.assertTrue("Flights with invalid airline codes are displayed!", flightSearchValidationPage.validateInvalidAirlineCodeHandling());
    }

    // Additional step definitions for other scenarios can be added here.
}