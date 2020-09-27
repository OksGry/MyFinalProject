Feature: As User I want read articles on news page of BBC website

  Background:
    Given the user open BBC website
    Given the user go to News
    Given the user close popup

  Scenario:
    Then  the name of the headline article to match the expected <title>
    |Madrid at ‘serious risk’ without virus lockdown|

  Scenario:
    Then secondary article titles to match the list of expected titles


  Scenario:
    When stores the text of the Category of the headline article
    And enter this text in the Search bar
    Then the name of the first article include the text of the Category