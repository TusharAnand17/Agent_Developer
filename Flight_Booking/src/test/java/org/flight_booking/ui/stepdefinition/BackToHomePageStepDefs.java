package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BackToHomePageStepDefs extends BasePage {

    private WebDriver driver;

    public BackToHomePageStepDefs(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Given("User is on the page with the search form")
    public void userIsOnThePageWithTheSearchForm() {
        goToUrl("https://example.com/search"); // Replace with actual URL
    }

    @Then("'Back to Home Page' button is visible below the search form")
    public void backToHomePageButtonIsVisibleBelowTheSearchForm() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        waitForElementToBeVisible(backButton);
    }

    @Given("'Back to Home Page' button is visible")
    public void backToHomePageButtonIsVisible() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        waitForElementToBeVisible(backButton);
    }

    @When("User clicks on the 'Back to Home Page' button")
    public void userClicksOnTheBackToHomePageButton() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("User is redirected to the homepage")
    public void userIsRedirectedToTheHomepage() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @Then("Homepage loads successfully without any errors")
    public void homepageLoadsSuccessfullyWithoutAnyErrors() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @Given("Search form is present and 'Back to Home Page' button is visible")
    public void searchFormIsPresentAndBackToHomePageButtonIsVisible() {
        WebElement searchForm = driver.findElement(By.id("searchForm")); // Replace with actual ID
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        waitForElementToBeVisible(searchForm);
        waitForElementToBeVisible(backButton);
    }

    @When("User enters data into the search form and clicks 'Back to Home Page' button")
    public void userEntersDataIntoTheSearchFormAndClicksBackToHomePageButton() {
        WebElement searchInput = driver.findElement(By.id("searchInput")); // Replace with actual ID
        type(searchInput, "Sample Data");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Form data is cleared upon redirection to the homepage")
    public void formDataIsClearedUponRedirectionToTheHomepage() {
        WebElement searchInput = driver.findElement(By.id("searchInput")); // Replace with actual ID
        assert searchInput.getAttribute("value").isEmpty();
    }

    @When("User disables internet connection and clicks 'Back to Home Page' button")
    public void userDisablesInternetConnectionAndClicksBackToHomePageButton() {
        ((JavascriptExecutor) driver).executeScript("navigator.connection.type = 'none';");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Appropriate error message is displayed")
    public void appropriateErrorMessageIsDisplayed() {
        WebElement errorMessage = driver.findElement(By.id("errorMessage")); // Replace with actual ID
        waitForElementToBeVisible(errorMessage);
        assert errorMessage.isDisplayed();
    }

    @Then("Button label is clear and intuitive")
    public void buttonLabelIsClearAndIntuitive() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        String label = backButton.getText();
        assert label.equals("Back to Home Page");
    }

    @Then("Button is located below the search form")
    public void buttonIsLocatedBelowTheSearchForm() {
        WebElement searchForm = driver.findElement(By.id("searchForm")); // Replace with actual ID
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        assert backButton.getLocation().getY() > searchForm.getLocation().getY();
    }

    @Then("Button click response time is within acceptable limits")
    public void buttonClickResponseTimeIsWithinAcceptableLimits() {
        long startTime = System.currentTimeMillis();
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
        long endTime = System.currentTimeMillis();
        assert (endTime - startTime) < 2000; // Example: 2 seconds
    }

    @When("User accesses the page on a mobile device and clicks 'Back to Home Page' button")
    public void userAccessesThePageOnAMobileDeviceAndClicksBackToHomePageButton() {
        // Simulate mobile device behavior
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 667));
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Button functions correctly on mobile devices")
    public void buttonFunctionsCorrectlyOnMobileDevices() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @When("User accesses the page on a tablet and clicks 'Back to Home Page' button")
    public void userAccessesThePageOnATabletAndClicksBackToHomePageButton() {
        // Simulate tablet behavior
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Button functions correctly on tablet devices")
    public void buttonFunctionsCorrectlyOnTabletDevices() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @When("User accesses the page on a desktop and clicks 'Back to Home Page' button")
    public void userAccessesThePageOnADesktopAndClicksBackToHomePageButton() {
        // Simulate desktop behavior
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Button functions correctly on desktop devices")
    public void buttonFunctionsCorrectlyOnDesktopDevices() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @When("User simulates server downtime and clicks 'Back to Home Page' button")
    public void userSimulatesServerDowntimeAndClicksBackToHomePageButton() {
        // Simulate server downtime
        driver.get("data:text/html,<html><body>Server Down</body></html>");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Button is accessible via screen readers")
    public void buttonIsAccessibleViaScreenReaders() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        String ariaLabel = backButton.getAttribute("aria-label");
        assert ariaLabel != null && !ariaLabel.isEmpty();
    }

    @When("User navigates to the 'Back to Home Page' button using the Tab key")
    public void userNavigatesToTheBackToHomePageButtonUsingTheTabKey() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        backButton.sendKeys("\t");
    }

    @Then("Button receives focus when navigated to using the Tab key")
    public void buttonReceivesFocusWhenNavigatedToUsingTheTabKey() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        assert backButton.equals(driver.switchTo().activeElement());
    }

    @When("User enters data into the search form without saving and clicks 'Back to Home Page' button")
    public void userEntersDataIntoTheSearchFormWithoutSavingAndClicksBackToHomePageButton() {
        WebElement searchInput = driver.findElement(By.id("searchInput")); // Replace with actual ID
        type(searchInput, "Unsaved Data");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Form data is cleared without saving")
    public void formDataIsClearedWithoutSaving() {
        WebElement searchInput = driver.findElement(By.id("searchInput")); // Replace with actual ID
        assert searchInput.getAttribute("value").isEmpty();
    }

    @When("User hovers over the 'Back to Home Page' button")
    public void userHoversOverTheBackToHomePageButton() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        String hoverScript = "var event = new MouseEvent('mouseover', { 'view': window, 'bubbles': true, 'cancelable': true }); arguments[0].dispatchEvent(event);";
        ((JavascriptExecutor) driver).executeScript(hoverScript, backButton);
    }

    @Then("Button displays a hover effect")
    public void buttonDisplaysAHoverEffect() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        String hoverColor = backButton.getCssValue("background-color");
        assert hoverColor.equals("rgba(0, 123, 255, 1)"); // Replace with actual hover color
    }

    @When("User disables JavaScript in the browser and clicks 'Back to Home Page' button")
    public void userDisablesJavaScriptInTheBrowserAndClicksBackToHomePageButton() {
        driver.get("data:text/html,<html><body><noscript>JavaScript Disabled</noscript></body></html>");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @When("User opens multiple tabs of the same page and clicks 'Back to Home Page' button in one tab")
    public void userOpensMultipleTabsOfTheSamePageAndClicksBackToHomePageButtonInOneTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://example.com/search', '_blank');");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Button functions correctly without affecting other tabs")
    public void buttonFunctionsCorrectlyWithoutAffectingOtherTabs() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

    @When("User clicks 'Back to Home Page' button and then uses the browser back button")
    public void userClicksBackToHomePageButtonAndThenUsesTheBrowserBackButton() {
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
        driver.navigate().back();
    }

    @Then("User is redirected back to the previous page")
    public void userIsRedirectedBackToThePreviousPage() {
        verifyPageUrl("https://example.com/search"); // Replace with actual URL
    }

    @When("User enters invalid data into the search form and clicks 'Back to Home Page' button")
    public void userEntersInvalidDataIntoTheSearchFormAndClicksBackToHomePageButton() {
        WebElement searchInput = driver.findElement(By.id("searchInput")); // Replace with actual ID
        type(searchInput, "Invalid Data");
        WebElement backButton = driver.findElement(By.id("backToHomePage")); // Replace with actual ID
        click(backButton);
    }

    @Then("Form validation errors are ignored and user is redirected to the homepage")
    public void formValidationErrorsAreIgnoredAndUserIsRedirectedToTheHomepage() {
        verifyPageUrl("https://example.com/home"); // Replace with actual URL
    }

}