package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setup.BaseSteps;
import com.setup.Locators;

public class LoginPage extends BaseSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // ✅ Initialize wait here so it’s never null
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLoginBtn() {
        driver.findElement(Locators.homeLoginBtn).click();
        BaseSteps.sleep();
    }

    public void clickinnerloginBtn() {
        driver.findElement(Locators.innerLoginBtn).click();
        BaseSteps.sleep();
    }

    // Step 2: Switch to the new tab
    public void switchToLoginTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // second tab
    }

    public void clickphonenumber() {
        try {
            // Wait until input is clickable
            WebElement phoneInput = wait.until(
                    ExpectedConditions.elementToBeClickable(Locators.phonenumber));

            // Sometimes label overlaps -> use JS click instead of normal click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phoneInput);

            // Take input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter mobile number: ");
            String mobile = sc.nextLine();
            System.out.print("Enter captcha: ");
            String captcha = sc.nextLine();

            // Enter values
            phoneInput.sendKeys(mobile);
            driver.findElement(Locators.captacha).sendKeys(captcha);

            BaseSteps.sleep();
            driver.findElement(Locators.nextbtn).click();

        } catch (Exception e) {
            System.err.println("Error in clickphonenumber(): " + e.getMessage());
        }
    }

    public void enterotp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        String otp = scanner.nextLine();

        try {
            // Use class-level wait (already initialized in constructor)
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp1)).sendKeys(otp.substring(0, 1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp2)).sendKeys(otp.substring(1, 2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp3)).sendKeys(otp.substring(2, 3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otp4)).sendKeys(otp.substring(3, 4));

            wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebtn)).click();

        } catch (Exception e) {
            System.err.println("An error occurred while entering OTP: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Validate login status
    public boolean validateLogin() {
        try {
            return driver.findElement(By.xpath("//span[contains(text(),'Mei')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}