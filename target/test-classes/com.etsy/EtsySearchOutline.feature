@outline
Feature: Etsy Search with Scenario Outline

  Background: Navigate
    Given the user navigates to "https://www.etsy.com/"

  Scenario Outline: Etsy Search Validation
    When the user search with "<searchValue>"
    Then the user should see the title "<title>"
    Examples:
      | searchValue | title       |
      | Hat         | Hat \| Etsy |
      | Key         | Key \| Etsy |
      | Pin         | Pin \| Etsy |

  # control+alt+L to organize file
  # command +option+L for MAC
