package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.setup.Reporter;

public class PropertyLocalityPage {

	// Locators
	public static By aboutloc = By.xpath("//*[@id=\"stickyWebHeader\"]/div/div/div[2]/nav/ul/li[3]/a");
	public static By rightarrow = By.xpath("//*[@id=\"swiper-button-next\"]");
	public static By rating = By
			.xpath("//*[@id=\"localityDetailTabId\"]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/span");

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
			WebElement aboutLocalityBtn = wait.until(ExpectedConditions.elementToBeClickable(aboutloc));
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
			WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(rightarrow));
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
			WebElement ratingDropdown = wait.until(ExpectedConditions.elementToBeClickable(rating));
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