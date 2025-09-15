package com.step_definitions;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.PropertyPhotos_Page;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class PropertyPhotoSteps extends BaseSteps {
	
    ExtentTest extTest = Hooks.extTest;
    PropertyPhotos_Page propertyPhotos;

    @Given("the user is on the shortlisted property details")
    public void the_user_is_on_the_shortlisted_property_details() {
    
    }

    @When("I click the photo gallery")
    public void i_click_the_photo_gallery() {
        propertyPhotos = new PropertyPhotos_Page(driver, Hooks.extTest);
        boolean actResult = propertyPhotos.clickPhotoGallery();
        Assert.assertTrue(actResult, "Failed to click the photo gallery link.");
        BaseSteps.sleep();
    }
    
    @And("photo gallery opens")
    public void photo_gallery_opens() {
        propertyPhotos = new PropertyPhotos_Page(driver, Hooks.extTest);
        boolean actResult = propertyPhotos.isGalleryOpen();
        Assert.assertTrue(actResult, "The photo gallery did not open.");
        BaseSteps.sleep();
    }
    
    @And("I click the first photo")
    public void i_click_the_first_photo() {
        propertyPhotos = new PropertyPhotos_Page(driver, Hooks.extTest);
        boolean actResult = propertyPhotos.clickFirstPhoto();
        Assert.assertTrue(actResult, "Failed to click the first photo.");
        BaseSteps.sleep();
    }
    
    @Then("I click the right arrow to view the photos")
    public void i_click_the_right_arrow_to_view_the_photos() {
        propertyPhotos = new PropertyPhotos_Page(driver, Hooks.extTest);
        boolean actResult = propertyPhotos.clickRightArrow();
        Assert.assertTrue(actResult, "Failed to click the right arrow.");
        BaseSteps.sleep();
    }

    @Then("I close the gallery")
    public void i_close_the_gallery() {
        propertyPhotos = new PropertyPhotos_Page(driver, Hooks.extTest);
        boolean actResult = propertyPhotos.closePhotoGallery();
        Assert.assertTrue(actResult, "Failed to close the photo gallery.");
        BaseSteps.sleep();
    }
}