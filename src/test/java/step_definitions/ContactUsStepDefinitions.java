package step_definitions;

import app.pom.ContactUs;
import app.pom.Homepage;
import base.BasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.File;

public class ContactUsStepDefinitions extends BasePage {

    Homepage homepage = new Homepage();
    ContactUs contactUs = new ContactUs();

    @When("user clicks on Contact Us button")
    public void user_clicks_on_Contact_Us_button() {
        homepage.clickContactButton();
    }

    @And("^user selects \"(.*)\" from subject heading")
    public void user_selects_subject_heading_from_subject_heading(String subject) {
        contactUs.selectSubjectHeadingByVisibleText(subject);
    }

    @And("^user enters \"(.*)\" in email address")
    public void user_enters_email_address(String email) {
        contactUs.inputEmailAddress(email);
    }

    @And("^user enters \"(.*)\" in order reference number")
    public void user_enters_order_reference_number(String refNum) {
        contactUs.inputOrderReferenceNumber(refNum);
    }

    @And("^user uploads \"(.*)\"")
    public void user_uploads_file(String filePath) {
        File file = new File(filePath);
        contactUs.setFileToUpload(file.getAbsolutePath());
    }

    @And("^user enters \"(.*)\" in message")
    public void user_enters_message(String message) {
        contactUs.inputMessage(message);
    }

    @And("user clicks Send button")
    public void user_clicks_Send_button() {
        contactUs.clickSubmit();
    }

    @Then("user should see successful submission banner")
    public void user_should_see_successful_submission_banner() {
        Assert.assertTrue(isElementVisible(contactUs.successfulSubmissionBanner));
    }

}
