
package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.setup.Reporter;

public class PropertyPhotos_Page {

	// Locators
	public static By photos = By.xpath("//*[@id=\"details\"]/div/div[4]/div[1]/div/img");
	public static By firstphoto = By.xpath(
			"//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[1]/div[3]/div/div[1]/div[3]/div/ul/li[1]/img");
	public static By picrightarrow = By.xpath("//*[@id=\"myGallery\"]/div/a/div");
	public static By cross = By.xpath(
			"//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[1]/div[3]/div/div/div/div[1]/div[1]/span[1]/a");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public PropertyPhotos_Page(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		this.extTest = extTest;
	}

	public boolean clickPhotoGallery() {
		try {
			WebElement photosSection = wait.until(ExpectedConditions.elementToBeClickable(photos));
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			// photosSection);
			photosSection.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the photo gallery link.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to click the photo gallery link: " + e.getMessage());
			return false;
		}
	}

	public boolean isGalleryOpen() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(firstphoto));
			Reporter.generateReport(driver, extTest, Status.PASS, "The photo gallery is open.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"The photo gallery failed to open: " + e.getMessage());
			return false;
		}
	}

	public boolean clickFirstPhoto() {
		try {
			WebElement firstPhoto = wait.until(ExpectedConditions.elementToBeClickable(firstphoto));

			firstPhoto.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the first photo.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the first photo: " + e.getMessage());
			return false;
		}
	}

	public boolean clickRightArrow() {
		try {
			WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(picrightarrow));
			rightArrow.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the right arrow.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click the right arrow: " + e.getMessage());
			return false;
		}
	}

	public boolean closePhotoGallery() {
		try {
			WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(cross));
			closeButton.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully closed the photo gallery.");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL,
					"Failed to close the photo gallery: " + e.getMessage());
			return false;
		}
	}
}
