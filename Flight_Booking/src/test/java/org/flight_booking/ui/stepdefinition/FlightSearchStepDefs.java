package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.FlightSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;

public class FlightSearchStepDefs {

    private WebDriver driver;
    private FlightSearchPage flightSearchPage;

    @Given("the flight search page is open")
    public void theFlightSearchPageIsOpen() {
        driver = new ChromeDriver();
        driver.get("http://example.com/flight-search");
        flightSearchPage = new FlightSearchPage(driver);
    }

    @Then("the \"From\" dropdown should default to \"Select City\"")
    public void theFromDropdownShouldDefaultToSelectCity() {
        assert flightSearchPage.getDefaultFromDropdownValue().equals("Select City");
    }

    @Then("the \"To\" dropdown should default to \"Select City\"")
    public void theToDropdownShouldDefaultToSelectCity() {
        assert flightSearchPage.getDefaultToDropdownValue().equals("Select City");
    }

    @Then("the \"Passengers\" field should default to {int}")
    public void thePassengersFieldShouldDefaultTo(int defaultValue) {
        assert Integer.parseInt(flightSearchPage.getDefaultPassengersValue()) == defaultValue;
    }

    @Then("the \"Travel Class\" dropdown should default to \"Economy\"")
    public void theTravelClassDropdownShouldDefaultToEconomy() {
        assert flightSearchPage.getDefaultTravelClassValue().equals("Economy");
    }

    @When("I leave the \"From\" field blank and click \"Search\"")
    public void iLeaveTheFromFieldBlankAndClickSearch() {
        flightSearchPage.selectFromCity("");
        flightSearchPage.clickSearchButton();
    }

    @Then("I should see an error message \"{string}\"")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        assert flightSearchPage.getErrorMessage().equals(expectedMessage);
    }

    @When("I leave the \"To\" field blank and click \"Search\"")
    public void iLeaveTheToFieldBlankAndClickSearch() {
        flightSearchPage.selectToCity("");
        flightSearchPage.clickSearchButton();
    }

    @When("I select \"{string}\" for both \"From\" and \"To\" fields and click \"Search\"")
    public void iSelectForBothFromAndToFieldsAndClickSearch(String city) {
        flightSearchPage.selectFromCity(city);
        flightSearchPage.selectToCity(city);
        flightSearchPage.clickSearchButton();
    }

    @When("I leave the \"Departure Date\" field blank and click \"Search\"")
    public void iLeaveTheDepartureDateFieldBlankAndClickSearch() {
        flightSearchPage.enterDepartureDate("");
        flightSearchPage.clickSearchButton();
    }

    @When("I try to select a past date in the \"Departure Date\" field")
    public void iTryToSelectAPastDateInTheDepartureDateField() {
        flightSearchPage.enterDepartureDate("2020-01-01");
    }

    @Then("past dates should be disabled and cannot be selected")
    public void pastDatesShouldBeDisabledAndCannotBeSelected() {
        // Implement logic to verify past dates are disabled
    }

    @When("I enter a non-numeric value \"{string}\" in the \"Passengers\" field and click \"Search\"")
    public void iEnterANonNumericValueInThePassengersFieldAndClickSearch(String value) {
        flightSearchPage.enterPassengers(value);
        flightSearchPage.clickSearchButton();
    }

    @When("I enter {int} in the \"Passengers\" field and click \"Search\"")
    public void iEnterInThePassengersFieldAndClickSearch(int value) {
        flightSearchPage.enterPassengers(String.valueOf(value));
        flightSearchPage.clickSearchButton