package com.step_definition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.Login_Page;
import com.setup.BaseSteps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends BaseSteps {

	Login_Page login_Page;
	ExtentTest extTest = Hooks.extTest;

	@Before("@validlogin")
	public void startBrowser() {
		launchBrowser();
		driver.get("https://www.magicbricks.com/");
		System.out.println(" Browser launched fresh for Valid Login scenario");
	}

	@Given("I launch the magicbricks website")
	public void i_launch_the_magicbricks_website() {
		// browser already launched in Hooks
		System.out.println("Browser launched via Hooks and Magicbricks website opened.");
	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		login_Page = new Login_Page(driver, extTest);
		boolean actResult = login_Page.clickLoginBtn();
		Assert.assertTrue(actResult, "Failed at homepage -> clickLoginBtn()");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		boolean actResult = login_Page.clickInnerLoginBtn();
		Assert.assertTrue(actResult, "Failed at login -> clickInnerLoginBtn()");
	}

	@When("I am redirected to the login page and click on phonenumber")
	public void i_am_redirected_to_the_login_page_and_click_on_phonenumber() {
		boolean switched = login_Page.switchToLoginTab();
		Assert.assertTrue(switched, "Failed to switch to login tab");

		boolean actResult = login_Page.clickPhoneNumber();
		Assert.assertTrue(actResult, "Failed at login -> clickPhoneNumber()");
	}

	@When("I enter the otp")
	public void i_enter_the_otp() {
		boolean actResult = login_Page.enterOtp();
		Assert.assertTrue(actResult, "Failed at login -> enterOtp()");
	}

	@Then("I should be redirected to the homepage")
	public void i_should_be_redirected_to_the_homepage() {
		boolean actResult = login_Page.validateLogin();
		Assert.assertTrue(actResult, "Login validation failed -> User not on homepage");
	}
}