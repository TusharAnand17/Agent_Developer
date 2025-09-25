# US001_Search_For_A_One_Way_Flight

---

## Test Cases

**Source:**  
- **File Name:** US001_Search_For_A_One_Way_Flight_testCases.xlsx  
- **Bucket:** agentdeveloper-testcases  

**Content:**  

| ID  | Work Item Type | Title                          | Test Step | Step Action                                            | Step Expected                                        | Test Description                     | Prerequisites   | Test Data       | Test Type | Test Complexity | Automation Status | Priority | Assigned To |
|-----|----------------|--------------------------------|-----------|-------------------------------------------------------|-----------------------------------------------------|--------------------------------------|-----------------|-----------------|-----------|-----------------|-------------------|----------|-------------|
| TC1 | Functional     | Verify default values for all fields | 1 | Open the flight search page | Default values are set: 'From' = 'Select City', 'To' = 'Select City', 'Passengers' = 1, 'Travel Class' = Economy | Verify default values for all fields | Application is deployed and accessible | None | Positive | Low | Automatable | High | Unassigned |
| TC2 | Functional     | Validate mandatory 'From' field | 1 | Leave 'From' field blank and click 'Search' | Error message: 'Please select a departure city.' | Validate error message when 'From' field is left blank | Application is deployed and accessible | 'From' = blank | Negative | Medium | Automatable | High | Unassigned |
| TC3 | Functional     | Validate mandatory 'To' field | 1 | Leave 'To' field blank and click 'Search' | Error message: 'Please select a destination city.' | Validate error message when 'To' field is left blank | Application is deployed and accessible | 'To' = blank | Negative | Medium | Automatable | High | Unassigned |
| TC4 | Functional     | Validate 'From' and 'To' cannot be the same | 1 | Select the same city for 'From' and 'To' fields and click 'Search' | Error message: 'Departure and destination cannot be the same.' | Validate error message when 'From' and 'To' fields have the same value | Application is deployed and accessible | 'From' = 'New York', 'To' = 'New York' | Negative | Medium | Automatable | High | Unassigned |
| TC5 | Functional     | Validate mandatory 'Departure Date' field | 1 | Leave 'Departure Date' blank and click 'Search' | Error message: 'Please select a departure date.' | Validate error message when 'Departure Date' field is left blank | Application is deployed and accessible | 'Departure Date' = blank | Negative | Medium | Automatable | High | Unassigned |
| TC6 | Functional     | Validate past dates disabled in calendar | 1 | Open the calendar picker and try selecting a past date | Past dates are disabled and cannot be selected | Validate that past dates are disabled in the calendar picker | Application is deployed and accessible | None | Negative | Medium | Automatable | Medium | Unassigned |
| TC7 | Functional     | Validate numeric input for 'Passengers' | 1 | Enter a non-numeric value in 'Passengers' field and click 'Search' | Error message: 'Please enter between 1 and 9 passengers.' | Validate error message when non-numeric value is entered in 'Passengers' field | Application is deployed and accessible | 'Passengers' = 'abc' | Negative | Medium | Automatable | Medium | Unassigned |
| TC8 | Functional     | Validate boundary value for 'Passengers' | 1 | Enter 0 in 'Passengers' field and click 'Search' | Error message: 'Please enter between 1 and 9 passengers.' | Validate error message when 'Passengers' field is below the minimum value | Application is deployed and accessible | 'Passengers' = 0 | Negative | Medium | Automatable | Medium | Unassigned |
| TC9 | Functional     | Validate upper boundary for 'Passengers' | 1 | Enter 10 in 'Passengers' field and click 'Search' | Error message: 'Please enter between 1 and 9 passengers.' | Validate error message when 'Passengers' field exceeds the maximum value | Application is deployed and accessible | 'Passengers' = 10 | Negative | Medium | Automatable | Medium | Unassigned |
| TC10 | Functional     | Validate valid 'Passengers' input | 1 | Enter 5 in 'Passengers' field and click 'Search' | Search is successful and results are displayed | Validate successful search with valid 'Passengers' input | Application is deployed and accessible | 'Passengers' = 5 | Positive | Medium | Automatable | High | Unassigned |
| TC11 | Functional     | Validate default 'Travel Class' selection | 1 | Open the flight search page | 'Travel Class' is set to 'Economy' by default | Validate default selection of 'Travel Class' | Application is deployed and accessible | None | Positive | Low | Automatable | Low | Unassigned |
| TC12 | Functional     | Validate 'One Way' checkbox functionality | 1 | Check the 'One Way' checkbox | 'Return Date' field is hidden | Validate that 'Return Date' field is hidden when 'One Way' checkbox is checked | Application is deployed and accessible | 'One Way' = checked | Positive | Medium | Automatable | Medium | Unassigned |
| TC13 | Functional     | Validate 'Return Date' reappears | 1 | Uncheck the 'One Way' checkbox | 'Return Date' field reappears | Validate that 'Return Date' field reappears when 'One Way' checkbox is unchecked | Application is deployed and accessible | 'One Way' = unchecked | Positive | Medium | Automatable | Medium | Unassigned |
| TC14 | Functional     | Validate search button disabled initially | 1 | Open the flight search page | 'Search' button is disabled | Validate that 'Search' button is disabled until all mandatory fields are valid | Application is deployed and accessible | None | Positive | Low | Automatable | High | Unassigned |
| TC15 | Functional     | Validate search button enabled after input | 1 | Fill all mandatory fields with valid data | 'Search' button is enabled | Validate that 'Search' button is enabled when all mandatory fields are valid | Application is deployed and accessible | 'From' = 'New York', 'To' = 'London', 'Departure Date' = '15-12-2023' | Positive | Medium | Automatable | High | Unassigned |
| TC16 | Functional     | Validate error for invalid date format | 1 | Enter an invalid date format in 'Departure Date' field and click 'Search' | Error message: 'Please select a valid departure date.' | Validate error message when an invalid date format is entered in 'Departure Date' field | Application is deployed and accessible | 'Departure Date' = '2023/12/15' | Negative | Medium | Automatable | Medium | Unassigned |
| TC17 | Functional     | Validate no flights available message | 1 | Enter valid data but no flights exist for the criteria | Message: 'No flights available for selected criteria.' | Validate message displayed when no flights are available for the selected criteria | Application is deployed and accessible | 'From' = 'New York', 'To' = 'Tokyo', 'Departure Date' = '15-12-2023' | Positive | Medium | Automatable | Medium | Unassigned |
| TC18 | Functional     | Validate results sorting by departure time | 1 | Perform a search with valid data | Results are sorted by departure time | Validate that search results are sorted by departure time | Application is deployed and accessible | 'From' = 'New York', 'To' = 'London', 'Departure Date' = '15-12-2023' | Positive | Medium | Automatable | Medium | Unassigned |
| TC19 | Functional     | Validate clear button in calendar picker | 1 | Open the calendar picker and click 'Clear' | 'Departure Date' field is cleared | Validate that 'Clear' button in calendar picker clears the 'Departure Date' field | Application is deployed and accessible | None | Positive | Low | Automatable | Low | Unassigned |
| TC20 | Functional     | Validate today highlight in calendar picker | 1 | Open the calendar picker | Today's date is highlighted | Validate that today's date is highlighted in the calendar picker | Application is deployed and accessible | None | Positive | Low | Automatable | Low | Unassigned |

