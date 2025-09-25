Feature: Back to Home Page Button Functionality

  Scenario: Verify 'Back to Home Page' button exists
    Given User is on the page with the search form
    Then 'Back to Home Page' button is visible below the search form

  Scenario: Verify button redirects to homepage
    Given 'Back to Home Page' button is visible
    When User clicks on the 'Back to Home Page' button
    Then User is redirected to the homepage

  Scenario: Verify homepage loads without errors
    Given 'Back to Home Page' button is visible
    When User clicks on the 'Back to Home Page' button
    Then Homepage loads successfully without any errors

  Scenario: Verify form data is cleared
    Given Search form is present and 'Back to Home Page' button is visible
    When User enters data into the search form and clicks 'Back to Home Page' button
    Then Form data is cleared upon redirection to the homepage

  Scenario: Verify button click with no internet
    Given 'Back to Home Page' button is visible
    When User disables internet connection and clicks 'Back to Home Page' button
    Then Appropriate error message is displayed

  Scenario: Verify button label clarity
    Given 'Back to Home Page' button is visible
    Then Button label is clear and intuitive

  Scenario: Verify button position
    Given 'Back to Home Page' button is visible
    Then Button is located below the search form

  Scenario: Verify button click response time
    Given 'Back to Home Page' button is visible
    When User clicks on the 'Back to Home Page' button
    Then Button click response time is within acceptable limits

  Scenario: Verify button functionality on mobile
    Given 'Back to Home Page' button is visible
    When User accesses the page on a mobile device and clicks 'Back to Home Page' button
    Then Button functions correctly on mobile devices

  Scenario: Verify button functionality on tablet
    Given 'Back to Home Page' button is visible
    When User accesses the page on a tablet and clicks 'Back to Home Page' button
    Then Button functions correctly on tablet devices

  Scenario: Verify button functionality on desktop
    Given 'Back to Home Page' button is visible
    When User accesses the page on a desktop and clicks 'Back to Home Page' button
    Then Button functions correctly on desktop devices

  Scenario: Verify button click during server downtime
    Given 'Back to Home Page' button is visible
    When User simulates server downtime and clicks 'Back to Home Page' button
    Then Appropriate error message is displayed

  Scenario: Verify button accessibility
    Given 'Back to Home Page' button is visible
    When User uses a screen reader to navigate to and clicks 'Back to Home Page' button
    Then Button is accessible via screen readers

  Scenario: Verify button focus
    Given 'Back to Home Page' button is visible
    When User navigates to the 'Back to Home Page' button using the Tab key
    Then Button receives focus when navigated to using the Tab key

  Scenario: Verify button click with unsaved changes
    Given Search form is present and 'Back to Home Page' button is visible
    When User enters data into the search form without saving and clicks 'Back to Home Page' button
    Then Form data is cleared without saving

  Scenario: Verify button hover effect
    Given 'Back to Home Page' button is visible
    When User hovers over the 'Back to Home Page' button
    Then Button displays a hover effect

  Scenario: Verify button click with JavaScript disabled
    Given 'Back to Home Page' button is visible
    When User disables JavaScript in the browser and clicks 'Back to Home Page' button
    Then Appropriate error message is displayed

  Scenario: Verify button click with multiple tabs open
    Given 'Back to Home Page' button is visible
    When User opens multiple tabs of the same page and clicks 'Back to Home Page' button in one tab
    Then Button functions correctly without affecting other tabs

  Scenario: Verify button click with browser back button
    Given 'Back to Home Page' button is visible
    When User clicks 'Back to Home Page' button and then uses the browser back button
    Then User is redirected back to the previous page

  Scenario: Verify button click with form validation errors
    Given Search form is present and 'Back to Home Page' button is visible
    When User enters invalid data into the search form and clicks 'Back to Home Page' button
    Then Form validation errors are ignored and user is redirected to the homepage