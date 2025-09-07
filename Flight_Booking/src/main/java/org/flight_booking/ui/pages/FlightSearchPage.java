package org.flight_booking.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FlightSearchPage extends BasePage {

    @FindBy(id = "fromDropdown")
    private WebElement fromDropdown;

    @FindBy(id = "toDropdown")
    private WebElement toDropdown;

    @FindBy(id = "passengersField")
    private WebElement passengersField;

    @FindBy(id = "travelClassDropdown")
    private WebElement travelClassDropdown;

    @FindBy(id = "departureDateField")
    private WebElement departureDateField;

    @FindBy(id = "returnDateField")
    private WebElement returnDateField;

    @FindBy(id = "oneWayCheckbox")
    private WebElement oneWayCheckbox;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(className = "dropdownOption")
    private List<WebElement> dropdownOptions;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageUrl(String expectedUrlPart) {
        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {
            throw new IllegalStateException("This is not the Flight Search page");
        }
    }

    public String getDefaultFromDropdownValue() {
        return getText(fromDropdown);
    }

    public String getDefaultToDropdownValue() {
        return getText(toDropdown);
    }

    public String getDefaultPassengersValue() {
        return passengersField.getAttribute("value");
    }

    public String getDefaultTravelClassValue() {
        return getText(travelClassDropdown);
    }

    public void selectFromCity(String city) {
        click(fromDropdown);
        selectByVisibleText(dropdownOptions, city);
    }

    public void selectToCity(String city) {
        click(toDropdown);
        selectByVisibleText(dropdownOptions, city);
    }

    public void enterPassengers(String passengers) {
        type(passengersField, passengers);
    }

    public void selectTravelClass(String travelClass) {
        click(travelClassDropdown);
        selectByVisibleText(dropdownOptions, travelClass);
    }

    public void enterDepartureDate(String date) {
        type(departureDateField, date);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public void checkOneWayCheckbox() {
        if (!oneWayCheckbox.isSelected()) {
            click(oneWayCheckbox);
        }
    }

    public void uncheckOneWayCheckbox() {
        if (oneWayCheckbox.isSelected()) {
            click(oneWayCheckbox);
        }
    }

    public boolean isReturnDateFieldVisible() {
        try {
            waitForElementToBeVisible(returnDateField);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}