Feature: Back to Home Page Button Functionality
  As a user, I want to ensure the "Back to Home Page" button works correctly across various scenarios.

  Scenario: Verify 'Back to Home Page' button exists
    Given the flight search page is open
    Then the "Back to Home Page" button should be visible below the search form

  Scenario: Verify button redirects to homepage
    Given the flight search page is open
    When I click on the "Back to Home Page" button
    Then I should be redirected to the homepage

  Scenario: Verify homepage loads without errors
    Given the flight search page is open
    When I click on the "Back to Home Page" button
    Then the homepage should load successfully without any errors

  Scenario: Verify form data is cleared
    Given the flight search page is open
    When I enter data into the search form and click the "Back to Home Page" button
    Then the form data should be cleared upon redirection to the homepage

  Scenario: Verify button click with no internet
    Given the flight search page is open
    When I disable the internet connection and click the "Back to Home Page" button
    Then an appropriate error message should be displayed

  Scenario: Verify button label clarity
    Given the flight search page is open
    Then the "Back to Home Page" button label should be clear and intuitive

  Scenario: Verify button position
    Given the flight search page is open
    Then the "Back to Home Page" button should be located below the search form

  Scenario: Verify button click response time
    Given the flight search page is open
    When I click on the "Back to Home Page" button
    Then the button click response time should be within acceptable limits

  Scenario: Verify button functionality on mobile
    Given the flight search page is open on a mobile device
    When I click on the "Back to Home Page" button
    Then the button should function correctly on mobile devices

  Scenario: Verify button functionality on tablet
    Given the flight search page is open on a tablet device
    When I click on the "Back to Home Page" button
    Then the button should function correctly on tablet devices

  Scenario: Verify button functionality on desktop
    Given the flight search page is open on a desktop device
    When I click on the "Back to Home Page" button
    Then the button should function correctly on desktop devices

  Scenario: Verify button click during server downtime
    Given the flight search page is open
    When I simulate server downtime and click the "Back to Home Page" button
    Then an appropriate error message should be displayed

  Scenario: Verify button accessibility
    Given the flight search page is open
    When I use a screen reader to navigate to and click the "Back to Home Page" button
    Then the button should be accessible via screen readers

  Scenario: Verify button focus
    Given the flight search page is open
    When I use the Tab key to navigate to the "Back to Home Page" button
    Then the button should receive focus

  Scenario: Verify button click with unsaved changes
    Given the flight search page is open
    When I enter data into the search form without saving and click the "Back to Home Page" button
    Then the form data should be cleared without saving

  Scenario: Verify button hover effect
    Given the flight search page is open
    When I hover over the "Back to Home Page" button
    Then the button should display a hover effect

  Scenario: Verify button click with JavaScript disabled
    Given the flight search page is open
    When I disable JavaScript in the browser and click the "Back to Home Page" button
    Then an appropriate error message should be displayed

  Scenario: Verify button click with multiple tabs open
    Given the flight search page is open in multiple tabs
    When I click the "Back to Home Page" button in one tab
    Then the button should function correctly without affecting other tabs

  Scenario: Verify button click with browser back button
    Given the flight search page is open
    When I click the "Back to Home Page" button and then use the browser back button
    Then I should be redirected back to the previous page

  Scenario: Verify button click with form validation errors
    Given the flight search page is open
    When I enter invalid data into the search form and click the "Back to Home Page" button
    Then form validation errors should be ignored and I should be redirected to the homepage