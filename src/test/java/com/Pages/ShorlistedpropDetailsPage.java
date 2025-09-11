package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class ShorlistedpropDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public ShorlistedpropDetailsPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		this.extTest = extTest;
	}

	public boolean clickFirstShortlistedProperty() {
		
		try {
			// Use the more specific locator for the first property
			WebElement property = wait
					.until(ExpectedConditions.elementToBeClickable(Locators.shortlistedPropertyCard2));
		

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", property);
			// property.click();
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

//	public boolean viewPhotos() {
//		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		try {
//
//			WebElement viewphotos = wait.until(ExpectedConditions.elementToBeClickable(Locators.photos));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewphotos);
//
//			WebElement clickphoto = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstphoto));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickphoto);
//			// viewphotos.click();
//
//			WebElement right = wait.until(ExpectedConditions.elementToBeClickable(Locators.rightarrow));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", right);
//
//			WebElement close = wait.until(ExpectedConditions.elementToBeClickable(Locators.cross));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
//
////			WebElement navback = wait.until(ExpectedConditions.elementToBeClickable(Locators.navback));
////			((JavascriptExecutor) driver).executeScript("arguments[0].click();", navback);
//
//			// navback.click();
//			// driver.navigate().back();
//
//			Reporter.generateReport(driver, extTest, Status.PASS, "Successfully viewed the photos of property");
//			return true;
//		} catch (Exception e) {
//			Reporter.generateReport(driver, extTest, Status.FAIL,
//					"Failed to view the photos of property " + e.getMessage());
//			return false;
//		}
//	}

	/*
	 * public public boolean navBack() { try {
	 * 
	 * WebElement navback =
	 * wait.until(ExpectedConditions.elementToBeClickable(Locators.mainshortlistbtn)
	 * ); navback.click();
	 * 
	 * Reporter.generateReport(driver, extTest, Status.PASS,
	 * "Successfullynavigated back to shorlisted property"); return true; } catch
	 * (Exception e) { Reporter.generateReport(driver, extTest, Status.FAIL,
	 * "Failed to view the photos of property " + e.getMessage()); return false; } }
	 */

//	public boolean viewcontactAgentIsPresent() {
//
//		try {
//			WebElement contactagent = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contactagent));
//			if (contactagent.isDisplayed()) {
//				// change Successfully navigated to the shortlisted property details page
//				Reporter.generateReport(driver, extTest, Status.PASS,
//						"View contact Agent element is present on the property details page:");
//				return true;
//			} else {
//				Reporter.generateReport(driver, extTest, Status.FAIL,
//						"View contact Agent element is not present on the property details page:");
//				return false;
//			}
//		} catch (Exception e) {
//			Reporter.generateReport(driver, extTest, Status.FAIL,
//					"Failed to switch to the shortlisted property details tab " + e.getMessage());
//			return false;
//		}
//	}

//  idhuvum try {
//  // Wait for the element to be present on the page
//  wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.contactagent));
//  Reporter.generateReport(driver, extTest, Status.PASS, "View contact Agent element is present on the page.");
//  return true;
//} catch (Exception e) {
//  Reporter.generateReport(driver, extTest, Status.FAIL, "View contact Agent element is not present on the page: " + e.getMessage());
//  return false;
//} idhu varaikum comment

//

	
	


	    /**
	     * Scrolls down the property details page to view the details section.
	     * @return true if scrolling is successful, false otherwise.
	     */
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

	    /**
	     * Validates the presence of the 'Offer' element on the page.
	     * @return true if the 'Offer' element is found and displayed, false otherwise.
	     */
	    public boolean validateOfferElementIsPresent() {
	        try {
	            // Wait until the 'Offer' element is visible on the page
	            WebElement offerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.offerElement));
	            
	            // Validate that the 'Offer' element is displayed
	            if (offerElement.isDisplayed()) {
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
	
	

	