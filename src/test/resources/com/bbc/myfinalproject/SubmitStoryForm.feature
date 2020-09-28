Feature: As User I can submit a question/story to BBC

  Background:
    Given the user open BBC website
    And the user go to News
    And the user close popup
    And the user go to Coronavirus page
    And the user click on Your Coronavirus Stories
    And the user click on How to share with BBC News


  Scenario Outline: User fills form for the submit a question/story with empty text field and submit.
  The page should be the same, submission don't work
    When the user fills the "Name" field with a valid value "<name>"
    And the user fills the "Email address" field with a valid value "<email>"
    And the user fills the "Contact number" field with a valid value "<contact number>"
    And the user fills the "Location" field with a valid value "<location>"
    And the user selects the "Please don't publish my name" checkbox
    And the user selects the 'I am over 16 years old' checkbox
    And the user selects the 'I accept the Terms of Service' checkbox
    Then url page the same what expected
    Examples:
      | name    | email                | contact number | location |
      | Kuhulin | IrishYersh@gmail.com | 7559066899     | Dublin   |


  Scenario Outline: User fills form for the submit a question/story with empty name field and submit.
  The page should be the same, submission don't work
    When the user fills the "Story" field with a valid value "<story>"
    And the user fills the "Email address" field with a valid value "<email>"
    And the user fills the "Contact number" field with a valid value "<contact number>"
    And the user fills the "Location" field with a valid value "<location>"
    And the user selects the "Please don't publish my name" checkbox
    And the user selects the "I am over 16 years old" checkbox
    And the user selects the 'I accept the Terms of Service' checkbox
    And the user submit form
    Then url page the same what expected
    Examples:
      | story                                         | email                | contact number | location |
      | Venezuela accused of 'egregious' crimes by UN | IrishYersh@gmail.com | 7559066899     | Dublin   |


  Scenario Outline: User fills form for the submit a question/story, but not selects the "I am over 16 years old" checkbox and submit.
  The page should be the same, submission don't work
    When the user fills the "Story" field with a valid value "<story>"
    And  the user fills the "Name" field with a valid value "<name>"
    And the user fills the "Email address" field with a valid value "<email>"
    And the user fills the "Contact number" field with a valid value "<contact number>"
    And the user fills the "Location" field with a valid value "<location>"
    And the user selects the "Please don't publish my name" checkbox
    And the user selects the "I accept the Terms of Service" checkbox
    Then url page the same what expected
    Examples:
      | story                                         | name    | email                | contact number | location |
      | Venezuela accused of 'egregious' crimes by UN | Kuhulin | IrishYersh@gmail.com | 7559066899     | Dublin   |


  Scenario Outline: User fills form for the submit a question/story, but not selects the "I accept the Terms of Service" checkbox and submit.
  The page should be the same, submission don't work
    When the user fills the "Story" field with a valid value "<story>"
    And  the user fills the "Name" field with a valid value "<name>"
    And the user fills the "Email address" field with a valid value "<email>"
    And the user fills the "Contact number" field with a valid value "<contact number>"
    And the user fills the "Location" field with a valid value "<location>"
    And the user selects the "Please don't publish my name" checkbox
    And the user selects the 'I am over 16 years old' checkbox
    Then url page the same what expected
    Examples:
      | story                                         | name    | email                | contact number | location |
      | Venezuela accused of 'egregious' crimes by UN | Kuhulin | IrishYersh@gmail.com | 7559066899     | Dublin   |

