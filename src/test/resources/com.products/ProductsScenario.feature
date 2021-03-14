Feature: Validation of Products Page

  @products
  Scenario: Validation of New Product Creation
    Given the user navigates to product website home page
    Then the user enters the product info "MyMoney" and "4"
    When the user enters the address info "Techtorial", "2200 E Devon", "Des Plaines", "IL", "60018"
    * the user enters the card info "Visa", "123456789", "04/22"
    And the user validate success message
    Then the user validates product details "MyMoney", "4" , "Techtorial" , "2200 E Devon" , "Des Plaines" , "IL" , "60018", "Visa" , " 123456789 ", "04/22 "

  @products @outline
  Scenario Outline: Validation of New Product Creation
    Given the user navigates to product website home page
    Then the user enters the product info "<productName>" and "<quantity>"
    When the user enters the address info "<name>", "<street>>", "<city>", "<state>", "<zip>"
    * the user enters the card info "<cardType>", "<cardNumber>", "<expireDate>"
    And the user validate success message
    Then the user validates product details "<productName>", "<quantity>" , "<name>" , "<street>>" , "<city>" , "<state>" , "<zip>" , "<cardType>" , "<cardNumber>" , "<expireDate>"
    Examples:
      | productName | quantity | name       | street       | city        | state | zip   | cardType        | cardNumber | expireDate |
      | MyMoney     | 4        | Techtorial | 22 E Devon   | Des Plaines | IL    | 60018 | Visa            | 123456789  | 04/22      |
      | FamilyAlbum | 2        | Academy    | 22 E Devon   | Austin      | TX    | 12345 | MasterCard      | 123456543  | 06/26      |
      | ScreenSaver | 3        | Techtorial | 23 Medway rd | Phila       | PA    | 19115 | American Express | 12354322   | 09/24      |




