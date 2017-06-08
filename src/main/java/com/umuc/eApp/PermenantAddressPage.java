package com.umuc.eApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by samendra.bandara on 6/7/17.
 */
public class PermenantAddressPage {
    private WebDriver driver;

    public PermenantAddressPage(WebDriver driver) {
        this.driver=driver;
    }
    public void populateCountry(String country) {
//        WebDriverWait wait= new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APP48")));
        Select countries = new Select(driver.findElement(By.xpath("//*[@id=\"APP12\"]")));
        countries.selectByVisibleText(country);

    }
    public void populateStreet(String street) {
        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"APP13\"]"));
        streetName.clear();
        streetName.sendKeys(street);
    }
    public void clearStreet() {
        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"APP13\"]"));
        streetName.clear();
    }
    public void populateCity(String city) {
        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"APP15\"]"));
        streetName.clear();
        streetName.sendKeys(city);
    }
    public void clearCity() {
        WebElement streetName = driver.findElement(By.xpath("//*[@id=\"APP15\"]"));
        streetName.clear();
    }
    public void populateState(String state) {
        Select stateName = new Select(driver.findElement(By.xpath("//*[@id=\"APP16\"]")));
        stateName.selectByVisibleText("Virginia");
    }
    public void populateZip(String zip) {
        WebElement zipcode = driver.findElement(By.xpath("//*[@id=\"APP17\"]"));
        zipcode.clear();
        zipcode.sendKeys(zip);
    }
    public String getMailingAddressText() {
        WebElement mail = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id33\"]/div[4]/h2"));
        return mail.getText();
    }
    public String getAddressErrorMsg() {
        WebElement addressError = driver.findElement(By.xpath("//*[@id=\"err-addrs\"]"));
        return addressError.getText();
    }
    public String getZipErrorMsg() {
        WebElement zipError = driver.findElement(By.xpath("//*[@id=\"err-zip\"]"));
        return zipError.getText();
    }
    public String getStateErrorMsg() {
        WebElement state = driver.findElement(By.xpath("//*[@id=\"err-statePerm\"]"));
        return state.getText();
    }
    public String getCityErrorMsg() {
        WebElement city = driver.findElement(By.xpath("//*[@id=\"err-city\"]"));
        return city.getText();
    }
    public void clickNo() {
        WebElement noRadioBtn = driver.findElement(By.xpath("//*[@id=\"APP182\"]"));
        noRadioBtn.click();
    }
    public boolean isNewAddressPresent() {
        WebElement newAddress = driver.findElement(By.xpath("//*[@id=\"APP182\"]"));
        return newAddress.isDisplayed();
    }





}
