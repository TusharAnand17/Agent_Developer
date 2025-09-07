package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class FlightSearchStepDefs extends BasePage {

    public FlightSearchStepDefs(WebDriver driver) {
        super(driver);
    }

    @Given("the flight search page is open")
    public void openFlightSearchPage() {
        goToUrl("https://example.com/flight-search");
    }

    @Then("the \"From\" dropdown should default to \"Select City\"")
    public void verifyFromDropdownDefault() {
        WebElement fromDropdown = driver.findElement(By.id("fromDropdown"));
        Assert.assertEquals("Select City", new Select(fromDropdown).getFirstSelectedOption().getText());
    }

    @Then("the \"To\" dropdown should default to \"Select City\"")
    public void verifyToDropdownDefault() {
        WebElement toDropdown = driver.findElement(By.id("toDropdown"));
        Assert.assertEquals("Select City", new Select(toDropdown).getFirstSelectedOption().getText());
    }

    @Then("the \"Passengers\" field should default to 1")
    public void verifyPassengersDefault() {
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        Assert.assertEquals("1", passengersField.getAttribute("value"));
    }

    @Then("the \"Travel Class\" dropdown should default to \"Economy\"")
    public void verifyTravelClassDefault() {
        WebElement travelClassDropdown = driver.findElement(By.id("travelClassDropdown"));
        Assert.assertEquals("Economy", new Select(travelClassDropdown).getFirstSelectedOption().getText());
    }

    @When("I leave the \"From\" field blank and click \"Search\"")
    public void leaveFromFieldBlankAndSearch() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a departure city.\"")
    public void verifyFromFieldErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("fromErrorMessage"));
        Assert.assertEquals("Please select a departure city.", getText(errorMessage));
    }

    @When("I leave the \"To\" field blank and click \"Search\"")
    public void leaveToFieldBlankAndSearch() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a destination city.\"")
    public void verifyToFieldErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("toErrorMessage"));
        Assert.assertEquals("Please select a destination city.", getText(errorMessage));
    }

    @When("I select \"New York\" for both \"From\" and \"To\" fields and click \"Search\"")
    public void selectSameFromAndToFields() {
        WebElement fromDropdown = driver.findElement(By.id("fromDropdown"));
        WebElement toDropdown = driver.findElement(By.id("toDropdown"));
        new Select(fromDropdown).selectByVisibleText("New York");
        new Select(toDropdown).selectByVisibleText("New York");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Departure and destination cannot be the same.\"")
    public void verifySameFromAndToErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("sameCityErrorMessage"));
        Assert.assertEquals("Departure and destination cannot be the same.", getText(errorMessage));
    }

    @When("I leave the \"Departure Date\" field blank and click \"Search\"")
    public void leaveDepartureDateBlankAndSearch() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a departure date.\"")
    public void verifyDepartureDateErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("departureDateErrorMessage"));
        Assert.assertEquals("Please select a departure date.", getText(errorMessage));
    }

    @When("I try to select a past date in the \"Departure Date\" field")
    public void trySelectingPastDate() {
        WebElement departureDateField = driver.findElement(By.id("departureDateField"));
        departureDateField.sendKeys("01/01/2000");
    }

    @Then("past dates should be disabled and cannot be selected")
    public void verifyPastDatesDisabled() {
        WebElement departureDateField = driver.findElement(By.id("departureDateField"));
        Assert.assertTrue(departureDateField.getAttribute("value").isEmpty());
    }

    @When("I enter a non-numeric value \"abc\" in the \"Passengers\" field and click \"Search\"")
    public void enterNonNumericPassengers() {
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        type(passengersField, "abc");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Please enter between 1 and 9 passengers.\"")
    public void verifyPassengersErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("passengersErrorMessage"));
        Assert.assertEquals("Please enter between 1 and 9 passengers.", getText(errorMessage));
    }

    @When("I enter 0 in the \"Passengers\" field and click \"Search\"")
    public void enterZeroPassengers() {
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        type(passengersField, "0");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @When("I enter 10 in the \"Passengers\" field and click \"Search\"")
    public void enterTenPassengers() {
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        type(passengersField, "10");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @When("I enter 5 in the \"Passengers\" field and click \"Search\"")
    public void enterFivePassengers() {
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        type(passengersField, "5");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("the search should proceed without any error message")
    public void verifySearchProceeds() {
        WebElement resultsPage = driver.findElement(By.id("resultsPage"));
        Assert.assertTrue(resultsPage.isDisplayed());
    }

    @When("I open the \"Travel Class\" dropdown")
    public void openTravelClassDropdown() {
        WebElement travelClassDropdown = driver.findElement(By.id("travelClassDropdown"));
        click(travelClassDropdown);
    }

    @Then("I should see the options \"Economy\", \"Business\", and \"First\"")
    public void verifyTravelClassOptions() {
        WebElement travelClassDropdown = driver.findElement(By.id("travelClassDropdown"));
        List<WebElement> options = new Select(travelClassDropdown).getOptions();
        Assert.assertTrue(options.stream().anyMatch(option -> option.getText().equals("Economy")));
        Assert.assertTrue(options.stream().anyMatch(option -> option.getText().equals("Business")));
        Assert.assertTrue(options.stream().anyMatch(option -> option.getText().equals("First")));
    }

    @When("I check the \"One Way\" checkbox")
    public void checkOneWayCheckbox() {
        WebElement oneWayCheckbox = driver.findElement(By.id("oneWayCheckbox"));
        click(oneWayCheckbox);
    }

    @Then("the \"Return Date\" field should be hidden")
    public void verifyReturnDateHidden() {
        WebElement returnDateField = driver.findElement(By.id("returnDateField"));
        Assert.assertFalse(returnDateField.isDisplayed());
    }

    @When("I uncheck the \"One Way\" checkbox")
    public void uncheckOneWayCheckbox() {
        WebElement oneWayCheckbox = driver.findElement(By.id("oneWayCheckbox"));
        click(oneWayCheckbox);
    }

    @Then("the \"Return Date\" field should reappear")
    public void verifyReturnDateReappears() {
        WebElement returnDateField = driver.findElement(By.id("returnDateField"));
        Assert.assertTrue(returnDateField.isDisplayed());
    }

    @When("I leave mandatory fields blank")
    public void leaveMandatoryFieldsBlank() {
        // Assuming fields are already blank
    }

    @Then("the \"Search\" button should be disabled")
    public void verifySearchButtonDisabled() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        Assert.assertFalse(searchButton.isEnabled());
    }

    @When("I fill all mandatory fields with valid data")
    public void fillMandatoryFieldsWithValidData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        WebElement fromDropdown = driver.findElement(By.id("fromDropdown"));
        WebElement toDropdown = driver.findElement(By.id("toDropdown"));
        WebElement departureDateField = driver.findElement(By.id("departureDateField"));
        WebElement passengersField = driver.findElement(By.id("passengersField"));
        WebElement travelClassDropdown = driver.findElement(By.id("travelClassDropdown"));

        new Select(fromDropdown).selectByVisibleText(data.get("From"));
        new Select(toDropdown).selectByVisibleText(data.get("To"));
        type(departureDateField, data.get("Departure Date"));
        type(passengersField, data.get("Passengers"));
        new Select(travelClassDropdown).selectByVisibleText(data.get("Travel Class"));
    }

    @Then("the \"Search\" button should be enabled")
    public void verifySearchButtonEnabled() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        Assert.assertTrue(searchButton.isEnabled());
    }

    @When("I fill all fields with valid data and click \"Search\"")
    public void fillAllFieldsAndSearch(io.cucumber.datatable.DataTable dataTable) {
        fillMandatoryFieldsWithValidData(dataTable);
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("the results page should display available flights sorted by departure time")
    public void verifyResultsPageDisplaysFlights() {
        WebElement resultsPage = driver.findElement(By.id("resultsPage"));
        Assert.assertTrue(resultsPage.isDisplayed());
        // Additional assertions for sorting can be added here
    }

    @When("I fill all fields with valid data that yield no results and click \"Search\"")
    public void fillFieldsWithNoResults(io.cucumber.datatable.DataTable dataTable) {
        fillMandatoryFieldsWithValidData(dataTable);
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see a message \"No flights available for selected criteria.\"")
    public void verifyNoFlightsMessage() {
        WebElement noFlightsMessage = driver.findElement(By.id("noFlightsMessage"));
        Assert.assertEquals("No flights available for selected criteria.", getText(noFlightsMessage));
    }

    @When("I manually enter an invalid date format \"31-02-2023\" in the \"Departure Date\" field and click \"Search\"")
    public void enterInvalidDateFormat() {
        WebElement departureDateField = driver.findElement(By.id("departureDateField"));
        type(departureDateField, "31-02-2023");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        click(searchButton);
    }

    @Then("I should see an error message \"Please select a valid date.\"")
    public void verifyInvalidDateErrorMessage() {
        WebElement errorMessage = driver.findElement(By.id("invalidDateErrorMessage"));
        Assert.assertEquals("Please select a valid date.", getText(errorMessage));
    }

    @When("I open the calendar picker and navigate to future months")
    public void navigateToFutureMonths() {
        WebElement calendarPicker = driver.findElement(By.id("calendarPicker"));
        click(calendarPicker);
        WebElement nextMonthButton = driver.findElement(By.id("nextMonthButton"));
        click(nextMonthButton);
    }

    @Then("future months should be accessible and past months should be disabled")
    public void verifyCalendarNavigation() {
        WebElement pastMonthButton = driver.findElement(By.id("pastMonthButton"));
        Assert.assertFalse(pastMonthButton.isEnabled());
        WebElement futureMonthButton = driver.findElement(By.id("futureMonthButton"));
        Assert.assertTrue(futureMonthButton.isEnabled());
    }

    @When("I select a date in the calendar picker and click the \"Clear\" button")
    public void selectDateAndClear() {
        WebElement calendarPicker = driver.findElement(By.id("calendarPicker"));
        click(calendarPicker);
        WebElement date = driver.findElement(By.id("someDate"));
        click(date);
        WebElement clearButton = driver.findElement(By.id("clearButton"));
        click(clearButton);
    }

    @Then("the selected date should be cleared and the field should be blank")
    public void verifyDateCleared() {
        WebElement departureDateField = driver.findElement(By.id("departureDateField"));
        Assert.assertTrue(departureDateField.getAttribute("value").isEmpty());
    }
}