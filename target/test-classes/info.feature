Feature: Print info

  Scenario: Validate information
    And the user print firstname
    * the user print lastname
    * the user should see the school name
    But the user print age
