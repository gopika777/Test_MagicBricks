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

public class SearchHome_Page {

	// Locators
	public static By deselectchennai = By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
	public static By loc = By.xpath("//*[@id=\"keyword\"]");
	public static By selectbgl = By.xpath("//*[@id=\"serachSuggest\"]/div[2]/span");

	public static By clickPropertType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
	public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
	public static By selectPropertyType = By.xpath("//*[@id=\"10002_10003_10021_10022\"]");// deselect flats
	public static By closePropertyType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");

	public static By clickBudget = By.id("rent_budget_lbl");
	public static By mindropdown = By.xpath("//*[@id=\"budgetMin\"]");
	public static By maxdropdown = By.xpath("//*[@id=\"budgetMax\"]");
	public static By closeBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]");

	public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");

	public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[1]");

	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest extTest;

	public SearchHome_Page(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.extTest = extTest;
	}

	// Enter location
	public boolean enterLocation(String location) {

		try {

			WebElement locationBox = wait.until(ExpectedConditions.elementToBeClickable(loc));

			locationBox.click();
			WebElement locationBox1 = wait.until(ExpectedConditions.elementToBeClickable(deselectchennai));

			locationBox1.click();
			locationBox.clear();
			locationBox.sendKeys(location);
			WebElement locationBox2 = wait.until(ExpectedConditions.elementToBeClickable(selectbgl));

			locationBox2.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Entered location: " + location);
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter location: " + e.getMessage());
			return false;

		}
	}

	// Select property type
	public boolean selectPropertyType() {
		try {
			WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(clickPropertType));
			dropdown.click();

			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(selectPropertyType));

			option.click();
			WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closePropertyType));

			close.click();

			Reporter.generateReport(driver, extTest, Status.PASS, "Selected property type");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select property type: " + e.getMessage());
			return false;
		}

	}

	// Select budget
	public boolean selectBudget() {
		try {

			WebElement dropdownSection = wait.until(ExpectedConditions.elementToBeClickable(clickBudget));
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			// dropdownSection);
			dropdownSection.click();

			// Min dropdown
			WebElement minOption = wait.until(ExpectedConditions.elementToBeClickable(mindropdown));
			minOption.sendKeys("100000");
			minOption.click();

			// Min dropdown
			WebElement maxOption = wait.until(ExpectedConditions.elementToBeClickable(maxdropdown));
			maxOption.sendKeys("10000000");
			maxOption.click();
			WebElement closeOption = wait.until(ExpectedConditions.elementToBeClickable(closeBudget));
			closeOption.click();

			Reporter.generateReport(driver, extTest, Status.PASS,
					"Selected Budget successfully using dropdown (Min & Max)");
			return true;

		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select budget: " + e.getMessage());
			return false;
		}
	}

	// Click search
	public boolean clickSearch() {
		try {
			WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
			searchBtn.click();
			Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Search button");
			return true;
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Search button: " + e.getMessage());
			return false;
		}
	}

	// Validate listing page
	public boolean validateListingPage() {
		try {
			WebElement sortby = wait.until(ExpectedConditions.visibilityOfElementLocated(sortBy));
			if (sortby.isDisplayed()) {
				Reporter.generateReport(driver, extTest, Status.PASS, "Listing page validated by Sort By dropdown");
				return true;
			} else {
				Reporter.generateReport(driver, extTest, Status.FAIL, "Sort By dropdown not visible");
				return false;
			}
		} catch (Exception e) {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate listing page: " + e.getMessage());
			return false;
		}
	}

}