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
	@Then("I scrolls down to view property details")
	public void I_scrolls_down_to_view_property_details() {
		slpdetails = new ShorlistedpropDetailsPage(driver, Hooks.extTest);
		boolean actResult = slpdetails.viewPropertyDetails();
		Assert.assertTrue(actResult, "Failed to scroll down to view property details: ");
	}

	@Then("I validate the presence of the offer element")
	public void I_validate_the_presence_of_the_offer_element() {
		slpdetails = new ShorlistedpropDetailsPage(driver, Hooks.extTest);
		boolean actResult = slpdetails.validateOfferElementIsPresent();
        Assert.assertTrue(actResult, "Failed to validate property details:");

	}

}
