Feature: Travel Class and One Way Checkbox
  Verify the functionality of the "Travel Class" dropdown and "One Way" checkbox.

  Scenario: Validate "Travel Class" dropdown
    Given the flight search page is open
    When I open the "Travel Class" dropdown
    Then the options "Economy", "Business", and "First" should be displayed

  Scenario: Validate "One Way" checkbox functionality
    Given the flight search page is open
    When I check the "One Way" checkbox
    Then the "Return Date" field should be hidden

  Scenario: Validate "Return Date" reappears
    Given the flight search page is open
    When I uncheck the "One Way" checkbox
    Then the "Return Date" field should reappear