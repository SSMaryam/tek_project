package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import utility.FakeData;
import utility.SeleniumUtility;

import java.util.Map;

public class CreateAccountSteps extends SeleniumUtility {
    @When("click on {string} button")
    public void click_on_button(String linkText) {
    clickOnElement(HomePage.getLinkLocator(linkText));
    }

    @Then("validate section title to be {string}")
    public void validate_section_title_to_be(String expectedTitle) {
        String actualTitle = getElementText(HomePage.SECTION_TITLE);
        Assert.assertEquals("Section Title ",expectedTitle, actualTitle);

    }
    @When("fill up create account form")
    public void fill_up_create_account_form(DataTable dataTable) {
       Map<String, String> data = dataTable.asMap();
       String firstName = data.get("firstName");
       String lastName = data.get("lastName");
       String email = data.get("email").equals("random") ? FakeData.emailAddress(firstName , lastName)
               : data.get("email");
       // store email address to recorder map
        recorder.put("email" , email);
        recorder.put("fullName", firstName +" " + lastName);
       sendText(CreateAccountPage.emailInput, email);
       sendText(CreateAccountPage.firstNameInput, firstName);
       sendText(CreateAccountPage.lastNameInput, lastName);
       sendText(CreateAccountPage.employmentInput, data.get("employmentStatus"));
       sendText(CreateAccountPage.dobInput, data.get("dob"));
       selectFromDropDown(CreateAccountPage.prefixSelect, data.get("prefix"));
       selectFromDropDown(CreateAccountPage.genderSelect, data.get("gender"));
       selectFromDropDown(CreateAccountPage.maritalStatusSelect, data.get("maritalStatus"));
    }
    @When("click on {string} icon")
    public void click_on_icon(String buttonText) {

    }
    @Then("validate title to be {string}")
    public void validate_title_to_be(String string) {


    }
    @Then("validate created fullName and email")
    public void validate_created_fullName_and_email() {
        String expectedEmail =recorder.get("email");
        String actualEmail = getElementText(CreateAccountPage.emailInput);
        Assert.assertEquals("Validate created email", expectedEmail, actualEmail);
        String expectedName = recorder.get("fullName");
        String actualName = recorder.get(CreateAccountPage.fullNameTitle);
        Assert.assertEquals("Validate created name", expectedName, actualName);
    }
    @When("send text {string} to {string} field")
    public void send_text_to_field(String text, String field) throws InterruptedException {
        // to avoid creation of same username
        if(text.equalsIgnoreCase("random")){
            String email = recorder.get("email");
            text = email.substring(0, email.indexOf("@"));
           // recorder.put("username" , email);
        }
        sendText(CreateAccountPage.getInputLocator(field), text);
        Thread.sleep(5000);
    }
}
