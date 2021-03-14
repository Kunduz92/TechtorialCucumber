Feature: Print personal information

// In cucumber we have only annotation Given, When, Then

  Scenario: Print info
    Given the user print firstname
    When the user print lastname
    Then the user should see the fullname
    And the user print state
    * the user print age
    But the user should see the school name