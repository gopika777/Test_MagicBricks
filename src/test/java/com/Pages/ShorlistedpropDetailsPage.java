package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

public class ShorlistedPropDetailsPage {

	public static By shortlistedPropertyCard2 = By.xpath("//*[@id=\"cardid81259709\"]/div[2]/div[1]");
	public static By offerElement = By.xpath("//*[@id=\"more-details\"]/div[2]/ul/li[4]/div[2]/a/div[1]");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public ShorlistedPropDetailsPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		this.extTest = extTest;
	}

	public boolean clickFirstShortlistedProperty() {

		try {
			// Use the more specific locator for the first property
			WebElement property = wait.until(ExpectedConditions.elementToBeClickable(shortlistedPropertyCard2));

			property.click();
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);

			if (tabs.size() > 1) {
				driver.switchTo().window(tabs.get(tabs.size() - 1));
				Reporter.generateReport(driver, extTest, Status.PASS,
						"Switched to the property details tab.Current URL: " + driver.getCurrentUrl());
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the property details tab.");
				return false;
			}

			Reporter.generateReport(driver, extTest, Status.PASS, "Selected first shortlisted property.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click on the first shortlisted property: " + e.getMessage());
			return false;
		}
	}

	public boolean viewPropertyDetails() {
		try {
			// Scroll down the page to bring the details section into view.
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

			Reporter.generateReport(driver, extTest, Status.PASS,
					"Successfully scrolled down to view property details.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to scroll down to view property details: " + e.getMessage());
			return false;
		}
	}

	public boolean validateOfferElementIsPresent() {
		try {
			// Wait until the 'Offer' element is visible on the page
			WebElement OfferElement = wait.until(ExpectedConditions.visibilityOfElementLocated(offerElement));

			// Validate that the 'Offer' element is displayed
			if (OfferElement.isDisplayed()) {
				Reporter.generateReport(driver, extTest, Status.PASS,
						"Validation successful: 'Offer' element is present on the property details page.");
				return true;
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL,
						"Validation failed: 'Offer' element is not displayed.");
				return false;
			}
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to validate property details: " + e.getMessage());
			return false;
		}
	}
}
