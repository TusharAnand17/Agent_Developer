Feature: Back to Home Page Functionality

  Scenario: Verify 'Back to Home Page' button presence
    Given the user is on the search form page
    When the user views the page
    Then the 'Back to Home Page' button should be visible under the search form

  Scenario: Verify redirection to homepage on button click
    Given the user is on the search form page
    When the user clicks the 'Back to Home Page' button
    Then the user should be redirected to the homepage

  Scenario: Verify homepage loads without errors
    Given the user is on the search form page
    When the user clicks the 'Back to Home Page' button
    Then the homepage should load successfully without any errors

  Scenario: Verify previously entered form data is cleared
    Given the user has entered data into the search form
    When the user clicks the 'Back to Home Page' button
    Then the previously entered form data should be cleared

  Scenario: Verify button alignment under search form
    Given the user is on the search form page
    When the user inspects the alignment of the 'Back to Home Page' button
    Then the button should be properly aligned under the search form

  Scenario: Verify button click when homepage is unavailable
    Given the homepage server is down
    When the user clicks the 'Back to Home Page' button
    Then an error message 'Unable to load homepage. Please try again later.' should be displayed

  Scenario: Verify button click when user session expires
    Given the user session has expired
    When the user clicks the 'Back to Home Page' button
    Then the user should be redirected to the login page or an error message 'Session expired.' should be displayed

  Scenario: Verify button click with unauthorized access
    Given the user has unauthorized access
    When the user clicks the 'Back to Home Page' button
    Then the user should be redirected to the login page or an error message 'Unauthorized access.' should be displayed

  Scenario: Verify button click response time
    Given the user is on the search form page
    When the user clicks the 'Back to Home Page' button
    Then the homepage should load within acceptable response time (e.g., less than 2 seconds)

  Scenario: Verify button label clarity
    Given the user is on the search form page
    When the user inspects the label of the 'Back to Home Page' button
    Then the button label should be clear and understandable

  Scenario: Verify button functionality across browsers
    Given the user is using different browsers (Chrome, Firefox, Edge)
    When the user clicks the 'Back to Home Page' button
    Then the button should function correctly on all tested browsers

  Scenario: Verify button functionality on mobile devices
    Given the user is using a mobile device
    When the user clicks the 'Back to Home Page' button
    Then the button should function correctly on all tested mobile devices

  Scenario: Verify button accessibility compliance
    Given the user is on the search form page
    When the user inspects the 'Back to Home Page' button for accessibility compliance
    Then the button should meet accessibility standards (e.g., ARIA labels, keyboard navigation)

  Scenario: Verify button click with invalid URL redirection
    Given the homepage URL is invalid
    When the user clicks the 'Back to Home Page' button
    Then an error message 'Invalid URL. Unable to redirect.' should be displayed

  Scenario: Verify button click with slow network
    Given the network conditions are slow
    When the user clicks the 'Back to Home Page' button
    Then the homepage should load successfully but with a delayed response