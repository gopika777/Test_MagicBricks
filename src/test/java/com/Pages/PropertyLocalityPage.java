package com.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class PropertyLocalityPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public PropertyLocalityPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.extTest = extTest;
	}


	public boolean clickAboutLocality() {
		try {
			// Wait for the 'About Locality' element to be visible and clickable.
			WebElement aboutLocalityBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.aboutloc));
			aboutLocalityBtn.click();
			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked About Locality.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click on 'About Locality': " + e.getMessage());
			return false;
		}
	}


	public boolean clickRightArrow() {
		try {
			// Wait for the right arrow element to be clickable.
			WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(Locators.rightarrow));
			rightArrow.click();
			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the right arrow.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the right arrow: " + e.getMessage());
			return false;
		}
	}


	public boolean clickRatingDropdown() {
		try {
			// Wait for the ratings dropdown to be clickable.
			WebElement ratingDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.rating));
			ratingDropdown.click();
			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the ratings dropdown.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click the ratings dropdown: " + e.getMessage());
			return false;
		}
	}


	public boolean scrollToTop() {
		try {
			// Use JavascriptExecutor to scroll the page to the top.
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully scrolled to the top of the page.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to scroll to the top of the page: " + e.getMessage());
			return false;
		}
	}
}