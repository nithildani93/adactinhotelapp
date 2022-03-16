Feature: This feature is to verify the user is logged in the adactinhotelapp
  Scenario: This feature is to verify the user is logged in
    Given the user opens the adactin site
    When the user enters the username
    And the user enters the password
    And the user clicks the submit button
    Then the user should be logged in and will able to see his username
	
	Scenario: This scenario is for user to select the desired hotel
    When the user selects the location as "Sydney" by "value"
    And the user selects the hotels as "Hotel Creek" by "value"
    And the user selects the "Standard" option in Room Type by "value"
    And the user selects option "1" as Rooms by "index"
    And the user enters the checkin date as"10/10/2022"
    And the user enters the checkout date as"9/10/2022"
    And the user enters the search button
    Then the user should able to see the list of hotels