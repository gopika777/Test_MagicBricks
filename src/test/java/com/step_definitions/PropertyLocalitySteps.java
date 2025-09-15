package com.step_definitions;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.PropertyLocality_Page;

import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropertyLocalitySteps extends BaseSteps {
	PropertyLocality_Page propertyLocality_Page;
	ExtentTest extTest = Hooks.extTest;

	@Given("the user is on the shortlisted property detail page")
	public void the_user_is_on_the_shortlisted_property_detail_page() {
	}

	@When("I click on the {string} section")
	public void I_click_on_the_section(String string) {
		propertyLocality_Page = new PropertyLocality_Page(driver, Hooks.extTest);
		boolean actResult = propertyLocality_Page.clickAboutLocality();
		Assert.assertTrue(actResult, "Failed to click on 'About Locality'.");
		BaseSteps.sleep();
	}

	@When("I click the right arrow to view more locality details")
	public void I_click_the_right_arrow_to_view_more_locality_details() {
		boolean actResult = propertyLocality_Page.clickRightArrow();
		Assert.assertTrue(actResult, "Failed to click the right arrow to view more locality details.");
		BaseSteps.sleep();
	}

	@When("I click on the dropdown to view the ratings")
	public void I_click_on_the_dropdown_to_view_the_ratings() {
		boolean actResult = propertyLocality_Page.clickRatingDropdown();
		Assert.assertTrue(actResult, "Failed to click on the ratings dropdown.");
		BaseSteps.sleep();
	}

	@Then("I scroll up to the top of the page")
	public void I_scroll_up_to_the_top_of_the_page() {
		boolean actResult = propertyLocality_Page.scrollToTop();
		Assert.assertTrue(actResult, "Failed to scroll up to the top of the page.");
		BaseSteps.sleep();
	}

}
