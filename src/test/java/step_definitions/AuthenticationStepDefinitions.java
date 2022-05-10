package step_definitions;

import app.pom.CreateAccount;
import app.pom.Homepage;
import app.pom.Login;
import app.pom.MyAccount;
import base.BasePage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateData;

import java.time.Duration;

public class AuthenticationStepDefinitions extends BasePage {

    Homepage homepage = new Homepage();
    Login login = new Login();
    CreateAccount createAccount = new CreateAccount();
    MyAccount myAccount = new MyAccount();

    @Given("user is on the application homepage")
    public void user_is_on_the_application_homepage() {
        driver.get("http://automationpractice.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @When("user clicks on the Sign In button")
    public void user_clicks_on_the_Sign_In_button() {
        homepage.clickLoginButton();
    }

    @And("user enters a valid and unregistered email address in the create an account Email Address input field")
    public void user_enters_a_valid_and_unregistered_email_address_in_the_create_an_account_Email_Address_input_field() {
        login.inputNewEmailAddress(GenerateData.email());
    }

    @And("user clicks Create An Account button")
    public void user_clicks_Create_An_Account_button() {
        login.clickCreateAccountButton();
    }

    @And("user fills out Your Personal Information form and clicks on Register button")
    public void user_fills_out_Your_Personal_Information_form() {
        String[] dob = GenerateData.dateOfBirth();
        String day = dob[0];
        String month = dob[1];
        String year = dob[2];

        createAccount.registerNewUser(GenerateData.firstName(), GenerateData.lastName(), GenerateData.password(),
                day, month, year, GenerateData.streetAddress(), GenerateData.city(), GenerateData.state(),
                GenerateData.zipCode(), GenerateData.mobilePhone());
    }

    @Then("user is navigated to My Account page")
    public void user_is_navigated_to_My_Account_page() {
        Assert.assertTrue(myAccount.isSignedIn());
    }

}
