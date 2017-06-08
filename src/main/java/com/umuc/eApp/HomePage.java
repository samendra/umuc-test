package com.umuc.eApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by samendra.bandara on 5/23/17.
 */
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean startNewTab() {
        WebElement startNew =driver.findElement(By.xpath("//*[@id=\"j_id0:j_id9\"]/div/div/div[2]/ul/li[1]/a"));
       return startNew.isDisplayed();

    }
    public boolean continueTab() {
        WebElement contiue =driver.findElement(By.xpath("//*[@id=\"j_id0:j_id9\"]/div/div/div[2]/ul/li[2]/a"));
        return contiue.isDisplayed();

    }


}
