package com.umuc.eApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by samendra.bandara on 5/24/17.
 */
public class LogIn {
    private WebDriver driver;

    public LogIn(WebDriver driver) {
        this.driver=driver;
    }


    public void populateEmail(String email) {
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"APP01\"]"));
        emailAddress.clear();
        emailAddress.sendKeys(email);

    }
    public void clickEmailBox() {
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"APP01\"]"));
        emailAddress.click();

    }

    public void populateConfirmationEmail(String confirmationemail ) {
        WebElement confirmEmailAddress = driver.findElement(By.xpath("//*[@id=\"APP02\"]"));
        confirmEmailAddress.clear();
        confirmEmailAddress.sendKeys(confirmationemail);

    }
    public void clickConfirmationEmailBox() {
        WebElement confirmEmailAddress = driver.findElement(By.xpath("//*[@id=\"APP02\"]"));
        confirmEmailAddress.click();

    }
    public void populatePassword(String pass) {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"APP03\"]"));
        password.clear();
        password.sendKeys(pass);

    }
    public void clickPasswordBox() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"APP03\"]"));
        password.click();

    }
    public void clickConfirmPasswordBox() {
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"APP04\"]"));
        confirmPassword.click();

    }

    public void populatePasswordConfirmation(String confirmPassword ) {
        WebElement confirmPass = driver.findElement(By.xpath("//*[@id=\"APP04\"]"));
        confirmPass.clear();
        confirmPass.sendKeys(confirmPassword);

    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"start2\"]/form/div[3]/button"));
        submit.click();
    }
    public void populateLogIn(String email, String confirmationemail, String pass, String confirmPassword ) {

        populateEmail(email);
        populateConfirmationEmail(confirmationemail);
        populatePassword(pass);
        populatePasswordConfirmation(confirmPassword);
        clickSubmit();

    }
    public void continueApplicationLogIn(String emailAdd, String pass) throws InterruptedException {
        Thread.sleep(4000);
        WebElement continu=driver.findElement(By.xpath("//*[@id=\"j_id0:j_id9\"]/div/div/div[2]/ul/li[2]/a"));
        continu.click();
        WebElement email= driver.findElement(By.xpath("//*[@id=\"APP92\"]"));
        email.clear();
        email.sendKeys(emailAdd);
        WebElement password= driver.findElement(By.xpath("//*[@id=\"APP93\"]"));
        password.clear();
        password.sendKeys(pass);
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"continue2\"]/form/div[3]/button"));
        signInButton.click();

    }
    public String getConfirmationEmailErrorMsg() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"confEmlErr\"]"));
       return errorMsg.getText();
    }
    public String getInvalidEmailErrorMsg() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"valEmlErr\"]"));
        return errorMsg.getText();
    }
    public String getPasswordErrorMsg() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"confPwdErr\"]"));
        return errorMsg.getText();
    }
    public String getInvalidPasswordErrorMsg() {
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"valPwdErr\"]"));
        return errorMsg.getText();
    }
    public boolean isPersonalInfoHeaderDisplayed(){
        WebElement personalInfoHeader = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id33\"]/header/h1"));
        return personalInfoHeader.isDisplayed();
    }

}
