
package com.stepdefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.InvalidFeedbackPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class InvalidFeedbackSteps extends BaseSteps {
    
    ExtentTest extTest = Hooks.extTest;
    InvalidFeedbackPage feedbackPage;
 
    @Given("the user is on shortlisted property details page")
    public void the_user_is_on_shortlisted_property_details_page() {
        // This step is a prerequisite. The previous test steps should have
        // already navigated the user to the correct page.
    }
    
    @When("I click the side bar")
    public void i_click_the_side_bar() {
        feedbackPage = new InvalidFeedbackPage(driver, Hooks.extTest);
        boolean actResult = feedbackPage.clickSideBar();
        Assert.assertTrue(actResult, "Failed to click the side bar.");
        BaseSteps.sleep();
    }

    @And("I click report issue")
    public void i_click_report_issue() {
        feedbackPage = new InvalidFeedbackPage(driver, Hooks.extTest);
        boolean actResult = feedbackPage.clickReportIssue();
        Assert.assertTrue(actResult, "Failed to click 'Report Issue' link.");
        BaseSteps.sleep();
    }
    
    @Then("I submit the feedback form without filling anything")
    public void i_submit_the_feedback_form_without_filling_anything() {
        feedbackPage = new InvalidFeedbackPage(driver, Hooks.extTest);
        boolean actResult = feedbackPage.submitFeedbackWithoutFilling();
        Assert.assertTrue(actResult, "Failed to submit the form without filling.");
        BaseSteps.sleep();
    }
    
    @Then("a validation error message is displayed")
    public void a_validation_error_message_is_displayed() {
        feedbackPage = new InvalidFeedbackPage(driver, Hooks.extTest);
        String errorMessage = feedbackPage.getErrorMessage();
        Assert.assertNotNull(errorMessage, "Validation error message was not displayed.");
        BaseSteps.sleep();
    }
}