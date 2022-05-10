Feature: As a user of automationpractice.com, I should be able to register and authenticate with valid credentials

  Scenario: As a guest user, I should be able to register a new account
    Given user is on the application homepage
    When user clicks on the Sign In button
    And user enters a valid and unregistered email address in the create an account Email Address input field
    And user clicks Create An Account button
    And user fills out Your Personal Information form and clicks on Register button
    Then user is navigated to My Account page