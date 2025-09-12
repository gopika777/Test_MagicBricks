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

public class InvalidFeedbackPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidFeedbackPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.extTest = extTest;
    }

    /**
     * Clicks the side bar button or icon to open the menu.
     * @return true if the click is successful, false otherwise.
     */
    public boolean clickSideBar() {
        try {
            WebElement sideBar = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.sidebar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sideBar);
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(sideBar).perform();
          
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the side bar.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click the side bar: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Clicks the 'Report Issue' link from the side bar menu.
     * @return true if the click is successful, false otherwise.
     */
    public boolean clickReportIssue() {
        try {
            WebElement reportIssueLink = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reportissue));
            //reportIssueLink.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reportIssueLink);
            try {
                reportIssueLink.click();
            } catch (Exception e) {
                // fallback if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reportIssueLink);
            }
            
            WebElement clickno = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickno));
            clickno.click();

            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked 'Report Issue' link.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click 'Report Issue' link: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Clicks the 'Submit' button without filling any form fields.
     * @return true if the submit button is successfully clicked, false otherwise.
     */
    public boolean submitFeedbackWithoutFilling() {
        try {
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.feedbacksumbit));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully clicked the 'Submit' button.");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Failed to click the 'Submit' button: " + e.getMessage());
            return false;
        }
    }

    /**
     * Gets the text of the validation error message.
     * @return The text of the error message, or null if not found.
     */
    public String getErrorMessage() {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.errormsg));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validation error message is present.");
            return errorMessage.getText();
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                "Validation error message not found: " + e.getMessage());
            return null;
        }
    }
}
