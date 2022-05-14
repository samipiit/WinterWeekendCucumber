package app.pom;

import app.shared.SystemBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends SystemBar {

    @FindBy(id = "id_contact")
    public WebElement subjectHeadingComboBox;

    @FindBy(id = "email")
    public WebElement emailInputField;

    @FindBy(id = "id_order")
    public WebElement orderReferenceInputField;

    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement fileUploadInput;

    @FindBy(id = "submitMessage")
    public WebElement sendButton;

    @FindBy(id = "message")
    public WebElement messageTextArea;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successfulSubmissionBanner;

    public ContactUs() {
        PageFactory.initElements(driver, this);
    }

    public void selectSubjectHeadingByVisibleText(String text) {
        selectFromDropdownByVisibleText(subjectHeadingComboBox, text);
    }

    public void inputEmailAddress(String emailAddress) {
        sendKeysToElement(emailInputField, emailAddress);
    }

    public void inputOrderReferenceNumber(String refNum) {
        sendKeysToElement(orderReferenceInputField, refNum);
    }

    public void setFileToUpload(String path) {
       uploadFile(fileUploadInput, path);
    }

    public void inputMessage(String message) {
        sendKeysToElement(messageTextArea, message);
    }

    public void clickSubmit() {
        clickOnElement(sendButton);
    }

    public String getBannerText() {
        return getTrimmedElementText(successfulSubmissionBanner);
    }
}
