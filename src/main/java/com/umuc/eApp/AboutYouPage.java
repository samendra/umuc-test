package com.umuc.eApp;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by samendra.bandara on 6/6/17.
 */
public class AboutYouPage {

    private WebDriver driver;

    public AboutYouPage(WebDriver driver) {
        this.driver=driver;

    }
    public void populatePersonalInfo(String fName, String lName, String phone, String dob) {
        populateFirstName(fName);
        populateLastName(lName);
        populateDOB(dob);
        populatePhone(phone);


    }
    public void populateFirstName(String fName) {
        WebElement firstName = driver.findElement(By.id("APP07"));
        firstName.clear();
        firstName.sendKeys(fName);

        }
    public void clearZipCode() {
        WebElement zipCode = driver.findElement(By.id("APP17"));
        zipCode.clear();

    }
    public void clearLasttName() {
        WebElement zipCode = driver.findElement(By.id("APP08"));
        zipCode.clear();

    }
    public void clearFirstName() {
        WebElement firstName = driver.findElement(By.id("APP07"));
        firstName.clear();

    }
    public void clearDOB() {
        WebElement birthdate = driver.findElement(By.id("APP46"));
        birthdate.clear();

    }
    public void clearPhone() {
        WebElement number = driver.findElement(By.id("APP10"));
        number.clear();
    }



    public void populateLastName(String lName) {
        WebElement lastName = driver.findElement(By.id("APP08"));
        lastName.clear();
        lastName.sendKeys(lName);

    }
    public void populateDOB(String dob) {
        WebElement birthdate = driver.findElement(By.id("APP46"));
        birthdate.clear();
        birthdate.sendKeys("06/06/1990");

    }
    public void populatePhone(String phone) {
        WebElement number = driver.findElement(By.id("APP10"));
        number.clear();
        number.sendKeys(phone);

    }
    public void numberOfCountries() {
        Select countries = new Select(driver.findElement(By.xpath("//*[@id=\"APP48\"]")));
        countries.getOptions();

    }
    public void populateCitizenship(String country) throws InterruptedException {
//        WebDriverWait wait= new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APP48")));
        //Thread.sleep(2000);
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id33\"]/div[1]/div[2]/div[2]/div/div/span[1]"));
        Select countries = new Select(driver.findElement(By.name("Citizenship")));
        countries.selectByValue(country);

    }
    public void populateCountryCode(String code) {
        Select countries = new Select(driver.findElement(By.xpath("//*[@id=\"APP11\"]")));
        countries.selectByValue(code);
    }
    public void populateSocialSecurity(String social) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement socialSecurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"APP47\"]")));
        socialSecurity.clear();
        socialSecurity.sendKeys(social);
    }
    public boolean isSocialSecurityTextBoxPresent() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement socialsecurity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"APP47\"]")));
        return socialsecurity.isDisplayed();
    }
    public boolean isVisaTextBoxPresent() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement visa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"APP49\"]")));
        return visa.isDisplayed();
    }
    public void clickNextButton() {
        WebElement next = driver.findElement(By.xpath("//*[@id=\"nextButtonPer\"]"));
        next.click();
    }
    public String getFirstNameErrorMsg() {
        WebElement firstNameError = driver.findElement(By.id("err-firstname"));
        return firstNameError.getText();
    }
    public String getLastNameErrorMsg() {
        WebElement lastNameError = driver.findElement(By.id("err-lastname"));
        return lastNameError.getText();
    }
    public String getDobErrorMsg() {
        WebElement dob = driver.findElement(By.id("err-dob"));
        return dob.getText();
    }
    public String getCountryCodeErrorMsg() {
        WebElement countryCode = driver.findElement(By.id("err-compCode"));
        return countryCode.getText();
    }
    public String getPhoneNumbereErrorMsg() {
        WebElement countryCode = driver.findElement(By.id("err-phnum"));
        return countryCode.getText();
    }





    }


