Feature: As a user of automationpractice.com, I should be able to register and authenticate with valid credentials

  Background:
    Given user is on the application homepage
    When user clicks on the Sign In button

  @Registration
  Scenario: As a guest user, I should be able to register a new account
    And user enters a valid and unregistered email address in the create an account Email Address input field
    And user clicks Create An Account button
    And user fills out Your Personal Information form and clicks on Register button
    Then user is navigated to My Account page

  @Authentication
  Scenario Outline: As a user, I should be able to see expected authentication results when attempting to login
    And user enters "<email>" in the Already Registered Email Address input field
    And user enters "<password>" in the Password input field
    And user clicks the submit Sign In button
    Then user should see "<expected>" authentication results

  Examples:
  | email        | password | expected      |
  | sami@piit.us | Test123  | auth          |
  | sami         | Test123  | invalid email |
  | sami@piit.us | Test12   | invalid auth  |