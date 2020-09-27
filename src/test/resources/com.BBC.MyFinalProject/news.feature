Feature: As User I want read articles on news page of BBC website

  Background:
    Given the user open BBC website
    Given the user go to News
    Given the user close popup

  Scenario: The name of the headline article should match the expected
    Then  the name of the headline article to match the expected <title>
      | Madrid at ‘serious risk’ without virus lockdown |

  Scenario:The secondary article titles should match the expected list of article titles
    Then secondary article titles to match the list of expected titles


  Scenario: The user searches for articles by category.
  The name of the first search result should contains the text of the category, what used for search
    When stores the text of the Category of the headline article
    And enter this text in the Search bar
    Then the name of the first article include the text of the Category