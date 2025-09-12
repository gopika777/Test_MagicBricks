
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

public class PropertyPhotosPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public PropertyPhotosPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.extTest = extTest;
    }

    /**
     * Clicks on the photos section to open the gallery view.
     * @return true if the click is successful, false otherwise.
     */
    public boolean clickPhotoGallery() {
        try {
            WebElement photosSection = wait.until(ExpectedConditions.elementToBeClickable(Locators.photos));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", photosSection);
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the photo gallery link.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click the photo gallery link: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Checks if the photo gallery modal has opened by waiting for a key element.
     * @return true if the gallery is visible, false otherwise.
     */
    public boolean isGalleryOpen() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstphoto));
            Reporter.generateReport(driver, extTest, Status.PASS, "The photo gallery is open.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "The photo gallery failed to open: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Clicks the first photo in the gallery.
     * @return true if the click is successful, false otherwise.
     */
    public boolean clickFirstPhoto() {
        try {
            WebElement firstPhoto = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstphoto));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstPhoto);
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the first photo.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click the first photo: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Clicks the right arrow to navigate to the next photo.
     * @return true if the right arrow is clicked successfully, false otherwise.
     */
    public boolean clickRightArrow() {
        try {
            WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(Locators.picrightarrow));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rightArrow);

            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the right arrow.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click the right arrow: " + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks the cross button to close the photo gallery.
     * @return true if the gallery is successfully closed, false otherwise.
     */
    public boolean closePhotoGallery() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.cross));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);

            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully closed the photo gallery.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to close the photo gallery: " + e.getMessage());
            return false;
        }
    }
}
