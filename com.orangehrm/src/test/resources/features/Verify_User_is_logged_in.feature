Feature: This feature is to verify the user is logged in the adactinhotelapp 
  Scenario Outline: This feature is to verify the user is logged in 
   Given the user opens the adactin site
   When the user enters the username as "<username>"
   And the user enters the password as "<password>"
   And the user clicks the submit button
   Then the user should be logged in and will able to see his username
    Examples: 
      |username|password|
      |nithil1234|nithil1234|
