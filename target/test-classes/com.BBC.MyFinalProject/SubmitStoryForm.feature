Feature: As User I can submit a question/story to BBC

  Background:
    Given the user open BBC website
    Given the user go to News
    Given the user close popup
    Given the user go to Coronavirus page
    Given the user click on Your Coronavirus Stories
    Given the user click on How to share with BBC News


  Scenario: User fills form for the submit a question/story with empty text field and submit.
  The page should be the same, submission don't work
    When the user fills the Name field with a valid value
    And the user fills the Email field with a valid value
    And the user fills the Phone field with a valid value
    And the user fills the Location field with a valid value
    And the user selects the 'Please don't publish my name' checkbox
    And the user selects the 'I am over 16 years old' checkbox
    And the user selects the 'I accept the Terms of Service' checkbox
    Then url page the same what expected


  Scenario: User fills form for the submit a question/story with empty name field and submit.
  The page should be the same, submission don't work
    When the user fills the Tell us your story field with a valid value
    And the user fills the Email field with a valid value
    And the user fills the Phone field with a valid value
    And the user fills the Location field with a valid value
    And the user selects the 'Please don't publish my name' checkbox
    And the user selects the 'I am over 16 years old' checkbox
    And the user selects the 'I accept the Terms of Service' checkbox
    And the user submit form
    Then url page the same what expected


  Scenario: User fills form for the submit a question/story, but not selects the "I am over 16 years old" checkbox and submit.
  The page should be the same, submission don't work
    When the user fills the Tell us your story field with a valid value
    And the user fills the Name field with a valid value
    And the user fills the Email field with a valid value
    And the user fills the Phone field with a valid value
    And the user fills the Location field with a valid value
    And the user selects the 'Please don't publish my name' checkbox
    And the user selects the 'I accept the Terms of Service' checkbox
    Then url page the same what expected


  Scenario: User fills form for the submit a question/story, but not selects the "I accept the Terms of Service" checkbox and submit.
  The page should be the same, submission don't work
    When the user fills the Tell us your story field with a valid value
    And the user fills the Name field with a valid value
    And the user fills the Email field with a valid value
    And the user fills the Phone field with a valid value
    And the user fills the Location field with a valid value
    And the user selects the 'Please don't publish my name' checkbox
    And the user selects the 'I am over 16 years old' checkbox
    Then url page the same what expected

