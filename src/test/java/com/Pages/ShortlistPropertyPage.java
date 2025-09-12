package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

public class ShortlistPropertyPage {

	public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[1]");
	public static By mostrecent = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[3]");

	public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
	public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");

	public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
	public static By shortlistButton = By.xpath("//*[@id=\"cardid42927687\"]/div/div[1]/div[2]/span[2]");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public ShortlistPropertyPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.extTest = extTest;
	}

	public boolean viewShortlistedProperties() {
		try {
			WebElement ViewShortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(viewShortlistBtn));
			ViewShortlistBtn.click();

			// Get all window handles
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(allWindowHandles);

			// Switch to the new tab (assuming it's the second one)
			if (tabs.size() > 1) {
				driver.switchTo().window(tabs.get(tabs.size() - 1));
				Reporter.generateReport(driver, extTest, Status.PASS,
						"Shortlisted Property page. Current URL: " + driver.getCurrentUrl());
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL,
						"Failed to switch to a new tab. Only one tab was found.");
				return false;
			}

			// Validate the presence of the new tab's header using the specific locator
			WebElement shortlistedTabHeader = wait
					.until(ExpectedConditions.visibilityOfElementLocated(shortlistTabHeader));
			if (shortlistedTabHeader.isDisplayed()) {
				Reporter.generateReport(driver, extTest, Status.PASS,
						"Successfully navigated to the shortlisted properties");
				return true;
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL,
						"Failed to navigate to the shortlisted properties page. Header not found.");
				return false;
			}
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to view shortlisted properties: " + e.getMessage());
			return false;
		}
	}

	public boolean sortByFilter() {

		try {

			WebElement shortlistBtn1 = wait.until(ExpectedConditions.elementToBeClickable(sortBy));
			shortlistBtn1.click();
			WebElement shortlistBtn2 = wait.until(ExpectedConditions.elementToBeClickable(mostrecent));
			shortlistBtn2.click();
			Reporter.generateReport(driver, extTest, Status.PASS, "Sortby most recent filter clicked");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click the main shortlist button: " + e.getMessage());
			return false;
		}
	}

	public boolean shortlistPropertyFromList() {
		try {

			WebElement shortlistBtn3 = wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
			shortlistBtn3.click();
			WebElement shortlistBtn = wait.until(ExpectedConditions.elementToBeClickable(mainshortlistbtn));
			shortlistBtn.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the main shortlist button.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click the main shortlist button: " + e.getMessage());
			return false;
		}
	}

}