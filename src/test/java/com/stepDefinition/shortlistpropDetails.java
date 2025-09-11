package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.ShorlistedpropDetailsPage;
import com.aventstack.extentreports.ExtentTest;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class shortlistpropDetails extends BaseSteps {
	 //private WebDriver driver;
	ExtentTest extTest = Hooks.extTest;
	ShorlistedpropDetailsPage slpdetails;
	@Given("the user is on the shortlisted property page")
	public void the_user_is_on_the_shortlisted_property_page() {
	   
	}
	@And("I click on the property from shorlisted list")
	public void i_click_on_the_property_from_shorlisted_list() {
		slpdetails = new ShorlistedpropDetailsPage(driver, Hooks.extTest);
		boolean actResult = slpdetails.clickFirstShortlistedProperty();
		Assert.assertTrue(actResult, "Failed to click on the shortlisted property.");
	}
	@Then("I click on photos for viewing and I click back arrow to navigate back")
	public void I_click_on_photos_for_viewing_and_I_click_back_arrow_to_navigate_back() {
		slpdetails = new ShorlistedpropDetailsPage(driver, Hooks.extTest);
		boolean actResult = slpdetails.viewPhotos();
		Assert.assertTrue(actResult, "Failed to click photos.");
	}

	@Then("I validate the contact agent in the property page")
	public void i_validate_the_contact_agent_in_the_property_page() {
		slpdetails = new ShorlistedpropDetailsPage(driver, Hooks.extTest);
		boolean actResult = slpdetails.viewcontactAgentIsPresent();
        Assert.assertTrue(actResult, "View contact Agent element is not present on the property details page:");

	}

}
