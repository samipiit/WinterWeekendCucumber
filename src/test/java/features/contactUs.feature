Feature: Users should be able to send a message to customer service team

  Background:
    Given user is on the application homepage

  Scenario Outline: As a guest, I should be able to submit an inquiry to the customer service team with an uploaded file
    When user clicks on Contact Us button
    And user selects "<subjectHeading>" from subject heading
    And user enters "<emailAddress>" in email address
    And user enters "<refNum>" in order reference number
    And user uploads "<file>"
    And user enters "<message>" in message
    And user clicks Send button
    Then user should see successful submission banner

    Examples:
    |subjectHeading   | emailAddress           | refNum  | file                                     | message         |
    |Customer service | sami@piit.us           | asdj235 | src\\test\\resources\\DummyWord.docx     | TEST - SAMI     |
    |Webmaster        | thuwaiba.dow@gmail.com | 8347@1f | src\\test\\resources\\DummyWord.docx     | TEST - THUWAIBA |
    |Customer service | antenehmaz@gmail.com   | ldsaD29 | src\\test\\resources\\DummyWord.docx     | TEST - ANTENEH  |
    |Webmaster        | yahyaq91@gmail.com     | jklhd45 | src\\test\\resources\\DummyWord.docx     | TEST - YAHYA    |

