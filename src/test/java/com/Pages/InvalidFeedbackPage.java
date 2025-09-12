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

public class InvalidFeedbackPage {

	// Locators
	public static By sidebar = By.xpath("//*[@id=\"details\"]/div/div[1]/div[2]");
	public static By reportissue = By.xpath("//li[text()='Report an issue']");
	public static By clickno = By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[4]/div/div/div/div/div[2]/span[2]");
	public static By feedbacksumbit = By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[4]/div/div/div/div[3]/span");
	public static By errormsg = By.xpath("//*[@id=\"propertyDetail\"]/div[4]/div[4]/div/div/div/div[2]/div[3]");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public InvalidFeedbackPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		this.extTest = extTest;
	}

	public boolean clickSideBar() {
		try {
			WebElement sideBar = wait.until(ExpectedConditions.visibilityOfElementLocated(sidebar));

			sideBar.click();
			org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
			actions.moveToElement(sideBar).perform();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the side bar.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the side bar: " + e.getMessage());
			return false;
		}
	}

	public boolean clickReportIssue() {
		try {
			WebElement reportIssueLink = wait.until(ExpectedConditions.visibilityOfElementLocated(reportissue));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reportIssueLink);
			try {
				reportIssueLink.click();
			} catch (Exception e) {
				// fallback if normal click fails
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", reportIssueLink);
			}

			WebElement clickNo = wait.until(ExpectedConditions.elementToBeClickable(clickno));
			clickNo.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked 'Report Issue' link.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click 'Report Issue' link: " + e.getMessage());
			return false;
		}
	}

	public boolean submitFeedbackWithoutFilling() {
		try {
			WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(feedbacksumbit));

			submitButton.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Submit' button.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click the 'Submit' button: " + e.getMessage());
			return false;
		}
	}

	public String getErrorMessage() {
		try {
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errormsg));
			Reporter.generateReport(driver, extTest, Status.PASS, "Validation error message is present.");
			return errorMessage.getText();
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Validation error message not found: " + e.getMessage());
			return null;
		}
	}
}
