US001 – Search for a One-Way Flight
As a traveler, I want to search for a one-way flight by selecting departure city, destination city,
departure date, number of passengers, and travel class so that I can view available flight options for
a single journey.
Acceptance Criteria:
• From (Departure City): Dropdown with cities (New York, London, Tokyo, Paris, Sydney,
Mumbai, Delhi, Dubai, Singapore). Default = 'Select City'. Mandatory. Error if blank →
'Please select a departure city.'
• To (Destination City): Same as From. Mandatory. Error if blank → 'Please select a
destination city.' If same as 'From' → 'Departure and destination cannot be the same.'
• Departure Date: Calendar picker (month navigation, today highlight, clear). Manual entry in
dd-mm-yyyy allowed. Past dates disabled. Mandatory. Error if blank → 'Please select a
departure date.'
• Return Date: Hidden when 'One Way' is checked.
• Passengers: Numeric input (1–9) with arrows. Default = 1. Error if invalid → 'Please enter
between 1 and 9 passengers.' Not mandatory, defaults to 1.
• Travel Class: Dropdown with Economy (default), Business, First. Not mandatory, defaults
to Economy.
• One Way Checkbox: Unchecked by default. Checked → hides Return Date. Unchecked →
Return Date reappears.
• Search Button: Disabled until all mandatory fields valid. On click, validate inputs. Errors
highlighted below fields. If valid → show results page.
• Results: List of available departure flights with airline, flight number, cities, dates/times,
duration, price (USD). Sorted by departure time. If none → 'No flights available for selected
criteria.'


US002 – Search for a Round-Trip Flight
As a traveler, I want to search for a round-trip flight by selecting departure city, destination city,
departure date, return date, number of passengers, and travel class so that I can view both
departure and return flights.
Acceptance Criteria:
• From & To: Same rules as US1.1 (mandatory, not same, errors).
• Departure Date: Same rules as US1.1 (mandatory, not in past).
• Return Date: Visible if 'One Way' unchecked. Calendar/manual entry in dd-mm-yyyy.
Mandatory. Error if blank → 'Please select a return date.' If ≤ departure date → 'Return
date must be after departure date.'
• Passengers & Travel Class: Same as US1.1.
• Search Button: Disabled until mandatory fields valid. On click, validate inputs (including
return date). Errors shown under invalid fields. If valid → load results.
• Results: Show Departure Flights + Return Flights separately. Each includes airline, flight
number, times, duration, price. Sorted by departure time. If none in a section → 'No flights
available for selected criteria.'


US003 – Navigate Back to Home Page
As a traveler, I want to click the 'Back to Home Page' button so that I can return to the main landing
page of the site.
Acceptance Criteria:
• Button 'Back to Home Page' appears under search form.
• On click → redirect to homepage.
• Homepage loads without errors.
• Previously entered form data cleared.