---

## RTM

**Source:**  
- **File Name:** US001_Search_For_A_One_Way_Flight_RTM.xlsx  
- **Bucket:** agentdeveloper-rtm  

**Content:**  

| User Story ID | User Story Name                | Acceptance Criteria                             | Test Case ID | Test Case Title                    | Priority | Execution Status | Defect ID(s) | Remarks / Gaps |
|---------------|--------------------------------|------------------------------------------------|--------------|------------------------------------|----------|------------------|---------------|----------------|
| US1.1         | Search for a One-Way Flight   | AC1: Valid 'From' & 'To' dropdown validation.  | TC1          | Verify default values for all fields | High     | Not Executed     | -             | -              |
| US1.2         | Search for a One-Way Flight   | AC2: Mandatory 'From' field validation.        | TC2          | Validate mandatory 'From' field    | High     | Not Executed     | -             | -              |
| US1.3         | Search for a One-Way Flight   | AC3: Mandatory 'To' field validation.          | TC3          | Validate mandatory 'To' field      | High     | Not Executed     | -             | -              |
| US1.4         | Search for a One-Way Flight   | AC4: 'From' and 'To' cannot be the same.       | TC4          | Validate 'From' and 'To' cannot be the same | High     | Not Executed     | -             | -              |
| US1.5         | Search for a One-Way Flight   | AC5: Mandatory 'Departure Date' field validation. | TC5          | Validate mandatory 'Departure Date' field | High     | Not Executed     | -             | -              |
| US1.6         | Search for a One-Way Flight   | AC6: Past dates disabled in calendar picker.   | TC6          | Validate past dates disabled in calendar | Medium   | Not Executed     | -             | -              |
| US1.7         | Search for a One-Way Flight   | AC7: Numeric input validation for 'Passengers'. | TC7          | Validate numeric input for 'Passengers' | Medium   | Not Executed     | -             | -              |
| US1.8         | Search for a One-Way Flight   | AC8: Boundary value validation for 'Passengers'. | TC8          | Validate boundary value for 'Passengers' | Medium   | Not Executed     | -             | -              |
| US1.9         | Search for a One-Way Flight   | AC9: Upper boundary validation for 'Passengers'. | TC9          | Validate upper boundary for 'Passengers' | Medium   | Not Executed     | -             | -              |
| US1.10        | Search for a One-Way Flight   | AC10: Valid 'Passengers' input.                | TC10         | Validate valid 'Passengers' input  | High     | Not Executed     | -             | -              |
| US1.11        | Search for a One-Way Flight   | AC11: Default 'Travel Class' selection.        | TC11         | Validate default 'Travel Class' selection | Low      | Not Executed     | -             | -              |
| US1.12        | Search for a One-Way Flight   | AC12: 'One Way' checkbox functionality.        | TC12         | Validate 'One Way' checkbox functionality | Medium   | Not Executed     | -             | -              |
| US1.13        | Search for a One-Way Flight   | AC13: 'Return Date' reappears when 'One Way' unchecked. | TC13         | Validate 'Return Date' reappears   | Medium   | Not Executed     | -             | -              |
| US1.14        | Search for a One-Way Flight   | AC14: Search button disabled initially.        | TC14         | Validate search button disabled initially | High     | Not Executed     | -             | -              |
| US1.15        | Search for a One-Way Flight   | AC15: Search button enabled after valid input. | TC15         | Validate search button enabled after input | High     | Not Executed     | -             | -              |
| US1.16        | Search for a One-Way Flight   | AC16: Error for invalid date format.           | TC16         | Validate error for invalid date format | Medium   | Not Executed     | -             | -              |
| US1.17        | Search for a One-Way Flight   | AC17: No flights available message.            | TC17         | Validate no flights available message | Medium   | Not Executed     | -             | -              |
| US1.18        | Search for a One-Way Flight   | AC18: Results sorting by departure time.       | TC18         | Validate results sorting by departure time | Medium   | Not Executed     | -             | -              |
| US1.19        | Search for a One-Way Flight   | AC19: Clear button in calendar picker.         | TC19         | Validate clear button in calendar picker | Low      | Not Executed     | -             | -              |
| US1.20        | Search for a One-Way Flight   | AC20: Today highlight in calendar picker.      | TC20         | Validate today highlight in calendar picker | Low      | Not Executed     | -             | -              |