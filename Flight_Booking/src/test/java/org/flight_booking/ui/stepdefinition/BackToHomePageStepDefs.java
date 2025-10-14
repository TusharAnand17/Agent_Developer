package org.flight_booking.ui.stepdefinition;

import io.cucumber.java.en.*;
import org.flight_booking.ui.pageobjects.BackToHomePage;

public class BackToHomePageStepDefs {

    BackToHomePage backToHomePage = new BackToHomePage();

    @Given("the user is on the search form page")
    public void theUserIsOnTheSearchFormPage() {
        backToHomePage.navigateToSearchFormPage();
    }

    @When("the user views the page")
    public void theUserViewsThePage() {
        backToHomePage.viewPage();
    }

    @Then("the 'Back to Home Page' button should be visible under the search form")
    public void theBackToHomePageButtonShouldBeVisibleUnderTheSearchForm() {
        backToHomePage.verifyButtonPresence();
    }

    @When("the user clicks the 'Back to Home Page' button")
    public void theUserClicksTheBackToHomePageButton() {
        backToHomePage.clickBackToHomePageButton();
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        backToHomePage.verifyRedirectionToHomepage();
    }

    @Then("the homepage should load successfully without any errors")
    public void theHomepageShouldLoadSuccessfullyWithoutAnyErrors() {
        backToHomePage.verifyHomepageLoadsWithoutErrors();
    }

    @Given("the user has entered data into the search form")
    public void theUserHasEnteredDataIntoTheSearchForm() {
        backToHomePage.enterDataIntoSearchForm();
    }

    @Then("the previously entered form data should be cleared")
    public void thePreviouslyEnteredFormDataShouldBeCleared() {
        backToHomePage.verifyFormDataCleared();
    }

    @When("the user inspects the alignment of the 'Back to Home Page' button")
    public void theUserInspectsTheAlignmentOfTheBackToHomePageButton() {
        backToHomePage.inspectButtonAlignment();
    }

    @Then("the button should be properly aligned under the search form")
    public void theButtonShouldBeProperlyAlignedUnderTheSearchForm() {
        backToHomePage.verifyButtonAlignment();
    }

    @Given("the homepage server is down")
    public void theHomepageServerIsDown() {
        backToHomePage.simulateHomepageServerDown();
    }

    @Then("an error message 'Unable to load homepage. Please try again later.' should be displayed")
    public void anErrorMessageUnableToLoadHomepageShouldBeDisplayed() {
        backToHomePage.verifyErrorMessageForServerDown();
    }

    @Given("the user session has expired")
    public void theUserSessionHasExpired() {
        backToHomePage.simulateSessionExpiration();
    }

    @Then("the user should be redirected to the login page or an error message 'Session expired.' should be displayed")
    public void theUserShouldBeRedirectedToTheLoginPageOrAnErrorMessageSessionExpiredShouldBeDisplayed() {
        backToHomePage.verifySessionExpirationBehavior();
    }

    @Given("the user has unauthorized access")
    public void theUserHasUnauthorizedAccess() {
        backToHomePage.simulateUnauthorizedAccess();
    }

    @Then("the user should be redirected to the login page or an error message 'Unauthorized access.' should be displayed")
    public void theUserShouldBeRedirectedToTheLoginPageOrAnErrorMessageUnauthorizedAccessShouldBeDisplayed() {
        backToHomePage.verifyUnauthorizedAccessBehavior();
    }

    @Then("the homepage should load within acceptable response time \(e.g., less than 2 seconds\)")
    public void theHomepageShouldLoadWithinAcceptableResponseTime() {
        backToHomePage.verifyResponseTime();
    }

    @When("the user inspects the label of the 'Back to Home Page' button")
    public void theUserInspectsTheLabelOfTheBackToHomePageButton() {
        backToHomePage.inspectButtonLabel();
    }

    @Then("the button label should be clear and understandable")
    public void theButtonLabelShouldBeClearAndUnderstandable() {
        backToHomePage.verifyButtonLabelClarity();
    }

    @Given("the user is using different browsers \(Chrome, Firefox, Edge\)")
    public void theUserIsUsingDifferentBrowsers() {
        backToHomePage.simulateDifferentBrowsers();
    }

    @Then("the button should function correctly on all tested browsers")
    public void theButtonShouldFunctionCorrectlyOnAllTestedBrowsers() {
        backToHomePage.verifyButtonFunctionalityAcrossBrowsers();
    }

    @Given("the user is using a mobile device")
    public void theUserIsUsingAMobileDevice() {
        backToHomePage.simulateMobileDevice();
    }

    @Then("the button should function correctly on all tested mobile devices")
    public void theButtonShouldFunctionCorrectlyOnAllTestedMobileDevices() {
        backToHomePage.verifyButtonFunctionalityOnMobileDevices();
    }

    @When("the user inspects the 'Back to Home Page' button for accessibility compliance")
    public void theUserInspectsTheBackToHomePageButtonForAccessibilityCompliance() {
        backToHomePage.inspectAccessibilityCompliance();
    }

    @Then("the button should meet accessibility standards \(e.g., ARIA labels, keyboard navigation\)")
    public void theButtonShouldMeetAccessibilityStandards() {
        backToHomePage.verifyAccessibilityCompliance();
    }

    @Given("the homepage URL is invalid")
    public void theHomepageURLIsInvalid() {
        backToHomePage.simulateInvalidHomepageURL();
    }

    @Then("an error message 'Invalid URL. Unable to redirect.' should be displayed")
    public void anErrorMessageInvalidURLUnableToRedirectShouldBeDisplayed() {
        backToHomePage.verifyErrorMessageForInvalidURL();
    }

    @Given("the network conditions are slow")
    public void theNetworkConditionsAreSlow() {
        backToHomePage.simulateSlowNetworkConditions();
    }

    @Then("the homepage should load successfully but with a delayed response")
    public void theHomepageShouldLoadSuccessfullyButWithADelayedResponse() {
        backToHomePage.verifyDelayedResponse();
    }
}