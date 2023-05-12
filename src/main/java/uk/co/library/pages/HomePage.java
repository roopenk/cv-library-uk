package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptAllCookies;
    @FindBy(xpath = "(//input[@id='keywords'])[1]")
    WebElement jobTitle;
    @FindBy(xpath = "//input[@id='location']")
    WebElement location;
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptions;
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobs;

    public void acceptCookies() throws InterruptedException {
        Thread.sleep(800);
        driver.switchTo().frame("gdpr-consent-notice");
        clickOnElement((By) acceptAllCookies);
        Reporter.log("Accept All Cookies : ");
        CustomListeners.test.log(Status.PASS, "Accept All Cookies.");
    }

    public void enterJobTitle(String jobTitle) {
        Reporter.log("Entering Job Title : " + jobTitle.toString());
        sendTextToElement((By) this.jobTitle, jobTitle);
        CustomListeners.test.log(Status.PASS, "Enter Job Tile: " + jobTitle);
    }

    public void enterLocation(String location) {
        Reporter.log("Enter Location : " + location.toString());
        sendTextToElement((By) this.location, location);
        CustomListeners.test.log(Status.PASS, "Enter Location: " + location);
    }

    public void selectDistance(String distance) {
        Reporter.log("Select Distance: " + distanceDropDown.toString());
        sendTextToElement((By) distanceDropDown, distance);
        CustomListeners.test.log(Status.PASS, "Select Distance: " + distance);
    }

    public void clickMoreSearchOptions() {
        Reporter.log("Click on More Search Options : " + moreSearchOptions.toString());
        clickOnElement((By) moreSearchOptions);
        CustomListeners.test.log(Status.PASS, "Click on More Search Options.");
    }

    public void enterMinSalary(String minSalary) {
        Reporter.log("Enter Minimum Salary: " + salaryMin.toString());
        sendTextToElement((By) salaryMin, minSalary);
        CustomListeners.test.log(Status.PASS, "Enter Minimum Salary: " + minSalary);
    }

    public void enterMaxSalary(String maxSalary) {
        Reporter.log("Enter Maximum Salary: " + salaryMax.toString());
        sendTextToElement((By) salaryMax, maxSalary);
        CustomListeners.test.log(Status.PASS, "Enter Maximum Salary: " + maxSalary);
    }

    public void selectSalaryType(String salaryType) {
        Reporter.log("Select Salary Type: " + salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown((By) salaryTypeDropDown, salaryType);
        CustomListeners.test.log(Status.PASS, "Select Salary Type: " + salaryType);
    }

    public void selectJobType(String jType) {
        Reporter.log("Select Job Type: " + jType);
        selectByVisibleTextFromDropDown((By) jobTypeDropDown, jType);
        CustomListeners.test.log(Status.PASS, "Select Job Type: " + jType);
    }

    public void clickOnFindJobs() {
        Reporter.log("Click Find Jobs Button: " + findJobs);
        clickOnElement((By) findJobs);
        CustomListeners.test.log(Status.PASS, "Click Find Jobs Button: ");
    }
}
